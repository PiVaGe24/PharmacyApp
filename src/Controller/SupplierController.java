package Controller;

import static Model.EmployeeDao.rol_user;
import Model.Supplier;
import Model.SupplierDao;
import View.JF_Main;
import View.JP_Purchase;
import View.JP_SupplierRegister;
import View.JP_TableSupplier;
import View.Notify.Notification;
import View.SimpleMessage.GlassPanePopup;
import View.SimpleMessage.Message;
import View.TableCustomButton.TableActionCellEditor;
import View.TableCustomButton.TableActionCellRender;
import View.TableCustomButton.TableActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PIERO
 */
public class SupplierController implements ActionListener,MouseListener,KeyListener,ItemListener{
    private Supplier supplier;
    private SupplierDao supplierDao;
    private JF_Main jfMain;
    private JP_Purchase jpPurchase;
    private JP_TableSupplier jpTableSupplier;
    private JP_SupplierRegister jpSupplierRegister; 
    String rol = rol_user;
    DefaultTableModel modelTableSupplier= new DefaultTableModel();

    public SupplierController(Supplier supplier, SupplierDao supplierDao, JF_Main jfMain,JP_TableSupplier jpTableSupplier,JP_SupplierRegister jpSupplierRegister,JP_Purchase jpPurchase) {
        this.supplier = supplier;
        this.supplierDao = supplierDao;
        this.jfMain= jfMain;
        this.jpPurchase= jpPurchase;
        this.jpTableSupplier = jpTableSupplier;
        this.jpSupplierRegister = jpSupplierRegister;
        //GlassPanePopup.install(jfMain);
        
        this.jpTableSupplier.btn_supplier_register.addMouseListener(this);
        this.jpSupplierRegister.btn_add_supplier.addActionListener(this);
        this.jpSupplierRegister.btn_supplier_update.addActionListener(this);
        this.jpSupplierRegister.btn_supplier_cancel.addActionListener(this);
        this.jpTableSupplier.table_supplier.addMouseListener(this);
        this.jpTableSupplier.txt_supplier_search.addKeyListener(this);
        
        this.jpSupplierRegister.txt_supplier_id.addKeyListener(this);
        this.jpSupplierRegister.txt_supplier_name.addKeyListener(this);
        this.jpSupplierRegister.txt_supplier_description.addKeyListener(this);
        this.jpSupplierRegister.txt_supplier_email.addKeyListener(this);
        this.jpSupplierRegister.txt_supplier_address.addKeyListener(this);
        this.jpSupplierRegister.txt_supplier_telephone.addKeyListener(this);
        this.jpTableSupplier.cmb_supplier_city.addItemListener(this);
        
                

        TableActionEvent evt = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                jpSupplierRegister.txt_supplier_id.setText(jpTableSupplier.table_supplier.getValueAt(row, 0).toString());
                jpSupplierRegister.txt_supplier_name.setText(jpTableSupplier.table_supplier.getValueAt(row, 1).toString());
                jpSupplierRegister.txt_supplier_description.setText(jpTableSupplier.table_supplier.getValueAt(row, 2).toString());
                jpSupplierRegister.txt_supplier_address.setText(jpTableSupplier.table_supplier.getValueAt(row, 3).toString());
                jpSupplierRegister.txt_supplier_telephone.setText(jpTableSupplier.table_supplier.getValueAt(row, 4).toString());
                jpSupplierRegister.txt_supplier_email.setText(jpTableSupplier.table_supplier.getValueAt(row, 5).toString());
                jpSupplierRegister.cmb_supplier_city.setSelectedItem(jpTableSupplier.table_supplier.getValueAt(row, 6).toString());
                jpSupplierRegister.btn_add_supplier.setVisible(false);
                jpSupplierRegister.btn_supplier_update.setVisible(true);
                jfMain.panelSlideSupplier.show(1);
                jpSupplierRegister.txt_supplier_name.requestFocus();
            }

