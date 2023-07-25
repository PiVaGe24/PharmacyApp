/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Category;
import Model.Product;
import Model.ProductDao;
import View.JF_Main;
import View.JP_ProductRegister;
import View.JP_TableProduct;
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
import java.text.NumberFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PIERO
 */
public class ProductController implements ActionListener,MouseListener,KeyListener,ItemListener{
    private Product objProduct;
    private ProductDao objProductDao;
    private JF_Main jfMain;
    private JP_TableProduct jpTableProduct;
    private JP_ProductRegister jpProductRegister;
    NumberFormat formatoNumero = NumberFormat.getInstance();
    NumberFormat formatoDinero = NumberFormat.getCurrencyInstance();
    DefaultTableModel modelTableProduct = new DefaultTableModel();

    public ProductController(Product objProduct, ProductDao objProductDao, JF_Main jfMain,JP_TableProduct jpTableProduct,JP_ProductRegister jpProductRegister) {
        this.objProduct = objProduct;
        this.objProductDao = objProductDao;
        this.jfMain = jfMain;
        this.jpTableProduct = jpTableProduct;
        this.jpProductRegister = jpProductRegister;
        //GlassPanePopup.install(jfMain);
        
        this.jpTableProduct.btn_product_register.addMouseListener(this);
        this.jpProductRegister.btn_product_add.addActionListener(this);
        this.jpProductRegister.btn_product_update.addActionListener(this);
        this.jpProductRegister.btn_product_cancel.addActionListener(this);
        this.jpTableProduct.table_product.addMouseListener(this);
        this.jpTableProduct.txt_product_search.addKeyListener(this);        
       
        this.jpProductRegister.txt_product_id.addKeyListener(this);
        this.jpProductRegister.txt_product_code.addKeyListener(this);
        this.jpProductRegister.txt_product_name.addKeyListener(this);
        this.jpProductRegister.txt_product_price.addKeyListener(this);
        this.jpProductRegister.txt_product_description.addKeyListener(this);
        this.jpProductRegister.cmb_product_category.addKeyListener(this);
        this.jpTableProduct.cmb_product_category.addItemListener(this);
        
        TableActionEvent evt = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                int id = Integer.parseInt(jpTableProduct.table_product.getValueAt(row, 0).toString());
                jpProductRegister.txt_product_id.setText(String.valueOf(id)); 
                Product objProduct = new Product();
                objProduct = objProductDao.CallProductQueryxId(id);
                jpProductRegister.txt_product_code.setText(""+objProduct.getCode());
                jpProductRegister.txt_product_name.setText(objProduct.getName());
                jpProductRegister.txt_product_description.setText(objProduct.getDescription());
                jpProductRegister.txt_product_price.setText(""+objProduct.getUnit_price());
                jpProductRegister.cmb_product_category.getModel().setSelectedItem(new Category(objProduct.getCategory_id(),objProduct.getCategory_name()));
                jpProductRegister.btn_product_add.setVisible(false);
                jpProductRegister.btn_product_update.setVisible(true);
                jfMain.panelSlideProduct.show(1);
                jpProductRegister.txt_product_code.requestFocus();
            }

