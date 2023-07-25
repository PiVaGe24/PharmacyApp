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
import Model.SaleDao;
import View.JF_Login;
import View.JF_Main;
import View.JF_System;
import View.JP_Category;
import View.JP_CustomerRegister;
import View.JP_Dashboard;
import View.JP_EmployeeRegister;
import View.JP_TableEmployee;
import View.ScrollBarCustom;
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

import static View.JP_Menu.lbl_username;
import static View.JP_Menu.lbl_rol;
import View.JP_ProductRegister;
import View.JP_Profile;
import View.JP_Purchase;
import View.JP_Report;
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
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import net.miginfocom.layout.ComponentWrapper;
import net.miginfocom.layout.LayoutCallback;

/**
 *
 * @author PIERO
 */
public final class Log implements ActionListener,KeyListener{
    private Employee employee;
    private EmployeeDao employeeDao;
    private JF_Login jfLogin;
    private JF_System jfSystem;
    private JF_Main jfMain;

    private JP_Profile jpProfile;
    private JP_Category jpCategory;
    private JP_Purchase jpPurchase;
    private JP_Sale jpSale;
    private JP_Report jpReport;
    private JP_Dashboard jpDashboard;
    
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

    public Log(Employee employee, EmployeeDao employeeDao, JF_Login jfLogin, JF_System jfSystem,
            EmployeeController employeeCtrl, CustomerController customerCtrl, SupplierController supplierCtrl, 
            CategoryController categoryCtrl, ProductController productCtrl, PurchaseController purchaseCtrl, 
            SaleController saleCtrl,JF_Main jfMain,JP_TableEmployee jpTableEmployee,JP_EmployeeRegister jpEmployeeRegister,
            JP_TableCustomer jpTableCustomer,JP_CustomerRegister jpCustomerRegister,JP_TableSupplier jpTableSupplier,
            JP_SupplierRegister jpSupplierRegister,JP_TableProduct jpTableProduc,JP_TableProduct jpTableProduct,JP_ProductRegister jpProductRegister,
            JP_Profile jpProfile ,JP_Category jpCategory,JP_Purchase jpPurchase,JP_Sale jpSale,JP_Report jpReport,JP_Dashboard jpDashboard,ReportController reportCtrl/*,JP_Menu jpMenu*/) {
        this.employee = employee;
        this.employeeDao = employeeDao;
        this.jfLogin = jfLogin;
        this.jfSystem = jfSystem;
        this.jfMain = jfMain;
        this.jpCategory = jpCategory;
        this.jpPurchase = jpPurchase;
        this.jpSale = jpSale;
        this.jpReport=jpReport;
        this.jpDashboard = jpDashboard;
        this.reportCtrl =reportCtrl;
        //this.jpMenu = jpMenu;
        
        this.jpProfile= jpProfile;
        
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
        this.jfSystem.btn_logout.addActionListener(this);
        this.jfLogin.txt_username.addKeyListener(this);
        this.jfLogin.txt_password.addKeyListener(this);
        
        //Instanciamos los paneles del Slide >3||velocidad de la animacion
        jfMain.panelSlideEmployee.init(jpTableEmployee,jpEmployeeRegister,jpEmployeeRegister); 
        jfMain.panelSlideCustomer.init(jpTableCustomer,jpCustomerRegister,jpCustomerRegister);
        jfMain.panelSlideSupplier.init(jpTableSupplier,jpSupplierRegister,jpSupplierRegister);
        jfMain.panelSlideProduct.init(jpTableProduct,jpProductRegister,jpProductRegister);
        jfMain.panelSlideEmployee.setAnimate(20);
        jfMain.panelSlideCustomer.setAnimate(20);
        jfMain.panelSlideSupplier.setAnimate(20);
        jfMain.panelSlideProduct.setAnimate(20);
        
        GlassPanePopup.install(jfMain);
        
        ClearPanelSlide();
        
        //View Dashboard
        ViewDashBoard();
        
        //View Profile
        ViewProfile();
        
        //View Category
        ViewCategory();
        
        //View Purchase
        ViewPurchase();
       
        //View Sale
        ViewSale();
        
        //View Report
        ViewReport();
        
        jfMain.panelProfile.setVisible(true);
        
        EventMenu evt = new EventMenu() {
            @Override
            public void selected(int index) {
                switch (index){
                    case 0:{
                        if(rol_user.equals("Administrador")){
                            ClearPanelSlide();
                            jfMain.panelDashboard.setVisible(true);
                            reportCtrl.ListSaleTopProductxPrice();
                            reportCtrl.ProgressSaleMonth();
                            reportCtrl.ListSaleTopProductxQuantity();
                            reportCtrl.ListSaleTopCustomer();
                            reportCtrl.ProgressSaleMothActual();
                            //jpDashboard.progress1.setValueWithAnimation(10);
                            //jpDashboard.progress2.start();
                            //jpDashboard.progress3.start();
                            jpDashboard.chart.start();
                            //jpDashboard.lineChart.start();
                        }else{
                            //jfMain.panelProfile.setVisible(true);
                            JOptionPane.showMessageDialog(null, "NO TIENES PERMISOS");
                        }
                        break;
                        
                    }case 1:{   
                        if(rol_user.equals("Administrador")){
                            ClearPanelSlide();
                            jfMain.panelSlideEmployee.setVisible(true);
                            jpTableEmployee.txt_employee_search.requestFocus();
                            jpEmployeeRegister.txt_employee_id.requestFocus();
                        }else{
                            //jfMain.panelProfile.setVisible(true);
                            JOptionPane.showMessageDialog(null, "NO TIENES PERMISOS");
                        }
                        break;
                    }case 2:{
                        ClearPanelSlide();
                        jfMain.panelSlideCustomer.setVisible(true);
                        jpTableCustomer.txt_customer_search.requestFocus();
                        jpCustomerRegister.txt_customer_id.requestFocus();
                        break;
                    }case 3:{
                        if(rol_user.equals("Administrador")){
                            ClearPanelSlide();
                            jfMain.panelSlideSupplier.setVisible(true);
                            jpTableSupplier.txt_supplier_search.requestFocus();
                            jpSupplierRegister.txt_supplier_name.requestFocus();
                        }else{
                            //jfMain.panelProfile.setVisible(true);
                            JOptionPane.showMessageDialog(null, "NO TIENES PERMISOS");
                        }
                        
                        break;
                    }case 4:{
                        ClearPanelSlide();
                        jfMain.panelSlideProduct.setVisible(true);
                        jpTableProduct.txt_product_search.requestFocus();
                        jpProductRegister.txt_product_code.requestFocus();
                        break;
                    }case 5:{
                        ClearPanelSlide();
                        jfMain.panelCategory.setVisible(true);
                        jpCategory.txt_category_name.requestFocus();
                        break;
                    }case 6:{
                        if(rol_user.equals("Administrador")){
                            ClearPanelSlide();
                            jfMain.panelPurchase.setVisible(true);
                            jpPurchase.txt_purchase_product_code.requestFocus();
                        }else{
                            //jfMain.panelProfile.setVisible(true);
                            JOptionPane.showMessageDialog(null, "NO TIENES PERMISOS");
                        }
                        
                        break;
                    }case 7:{
                        ClearPanelSlide();
                        jfMain.panelSale.setVisible(true);
                        jpSale.txt_sale_customer_document.requestFocus();
                        break;
                    }case 8:{
                        ClearPanelSlide();
                        reportCtrl.ReportMonthActual();
                        jfMain.panelReport.setVisible(true);
                        break;
                    }case 9:{
                        ClearPanelSlide();
                        jfMain.panelProfile.setVisible(true);
                        break;
                    }case 10:{
                        ClearPanelSlide();
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
                        break;
                    }
                };
            }
        };       
        jfMain.jP_Menu1.initMenu(evt); 
        //Locale.setDefault(Locale.ENGLISH);
        System.out.println("ACTUAL: "+Locale.getDefault());
        
        jfMain.header1.buttonBadges1.addActionListener(this); 
        //EventMenu evt = new EventMenu() {
    }
    
