package Controller;

import Model.Customer;
import Model.CustomerDao;
import View.JF_Main;
import View.JP_CustomerRegister;
import View.JP_Sale;
import View.JP_TableCustomer;
import View.Notify.Notification;
import View.SimpleMessage.GlassPanePopup;
import View.SimpleMessage.Message;
import View.TableCustomButton.TableActionCellEditor;
import View.TableCustomButton.TableActionCellRender;
import View.TableCustomButton.TableActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PIERO
 */
public class CustomerController implements ActionListener,MouseListener,KeyListener{
    private Customer customer;
    private CustomerDao customerDao;
    private JF_Main jfMain;
    private JP_TableCustomer jpTableCustomer;
    private JP_CustomerRegister jpCustomerRegister;
    private JP_Sale jpSale;
    
    DefaultTableModel modelTableCustomer = new DefaultTableModel();

    public CustomerController(Customer customer, CustomerDao customerDao, JF_Main jfMain,JP_TableCustomer jpTableCustomer,JP_CustomerRegister jpCustomerRegister,JP_Sale jpSale) {
        this.customer = customer;
        this.customerDao = customerDao;
        this.jfMain = jfMain;
        this.jpTableCustomer = jpTableCustomer;
        this.jpCustomerRegister = jpCustomerRegister;
        this.jpSale=jpSale;
        //GlassPanePopup.install(jfMain);
        
        this.jpTableCustomer.btn_customer_register.addMouseListener(this);
        this.jpCustomerRegister.btn_customer_update.addActionListener(this);
        this.jpCustomerRegister.btn_customer_cancel.addActionListener(this);
        this.jpCustomerRegister.btn_customer_add.addActionListener(this);
        this.jpTableCustomer.txt_customer_search.addKeyListener(this);
        
        this.jpCustomerRegister.txt_customer_id.addKeyListener(this);
        this.jpCustomerRegister.txt_customer_fullname.addKeyListener(this);
        this.jpCustomerRegister.txt_customer_email.addKeyListener(this);
        this.jpCustomerRegister.txt_customer_address.addKeyListener(this);
        this.jpCustomerRegister.txt_customer_telephone.addKeyListener(this);

        TableActionEvent evt = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                jpCustomerRegister.txt_customer_id.setText(jpTableCustomer.table_customer.getValueAt(row, 0).toString());
                jpCustomerRegister.txt_customer_fullname.setText(jpTableCustomer.table_customer.getValueAt(row, 1).toString());
                jpCustomerRegister.txt_customer_telephone.setText(jpTableCustomer.table_customer.getValueAt(row, 2).toString());
                jpCustomerRegister.txt_customer_address.setText(jpTableCustomer.table_customer.getValueAt(row, 3).toString());
                jpCustomerRegister.txt_customer_email.setText(jpTableCustomer.table_customer.getValueAt(row, 4).toString());
 
                jpCustomerRegister.btn_customer_update.setVisible(true);
                jpCustomerRegister.btn_customer_add.setVisible(false);
                jpCustomerRegister.txt_customer_id.setEditable(false);
                jfMain.panelSlideCustomer.show(1);
                jpCustomerRegister.txt_customer_fullname.requestFocus();
            }
            @Override
            public void onDelete(int row) {
                if(jpTableCustomer.table_customer.isEditing()){
                    jpTableCustomer.table_customer.getCellEditor().stopCellEditing();
                }
                int idseleccionado = Integer.parseInt(jpTableCustomer.table_customer.getValueAt(row, 0).toString());
                String fullname = jpTableCustomer.table_customer.getValueAt(row, 1).toString();

                Message msg = new Message("Confirm...","Do you want to remove the "+fullname);
                msg.eventOK(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if(customerDao.DeleteCustomerQuery(idseleccionado)){
                            ClearFieldsCustomer();
                            ListAllCustomer();
                            Notification noti = new Notification(jfMain, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Delete successful");
                            noti.showNotification();
                        }
                        GlassPanePopup.closePopupLast();
                    }
                });
                GlassPanePopup.showPopup(msg);
            }
            @Override
            public void onView(int row) {
                System.out.println("View" +row);
            }
        };
        jpTableCustomer.table_customer.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(evt));
        //jfMain.panelSlideCustomer.init(jpTableCustomer,jpCustomerRegister,jpCustomerRegister);
        //jfMain.panelSlideCustomer.setAnimate(20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jpCustomerRegister.btn_customer_add || e.getSource()==jpCustomerRegister.btn_customer_update){
            if(validateFields()){
                int idCustomer = Integer.parseInt(jpCustomerRegister.txt_customer_id.getText().trim());
                String fullname = jpCustomerRegister.txt_customer_fullname.getText().trim();
                String address = jpCustomerRegister.txt_customer_address.getText().trim();
                String telephone =jpCustomerRegister.txt_customer_telephone.getText().trim();
                String email = jpCustomerRegister.txt_customer_email.getText().trim();
                customer.setId(idCustomer);
                customer.setFull_name(fullname);
                customer.setAddress(address);
                customer.setTelephone(telephone);
                customer.setEmail(email);
                if(jpCustomerRegister.btn_customer_update.isVisible()){
                    if(customerDao.UpdateCustomerQuery(customer)){
                    ListAllCustomer();
                    jfMain.panelSlideCustomer.show(0);
                    Notification noti = new Notification(jfMain, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Data updated successfully");
                    noti.showNotification();
                    jpTableCustomer.txt_customer_search.requestFocus();}
                }else{
                    if(customerDao.RegisterCustomerQuery(customer)){
                    ListAllCustomer();
                    ClearFieldsCustomer();
                    Notification noti = new Notification(jfMain, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Register successful");
                    noti.showNotification();
                    jpCustomerRegister.txt_customer_id.requestFocus();}
                }
            }else{
                Notification noti = new Notification(jfMain, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "All fields are required");
                noti.showNotification();
            }
        }/*else if(e.getSource()==jpTableCustomer.btn_customer_register){
            ClearFieldsCustomer();
            jfMain.panelSlideCustomer.show(1);
            jpCustomerRegister.txt_customer_id.requestFocus();
        }*/else if(e.getSource()==jpCustomerRegister.btn_customer_cancel){
            jfMain.panelSlideCustomer.show(0);
            jpTableCustomer.txt_customer_search.requestFocus();
        }
    }
    
    public void ListAllCustomer(){
        ClearTableCustomer();
        jpTableCustomer.table_customer.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        List <Customer> listCustomer = customerDao.ListCustomerQuery(jpTableCustomer.txt_customer_search.getText());
        modelTableCustomer = (DefaultTableModel) jpTableCustomer.table_customer.getModel();
        Object[] row = new Object[5];
        for(int i=0;i<listCustomer.size();i++){
            row[0]=listCustomer.get(i).getId();
            row[1]=listCustomer.get(i).getFull_name();
            row[2]=listCustomer.get(i).getTelephone();
            row[3]=listCustomer.get(i).getAddress();
            row[4]=listCustomer.get(i).getEmail();
            modelTableCustomer.addRow(row);
        }
        jpTableCustomer.table_customer.setModel(modelTableCustomer);
    }    

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource()==jpTableCustomer.btn_customer_register){
            ClearFieldsCustomer();
            jfMain.panelSlideCustomer.show(1);
            jpCustomerRegister.txt_customer_id.requestFocus();
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        String id = jpCustomerRegister.txt_customer_id.getText().trim();
        String fullname = jpCustomerRegister.txt_customer_fullname.getText().trim();
        String email = jpCustomerRegister.txt_customer_email.getText().trim();
        String address =jpCustomerRegister.txt_customer_address.getText().trim();
        String telephone =jpCustomerRegister.txt_customer_telephone.getText().trim();
        if(e.getSource()==jpCustomerRegister.txt_customer_id){
            if (e.getKeyCode() == KeyEvent.VK_ENTER&&!id.equals("")) {
                jpCustomerRegister.txt_customer_fullname.requestFocus();
            }
        }else if(e.getSource()==jpCustomerRegister.txt_customer_fullname){
            if (e.getKeyCode() == KeyEvent.VK_ENTER&&!fullname.equals("")) {
                jpCustomerRegister.txt_customer_email.requestFocus();
            }
        }else if(e.getSource()==jpCustomerRegister.txt_customer_email){
            if (e.getKeyCode() == KeyEvent.VK_ENTER&&!email.equals("")) {
                jpCustomerRegister.txt_customer_address.requestFocus();
            }
        }else if(e.getSource()==jpCustomerRegister.txt_customer_address){
            if (e.getKeyCode() == KeyEvent.VK_ENTER&&!address.equals("")) {
                jpCustomerRegister.txt_customer_telephone.requestFocus();
            }
        }else if(e.getSource()==jpCustomerRegister.txt_customer_telephone&&jpCustomerRegister.btn_customer_add.isVisible()){
            if (e.getKeyCode() == KeyEvent.VK_ENTER&&
                    !id.equals("")&&
                    !fullname.equals("")&&
                    !email.equals("")&&
                    !address.equals("")&&
                    !telephone.equals("")
                    ) {
                System.out.println("Registrar Customer");
            }else if(e.getKeyCode() == KeyEvent.VK_ENTER&&!telephone.equals("")){
                jpCustomerRegister.txt_customer_id.requestFocus();
            }
        }else if(e.getSource()==jpCustomerRegister.txt_customer_telephone&&jpCustomerRegister.btn_customer_update.isVisible()){
            if (e.getKeyCode() == KeyEvent.VK_ENTER&&
                    !id.equals("")&&
                    !fullname.equals("")&&
                    !email.equals("")&&
                    !address.equals("")&&
                    !telephone.equals("")
                    ) {
                System.out.println("Actualiza Customer");
            }else if(e.getKeyCode() == KeyEvent.VK_ENTER&&!telephone.equals("")){
                jpCustomerRegister.txt_customer_id.requestFocus();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource()==jpTableCustomer.txt_customer_search){
            ListAllCustomer();
        }
    }
    
    public void ClearFieldsCustomer(){
        jpCustomerRegister.txt_customer_id.setText("");
        jpCustomerRegister.txt_customer_id.setEnabled(true);
        jpCustomerRegister.txt_customer_id.setEditable(true);
        jpCustomerRegister.txt_customer_fullname.setText("");
        jpCustomerRegister.txt_customer_address.setText("");
        jpCustomerRegister.txt_customer_telephone.setText("");
        jpCustomerRegister.txt_customer_email.setText("");
        jpCustomerRegister.btn_customer_add.setVisible(true);
        jpCustomerRegister.btn_customer_update.setVisible(false);
    }
    
    public void ClearTableCustomer(){
        for(int i=0;i<modelTableCustomer.getRowCount();i++){
            modelTableCustomer.removeRow(i);
            i--;
        }
    }
    /*public void FillCustomer(){
        List <Customer> listCustomer = customerDao.fillCustomerSql();
        jpSale.cmb_customer_name.removeAllItems();
        //jpSale.cmb_customer_name.removeAllItems();
        jpSale.cmb_customer_name.addItem(new Customer(0,"Select"));
        for (int i = 0; i < listCustomer.size(); i++) {
            jpSale.cmb_customer_name.addItem(new Customer(listCustomer.get(i).getId(),listCustomer.get(i).getFull_name()));
            //jpTableProduct.cmb_product_category.addItem(new Category(listCategory.get(i).getId(),listCategory.get(i).getName()));
        }
    }*/
    
    private boolean validateFields(){
        String idCustomer = jpCustomerRegister.txt_customer_id.getText().trim();
        String fullname=jpCustomerRegister.txt_customer_fullname.getText().trim();
        String address=jpCustomerRegister.txt_customer_address.getText().trim();
        String telephone=jpCustomerRegister.txt_customer_telephone.getText().trim();
        String email=jpCustomerRegister.txt_customer_email.getText().trim();
        
        return !fullname.isEmpty() && !address.isEmpty() && !telephone.isEmpty()
                && !email.isEmpty() && !idCustomer.isEmpty();
    }
    
}
