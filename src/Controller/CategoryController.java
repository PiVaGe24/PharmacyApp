/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Category;
import Model.CategoryDao;
import View.JF_Main;
import View.JP_Category;
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
public class CategoryController implements ActionListener,MouseListener,KeyListener{
    private Category category;
    private CategoryDao categoryDao;
    private JF_Main jfMain;
    private JP_Category jpCategory;
    private JP_ProductRegister jpProductRegister;
    private JP_TableProduct jpTableProduct;
    DefaultTableModel modelTableCategory = new DefaultTableModel();

    public CategoryController(Category category, CategoryDao categoryDao,JF_Main jfMain,JP_ProductRegister jpProductRegister, JP_Category jpCategory,JP_TableProduct jpTableProduct) {
        this.category = category;
        this.categoryDao = categoryDao;
        this.jfMain = jfMain;
        this.jpCategory = jpCategory;
        this.jpProductRegister = jpProductRegister;
        this.jpTableProduct = jpTableProduct;
        this.jpCategory.btn_category_register.addActionListener(this);
        this.jpCategory.btn_category_update.addActionListener(this);
        this.jpCategory.btn_category_delete.addActionListener(this);
        this.jpCategory.btn_category_cancel.addActionListener(this);
        this.jpCategory.txt_category_search.addKeyListener(this);
        this.jpCategory.table_category.addMouseListener(this);
        
        TableActionEvent evt = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                jpCategory.txt_category_id.setText(jpCategory.table_category.getValueAt(row, 0).toString());
                jpCategory.txt_category_name.setText(jpCategory.table_category.getValueAt(row, 1).toString());
                jpCategory.btn_category_register.setVisible(false);
                jpCategory.btn_category_update.setVisible(true);
                jpCategory.btn_category_cancel.setVisible(true);
                jpCategory.txt_category_name.requestFocus();
            }

            @Override
            public void onDelete(int row) {
                if(jpCategory.table_category.isEditing()){
                    jpCategory.table_category.getCellEditor().stopCellEditing();
                }
                    String category=jpCategory.table_category.getValueAt(row, 1).toString();
                    Message msg = new Message("Confirm...","Do you want to remove the "+category.toUpperCase());
                    msg.eventOK(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                                int id = Integer.parseInt(jpCategory.table_category.getValueAt(row, 0).toString());
                                if(categoryDao.DeleteCategoryQuery(id)){
                                    ClearFieldCategory();
                                    ListAllCategory();
                                    FillCategory();
                                    jpCategory.btn_category_cancel.setVisible(false);
                                    jpCategory.btn_category_update.setVisible(false);
                                    jpCategory.btn_category_register.setVisible(true);    
                                    Notification noti = new Notification(jfMain, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Delete successful");
                                    noti.showNotification();
                                    jpCategory.txt_category_name.requestFocus();
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
        //Agrega los botones a la tabla
        jpCategory.table_category.getColumnModel().getColumn(2).setCellEditor(new TableActionCellEditor(evt));
        
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jpCategory.btn_category_register){
            String name = jpCategory.txt_category_name.getText().trim();
            if(name.equals("")){
                Notification noti = new Notification(jfMain, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "All fields are required");
                noti.showNotification();
            }else{
                category.setName(name);
                if(categoryDao.RegisterCategoryQuery(category)){
                    Notification noti = new Notification(jfMain, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Register successful");
                    noti.showNotification();
                    ClearFieldCategory();
                    ListAllCategory();
                    FillCategory();
                }
            }
        }else if(e.getSource()==jpCategory.btn_category_update){
            if(jpCategory.txt_category_name.getText().equals("")){
                Notification noti = new Notification(jfMain, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "All fields are required");
                noti.showNotification();
            }else{
                category.setId(Integer.parseInt(jpCategory.txt_category_id.getText()));
                category.setName(jpCategory.txt_category_name.getText().trim());
                if(categoryDao.UpdateCategoryQuery(category)){
                    ClearFieldCategory();
                    ListAllCategory();
                    FillCategory();
                }
            }
        }else if(e.getSource()==jpCategory.btn_category_cancel){
            ClearFieldCategory();
        }
    }

    public void ListAllCategory(){
        ClearTableCategory();
        jpCategory.table_category.getColumnModel().getColumn(2).setCellRenderer(new TableActionCellRender());
        List <Category> ListCategory = categoryDao.ListCategoryQuery(jpCategory.txt_category_search.getText());
        modelTableCategory = (DefaultTableModel)jpCategory.table_category.getModel();
        Object[] row = new Object[2];
            for (int i = 0; i < ListCategory.size(); i++) {
                row[0] = ListCategory.get(i).getId();
                row[1] = ListCategory.get(i).getName();
                modelTableCategory.addRow(row);
            }
        jpCategory.table_category.setModel(modelTableCategory);
        }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource()==jpCategory.table_category){
            
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
        if(e.getSource()==jpCategory.txt_category_search){
            ListAllCategory();
        }
    }
    
    public void ClearTableCategory(){
        for (int i = 0; i < modelTableCategory.getRowCount(); i++) {
            modelTableCategory.removeRow(i);
            i--;
        }
    }
    
    public void ClearFieldCategory(){
        jpCategory.txt_category_id.setText("");
        jpCategory.txt_category_name.setText("");
        jpCategory.btn_category_register.setVisible(true);
        jpCategory.btn_category_cancel.setVisible(false);
        jpCategory.btn_category_update.setVisible(false);
    }
    
    public void FillCategory(){
        List <Category> listCategory = categoryDao.fillCategorySql();
        jpProductRegister.cmb_product_category.removeAllItems();
        jpTableProduct.cmb_product_category.removeAllItems();
        jpTableProduct.cmb_product_category.addItem(new Category(0,"All"));
        for (int i = 0; i < listCategory.size(); i++) {
            jpProductRegister.cmb_product_category.addItem(new Category(listCategory.get(i).getId(),listCategory.get(i).getName()));
            jpTableProduct.cmb_product_category.addItem(new Category(listCategory.get(i).getId(),listCategory.get(i).getName()));
        }
    }
}