    public void ViewDashBoard(){
        jpDashboard.setSize(1020, 670);
        jpDashboard.setLocation(0,0);
        jfMain.panelDashboard.removeAll();
        jfMain.panelDashboard.add(jpDashboard,BorderLayout.CENTER);
        jfMain.panelDashboard.revalidate();
        jfMain.panelDashboard.repaint();
    }
    public void ViewProfile(){
        jpProfile.setSize(1020, 670);
        jpProfile.setLocation(0,0);
        jfMain.panelProfile.removeAll();
        jfMain.panelProfile.add(jpProfile,BorderLayout.CENTER);
        jfMain.panelProfile.revalidate();
        jfMain.panelProfile.repaint();
    }
    
    public void ViewCategory(){
        jpCategory.setSize(1020, 670);
        jpCategory.setLocation(0, 0);
        jfMain.panelCategory.removeAll();
        jfMain.panelCategory.add(jpCategory,BorderLayout.CENTER);
        jfMain.panelCategory.revalidate();
        jfMain.panelCategory.repaint();
    }
    
    public void ViewPurchase(){
        jpPurchase.setSize(1020, 670);
        jpPurchase.setLocation(0, 0);
        jfMain.panelPurchase.removeAll();
        jfMain.panelPurchase.add(jpPurchase,BorderLayout.CENTER);
        jfMain.panelPurchase.revalidate();
        jfMain.panelPurchase.repaint();
    }
    
