/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Employee;
import Model.EmployeeDao;
import static Model.EmployeeDao.address_user;
import static Model.EmployeeDao.email_user;
import static Model.EmployeeDao.full_name;
import static Model.EmployeeDao.id_user;
import static Model.EmployeeDao.rol_user;
import static Model.EmployeeDao.telephone_user;
import static Model.EmployeeDao.username_user;
import Model.MenuItem;
import View.JF_Login;
import View.JF_Main;
import View.JF_System;
import View.JP_Category;
import View.JP_CustomerRegister;
import View.JP_Dashboard;
import View.JP_EmployeeRegister;
import View.JP_Menu;
import View.JP_TableEmployee;
import View.SimpleMessage.GlassPanePopup;
import View.event.EventMenu;
import java.awt.Color;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.table.DefaultTableModel;

//import static View.JP_Menu.lbl_username;
//import static View.JP_Menu.lbl_rol;
import View.JP_ProductRegister;
import View.JP_Profile;
import View.JP_Purchase;
import View.JP_Report;
import View.JP_RolPermissions;
import View.JP_Sale;
import View.JP_SupplierRegister;
import View.JP_TableCustomer;
import View.JP_TableProduct;
import View.JP_TableSupplier;
import View.SimpleMessage.DefaultLayoutCallback;
import View.SimpleMessage.DefaultOption;
import View.sample.notification.Notifications;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Point;
import java.util.Locale;
import javax.swing.JComponent;
import javax.swing.JPanel;
import net.miginfocom.layout.ComponentWrapper;
import net.miginfocom.layout.LayoutCallback;

/**
 *
 * @author PIERO
 */
public class Log implements ActionListener,KeyListener{
    private Employee employee;
    private EmployeeDao employeeDao;
    private JF_Login jfLogin;
    private JF_Main jfMain;

    private JP_Profile jpProfile;
    private JP_Category jpCategory;
    private JP_Purchase jpPurchase;
    private JP_Sale jpSale;
    private JP_Report jpReport;
    private JP_Dashboard jpDashboard;
    private JP_Menu jpMenu;
    private JP_RolPermissions jpPermissions;
    
    private JP_TableEmployee jpTableEmployee;
    private JP_EmployeeRegister jpEmployeeRegister;
    
    private JP_TableCustomer jpTableCustomer;
    private JP_CustomerRegister jpCustomerRegister;
    
    private JP_TableSupplier jpTableSupplier;
    private JP_SupplierRegister jpSupplierRegister;
    
    private JP_TableProduct jpTableProduct;
    private JP_ProductRegister jpProductRegister;
   
    private EmployeeController employeeCtrl;
    private CustomerController customerCtrl;
    private SupplierController supplierCtrl;
    private CategoryController categoryCtrl;
    private ProductController productCtrl;
    private PurchaseController purchaseCtrl;
    private SaleController saleCtrl;
    private ReportController reportCtrl;

    
    DefaultTableModel model = new DefaultTableModel();

