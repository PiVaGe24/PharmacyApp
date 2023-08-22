/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Customer;
import Model.MenuItemDao;
import Model.Permission;
import Model.Rol;
import Model.RolDao;
import View.JP_EmployeeRegister;
import View.JP_RolPermissions;
import View.JP_TableEmployee;
import View.SimpleMessage.GlassPanePopup;
import View.SimpleMessage.Message;
import View.TableCustomButton.TableActionCellEditor;
import View.TableCustomButton.TableActionCellRender;
import View.TableCustomButton.TableActionEvent;
import View.toggle.ToggleButton;
import View.toggle.ToggleListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PIERO
 */
public class RolesPermissionsController implements ActionListener,ItemListener, ToggleListener {
    private RolDao rolDao;
    private MenuItemDao menuItemDao;
    private JP_EmployeeRegister jpEmployeeRegister;
    private JP_TableEmployee jpTableEmployee;
    private JP_RolPermissions jpPermissions;
    DefaultTableModel modelTableRol = new DefaultTableModel();
    Map<String, ToggleButton> permissionButtonMap = new HashMap();
    //List<Permission> permissions = loadPermissionsFromDatabase();
    List<ToggleButton> toggleButtons = new ArrayList<>();
    Map<ToggleButton, Integer> buttonPermissionIdMap = new HashMap<>();