            @Override
            public void onDelete(int row) {
                if(jpTableSupplier.table_supplier.isEditing()){
                    jpTableSupplier.table_supplier.getCellEditor().stopCellEditing();
                }
                int id = Integer.parseInt(jpTableSupplier.table_supplier.getValueAt(row, 0).toString());
                String name = jpTableSupplier.table_supplier.getValueAt(row, 1).toString();
                
                Message msg = new Message("Confirm...","Do you want to remove the "+name.toUpperCase());
                msg.eventOK(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if(supplierDao.DeleteSupplierQuery(id)){
                            ListAllSupplier();
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
            }
        };
        //Agrega los botones a la tabla
        jpTableSupplier.table_supplier.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor(evt));
        //Instanciamos los paneles del Slide >3||velocidad de la animacion
        //jfMain.panelSlideSupplier.init(jpTableSupplier,jpSupplierRegister,jpTableSupplier);
        //jfMain.panelSlideSupplier.setAnimate(20);
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
            String name = jpSupplierRegister.txt_supplier_name.getText().trim();
            String address = jpSupplierRegister.txt_supplier_address.getText().trim();
            String telephone = jpSupplierRegister.txt_supplier_telephone.getText().trim();
            String email = jpSupplierRegister.txt_supplier_email.getText().trim();
            String description = jpSupplierRegister.txt_supplier_description.getText().trim();
            String city = jpSupplierRegister.cmb_supplier_city.getSelectedItem().toString();
        if(e.getSource()==jpSupplierRegister.btn_add_supplier){
            if(name.equals("")||
                    address.equals("")||
                    telephone.equals("")||
                    email.equals("")||
                    description.equals("")||
                    city.equals("")){
                Notification noti = new Notification(jfMain, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "All fields are required");
                noti.showNotification();
            }else{
                supplier.setName(name);
                supplier.setAddress(address);
                supplier.setTelephone(telephone);
                supplier.setEmail(email);
                supplier.setDescription(description);
                supplier.setCity(city);
                if(supplierDao.RegisterSupplierQuery(supplier)){
                    ListAllSupplier();
                    ClearFieldSupplier();
                    Notification noti = new Notification(jfMain, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Register successful");
                    noti.showNotification();
                    jpSupplierRegister.txt_supplier_name.requestFocus();}
            }
        }else if(e.getSource()==jpSupplierRegister.btn_supplier_update){
            if(name.equals("")||
                    address.equals("")||
                    telephone.equals("")||
                    email.equals("")||
                    description.equals("")||
                    city.equals("")){
                Notification noti = new Notification(jfMain, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "All fields are required");
                noti.showNotification();
            }else{
                supplier.setName(name);
                supplier.setAddress(address);
                supplier.setTelephone(telephone);
                supplier.setEmail(email);
                supplier.setDescription(description);
                supplier.setCity(city);
                supplier.setId(Integer.parseInt(jpSupplierRegister.txt_supplier_id.getText().trim()));
                if(supplierDao.UpdateSupplierQuery(supplier)){
                    Notification noti = new Notification(jfMain, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Data "+name+" updated successfully");
                    noti.showNotification();
                    ListAllSupplier();
                    jfMain.panelSlideSupplier.show(0);
                    FillSupplier();
                    jpTableSupplier.txt_supplier_search.requestFocus();}
            }
        }/*else if(e.getSource()==jpTableSupplier.btn_supplier_register){
        }*/else if(e.getSource()==jpSupplierRegister.btn_supplier_cancel){
            jfMain.panelSlideSupplier.show(0);
            jpTableSupplier.txt_supplier_search.requestFocus();
        }
    }

    public void ListAllSupplier(){
        ClearTableSupplier();
        jpTableSupplier.table_supplier.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender());
            List <Supplier> listSupplier = supplierDao.ListSupplierQuery(jpTableSupplier.txt_supplier_search.getText().trim(),jpTableSupplier.cmb_supplier_city.getSelectedItem().toString());
            modelTableSupplier=(DefaultTableModel) jpTableSupplier.table_supplier.getModel();
            Object[] row = new Object[7];
            for (int i = 0; i < listSupplier.size(); i++) {
                row[0]=listSupplier.get(i).getId();
                row[1]=listSupplier.get(i).getName();
                row[2]=listSupplier.get(i).getDescription();
                row[3]=listSupplier.get(i).getAddress();
                row[4]=listSupplier.get(i).getTelephone();
                row[5]=listSupplier.get(i).getEmail();
                row[6]=listSupplier.get(i).getCity();
                modelTableSupplier.addRow(row);
            }
            jpTableSupplier.table_supplier.setModel(modelTableSupplier);   
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource()==jpTableSupplier.btn_supplier_register){
            ClearFieldSupplier();
            jfMain.panelSlideSupplier.show(1);
            jpSupplierRegister.txt_supplier_name.requestFocus();
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
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource()==jpTableSupplier.txt_supplier_search){
            ListAllSupplier();
        }
    }
    
    public void ClearTableSupplier(){
        for (int i = 0; i < modelTableSupplier.getRowCount(); i++) {
            modelTableSupplier.removeRow(i);
            i--;
        }
    }
    
    public void ClearFieldSupplier(){
        jpSupplierRegister.txt_supplier_name.setText("");
        jpSupplierRegister.txt_supplier_address.setText("");
        jpSupplierRegister.txt_supplier_telephone.setText("");
        jpSupplierRegister.txt_supplier_email.setText("");
        jpSupplierRegister.txt_supplier_description.setText("");
        jpSupplierRegister.cmb_supplier_city.setSelectedIndex(0);
        jpSupplierRegister.txt_supplier_id.setText("");
        jpSupplierRegister.btn_add_supplier.setVisible(true);
        jpSupplierRegister.btn_supplier_update.setVisible(false);
    }
    
    public void FillSupplier(){
        List <Supplier> listSupplier = supplierDao.ListSupplierQuery(jpTableSupplier.txt_supplier_search.getText(),"All");
        jpPurchase.cmb_product_supplier.removeAllItems();
        for (int i = 0; i < listSupplier.size(); i++) {
            int id = listSupplier.get(i).getId();
            String name = listSupplier.get(i).getName();
            jpPurchase.cmb_product_supplier.addItem(new Supplier(id, name));
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
         if(e.getStateChange() == ItemEvent.SELECTED){
            String item = (String) e.getItem();
            if(e.getSource()==jpTableSupplier.cmb_supplier_city){
                ListAllSupplier();
            }
            System.out.println(item);
        }
    }
}
