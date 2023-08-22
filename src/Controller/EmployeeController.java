package Controller;

import Model.Employee;
import Model.EmployeeDao;
import static Model.EmployeeDao.id_user;
import Model.Rol;
import View.JF_Main;
import View.JP_EmployeeRegister;
import View.JP_Profile;
import View.JP_TableEmployee;
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
import java.util.Optional;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PIERO
 */
public class EmployeeController implements ActionListener,MouseListener,KeyListener,ItemListener{
    private Employee employee;
    private EmployeeDao employeeDao;
    private JF_Main jfMain;
    private JP_Profile jpProfile;
    private JP_EmployeeRegister jpEmployeeRegister;
    private JP_TableEmployee jpTableEmployee;
    private JTextField[] textFields;
    DefaultTableModel modelTableEmployee = new DefaultTableModel();

    public EmployeeController(Employee employee, EmployeeDao employeeDao,JP_TableEmployee jpTableEmployee,JP_EmployeeRegister jpEmployeeRegister,JF_Main jfMain,JP_Profile jpProfile) {
        this.employee = employee;
        this.employeeDao = employeeDao;
        this.jpEmployeeRegister = jpEmployeeRegister;
        this.jpTableEmployee = jpTableEmployee;
        this.jfMain = jfMain;
        this.jpProfile = jpProfile;
        //GlassPanePopup.install(jfMain);
        
        this.jpTableEmployee.txt_employee_search.addKeyListener(this);
        this.jpTableEmployee.btn_employee_register.addMouseListener(this);
        this.jpTableEmployee.table_employee.addMouseListener(this);
        this.jpEmployeeRegister.btn_employee_add.addActionListener(this);
        this.jpEmployeeRegister.btn_employee_update.addActionListener(this);
        this.jpEmployeeRegister.btn_employee_cancel.addActionListener(this);
        
        this.jpEmployeeRegister.txt_employee_id.addKeyListener(this);
        this.jpEmployeeRegister.txt_employee_fullname.addKeyListener(this);
        this.jpEmployeeRegister.txt_employee_username.addKeyListener(this);
        this.jpEmployeeRegister.txt_employee_address.addKeyListener(this);
        this.jpEmployeeRegister.txt_employee_telephone.addKeyListener(this);
        this.jpEmployeeRegister.txt_employee_email.addKeyListener(this);
        this.jpEmployeeRegister.txt_employee_password.addKeyListener(this);
        this.jpProfile.txt_profile_modify_password.addKeyListener(this);
        this.jpProfile.txt_profile_confirm_password.addKeyListener(this);
        this.jpProfile.btn_profile_update.addActionListener(this);
        this.jpProfile.cmb_profile_languaje.addItemListener(this);
        this.jpTableEmployee.cmb_employee_rol.addItemListener(this);
        
        textFields = new JTextField[] {
            this.jpEmployeeRegister.txt_employee_id,
            this.jpEmployeeRegister.txt_employee_fullname,
            this.jpEmployeeRegister.txt_employee_username,
            this.jpEmployeeRegister.txt_employee_address,
            this.jpEmployeeRegister.txt_employee_telephone,
            this.jpEmployeeRegister.txt_employee_email,
            this.jpEmployeeRegister.txt_employee_password,
        };
        TableActionEvent evt = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                if(jpTableEmployee.table_employee.getValueAt(row, 0).toString().equals("1")){
                    jpEmployeeRegister.cmb_employee_rol.setEnabled(false);
                }else{jpEmployeeRegister.cmb_employee_rol.setEnabled(true);}
                jpEmployeeRegister.txt_employee_id.setText(jpTableEmployee.table_employee.getValueAt(row, 0).toString());
                jpEmployeeRegister.txt_employee_fullname.setText(jpTableEmployee.table_employee.getValueAt(row, 1).toString());
                jpEmployeeRegister.txt_employee_username.setText(jpTableEmployee.table_employee.getValueAt(row, 2).toString());
                jpEmployeeRegister.txt_employee_address.setText(jpTableEmployee.table_employee.getValueAt(row, 3).toString());
                jpEmployeeRegister.txt_employee_telephone.setText(jpTableEmployee.table_employee.getValueAt(row, 4).toString());
                jpEmployeeRegister.txt_employee_email.setText(jpTableEmployee.table_employee.getValueAt(row, 5).toString());
                jpEmployeeRegister.cmb_employee_rol.getModel().setSelectedItem(new Rol(Integer.parseInt(jpTableEmployee.table_employee.getValueAt(row, 7).toString()), jpTableEmployee.table_employee.getValueAt(row, 6).toString()));
                
                jpEmployeeRegister.txt_employee_password.setText("***");
                jpEmployeeRegister.txt_employee_id.setEditable(false);
                jpEmployeeRegister.txt_employee_password.setEditable(false);
                jpEmployeeRegister.btn_employee_add.setVisible(false);
                jpEmployeeRegister.btn_employee_update.setVisible(true);
                jfMain.panelSlideEmployee.show(1);
                jpEmployeeRegister.txt_employee_fullname.requestFocus();
            }
            @Override
            public void onDelete(int row) {
                if(jpTableEmployee.table_employee.isEditing()){
                    jpTableEmployee.table_employee.getCellEditor().stopCellEditing();
                }
                int idseleccionado = Integer.parseInt(jpTableEmployee.table_employee.getValueAt(row, 0).toString());
                String username = jpTableEmployee.table_employee.getValueAt(row, 2).toString();
                String rol = jpTableEmployee.table_employee.getValueAt(row, 6).toString();

                if(jpTableEmployee.table_employee.getValueAt(row, 0).equals(id_user) || idseleccionado==1){
                    Notification noti = new Notification(jfMain, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Cannot remove user.");
                    noti.showNotification();
                }else{
                    Message msg = new Message("Confirm...","Do you want to remove the "+rol.toUpperCase()+" "+username.toUpperCase());
                    msg.eventOK(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(employeeDao.DeleteEmployeeQuery(idseleccionado)){
                                ListAllEmployee();
                                Notification noti = new Notification(jfMain, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Delete successful");
                                noti.showNotification();
                                jpTableEmployee.txt_employee_search.requestFocus();
                            }
                            GlassPanePopup.closePopupLast();
                        }
                    });
                    msg.eventCancel(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            jpTableEmployee.txt_employee_search.requestFocus();
                            GlassPanePopup.closePopupLast();
                        }
                    });
                    GlassPanePopup.showPopup(msg);
                }
                jpTableEmployee.txt_employee_search.requestFocus();
            }
            @Override
            public void onView(int row) {
                System.out.println("View" +row);
            }
        };
        //Agrega los botones EDITAR Y ELIMINAR a la tabla
        jpTableEmployee.table_employee.getColumnModel().getColumn(8).setCellEditor(new TableActionCellEditor(evt));
        //Instanciamos los paneles del Slide >3||velocidad de la animacion
        //jfMain.panelSlideEmployee.init(jpTableEmployee,jpEmployeeRegister,jpEmployeeRegister);
        //jfMain.panelSlideEmployee.setAnimate(20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jpEmployeeRegister.btn_employee_add || e.getSource()==jpEmployeeRegister.btn_employee_update){
            if(validateFields()){
                int rol;
                int id = Integer.parseInt(jpEmployeeRegister.txt_employee_id.getText().trim());
                String fullname = jpEmployeeRegister.txt_employee_fullname.getText().trim();
                String username = jpEmployeeRegister.txt_employee_username.getText().trim();
                String address = jpEmployeeRegister.txt_employee_address.getText().trim();
                String telephone = jpEmployeeRegister.txt_employee_telephone.getText().trim();
                String email = jpEmployeeRegister.txt_employee_email.getText().trim();
                String password = String.valueOf(jpEmployeeRegister.txt_employee_password.getPassword());

                if(jpEmployeeRegister.cmb_employee_rol.isEnabled()){
                    rol = getSelectedRolId();
                }else{
                    rol = 1;
                }
                if(jpEmployeeRegister.btn_employee_update.isVisible()){
                    id = Integer.parseInt(jpEmployeeRegister.txt_employee_id.getText().trim());
                }
                employee.setId(id);
                employee.setFull_name(fullname);
                employee.setUsername(username);
                employee.setAddress(address);
                employee.setTelephone(telephone);
                employee.setEmail(email);
                employee.setPassword(password);
                employee.setId_rol(rol);
                if(jpEmployeeRegister.btn_employee_update.isVisible()){
                    if(employeeDao.UpdateEmployeeQuery(employee)){
                    if(id==id_user){
                        jfMain.jP_Menu1.lbl_username.setText(username);
                        jfMain.jP_Menu1.lbl_rol.setText(jpEmployeeRegister.cmb_employee_rol.getSelectedItem().toString());
                        jpProfile.txt_profile_name.setText(fullname);
                        jpProfile.txt_profile_address.setText(address);
                        jpProfile.txt_profile_telephone.setText(telephone);
                        jpProfile.txt_profile_email.setText(email);
                        jpProfile.txt_profile_rol.setText(jpEmployeeRegister.cmb_employee_rol.getSelectedItem().toString());}
                    Notification noti = new Notification(jfMain, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Data updated successfully");
                    noti.showNotification();
                    ListAllEmployee();
                    jfMain.panelSlideEmployee.show(0);
                    jpTableEmployee.txt_employee_search.requestFocus();}
                }else{
                    if(employeeDao.RegisterEmployeeQuery(employee)){
                    clearFieldsEmployee();
                    Notification noti = new Notification(jfMain, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Register successful");
                    noti.showNotification();
                    ListAllEmployee();
                    jpEmployeeRegister.txt_employee_id.requestFocus();}
                }
            }else{
                Notification noti = new Notification(jfMain, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "All fields are required");
                noti.showNotification();
            } 
        }else if(e.getSource()==jpProfile.btn_profile_update){
            String pass = String.valueOf(jpProfile.txt_profile_modify_password.getPassword());
            String confirmPass = String.valueOf(jpProfile.txt_profile_confirm_password.getPassword());
            if(!pass.equals("")&&!confirmPass.equals("")){
                if(pass.equals(String.valueOf(confirmPass))){
                    employee.setPassword(pass);
                    if(employeeDao.updateEmployeePasswordQuery(employee)!=false){
                        jpProfile.txt_profile_modify_password.setText("");
                        jpProfile.txt_profile_confirm_password.setText("");
                        Notification noti = new Notification(jfMain, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Password updated successfully");
                        noti.showNotification();}
                }else{
                    Notification noti = new Notification(jfMain, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "The fields do not match");
                    noti.showNotification();}
            }else{
                Notification noti = new Notification(jfMain, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "Complete all fields");
                noti.showNotification();}
        }/*else if(e.getSource()==jpTableEmployee.btn_employee_register){
            clearFieldsEmployee();
            jfMain.panelSlideEmployee.show(1);
            jpEmployeeRegister.txt_employee_id.requestFocus();
        }*/else if(e.getSource()==jpEmployeeRegister.btn_employee_cancel){
            jfMain.panelSlideEmployee.show(0);
            jpTableEmployee.txt_employee_search.requestFocus();
        }
        
    }
    
    public void ListAllEmployee(){
        if(jpTableEmployee.table_employee.isEditing()){
            jpTableEmployee.table_employee.getCellEditor().stopCellEditing();
        }
        ClearTableEmployee();
        jpTableEmployee.table_employee.getColumnModel().getColumn(8).setCellRenderer(new TableActionCellRender());
            List<Employee> list_employee = employeeDao.ListEmployeeQuery(jpTableEmployee.txt_employee_search.getText().trim(),jpTableEmployee.cmb_employee_rol.getItemAt(jpTableEmployee.cmb_employee_rol.getSelectedIndex()).getId());
            modelTableEmployee=(DefaultTableModel) jpTableEmployee.table_employee.getModel();
            Object[] row = new Object[8];
            list_employee.stream().map((employe) -> {
                row[0] = employe.getId();
                row[1] = employe.getFull_name();
                row[2] = employe.getUsername();
                row[3] = employe.getAddress();
                row[4] = employe.getTelephone();
                row[5] = employe.getEmail();
                row[6] = employe.getRol_name();
                row[7] = employe.getId_rol();
                return row;
            }).forEachOrdered(modelTableEmployee::addRow);
    }
    
    public void clearFieldsEmployee(){
        jpEmployeeRegister.txt_employee_id.setText("");
        jpEmployeeRegister.txt_employee_id.setEnabled(true);
        jpEmployeeRegister.txt_employee_id.setEditable(true);
        jpEmployeeRegister.txt_employee_password.setEnabled(true);
        jpEmployeeRegister.txt_employee_password.setEditable(true);
        jpEmployeeRegister.txt_employee_fullname.setText("");
        jpEmployeeRegister.txt_employee_username.setText("");
        jpEmployeeRegister.txt_employee_address.setText("");
        jpEmployeeRegister.txt_employee_telephone.setText("");
        jpEmployeeRegister.txt_employee_email.setText("");
        jpEmployeeRegister.txt_employee_password.setText("");
        jpEmployeeRegister.cmb_employee_rol.setSelectedItem(new Rol(2, "Invitado"));
        jpEmployeeRegister.cmb_employee_rol.setEnabled(true);
        jpEmployeeRegister.btn_employee_add.setVisible(true);
        jpEmployeeRegister.btn_employee_update.setVisible(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource()==jpTableEmployee.table_employee){
            jpTableEmployee.txt_employee_search.requestFocus();
//       int row = jpEmployeeRegister.table_employee.rowAtPoint(e.getPoint());
        }else if(e.getSource()==jpTableEmployee.btn_employee_register){
            clearFieldsEmployee();
            jfMain.panelSlideEmployee.show(1);
            jpEmployeeRegister.txt_employee_id.requestFocus();
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
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            for (int i = 0; i < textFields.length; i++) {
                JTextField textField = textFields[i];
                String fieldValue = textField.getText().trim();
                if (e.getSource() == textField) {
                    if (!fieldValue.equals("")) {
                        if (i < textFields.length - 1) {
                            textFields[i + 1].requestFocus();
                        } else if (jpEmployeeRegister.btn_employee_add.isVisible()||jpEmployeeRegister.btn_employee_update.isVisible()) {
                            boolean allFieldsFilled = true;
                            for (JTextField field : textFields) {
                                if (field.getText().trim().isEmpty()) {
                                    allFieldsFilled = false;
                                    break;}
                            }
                            if(allFieldsFilled){
                                if(jpEmployeeRegister.btn_employee_add.isVisible()){
                                    System.out.println("ADD EMPLOY.");//jpCustomerRegister.btn_customer_add.doClick();
                                }else{
                                    System.out.println("UPD EMPLOY.");}
                            }else{
                                textFields[0].requestFocus();}
                        }
                    }
                    break;
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource()==jpTableEmployee.txt_employee_search){
            ListAllEmployee();
        }
    }
    
    public void ClearTableEmployee(){
        jpTableEmployee.table_employee.clearSelection();
        modelTableEmployee.setRowCount(0);
        /*for(int i=0;i<modelTableEmployee.getRowCount();i++){
            modelTableEmployee.removeRow(i);
            i--;
        }*/
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //System.out.println(e.getItem() + " " + e.getStateChange() );
        if(e.getStateChange() == ItemEvent.SELECTED){
            
            //String item = (String) e.getItem();
            if(e.getSource()==jpTableEmployee.cmb_employee_rol){
                ListAllEmployee();
            }
            //System.out.println(item);
        }
    }
    
    private boolean validateFields() {
        String id= jpEmployeeRegister.txt_employee_id.getText().trim();
        String full_name= jpEmployeeRegister.txt_employee_fullname.getText().trim();
        String username = jpEmployeeRegister.txt_employee_username.getText().trim();
        //int rol = getSelectedCategoryId();
        String address = jpEmployeeRegister.txt_employee_address.getText().trim();
        String telephone = jpEmployeeRegister.txt_employee_telephone.getText().trim();
        String email = jpEmployeeRegister.txt_employee_email.getText().trim();
        
        return !full_name.isEmpty() && !username.isEmpty() && !address.isEmpty()
                && !telephone.isEmpty() && !email.isEmpty() && !id.isEmpty();
    }
    
    private int getSelectedRolId() {
        return jpEmployeeRegister.cmb_employee_rol
                .getItemAt(jpEmployeeRegister.cmb_employee_rol.getSelectedIndex())
                .getId();
    }
    
}