    public RolesPermissionsController(RolDao rolDao, MenuItemDao menuItemDao,JP_EmployeeRegister jpEmployeeRegister,JP_TableEmployee jpTableEmployee, JP_RolPermissions jpPermission) {
        this.rolDao = rolDao;
        this.menuItemDao=menuItemDao;
        this.jpEmployeeRegister = jpEmployeeRegister;
        this.jpTableEmployee = jpTableEmployee;
        this.jpPermissions = jpPermission;
        this.jpPermissions.cmb_rol.addItemListener(this);
        this.jpPermissions.tglDashboard.addEventToggleSelected(this);
        this.jpPermissions.tglEmployee.addEventToggleSelected(this);
        this.jpPermissions.tglCustomer.addEventToggleSelected(this);
        this.jpPermissions.tglSupplier.addEventToggleSelected(this);
        this.jpPermissions.tglProduct.addEventToggleSelected(this);
        this.jpPermissions.tglCategory.addEventToggleSelected(this);
        this.jpPermissions.tglPurchase.addEventToggleSelected(this);
        this.jpPermissions.tglSale.addEventToggleSelected(this);
        this.jpPermissions.tglReport.addEventToggleSelected(this);
        this.jpPermissions.btn_rol_add.addActionListener(this);
        this.jpPermissions.btn_rol_cancel.addActionListener(this);
        this.jpPermissions.btn_rol_update.addActionListener(this);
        
        buttonPermissionIdMap.put(jpPermissions.tglDashboard, 1);
        buttonPermissionIdMap.put(jpPermissions.tglEmployee, 2);
        buttonPermissionIdMap.put(jpPermissions.tglCustomer, 3);
        buttonPermissionIdMap.put(jpPermissions.tglSupplier, 4);
        buttonPermissionIdMap.put(jpPermissions.tglProduct, 5);
        buttonPermissionIdMap.put(jpPermissions.tglCategory, 6);
        buttonPermissionIdMap.put(jpPermissions.tglPurchase, 7);
        buttonPermissionIdMap.put(jpPermissions.tglSale, 8);
        buttonPermissionIdMap.put(jpPermissions.tglReport, 9);
        
        permissionButtonMap.put("Dashboard", jpPermissions.tglDashboard);
        permissionButtonMap.put("Employee", jpPermissions.tglEmployee);
        permissionButtonMap.put("Customer", jpPermissions.tglCustomer);
        permissionButtonMap.put("Supplier", jpPermissions.tglSupplier);
        permissionButtonMap.put("Product", jpPermissions.tglProduct);
        permissionButtonMap.put("Category", jpPermissions.tglCategory);
        permissionButtonMap.put("Purchase", jpPermissions.tglPurchase);
        permissionButtonMap.put("Sale", jpPermissions.tglSale);
        permissionButtonMap.put("Report", jpPermissions.tglReport);
        
        TableActionEvent evt = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                jpPermission.txt_rol_id.setText(jpPermission.table_rol.getValueAt(row, 0).toString());
                jpPermission.txt_rol_name.setText(jpPermission.table_rol.getValueAt(row, 1).toString());
                jpPermissions.btn_rol_add.setVisible(false);
                jpPermissions.btn_rol_update.setVisible(true);
                jpPermissions.btn_rol_cancel.setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                if(jpPermission.table_rol.isEditing()){
                    jpPermission.table_rol.getCellEditor().stopCellEditing();
                }
                int idseleccionado = Integer.parseInt(jpPermission.table_rol.getValueAt(row, 0).toString());
                String rol = jpPermission.table_rol.getValueAt(row, 1).toString();

                Message msg = new Message("Confirm...","Do you want to remove the Rol : "+rol);
                    msg.eventOK(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            if(rolDao.deleteRolQuery(idseleccionado)){
                                FillCmbRol();
                                ListAllRol();
                                jpPermissions.txt_rol_id.setText("");
                                jpPermissions.txt_rol_name.setText("");
                                jpPermissions.btn_rol_add.setVisible(true);
                                jpPermissions.btn_rol_update.setVisible(false);
                                jpPermissions.btn_rol_cancel.setVisible(false);
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
        jpPermission.table_rol.getColumnModel().getColumn(2).setCellEditor(new TableActionCellEditor(evt));
        FillCmbRol();
        ListAllRol();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jpPermissions.btn_rol_add){
            if(!jpPermissions.txt_rol_name.getText().trim().isEmpty()){
                if(rolDao.registerRolQuery(jpPermissions.txt_rol_name.getText())){
                    ListAllRol();
                    FillCmbRol();
                    jpPermissions.txt_rol_name.setText("");
                }
            }
        }else if(e.getSource()==jpPermissions.btn_rol_update){
            if(rolDao.updateRolQuery(jpPermissions.txt_rol_name.getText().trim(), Integer.parseInt(jpPermissions.txt_rol_id.getText().trim()))){
                ListAllRol();
                FillCmbRol();
                jpPermissions.txt_rol_id.setText("");
                jpPermissions.txt_rol_name.setText("");
                jpPermissions.btn_rol_add.setVisible(true);
                jpPermissions.btn_rol_update.setVisible(false);
                jpPermissions.btn_rol_cancel.setVisible(false);
            }
        }else if(e.getSource()==jpPermissions.btn_rol_cancel){
            jpPermissions.txt_rol_id.setText("");
            jpPermissions.txt_rol_name.setText("");
            jpPermissions.btn_rol_add.setVisible(true);
            jpPermissions.btn_rol_update.setVisible(false);
            jpPermissions.btn_rol_cancel.setVisible(false);
        }
    }

    public void ListAllRol() {
        modelTableRol.setRowCount(0);
        jpPermissions.table_rol.clearSelection();
        
        jpPermissions.table_rol.getColumnModel().getColumn(2).setCellRenderer(new TableActionCellRender());
        List<Rol> list_employee = rolDao.ListRolQuery();
        modelTableRol = (DefaultTableModel) jpPermissions.table_rol.getModel();
        Object[] row = new Object[2];
        list_employee.stream().map((employe) -> {
            row[0] = employe.getId();
            row[1] = employe.getName();
            return row;
        }).forEachOrdered(modelTableRol::addRow);
    }

    public void FillCmbRol() {
        List<Rol> listRol1 = rolDao.fillRolSql(1);
        List<Rol> listRol = rolDao.fillRolSql(0);

        jpEmployeeRegister.cmb_employee_rol.removeAllItems();
        jpPermissions.cmb_rol.removeAllItems();
        jpTableEmployee.cmb_employee_rol.removeAllItems();
        jpPermissions.cmb_rol.addItem(new Rol(0, "Select"));
        jpTableEmployee.cmb_employee_rol.addItem(new Rol(0, "All"));
        
        for (int i = 0; i < listRol.size(); i++) {
            jpEmployeeRegister.cmb_employee_rol.addItem(new Rol(listRol.get(i).getId(), listRol.get(i).getName()));
            jpTableEmployee.cmb_employee_rol.addItem(new Rol(listRol.get(i).getId(), listRol.get(i).getName()));
        }
        
        for (int i = 0; i < listRol1.size(); i++) {
            jpPermissions.cmb_rol.addItem(new Rol(listRol1.get(i).getId(), listRol1.get(i).getName()));
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
             List<ToggleButton> toggleButtons = Arrays.asList(
                jpPermissions.tglDashboard,
                jpPermissions.tglEmployee,
                jpPermissions.tglCustomer,
                jpPermissions.tglSupplier,
                jpPermissions.tglProduct,
                jpPermissions.tglCategory,
                jpPermissions.tglPurchase,
                jpPermissions.tglSale,
                jpPermissions.tglReport
            );
            Rol item = (Rol) e.getItem();
            if(item.getId()!=0){
                List<Permission> permissions = menuItemDao.loadPermissionsFromDatabase(item.getId());
                    
                permissions.forEach((permission) -> {
                    ToggleButton toggleButton = permissionButtonMap.get(permission.getName());
                     if (toggleButton != null) {
                         toggleButton.setSelected(permission.getStatus());
                     }
                 });               
                /*for (Permission permission : permissions) {
                    System.out.println("ID: " + permission.getId());
                    System.out.println("Name: " + permission.getName());
                    System.out.println("Status: " + (permission.getStatus() ? "Prendido" : "Apagado"));
                    System.out.println();
                }*/
                 //System.out.println(item.getId());
                 toggleButtons.forEach((toggleButton) -> {
                     toggleButton.setEnabled(true);
                 });
            }else{
                
                toggleButtons.stream().map((toggleButton) -> {
                    toggleButton.setEnabled(false);
                     return toggleButton;
                 }).forEachOrdered((toggleButton) -> {
                     toggleButton.setSelected(false);
                 });
            }
            //System.out.println(item.getId());
            /*if (e.getSource() == jpPermissions.cmb_rol) {
                System.out.println(e.getItem() + " " + e.getStateChange());
                //System.out.println(e.getItemSelectable());
            }
            System.out.println(item.getId());*/
            //System.out.println(item);
        }
    }

    @Override
    public void onSelected(boolean selected, ToggleButton btn) {
        if (getSelectedRolId() != 0) {
            Integer permissionId = buttonPermissionIdMap.get(btn);
            if (permissionId != null) {
                rolDao.updatePermissionsRolQuery(selected, getSelectedRolId(), permissionId);
            }
        }
    }

    @Override
    public void onAnimated(float animated) {
    }
    
    private int getSelectedRolId(){
        return jpPermissions.cmb_rol
                .getItemAt(jpPermissions.cmb_rol.getSelectedIndex())
                .getId();
    }
        
}