    public Log(Employee employee, EmployeeDao employeeDao, JF_Login jfLogin,
            EmployeeController employeeCtrl, CustomerController customerCtrl, SupplierController supplierCtrl, 
            CategoryController categoryCtrl, ProductController productCtrl, PurchaseController purchaseCtrl, 
            SaleController saleCtrl,JF_Main jfMain,JP_TableEmployee jpTableEmployee,JP_EmployeeRegister jpEmployeeRegister,
            JP_TableCustomer jpTableCustomer,JP_CustomerRegister jpCustomerRegister,JP_TableSupplier jpTableSupplier,
            JP_SupplierRegister jpSupplierRegister,JP_TableProduct jpTableProduc,JP_TableProduct jpTableProduct,JP_ProductRegister jpProductRegister,
            JP_Profile jpProfile ,JP_Category jpCategory,JP_Purchase jpPurchase,JP_Sale jpSale,JP_Report jpReport,JP_Dashboard jpDashboard,ReportController reportCtrl
            ,JP_Menu jpMenu,JP_RolPermissions jpPermissions) {
        this.employee = employee;
        this.employeeDao = employeeDao;
        this.jfLogin = jfLogin;
        this.jfMain = jfMain;
        this.jpCategory = jpCategory;
        this.jpPurchase = jpPurchase;
        this.jpSale = jpSale;
        this.jpReport=jpReport;
        this.jpDashboard = jpDashboard;
        this.reportCtrl =reportCtrl;
        this.jpMenu = jpMenu;
        this.jpProfile= jpProfile;
        this.jpPermissions=jpPermissions;
        
        this.jpTableEmployee = jpTableEmployee;
        this.jpEmployeeRegister = jpEmployeeRegister;
        this.jpTableCustomer = jpTableCustomer;
        this.jpCustomerRegister = jpCustomerRegister;
        this.jpTableSupplier = jpTableSupplier;
        this.jpSupplierRegister = jpSupplierRegister;
        this.jpTableProduct = jpTableProduct;
        this.jpProductRegister = jpProductRegister;
        
        this.employeeCtrl = employeeCtrl;
        this.customerCtrl = customerCtrl;
        this.supplierCtrl = supplierCtrl;
        this.categoryCtrl = categoryCtrl;
        this.productCtrl = productCtrl;
        this.purchaseCtrl = purchaseCtrl;
        this.saleCtrl = saleCtrl;
        
        this.jfLogin.btn_login.addActionListener(this);
        this.jfLogin.txt_username.addKeyListener(this);
        this.jfLogin.txt_password.addKeyListener(this);
        
        //employeeDao.RegisterEmployeeQuery(new Employee(2, "admin", "admin", "admin", "admin", "admin", "123", "admin","2023-08-03 16:59:31", "2023-08-03 16:59:31"));
        //Instanciamos los paneles del Slide >3||velocidad de la animacion
        jfMain.panelSlideCustomer.init(jpTableCustomer,jpCustomerRegister,jpCustomerRegister);
        jfMain.panelSlideSupplier.init(jpTableSupplier,jpSupplierRegister,jpSupplierRegister);
        jfMain.panelSlideProduct.init(jpTableProduct,jpProductRegister,jpProductRegister);
        jfMain.panelSlideEmployee.init(jpTableEmployee,jpEmployeeRegister,jpEmployeeRegister); 
        
        jfMain.panelSlideEmployee.setAnimate(20);
        jfMain.panelSlideCustomer.setAnimate(20);
        jfMain.panelSlideSupplier.setAnimate(20);
        jfMain.panelSlideProduct.setAnimate(20);
        
        GlassPanePopup.install(jfMain);
        //LoadView
        showViewInPanel(jfMain.panelProfile, jpProfile);
        showViewInPanel(jfMain.panelCategory, jpCategory);
        showViewInPanel(jfMain.panelPurchase, jpPurchase);
        showViewInPanel(jfMain.panelSale, jpSale);
        showViewInPanel(jfMain.panelReport, jpReport);
        showViewInPanel(jfMain.panelDashboard, jpDashboard);
        showViewInPanel(jfMain.panelPermission, jpPermissions);
             
        //Locale.setDefault(Locale.ENGLISH);
        System.out.println("ACTUAL: "+Locale.getDefault());
        jfMain.header1.buttonBadges1.addActionListener(this);
    }

    private void showViewInPanel(JPanel targetPanel, JPanel viewPanel) {
        viewPanel.setSize(1020, 670);
        viewPanel.setLocation(0, 0);
        targetPanel.removeAll();
        targetPanel.add(viewPanel, BorderLayout.CENTER);
        targetPanel.revalidate();
        targetPanel.repaint();
    }
    
    public  void ClearPanelSlide(){
        //jfMain.body.setVisible(false);
        jfMain.panelDashboard.setVisible(false);
        jfMain.panelSlideEmployee.setVisible(false);
        jfMain.panelSlideCustomer.setVisible(false);
        jfMain.panelSlideSupplier.setVisible(false);
        jfMain.panelSlideProduct.setVisible(false);
        jfMain.panelCategory.setVisible(false);
        jfMain.panelPurchase.setVisible(false);
        jfMain.panelSale.setVisible(false);
        jfMain.panelReport.setVisible(false);
        jfMain.panelProfile.setVisible(false);
        jfMain.panelPermission.setVisible(false);
    }
   
public void LoginUser(){
        jfLogin.setSize(930, 415);
        Shape forma = new RoundRectangle2D.Double(0,0, jfLogin.getBounds().width,jfLogin.getBounds().height, 30, 30);
        jfLogin.setShape(forma);
        jfLogin.setLocationRelativeTo(null);        
        //TRANSPARECIA
        //com.sun.awt.AWTUtilities.setWindowOpacity(jfLogin, 0.5f);
        jfLogin.setVisible(true);
    }
    
    private void ViewJFSystemUser(){
        jfLogin.dispose();
        jfMain.setSize(1288, 778);
        jfMain.setBackground(new Color(0,0,0,0));//REMOVE COLOR
        //ScrollBarCustom sb= new ScrollBarCustom();
        //sb.setForeground(new Color(130 ,130,130,130));
        jfMain.setVisible(true);
        jfMain.setResizable(false);
        jfMain.setTitle("Admin");
        jfMain.setLocationRelativeTo(null);
        jfMain.repaint();
    }

    public void LoadProfileUser(){
        jpProfile.txt_profile_id.setText(""+id_user);
        jpProfile.txt_profile_name.setText(full_name);
        jpProfile.txt_profile_address.setText(address_user);
        jpProfile.txt_profile_telephone.setText(telephone_user);
        jpProfile.txt_profile_email.setText(email_user);
        jpProfile.txt_profile_rol.setText(rol_user);
    }

