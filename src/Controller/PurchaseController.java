package Controller;

import static Model.EmployeeDao.id_user;
import Model.Product;
import Model.ProductDao;
import Model.Purchase;
import Model.PurchaseDao;
import View.JF_Main;
import View.JF_Print;
import View.JP_Purchase;
import View.JP_Report;
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
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PIERO
 */
public class PurchaseController implements ActionListener,KeyListener,TableModelListener{
    private Purchase objPurchase;
    private PurchaseDao objPurchaseDao;
    private JP_Purchase jpPurchase;
    private JF_Main jfMain;
    private JP_Report jpReport;
    private int getIdSupplier=0;
    private int item =0;
    NumberFormat formatoDinero = NumberFormat.getCurrencyInstance();
    Product objProduct = new Product();
    ProductDao objProductDao = new ProductDao();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat formatoFechaPersonal = new SimpleDateFormat("EEE, d MMMM");//YYYY
    DefaultTableModel modelTablePurchase = new DefaultTableModel();
    DefaultTableModel temp;
    
        
        
     ListSelectionModel modelo;

   
    public PurchaseController(Purchase objPurchase, PurchaseDao objPurchaseDao, JP_Purchase jpPurchase,JF_Main jfMain,JP_Report jpReport) {
        this.objPurchase = objPurchase;
        this.objPurchaseDao = objPurchaseDao;
        this.jpPurchase = jpPurchase;
        this.jfMain = jfMain;
        this.jpReport = jpReport;
        this.jpPurchase.btn_add_product_to_buy.addActionListener(this);
        this.jpPurchase.btn_confirm_purchase.addActionListener(this);
        this.jpPurchase.btn_remove_purchase.addActionListener(this);
        this.jpPurchase.txt_purchase_product_code.addKeyListener(this);
        this.jpPurchase.txt_purchase_price.addKeyListener(this);
        this.jpPurchase.txt_purchase_amount.addKeyListener(this);
        this.jpPurchase.btn_new_purchase.addActionListener(this);
        
        this.jpPurchase.table_purchase.getModel().addTableModelListener(this);
    
        TableActionEvent evt = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                /*int id = Integer.parseInt(jpPurchase.table_purchase.getValueAt(row, 0).toString());
                jpPurchase.txt_purchase_id.setText(String.valueOf(id));   
                objProduct=objProductDao.CallProductQueryxId(id);
                jpPurchase.txt_purchase_product_code.setText(String.valueOf(objProduct.getCode()));
                jpPurchase.txt_purchase_product_name.setText(objProduct.getName());
                jpPurchase.txt_purchase_amount.setText(jpPurchase.table_purchase.getValueAt(row, 2).toString());
                jpPurchase.txt_purchase_price.setText(jpPurchase.table_purchase.getValueAt(row, 3).toString());
                jpPurchase.txt_purchase_subtotal.setText(jpPurchase.table_purchase.getValueAt(row, 3).toString());
                jpPurchase.txt_purchase_product_code.setEditable(false);*/
                
                //jpProductRegister.txt_product_code.setText(""+objProduct.getCode());
                //jpProductRegister.txt_product_name.setText(objProduct.getName());
                //jpProductRegister.txt_product_description.setText(objProduct.getDescription());
                //jpProductRegister.txt_product_price.setText(""+objProduct.getUnit_price());
                //jpProductRegister.cmb_product_category.getModel().setSelectedItem(new Category(objProduct.getCategory_id(),objProduct.getCategory_name()));
                /*
                jpProductRegister.txt_product_id.setEditable(false);
                jpProductRegister.btn_product_add.setVisible(false);
                jpProductRegister.btn_product_update.setVisible(true);
                */
            }

