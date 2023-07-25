/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Employee;
import Model.EmployeeDao;

import static Model.EmployeeDao.rol_user;
import static Model.EmployeeDao.username_user;

import static Model.EmployeeDao.id_user;
import static Model.EmployeeDao.full_name;
import static Model.EmployeeDao.address_user;
import static Model.EmployeeDao.telephone_user;
import static Model.EmployeeDao.email_user;
import View.JF_Login;
import View.JF_Main;
import View.JF_System;
import View.JP_Menu;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PIERO
 */
public class LoginController implements ActionListener,KeyListener{
    private Employee employee;
    private EmployeeDao employeeDao;
    private JF_Login jfLogin;
    private JF_System jfSystem;
    private JF_Main jfMain;
    
    private EmployeeController employeeCtrl;
    private CustomerController customerCtrl;
    private SupplierController supplierCtrl;
    private CategoryController categoryCtrl;
    private ProductController productCtrl;
    private PurchaseController purchaseCtrl;
    private SaleController saleCtrl;
    
    DefaultTableModel model = new DefaultTableModel();
    
    public LoginController(Employee employee, EmployeeDao employeeDao, JF_Login jfLogin,JF_System jfSystem,EmployeeController employeeCtrl,CustomerController customerCtrl,SupplierController supplierCtrl,CategoryController categoryCtrl,ProductController productCtrl,PurchaseController purchaseCtrl,SaleController saleCtrl,JF_Main jfMain) {
        this.employee = employee;
        this.employeeDao = employeeDao;
        this.jfLogin = jfLogin;
        this.jfSystem=jfSystem;
        this.jfMain = jfMain;
        
        this.employeeCtrl=employeeCtrl;
        this.customerCtrl=customerCtrl;
        this.supplierCtrl=supplierCtrl;
        this.categoryCtrl=categoryCtrl;
        this.productCtrl=productCtrl;
        this.purchaseCtrl=purchaseCtrl;
        this.saleCtrl=saleCtrl;

        this.jfLogin.btn_login.addActionListener(this);
        this.jfSystem.btn_logout.addActionListener(this);
        this.jfLogin.txt_username.addKeyListener(this);
        this.jfLogin.txt_password.addKeyListener(this);
        
        
    }

    public void ViewJFLoginUser(){
//        jfLogin.setSize(930, 415);
//        jfLogin.setResizable(false);
//        jfLogin.setTitle("Ingresar al Sistema");
//        jfLogin.setLocationRelativeTo(null);
    
        /*jfLogin.setUndecorated(true);
        jfLogin.setSize(400, 300);
        Shape forma = new RoundRectangle2D.Double(0, 0, jfLogin.getBounds().width, jfLogin.getBounds().height, 30, 30);
        jfLogin.setShape(forma);
        */
        
        jfLogin.setSize(930, 415);
        
        Shape forma = new RoundRectangle2D.Double(0,0, jfLogin.getBounds().width,jfLogin.getBounds().height, 30, 30);
        jfLogin.setShape(forma);
        jfLogin.setLocationRelativeTo(null);
        
        //FRAME QUE SE MUESTRA PRIMERO
        jfSystem.JTPanel.setSelectedIndex(4);
        
        //com.sun.awt.AWTUtilities.setWindowOpacity(jfLogin, 0.5f);
        jfLogin.setVisible(true);
                
//        jfLogin.repaint();
//        jfLogin.setVisible(true);

    }
    
    public void ViewJFSystemUser(){
        jfSystem.setSize(1208,680);
        jfSystem.setResizable(false);
        jfSystem.setTitle("Admin");
        jfSystem.setLocationRelativeTo(null);
        jfSystem.repaint();
    }

    public void LoadProfileUser(){
        jfSystem.txt_profile_id.setText(""+id_user);
        jfSystem.txt_profile_name.setText(full_name);
        jfSystem.txt_profile_address.setText(address_user);
        jfSystem.txt_profile_telephone.setText(telephone_user);
        jfSystem.txt_profile_email.setText(email_user);
        jfSystem.txt_profile_rol.setText(rol_user);
        jfSystem.lbl_employee_name.setText(username_user);
        jfSystem.lbl_employee_rol.setText(rol_user);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jfLogin.btn_login){
            System.out.println("ant");
            String user = jfLogin.txt_username.getText().trim();
            String pass = String.valueOf(jfLogin.txt_password.getPassword());
            employee=employeeDao.LoginQuery(user, pass);
            
            if(String.valueOf(employee.getRol()).equals("Administrador")){
                ViewJFSystemUser();
                
                employeeCtrl.ListAllEmployee();
                jfLogin.dispose();
                jfSystem.setVisible(true);
                customerCtrl.ListAllCustomer();
                supplierCtrl.ListAllSupplier();
                categoryCtrl.ListAllCategory();
                productCtrl.ListAllProduct();
                purchaseCtrl.ListAllPurchse();
                saleCtrl.listAllSales();
                
                categoryCtrl.FillCategory();
                supplierCtrl.FillSupplier();
                
                //Enabled Employee
                //jfSystem.txt_employee_search.setEnabled(true);
                jfSystem.JTPanel.setEnabledAt(4, true);
                jfSystem.lbl_employees.setEnabled(true);
                
                //Enabled Customer
                //jfSystem.txt_customer_search.setEnabled(true);
                jfSystem.JTPanel.setEnabledAt(3, true);
                jfSystem.lbl_customers.setEnabled(true);
                
                System.out.println("WELCOME **"+username_user+"**"+"\n"+"ROL **"+rol_user+"**");
                LoadProfileUser();
                
            }else if(String.valueOf(employee.getRol()).equals("Auxiliar")){
                ViewJFSystemUser();
                //jfSystem.txt_employee_search.setEnabled(false);
                //customerCtrl.ListAllCustomer();
                
                jfLogin.dispose();
                jfSystem.setVisible(true);
                
                System.out.println("WELCOME **"+username_user+"**"+"\n"+"ROL **"+rol_user+"**");
                LoadProfileUser();
            }
        }else if(e.getSource()==jfSystem.btn_logout){
            id_user = 0;
            full_name = "";
            username_user = "";
            address_user = "";
            telephone_user = "";
            email_user = "";
            rol_user="";
            jfLogin.txt_username.setText("");
            jfLogin.txt_password.setText("");
            jfSystem.dispose();
            jfLogin.setVisible(true);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource()==jfLogin.txt_username){
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                jfLogin.txt_password.requestFocus();
            }
        }else if(e.getSource()==jfLogin.txt_password){
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if(jfLogin.txt_username.getText().isEmpty()){
                    jfLogin.txt_username.requestFocus();
                }else{
                //Al presionar enter sobre la caja de contraseña presiona el boton de login
                //jfLogin.btn_login.requestFocus();
                jfLogin.btn_login.doClick();
                //jfLogin.getRootPane().setDefaultButton(jfLogin.btn_login);
                }
            }            
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }

}
