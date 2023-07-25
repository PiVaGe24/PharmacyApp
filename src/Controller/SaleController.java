/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Customer;
import Model.CustomerDao;
import static Model.EmployeeDao.id_user;
import Model.Product;
import Model.ProductDao;
import Model.Sale;
import Model.SaleDao;
import View.JF_Main;
import View.JP_Report;
import View.JP_Sale;
import View.Notify.Notification;
import View.TableCustomButton.TableActionCellEditor;
import View.TableCustomButton.TableActionCellRender;
import View.TableCustomButton.TableActionEvent;
import View.toggle.ToggleListener;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PIERO
 */
public class SaleController implements ActionListener, MouseListener, KeyListener,TableModelListener,ToggleListener{
    private SaleDao saleDao;
    private JF_Main jfMain;
    private JP_Sale jpSale;
    private JP_Report jpReport;
    Product objProduct = new Product();
    ProductDao productDao = new ProductDao();
    CustomerDao customerDao = new CustomerDao();
    Customer objCustomer = new Customer();
    private int item = 0;
    NumberFormat formatoDinero = NumberFormat.getCurrencyInstance();
    DefaultTableModel modelTableSale = new DefaultTableModel();
    DefaultTableModel ModelTableCustomer = new DefaultTableModel();
    DefaultTableModel temp;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat formatoFechaPersonal = new SimpleDateFormat("EEE, d MMMM");//YYYY
    List<Customer> nameCustomer = customerDao.ListCustomerQuery("");
        