            @Override
            public void onDelete(int row) {
                if(jpPurchase.table_purchase.isEditing()){
                    jpPurchase.table_purchase.getCellEditor().stopCellEditing();
                }
                String productName = jpPurchase.table_purchase.getValueAt(row, 1).toString();
                Message msg = new Message("Confirm...","Do you want to remove the "+productName.toUpperCase());
                msg.eventOK(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        modelTablePurchase = (DefaultTableModel) jpPurchase.table_purchase.getModel();
                        modelTablePurchase.removeRow(jpPurchase.table_purchase.getSelectedRow());
                        CalculatePurchase();
                        jpPurchase.txt_purchase_product_code.requestFocus();
                        Notification noti = new Notification(jfMain, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Delete successful");
                        noti.showNotification();
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
        //Agrega los botones a la tabla
        jpPurchase.table_purchase.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(evt));
    }
       
    
    public void Seleccion(ListSelectionModel lsm)
        {
        modelo = lsm;
        }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jpPurchase.btn_add_product_to_buy){
            if(jpPurchase.txt_purchase_id.getText().trim().equals("")||
                    jpPurchase.txt_purchase_product_name.getText().trim().equals("")||
                    jpPurchase.txt_purchase_amount.getText().trim().equals("")||
                    jpPurchase.txt_purchase_price.getText().trim().equals("")||
                    Double.parseDouble(jpPurchase.txt_purchase_price.getText())<=0.0||
                    Double.parseDouble(jpPurchase.txt_purchase_amount.getText())<=0.0
                    ){
                Notification noti = new Notification(jfMain, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "All fields are required");
                noti.showNotification();
            }else{
            jpPurchase.table_purchase.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
            int idSupplier = jpPurchase.cmb_product_supplier.getItemAt(jpPurchase.cmb_product_supplier.getSelectedIndex()).getId();
            if(jpPurchase.table_purchase.getRowCount()==0||getIdSupplier==idSupplier){
                getIdSupplier = idSupplier;
                    int amount = Integer.parseInt(jpPurchase.txt_purchase_amount.getText().trim());
                    String productName = jpPurchase.txt_purchase_product_name.getText().trim();
                    double price = Double.parseDouble(jpPurchase.txt_purchase_price.getText().trim());
                    int idPurchase = Integer.parseInt(jpPurchase.txt_purchase_id.getText().trim());
                    String supplierName =jpPurchase.cmb_product_supplier.getItemAt(jpPurchase.cmb_product_supplier.getSelectedIndex()).getName();
                    if(amount>0){
                        temp = (DefaultTableModel) jpPurchase.table_purchase.getModel();
                        for(int i = 0; i<jpPurchase.table_purchase.getRowCount();i++){
                            if(jpPurchase.table_purchase.getValueAt(i, 1).equals(jpPurchase.txt_purchase_product_name.getText())){
                                Notification noti = new Notification(jfMain, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "The product is already registered.");
                                noti.showNotification();
                                jpPurchase.txt_purchase_product_code.setText("");
                                jpPurchase.txt_purchase_product_name.setText("");
                                jpPurchase.txt_purchase_amount.setText("");
                                jpPurchase.txt_purchase_price.setText("");
                                jpPurchase.txt_purchase_id.setText("");
                                jpPurchase.txt_purchase_subtotal.setText("");
                                jpPurchase.txt_purchase_product_code.requestFocus();
                                return;}
                        }
                        ArrayList listPurchase = new ArrayList();
                        item = 1;
                        listPurchase.add(item);
                        listPurchase.add(idPurchase);
                        listPurchase.add(productName);
                        listPurchase.add(amount);
                        listPurchase.add(price);
                        listPurchase.add(amount*price);
                        listPurchase.add(supplierName);
                        
                        Object[] obj = new Object[6];
                        obj[0]=listPurchase.get(1);
                        obj[1]=listPurchase.get(2);
                        obj[2]=listPurchase.get(3);
                        obj[3]=listPurchase.get(4);
                        obj[4]=listPurchase.get(5);
                        obj[5]=listPurchase.get(6);
                        temp.addRow(obj);
                        jpPurchase.table_purchase.setModel(temp);
                        
                        ClearFieldPurchase();
                        jpPurchase.cmb_product_supplier.setEditable(false);
                        jpPurchase.txt_purchase_product_code.requestFocus();
                        CalculatePurchase();}
            }else{
                Notification noti = new Notification(jfMain, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "You cannot make the same purchase from several suppliers");
                noti.showNotification();}}
        }else if(e.getSource()==jpPurchase.btn_confirm_purchase){
            if (jpPurchase.table_purchase.getRowCount()>0) {
                InsertPurchase();
            }
        }else if(e.getSource()== jpPurchase.btn_new_purchase){
            if (jpPurchase.table_purchase.getRowCount()>0) {
                ClearTableTemp();
                ClearFieldPurchase();
            }
        }
    }
    



    private void InsertPurchase(){
        double total = Double.parseDouble(jpPurchase.txt_purchase_total_to_pay.getText().trim());
        int id_employee=id_user;        
        if(objPurchaseDao.RegisterPurchaseQuery(getIdSupplier, id_employee, total)){
            int purchase_id = objPurchaseDao.purchaseId();
            for (int i = 0; i < jpPurchase.table_purchase.getRowCount(); i++) {
                int id_product = Integer.parseInt(jpPurchase.table_purchase.getValueAt(i, 0).toString());
                int purchase_amount = Integer.parseInt(jpPurchase.table_purchase.getValueAt(i, 2).toString());
                double purchase_price = Double.parseDouble(jpPurchase.table_purchase.getValueAt(i, 3).toString());
                double purchase_subtotal = purchase_price*purchase_amount;
                //Detalles de la compra
                objPurchaseDao.RegisterPurchaseDetailQuery(purchase_price, purchase_amount, purchase_subtotal,purchase_id, id_product);                
                //traer la cantidad
                objProduct = objProductDao.CallQuantityProductQuery(id_product);
                int amount = objProduct.getProduct_quantity()+purchase_amount;
                //System.out.println("Cantidad actual del producto "+objProduct.getProduct_quantity());
                //System.out.println("Cantidad reg "+purchase_amount);
                //System.out.println(amount +"   "+ id_product);
                objProductDao.UpdateStockQuery(amount, id_product);
            }
            ClearTableTemp();
            ClearFieldPurchase();
            Notification noti = new Notification(jfMain, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Successful purchase");
            noti.showNotification();
            JF_Print print = new JF_Print(purchase_id);
            print.setVisible(true);
            
        }
    }
    
    public void ListAllPurchse(){
        ClearTablePurchase();
        //jpPurchase.table_purchase.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
        List<Purchase> listPurchase = objPurchaseDao.ListAllPurchaseQuery();
        modelTablePurchase = (DefaultTableModel) jpReport.table_all_purchase.getModel();
        Object[] row = new Object[4];
        for (int i = 0; i < listPurchase.size(); i++) {
            row[0]=listPurchase.get(i).getId();
            row[1]=listPurchase.get(i).getSupplier_name_product();
            row[2]=formatoDinero.format(listPurchase.get(i).getTotal());
            try {
                row[3]=formatoFechaPersonal.format(format.parse(listPurchase.get(i).getCreated()));
            } catch (ParseException ex) {
                Logger.getLogger(PurchaseController.class.getName()).log(Level.SEVERE, null, ex);
            }
            modelTablePurchase.addRow(row);
        }
        jpReport.table_all_purchase.setModel(modelTablePurchase);                
    }
    
    public void ClearTablePurchase(){
        for (int i = 0; i < modelTablePurchase.getRowCount(); i++) {
            modelTablePurchase.removeRow(i);
            i--;
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource()==jpPurchase.txt_purchase_product_code){
            
            jpPurchase.txt_purchase_product_name.setText("");
            jpPurchase.txt_purchase_id.setText("");
        
            if(e.getKeyCode()==KeyEvent.VK_ENTER){
                if(jpPurchase.txt_purchase_product_code.getText().equals("")){
                    Notification noti = new Notification(jfMain, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "Missing product code");
                    noti.showNotification();
                }else{
                    String codeProduct =jpPurchase.txt_purchase_product_code.getText().trim();
                    if(Integer.parseInt(String.valueOf(objProductDao.CallProductQueryxCode(codeProduct).getId()))!=0){
                        objProduct = objProductDao.CallProductQueryxCode(codeProduct);                        
                        jpPurchase.txt_purchase_product_name.setText(objProduct.getName());
                        jpPurchase.txt_purchase_id.setText(""+objProduct.getId());
                        jpPurchase.txt_purchase_amount.requestFocus();
                    }else{
                        Notification noti = new Notification(jfMain, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "Code not registered");
                        noti.showNotification();
                        jpPurchase.txt_purchase_product_code.setText(" ");}
                }
            }else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                jpPurchase.txt_purchase_product_code.setText(" ");
            }
        }else if(e.getSource()==jpPurchase.txt_purchase_amount){
            if(e.getKeyCode()==KeyEvent.VK_ENTER){
                if(!jpPurchase.txt_purchase_amount.getText().equals("")){
                    jpPurchase.txt_purchase_price.requestFocus();
                }
            }
        }else if(e.getSource()==jpPurchase.txt_purchase_price){
            if(!jpPurchase.txt_purchase_price.getText().equals("")&&e.getExtendedKeyCode()==KeyEvent.VK_ENTER){
                jpPurchase.btn_add_product_to_buy.doClick();
            }
        }    
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int quantity;
        double price =  0;
        if(e.getSource()==jpPurchase.txt_purchase_price){
            if(jpPurchase.txt_purchase_amount.getText().equals("")||jpPurchase.txt_purchase_price.getText().equals("")){
                jpPurchase.txt_purchase_subtotal.setText("0.0");
            }else if(!jpPurchase.txt_purchase_amount.getText().trim().equals("")&&!jpPurchase.txt_purchase_price.getText().trim().equals("")){
                quantity= Integer.parseInt(jpPurchase.txt_purchase_amount.getText().trim());
                price = Double.parseDouble(jpPurchase.txt_purchase_price.getText().trim());
                jpPurchase.txt_purchase_subtotal.setText(""+quantity*price);
            }
        }else if(e.getSource()==jpPurchase.txt_purchase_amount){
            if(jpPurchase.txt_purchase_price.getText().equals("")||jpPurchase.txt_purchase_amount.getText().equals("")){
                jpPurchase.txt_purchase_subtotal.setText("0.0");
            }else if(!jpPurchase.txt_purchase_amount.getText().trim().equals("")&&!jpPurchase.txt_purchase_price.getText().trim().equals("")){
                quantity= Integer.parseInt(jpPurchase.txt_purchase_amount.getText().trim());
                price = Double.parseDouble(jpPurchase.txt_purchase_price.getText().trim());
                jpPurchase.txt_purchase_subtotal.setText(""+quantity*price);
            }
        }    

    }
    
    public void ClearFieldPurchase(){
        jpPurchase.txt_purchase_product_code.setText("");
        jpPurchase.txt_purchase_product_name.setText("");
        jpPurchase.txt_purchase_amount.setText("");
        jpPurchase.txt_purchase_price.setText("");
        jpPurchase.txt_purchase_id.setText("");
        jpPurchase.txt_purchase_subtotal.setText("");
        jpPurchase.txt_purchase_total_to_pay.setText("");
        jpPurchase.txt_purchase_product_code.setEditable(true);
    }
    
    public void CalculatePurchase(){
        double total = 0.00;
        int numRow = jpPurchase.table_purchase.getRowCount();
        for (int i = 0; i < numRow; i++) {
            total=total+Double.parseDouble(String.valueOf(jpPurchase.table_purchase.getValueAt(i, 4)));
        }
        jpPurchase.txt_purchase_total_to_pay.setText(""+total);
    }
    
    public void ClearTableTemp(){
        for (int i = 0; i < temp.getRowCount(); i++) {
            temp.removeRow(i);
            i--;
        }
    }


    @Override
    public void tableChanged(TableModelEvent tme) {      
        if(jpPurchase.table_purchase.getSelectedRow()>=0){
            /*int row = jpPurchase.table_purchase.getSelectedRow();
            System.out.println(row);
            int amount = Integer.parseInt(temp.getValueAt(row, 2).toString());
            System.out.println(amount);
            double price = Double.parseDouble(temp.getValueAt(row, 3).toString());
            System.out.println(price);
            System.out.println(String.valueOf(amount*price));
            //modelTablePurchase.setValueAt(amount, row, 2);
            //modelTablePurchase.setValueAt(modelTablePurchase.getValueAt(row, 3).toString(), row, 3);
            //temp.setValueAt("asd", row, 4);
            //temp.setValueAt(row, row, 4);
            System.out.println("CAMBIOS TABLA");*/
        }

        //if(jpPurchase.table_purchase.getRowCount()>0){
            
        //}
        
    }


}