            @Override
            public void onDelete(int row) {
                if(jpTableProduct.table_product.isEditing()){
                    jpTableProduct.table_product.getCellEditor().stopCellEditing();
                }
                    String productName = jpTableProduct.table_product.getValueAt(row, 2).toString();
                    int idProduct = Integer.parseInt(jpTableProduct.table_product.getValueAt(row, 0).toString());
                    
                    Message msg = new Message("Confirm...","Do you want to remove the "+productName.toUpperCase());
                    msg.eventOK(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            if(objProductDao.DeleteProductQuery(idProduct)){
                                ListAllProduct();
                                Notification noti = new Notification(jfMain, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Delete successful");
                                noti.showNotification();
                            }
                            GlassPanePopup.closePopupLast();
                        }
                    });
                    GlassPanePopup.showPopup(msg);
                    jpProductRegister.txt_product_code.requestFocus();
            }
            @Override
            public void onView(int row) {
                System.out.println("View" +row);
            }
        };
        //Agrega los botones a la tabla
        jpTableProduct.table_product.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor(evt));
        //Instanciamos los paneles del Slide >3||velocidad de la animacion
        //jfMain.panelSlideProduct.init(jpTableProduct,jpProductRegister,jpProductRegister);
        //jfMain.panelSlideProduct.setAnimate(20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String code = jpProductRegister.txt_product_code.getText().trim();
        String name = jpProductRegister.txt_product_name.getText().trim();
        String unitPrice = jpProductRegister.txt_product_price.getText().trim();
        String description =jpProductRegister.txt_product_description.getText().trim();
        String id = jpProductRegister.txt_product_id.getText().trim();
        int categoryid = jpProductRegister.cmb_product_category.getItemAt(jpProductRegister.cmb_product_category.getSelectedIndex()).getId();
        if(e.getSource()==jpProductRegister.btn_product_add){
            if(code.equals("")||
                    name.equals("")||
                    String.valueOf(unitPrice).equals("")||
                    description.equals("")){
                Notification noti = new Notification(jfMain, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "All fields are required");
                noti.showNotification();
            }else{
                objProduct.setCode(code);
                objProduct.setName(name);
                objProduct.setUnit_price(Double.parseDouble(unitPrice));
                objProduct.setDescription(description);
                objProduct.setCategory_id(categoryid);
                if(objProductDao.RegisterProductQuery(objProduct)){
                    ListAllProduct();
                    ClearFieldProduct();
                    Notification noti = new Notification(jfMain, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Register successful");
                    noti.showNotification();
                    jpProductRegister.txt_product_code.requestFocus();}
            }
        }else if(e.getSource()==jpProductRegister.btn_product_update){
            if(String.valueOf(code).equals("")||
                    name.equals("")||
                    String.valueOf(unitPrice).equals("")||
                    description.equals("")
                    || String.valueOf(categoryid).equals("")
                    ){
                Notification noti = new Notification(jfMain, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "All fields are required");
                noti.showNotification();
            }else{
                objProduct.setCode(code);
                objProduct.setName(name);
                objProduct.setUnit_price(Double.parseDouble(unitPrice));
                objProduct.setDescription(description);
                objProduct.setCategory_id(categoryid);
                objProduct.setId(Integer.parseInt(id));
                if(objProductDao.UpdateProductQuery(objProduct)){
                    ListAllProduct();
                    Notification noti = new Notification(jfMain, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Data updated successfully");
                    noti.showNotification();
                    jfMain.panelSlideProduct.show(0);
                    jpTableProduct.txt_product_search.requestFocus();}
            }
        }/*else if(e.getSource()==jpTableProduct.btn_product_register){

        }*/else if(e.getSource()==jpProductRegister.btn_product_cancel){
            jfMain.panelSlideProduct.show(0);
            jpTableProduct.txt_product_search.requestFocus();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource()==jpTableProduct.table_product){
            //int row=jfMain.table_products.rowAtPoint(e.getPoint());
        }else if(e.getSource()==jpTableProduct.btn_product_register){
            ClearFieldProduct();
            jfMain.panelSlideProduct.show(1);
            jpProductRegister.txt_product_code.requestFocus();
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
        String code = jpProductRegister.txt_product_code.getText().trim();
        String name = jpProductRegister.txt_product_name.getText().trim();
        String price = jpProductRegister.txt_product_price.getText().trim();
        String description = jpProductRegister.txt_product_description.getText().trim();
        if(e.getSource()==jpProductRegister.txt_product_code){
            if (e.getKeyCode() == KeyEvent.VK_ENTER&&!code.equals("")) {
                jpProductRegister.txt_product_name.requestFocus();
            }else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                jpProductRegister.txt_product_code.setText(" ");
            }
        }else if(e.getSource()==jpProductRegister.txt_product_name){
            if (e.getKeyCode() == KeyEvent.VK_ENTER&&!name.equals("")) {
                jpProductRegister.txt_product_price.requestFocus();
            }
        }else if(e.getSource()==jpProductRegister.txt_product_price){
            if (e.getKeyCode() == KeyEvent.VK_ENTER&&!price.equals("")) {
                jpProductRegister.txt_product_description.requestFocus();
            }
        }else if(e.getSource()==jpProductRegister.txt_product_description&&jpProductRegister.btn_product_add.isVisible()){
            if (e.getKeyCode() == KeyEvent.VK_ENTER&&
                    !code.equals("")&&
                    !name.equals("")&&
                    !price.equals("")&&
                    !description.equals("")
                    ) {
                System.out.println("Registrar Product");
            }else if(e.getKeyCode() == KeyEvent.VK_ENTER&&!description.equals("")){
                jpProductRegister.txt_product_code.requestFocus();
            }
        }else if(e.getSource()==jpProductRegister.txt_product_description&&jpProductRegister.btn_product_update.isVisible()){
            if (e.getKeyCode() == KeyEvent.VK_ENTER&&
                    !code.equals("")&&
                    !name.equals("")&&
                    !price.equals("")&&
                    !description.equals("")
                    ) {
                System.out.println("Actualiza Product");
            }else if(e.getKeyCode() == KeyEvent.VK_ENTER&&!description.equals("")){
                jpProductRegister.txt_product_code.requestFocus();
            }
        }
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource()==jpTableProduct.txt_product_search){
            ListAllProduct();
        }
    }
    
    public void ListAllProduct(){
        ClearTableProduct();
        jpTableProduct.table_product.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender());
        List <Product> listProduct = objProductDao.ListProductQuery(jpTableProduct.txt_product_search.getText().trim(),jpTableProduct.cmb_product_category.getItemAt(jpTableProduct.cmb_product_category.getSelectedIndex()).getId());
        modelTableProduct = (DefaultTableModel) jpTableProduct.table_product.getModel();
        Object[] row = new Object[7];
        for (int i = 0; i < listProduct.size(); i++) {  
            row[0]=listProduct.get(i).getId();
            row[1]=listProduct.get(i).getCode();
            row[2]=listProduct.get(i).getName();
            row[3]=listProduct.get(i).getDescription();
            row[4]=formatoDinero.format(listProduct.get(i).getUnit_price());
            row[5]=formatoNumero.format(listProduct.get(i).getProduct_quantity());
            row[6]=listProduct.get(i).getCategory_name();
            modelTableProduct.addRow(row);
        }
        jpTableProduct.table_product.setModel(modelTableProduct); 
    }
    
    public void ClearFieldProduct(){
        jpProductRegister.txt_product_id.setText("");
        jpProductRegister.txt_product_code.setText("");
        jpProductRegister.txt_product_name.setText("");
        jpProductRegister.txt_product_price.setText("");
        jpProductRegister.txt_product_description.setText("");
        jpProductRegister.cmb_product_category.setSelectedIndex(0);
        jpProductRegister.btn_product_update.setVisible(false);
        jpProductRegister.btn_product_add.setVisible(true);
    }
    
    public void ClearTableProduct(){
        for (int i = 0; i < modelTableProduct.getRowCount(); i++) {
            modelTableProduct.removeRow(i);
            i--;
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED){
            //id producto
            //System.out.println(jpTableProduct.cmb_product_category.getItemAt(jpTableProduct.cmb_product_category.getSelectedIndex()).getId());
            //name producto
            //System.out.println(jpTableProduct.cmb_product_category.getSelectedItem());
            //String item = (String) e.getItem();
            if(e.getSource()==jpTableProduct.cmb_product_category){
                //Hace que se liste
                ListAllProduct();
            }
            //System.out.println(item);
        }
    }
    
}