    private void showPanelAndSetFocus(JPanel panel, JComponent component) {
        panel.setVisible(true);
        component.requestFocus();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jfLogin.btn_login){
            String user = jfLogin.txt_username.getText().trim();
            String pass = String.valueOf(jfLogin.txt_password.getPassword());
            
            employee=employeeDao.LoginQuery(user, pass);
            
            if(employee.getFull_name()!=null){
                
                LoadProfileUser();
                //lbl_username.setText("HOLA"/*EmployeeDao.username_user*/);
                //lbl_rol.setText("PERSONA 1"/*EmployeeDao.rol_user*/);

                // Métodos para mostrar diferentes vistas
                EventMenu evt = new EventMenu() {
                    @Override
                    public void selected(MenuItem item) {
                        ClearPanelSlide();
                        switch(item.getName()){
                            case "Dashboard":{
                                jfMain.panelDashboard.setVisible(true);
                                reportCtrl.ListSaleTopProductxPrice();
                                reportCtrl.ProgressSaleMonth();
                                reportCtrl.ListSaleTopProductxQuantity();
                                reportCtrl.ListSaleTopCustomer();
                                reportCtrl.ProgressSaleMothActual();
                                jpDashboard.chart.start();
                                break;
                            }case "Employee":{
                                showPanelAndSetFocus(jfMain.panelSlideEmployee, jpTableEmployee.txt_employee_search);
                                jpEmployeeRegister.txt_employee_id.requestFocus();
                                break;
                            }case "Customer":{
                                showPanelAndSetFocus(jfMain.panelSlideCustomer, jpTableCustomer.txt_customer_search);
                                jpCustomerRegister.txt_customer_id.requestFocus();
                                break;
                            }case "Supplier":{
                                showPanelAndSetFocus(jfMain.panelSlideSupplier, jpTableSupplier.txt_supplier_search);
                                jpSupplierRegister.txt_supplier_name.requestFocus();
                                break;
                            }case "Product":{
                                showPanelAndSetFocus(jfMain.panelSlideProduct, jpTableProduct.txt_product_search);
                                jpProductRegister.txt_product_code.requestFocus();
                                break;
                            }case "Category":{
                                showPanelAndSetFocus(jfMain.panelCategory, jpCategory.txt_category_name);
                                break;
                            }case "Purchase":{
                                showPanelAndSetFocus(jfMain.panelPurchase, jpPurchase.txt_purchase_product_code);
                                break;
                            }case "Sale":{
                                showPanelAndSetFocus(jfMain.panelSale, jpSale.txt_sale_customer_document);
                                break;
                            }case "Report":{
                                reportCtrl.ReportMonthActual();
                                jfMain.panelReport.setVisible(true);
                                break;
                            }case "Permissions":{
                                showPanelAndSetFocus(jfMain.panelPermission, jpPermissions.txt_rol_name);
                                break;
                            }case "Profile":{
                                jfMain.panelProfile.setVisible(true);
                                break;
                            }case "Logout":{
                                id_user = 0;
                                full_name = "";
                                username_user = "";
                                address_user = "";
                                telephone_user = "";
                                email_user = "";
                                rol_user="";
                                jfLogin.txt_username.setText("");
                                jfLogin.txt_password.setText("");
                                jfMain.dispose();
                                jfLogin.setVisible(true);
                                jfMain.jP_Menu1.ClearMenu();//Limpiar el menu
                                // Métodos para mostrar diferentes vistas
                                break;
                            }
                        };
                    }
                };
                jfMain.jP_Menu1.initMenu(evt,id_user,username_user,rol_user); 
                
                employeeCtrl.ListAllEmployee();
                customerCtrl.ListAllCustomer();
                supplierCtrl.ListAllSupplier();
                categoryCtrl.ListAllCategory();
                //productCtrl.ListAllProduct();
                purchaseCtrl.ListAllPurchse();
                saleCtrl.listAllSales();
                categoryCtrl.FillCategory();
                supplierCtrl.FillSupplier();

                ViewJFSystemUser();
                System.out.println("WELCOME **"+username_user+"**"+"\n"+"ROL **"+rol_user+"**");    
            }
        }else if(e.getSource()==jfMain.header1.buttonBadges1){
            GlassPanePopup.showPopup(new Notifications(),new DefaultOption(){
                @Override
                public float opacity() {
                    return 0;
                    //return super.opacity(); //To change body of generated methods, choose Tools | Templates.
                }
                @Override
                public LayoutCallback getLayoutCallBack(Component parent) {
                    return new DefaultLayoutCallback(parent){
                        @Override
                        public void correctBounds(ComponentWrapper cw) {
                            if(parent.isVisible()){
                                Point p1=parent.getLocationOnScreen();
                                Point b1=jfMain.header1.buttonBadges2.getLocationOnScreen();
                                int x=b1.x-p1.x-60;
                                int y=b1.y-p1.y;
                                cw.setBounds(x-cw.getWidth()+jfMain.header1.buttonBadges2.getWidth(), y+jfMain.header1.buttonBadges2.getHeight(), cw.getHeight(), cw.getHeight());
                            }else{
                                super.correctBounds(cw); //To change body of generated methods, choose Tools | Templates.
                            }
                        }
                    };
                }
            });
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if(e.getSource()==jfLogin.txt_username){
                jfLogin.txt_password.requestFocus();
            }else if(e.getSource()==jfLogin.txt_password){
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