    public void ViewSale(){
        jpSale.setSize(1020, 670);
        jpSale.setLocation(0, 0);
        jfMain.panelSale.removeAll();
        jfMain.panelSale.add(jpSale,BorderLayout.CENTER);
        jfMain.panelSale.revalidate();
        jfMain.panelSale.repaint();
    }
    
    public void ViewReport(){
        jpReport.setSize(1020, 670);
        jpReport.setLocation(0, 0);
        jfMain.panelReport.removeAll();
        jfMain.panelReport.add(jpReport,BorderLayout.CENTER);
        jfMain.panelReport.revalidate();
        jfMain.panelReport.repaint();
    }
    
    public  void ClearPanelSlide(){
        jfMain.panelSlideEmployee.setVisible(false);
        jfMain.panelSlideCustomer.setVisible(false);
        jfMain.panelSlideSupplier.setVisible(false);
        jfMain.panelSlideProduct.setVisible(false);
        jfMain.panelProfile.setVisible(false);
        jfMain.panelReport.setVisible(false);
        jfMain.panelCategory.setVisible(false);
        jfMain.panelPurchase.setVisible(false);
        jfMain.panelSale.setVisible(false);
        jfMain.panelDashboard.setVisible(false);
        //jfMain.panelSlideEmployee.setVisible(false);
        //jfMain.panelSlideEmployee.setVisible(false);
        //jfMain.panelSlideCustomer.setVisible(false);
    }
   
public void LoginUser(){
        jfLogin.setSize(930, 415);
        Shape forma = new RoundRectangle2D.Double(0,0, jfLogin.getBounds().width,jfLogin.getBounds().height, 30, 30);
        jfLogin.setShape(forma);
        jfLogin.setLocationRelativeTo(null);        
        //FRAME QUE SE MUESTRA PRIMERO
        //jfSystem.JTPanel.setSelectedIndex(4);
        //com.sun.awt.AWTUtilities.setWindowOpacity(jfLogin, 0.5f);
        jfLogin.setVisible(true);
    }
    
    public void ViewJFSystemUser(){
        jfMain.setSize(1288, 778);
        jfMain.setBackground(new Color(0,0,0,0));
        //jpMenu.setOpaque(false);
        ScrollBarCustom sb= new ScrollBarCustom();
        sb.setForeground(new Color(130 ,130,130,130));
        jfMain.setVisible(true);
        jfMain.setResizable(false);
        jfMain.setTitle("Admin");
        jfMain.setLocationRelativeTo(null);
        jfMain.panelProfile.setVisible(true);
        jfMain.repaint();
    }

    public void LoadProfileUser(){
        jpProfile.txt_profile_id.setText(""+id_user);
        jpProfile.txt_profile_name.setText(full_name);
        jpProfile.txt_profile_address.setText(address_user);
        jpProfile.txt_profile_telephone.setText(telephone_user);
        jpProfile.txt_profile_email.setText(email_user);
        jpProfile.txt_profile_rol.setText(rol_user);
        //jpProfile.lbl_employee_name.setText(username_user);
        //jpProfile.lbl_employee_rol.setText(rol_user);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jfLogin.btn_login){
            String user = jfLogin.txt_username.getText().trim();
            String pass = String.valueOf(jfLogin.txt_password.getPassword());
            employee=employeeDao.LoginQuery(user, pass);
            if(String.valueOf(employee.getRol()).equals("Administrador")||String.valueOf(employee.getRol()).equals("Auxiliar")){
                ViewJFSystemUser();
                jfLogin.dispose();
                lbl_username.setText(EmployeeDao.username_user);
                lbl_rol.setText(EmployeeDao.rol_user);
                
                employeeCtrl.ListAllEmployee();

                //jfSystem.setVisible(true);
                customerCtrl.ListAllCustomer();
                supplierCtrl.ListAllSupplier();
                categoryCtrl.ListAllCategory();
                //productCtrl.ListAllProduct();
                purchaseCtrl.ListAllPurchse();
                saleCtrl.listAllSales();
                
                categoryCtrl.FillCategory();
                supplierCtrl.FillSupplier();
                customerCtrl.FillCustomer();
                
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
/*                ViewJFSystemUser();
                //jfSystem.txt_employee_search.setEnabled(false);
                //customerCtrl.ListAllCustomer();
                
                jfLogin.dispose();
                jfSystem.setVisible(true);
                
                System.out.println("WELCOME **"+username_user+"**"+"\n"+"ROL **"+rol_user+"**");
                LoadProfileUser();*/
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