    public SaleController(SaleDao saleDao, JP_Sale jpSale,JF_Main jfMain, JP_Report jpReport) {
        this.saleDao = saleDao;
        this.jpSale= jpSale;
        this.jfMain= jfMain;
        this.jpReport= jpReport;
        this.jpSale.btn_sale_confirm.addActionListener(this);
        this.jpSale.btn_sale_new.addActionListener(this);
        this.jpSale.btn_sale_delete.addActionListener(this);
        this.jpSale.btn_sale_add_product.addActionListener(this);
        this.jpSale.txt_sale_product_code.addKeyListener(this);
        this.jpSale.txt_sale_quantity.addKeyListener(this);
        this.jpSale.txt_sale_customer_document.addKeyListener(this);
        this.jpSale.txt_customer_search.addKeyListener(this);
        this.jpSale.table_customer.addMouseListener(this);
        ;
        
        this.jpSale.table_sale.getModel().addTableModelListener(this);
        
        this.jpSale.tglbtn_quantity.addEventToggleSelected(this);
        
        //this.jpSale.txt_name_customer.addKeyListener(this);
        
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
                if(jpSale.table_sale.isEditing()){
                    jpSale.table_sale.getCellEditor().stopCellEditing();
                }
                if(jpSale.table_sale.getRowCount()>0){
                    modelTableSale = (DefaultTableModel) jpSale.table_sale.getModel();
                    modelTableSale.removeRow(row);
                    CalculateSale();
                    jpSale.txt_sale_product_code.requestFocus();
                    if(jpSale.table_sale.getRowCount()==0){
                        jpSale.txt_sale_customer_document.setEditable(true);
                    }
                }
            }
            @Override
            public void onView(int row) {
                System.out.println("View" +row);
            }
        };
        //Agrega los botones a la tabla
        jpSale.table_sale.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(evt));
    }

    public void Message(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
    
   /* public void autoComplete(String txt){
        String complete = "";
        int start =jpSale.txt_name_customer.getText().length();
        int last =jpSale.txt_name_customer.getText().length();
        int a;
        for (a = 0; a<nameCustomer.size(); a++) {
            System.out.println(nameCustomer.get(a).getFull_name().startsWith(txt));
            if(nameCustomer.get(a).getFull_name().startsWith(txt)){
                complete = nameCustomer.get(a).getFull_name();
                last = complete.length();
                break;
            }
        }
        if(last>start){
            jpSale.txt_name_customer.setText(complete);
            jpSale.txt_name_customer.setCaretPosition(last);
            jpSale.txt_name_customer.moveCaretPosition(start);
        }
    }*/
    
    public void actionPerformed(ActionEvent e) {
        String product_name = jpSale.txt_sale_product_name.getText().trim();
        String customer_name = jpSale.txt_sale_customer_name.getText().trim();
        String total_to_pay = jpSale.txt_sale_total_to_pay.getText().trim();
        String product_id = jpSale.txt_sale_product_id.getText().trim();
        String sub_total = jpSale.txt_sale_subtotal.getText().trim();
        String quantity = jpSale.txt_sale_quantity.getText().trim();

        if (e.getSource() == jpSale.btn_sale_confirm) {
            if(!customer_name.equals("")&&
                    jpSale.table_sale.getRowCount()>0&&
                    Double.parseDouble(total_to_pay)>0
                    ){
                insertSale();
            }else{
                Notification noti = new Notification(jfMain, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "There are no registered sales");
                noti.showNotification();}
        }else if (e.getSource() == jpSale.btn_sale_new) {
            if(jpSale.table_sale.getRowCount()>0){
                ClearTableTemp();
            }
            ClearAllFieldSale();
            jpSale.txt_sale_customer_document.setEditable(true);
            jpSale.txt_sale_customer_document.requestFocus();
        }else if (e.getSource() == jpSale.btn_sale_add_product
                &&
                !product_id.equals("")&&
                !customer_name.equals("")&&
                Double.parseDouble(sub_total)>0
                
                ) {
            //Agregar productos a la tabla de ventas temporalmente
            int amount = Integer.parseInt(quantity);
            double price = Double.parseDouble(jpSale.txt_sale_price.getText());
            int prod_id = Integer.parseInt(product_id);
            double subtotal = amount * price;
            
            int stock = Integer.parseInt(jpSale.txt_sale_stock.getText());
            
            if (stock >= amount) {
                item = item + 1;
                temp = (DefaultTableModel) jpSale.table_sale.getModel();
                for (int i = 0; i < jpSale.table_sale.getRowCount(); i++) {
                    if (jpSale.table_sale.getValueAt(i, 1).equals(product_name)) {     
                        if(stock>=amount+Integer.parseInt(temp.getValueAt(i, 2).toString())){
                            int cantidadActual = Integer.parseInt(temp.getValueAt(i, 2).toString());
                            temp.setValueAt(cantidadActual + amount, i, 2);                            
                            temp.setValueAt(Integer.parseInt(temp.getValueAt(i, 2).toString())*Double.parseDouble(temp.getValueAt(i, 3).toString()), i, 4);
                            CalculateSale();
                            ClearFieldSale();
                        }else{
                            JOptionPane.showMessageDialog(null, "SUPERO EL STOCK");
                        }
                        return;
                    }
                }
                ArrayList list = new ArrayList();
                list.add(item);
                list.add(prod_id);
                list.add(product_name);
                list.add(amount);
                list.add(price);
                list.add(subtotal);
                list.add(customer_name);

                Object[] obj = new Object[6];
                obj[0] = list.get(1);
                obj[1] = list.get(2);
                obj[2] = list.get(3);
                obj[3] = list.get(4);
                obj[4] = list.get(5);
                obj[5] = list.get(6);
                jpSale.table_sale.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
                temp.addRow(obj);
                jpSale.table_sale.setModel(temp);
                CalculateSale();
                ClearFieldSale();
                jpSale.txt_sale_product_code.requestFocus();
                jpSale.txt_sale_customer_document.setEditable(false);
                
            } else {
                Notification noti = new Notification(jfMain, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "Stock not available");
                noti.showNotification();
                ClearFieldSale();
                jpSale.txt_sale_product_code.requestFocus();
            }
        } 
        
        else if (e.getSource()==jpSale.btn_sale_add_product&&customer_name.equals("")) {
            Notification noti = new Notification(jfMain, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "Missing customer name");
            noti.showNotification();
            jpSale.txt_sale_customer_document.requestFocus();
        } else if (e.getSource()==jpSale.btn_sale_add_product&&product_name.equals("")){
            Notification noti = new Notification(jfMain, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "Missing product");
            noti.showNotification();
            jpSale.txt_sale_product_code.requestFocus();
        } else if (e.getSource()==jpSale.btn_sale_add_product&&quantity.equals("")){
            Notification noti = new Notification(jfMain, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "Quantity is missing");
            noti.showNotification();
            jpSale.txt_sale_quantity.requestFocus();
        }
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        String code_product = jpSale.txt_sale_product_code.getText().trim();
        //String quantity_product = jpSale.txt_sale_quantity.getText().trim();
        String sale_price = jpSale.txt_sale_price.getText().trim();
        String customer_name = jpSale.txt_sale_customer_name.getText().trim();
        String id_product = jpSale.txt_sale_product_id.getText().trim();
        String customer_id = jpSale.txt_sale_customer_document.getText().trim();
        String subtotal = jpSale.txt_sale_subtotal.getText().trim();
        if (e.getSource() == jpSale.txt_sale_product_code) {
//            jpSale.txt_sale_product_id.setText("");
//            jpSale.txt_sale_product_name.setText("");
//            jpSale.txt_sale_price.setText("0");
//            jpSale.txt_sale_subtotal.setText("0");
//            jpSale.txt_sale_stock.setText("0");
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (!"".equals(code_product)) {
                    objProduct = productDao.CallProductQueryxCode(code_product);
                    if (objProduct.getName() != null) {
                        jpSale.txt_sale_product_name.setText(objProduct.getName());
                        jpSale.txt_sale_product_id.setText("" + objProduct.getId());
                        jpSale.txt_sale_stock.setText("" + objProduct.getProduct_quantity());
                        jpSale.txt_sale_price.setText("" + objProduct.getUnit_price());
                        jpSale.txt_sale_quantity.setText("1");//REGISTRAR El PRODUCTO EN LA TABLA
                        sale_price = jpSale.txt_sale_price.getText().trim();
                        //if(!jpSale.txt_sale_quantity.getText().isEmpty()){
                        int quantity = Integer.parseInt(jpSale.txt_sale_quantity.getText().trim());
                        double price = Double.parseDouble(sale_price);
                        jpSale.txt_sale_subtotal.setText("" + quantity * price);
                        //}
                        
                        if(!jpSale.txt_sale_quantity.isEditable()){
                            jpSale.btn_sale_add_product.doClick();
                            jpSale.txt_sale_product_code.setText(" ");
                        }else{
                            jpSale.txt_sale_quantity.requestFocus();
                        } 
                    }else{
                        Notification noti = new Notification(jfMain, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "Product code not registered");
                        noti.showNotification();
                        jpSale.txt_sale_product_code.setText(" ");
                        //ClearFieldSale();
                        jpSale.txt_sale_product_code.requestFocus();
                    }
                    
                    
                }else{
                    Notification noti = new Notification(jfMain, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "Enter the product code");
                    noti.showNotification();}
                
                
                
            }else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                jpSale.txt_sale_product_code.setText(" ");
            }
            /*jpSale.txt_sale_product_id.setText("");
            jpSale.txt_sale_product_name.setText("");
            jpSale.txt_sale_price.setText("0");
            jpSale.txt_sale_subtotal.setText("0");
            jpSale.txt_sale_stock.setText("0");
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (!"".equals(jpSale.txt_sale_product_code.getText())) {
                    String code = jpSale.txt_sale_product_code.getText().trim();
                    objProduct = productDao.CallProductQueryxCode(code);
                    if (objProduct.getName() != null) {
                        jpSale.txt_sale_product_name.setText(objProduct.getName());
                        jpSale.txt_sale_product_id.setText("" + objProduct.getId());
                        jpSale.txt_sale_stock.setText("" + objProduct.getProduct_quantity());
                        jpSale.txt_sale_price.setText("" + objProduct.getUnit_price());
                        if(!jpSale.txt_sale_quantity.getText().isEmpty()){
                            int quantity = Integer.parseInt(jpSale.txt_sale_quantity.getText());
                            double price = Double.parseDouble(jpSale.txt_sale_price.getText());
                            jpSale.txt_sale_subtotal.setText("" + quantity * price);
                        }
                        jpSale.txt_sale_quantity.requestFocus();
                    }else{
                        Message("No existe ningún producto con ese código");
                        //ClearFieldSale();
                        jpSale.txt_sale_product_code.requestFocus();}
                }else{
                     Message("Ingrese el código del producto a vender");}
            }else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                jpSale.txt_sale_product_code.setText(" ");
            }*/
        }
        
        /*else if (e.getSource()==jpSale.txt_sale_quantity){
            if(e.getKeyCode() == KeyEvent.VK_ENTER&&jpSale.txt_sale_quantity.getText().trim().equals("")){
                Notification noti = new Notification(jfMain, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "Enter an amount");
                noti.showNotification();
            }else if(e.getKeyCode() == KeyEvent.VK_ENTER&&id_product.equals("")&&!customer_name.equals("")){
                jpSale.txt_sale_product_code.requestFocus();
            }else if (e.getKeyCode() == KeyEvent.VK_ENTER&&customer_name.equals("")&&!id_product.equals("")) {
                jpSale.txt_sale_customer_document.requestFocus();
            }else if(e.getKeyCode() == KeyEvent.VK_ENTER&&!customer_name.equals("")&&Double.parseDouble(subtotal)>0){
                jpSale.btn_sale_add_product.doClick();
            }
            else if(e.getKeyCode() == KeyEvent.VK_ENTER&&!jpSale.txt_sale_quantity.getText().trim().equals("")){
                jpSale.txt_sale_product_code.requestFocus();
            }  
        }*/
        
        else if(e.getSource()==jpSale.txt_sale_customer_document){
            jpSale.txt_sale_customer_name.setText("");
            if (e.getKeyCode() == KeyEvent.VK_ENTER&&!customer_id.equals("")) {
                objCustomer = customerDao.CallCustomerQueryxId(Integer.parseInt(customer_id));
                if(objCustomer.getFull_name()!=null){
                    jpSale.txt_sale_customer_name.setText(objCustomer.getFull_name());
                    jpSale.txt_sale_product_code.requestFocus();
                }else{
                    Message("Codigo de cliente no registrado");}
            }if(e.getKeyCode() == KeyEvent.VK_ENTER&&!customer_name.equals("")){
                jpSale.txt_sale_product_code.requestFocus();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == jpSale.txt_sale_quantity||!jpSale.txt_sale_quantity.getText().isEmpty()) {
            if(!jpSale.txt_sale_price.getText().isEmpty()&&!jpSale.txt_sale_quantity.getText().isEmpty()){
               int quantity = Integer.parseInt(jpSale.txt_sale_quantity.getText());
               double price = Double.parseDouble(jpSale.txt_sale_price.getText());
               jpSale.txt_sale_subtotal.setText("" + quantity * price);
            }else{
                jpSale.txt_sale_subtotal.setText("0");
            }
        }else if(e.getSource()==jpSale.txt_customer_search){
            ListCustomer();
        }
    }
     
    private void insertSale() {
        int customer_id = Integer.parseInt(jpSale.txt_sale_customer_document.getText());
        double total = Double.parseDouble(jpSale.txt_sale_total_to_pay.getText());
        if (saleDao.registerSaleQuery(customer_id, id_user , total)&&jpSale.table_sale.getRowCount()>0) {
            Product product = new Product();
            ProductDao productDao = new ProductDao();
            int sale_id = saleDao.saleId();

            // registerPurchaseDetailQuery();
            for (int i = 0; i < jpSale.table_sale.getRowCount(); i++) {
                int product_id = Integer.parseInt(jpSale.table_sale.getValueAt(i, 0).toString());
                int sale_quantity = Integer.parseInt(jpSale.table_sale.getValueAt(i, 2).toString());
                double sale_price = Double.parseDouble(jpSale.table_sale.getValueAt(i, 3).toString());
                double sale_subtotal = sale_quantity * sale_price;

                saleDao.registerSaleDetailQuery(product_id, sale_id, sale_quantity, sale_price, sale_subtotal);

                //Traer la cantidad de productos
                product = productDao.CallQuantityProductQuery(product_id);
                //Obtener cantidad actual y restar la cantidad comprada
                int amount = product.getProduct_quantity() - sale_quantity;
                //System.out.println("Cantidad Actual:" + product.getProduct_quantity());
                //System.out.println("Monto vendido :" + sale_quantity);
                productDao.UpdateStockQuery(amount, product_id);
            }
            JOptionPane.showMessageDialog(null, "Venta generada");
            ClearTableTemp();
            ClearAllFieldSale();
        }
    }
    
    //Listar todas las ventas
    public void listAllSales() {
        ClearTableSale();
        List<Sale> list = saleDao.listAllSalesQuery();
        modelTableSale = (DefaultTableModel) jpReport.table_all_sale.getModel();
        //Recorrer la lista+        
        Object[] row = new Object[5];
            for (int i = 0; i < list.size(); i++) {
                row[0] = list.get(i).getId();
                row[1] = list.get(i).getCustomer_name();
                row[2] = list.get(i).getEmployee_name();
                row[3] = formatoDinero.format(list.get(i).getTotal_to_pay());
            try {
                row[4] = formatoFechaPersonal.format(format.parse(list.get(i).getSale_date()));
            } catch (ParseException ex) {
                Logger.getLogger(SaleController.class.getName()).log(Level.SEVERE, null, ex);
            }
                modelTableSale.addRow(row);
            }
        jpReport.table_all_sale.setModel(modelTableSale);
        }
    
    private void CalculateSale() {
        double total = 0.00;
        int numRow = jpSale.table_sale.getRowCount();
        for (int i = 0; i < numRow; i++) {
            total = total + Double.parseDouble(String.valueOf(jpSale.table_sale.getValueAt(i, 4)));
        }
        jpSale.txt_sale_total_to_pay.setText("" + total);
    }
    
    //Limpiar tabla
    public void ClearTableSale() {
        for (int i = 0; i < modelTableSale.getRowCount(); i++) {
            modelTableSale.removeRow(i);
            i = i - 1;
        }
    }

    //Limpiar tabla temporal
    public void ClearTableTemp() {
        for (int i = 0; i < temp.getRowCount(); i++) {
            temp.removeRow(i);
            i = i - 1;
        }
    }
    
    // Limpiar algunos campos
    public void ClearFieldSale() {
        jpSale.txt_sale_product_code.setText("");
        jpSale.txt_sale_product_name.setText("");
        jpSale.txt_sale_quantity.setText("");
        jpSale.txt_sale_product_id.setText("");
        jpSale.txt_sale_price.setText("");
        jpSale.txt_sale_subtotal.setText("");
        jpSale.txt_sale_stock.setText("");
    }

    //Limpiar todos los campos
    public void ClearAllFieldSale() {
        jpSale.txt_sale_product_code.setText("");
        jpSale.txt_sale_product_name.setText("");
        jpSale.txt_sale_quantity.setText("");
        jpSale.txt_sale_product_id.setText("");
        jpSale.txt_sale_price.setText("");
        jpSale.txt_sale_subtotal.setText("");
        jpSale.txt_sale_customer_document.setText("");
        jpSale.txt_sale_customer_name.setText("");
        jpSale.txt_sale_total_to_pay.setText("");
        jpSale.txt_sale_stock.setText("");
    }

    private void ListCustomer() {
        ClearTableCustomer();
        List <Customer> listCustomer = customerDao.ListCustomerQuery(jpSale.txt_customer_search.getText());
        ModelTableCustomer = (DefaultTableModel) jpSale.table_customer.getModel();
        Object[] row = new Object[2];
        for(int i=0;i<listCustomer.size();i++){
            row[0]=listCustomer.get(i).getId();
            row[1]=listCustomer.get(i).getFull_name();
            ModelTableCustomer.addRow(row);
        }
        jpSale.table_customer.setModel(ModelTableCustomer);
    }
    
    public void ClearTableCustomer(){
        for(int i=0;i<ModelTableCustomer.getRowCount();i++){
            ModelTableCustomer.removeRow(i);
            i--;
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource()==jpSale.table_customer){
            jpSale.txt_id_customer.setText(String.valueOf(ModelTableCustomer.getValueAt(jpSale.table_customer.getSelectedRow(),0)));
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
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        Product product = new Product();
        //Obtener cantidad actual y restar la cantidad comprada  
        if(jpSale.table_sale.getRowCount()>0&&e.getFirstRow()>=0&&e.getColumn()>=0){
            product = productDao.CallQuantityProductQuery((int)temp.getValueAt(row, 0));
            int amount = product.getProduct_quantity();
            System.out.println(temp.getValueAt(row, 2));
            if(Integer.parseInt(temp.getValueAt(row, 2).toString())==0){
                temp.setValueAt("1", row, 2);
                temp.setValueAt((double) temp.getValueAt(row, 3), row, 4);
                CalculateSale();
            }else if(jpSale.table_sale.getRowCount()>0&&e.getFirstRow()>=0&&e.getColumn()>=0&&Integer.parseInt(temp.getValueAt(row, 2).toString())>amount){
                temp.setValueAt(amount, row, 2);
                temp.setValueAt(amount*(double) temp.getValueAt(row, 3), row, 4);
                CalculateSale();
                JOptionPane.showMessageDialog(null, "Supera el stock");
            }else if(jpSale.table_sale.getRowCount()>0&&e.getFirstRow()>=0&&e.getColumn()>=0&&column==2){
                System.out.println("Cantidad modificada");
                int quatity=Integer.parseInt(temp.getValueAt(row, 2).toString());
                double price = Double.parseDouble(temp.getValueAt(row, 3).toString());
                temp.setValueAt(quatity*price, row, 4);
            }
        }
        
        // Obtener información sobre el cambio en la tabla
        //System.out.println(e.getSource());
        //String columnName = model.getColumnName(column);
        //Object data = model.getValueAt(row, column);
        // Realizar la acción necesaria
        //System.out.println("Cambio en la fila " + row + ", columna " + column + ": ");
    }

    @Override
    public void onSelected(boolean selected) {
        if(selected==true){
            jpSale.txt_sale_quantity.setEditable(selected);
        }else{
            jpSale.txt_sale_quantity.setEditable(selected);
        }
    }

    @Override
    public void onAnimated(float animated) {
    }
}
