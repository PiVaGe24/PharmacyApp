package Main;

import Controller.CategoryController;
import Controller.CustomerController;
import Controller.EmployeeController;
import Controller.Log;
import Controller.ProductController;
import Controller.PurchaseController;
import Controller.ReportController;
import Controller.SaleController;
import Controller.SupplierController;
import Model.Category;
import Model.CategoryDao;
import Model.Customer;
import Model.CustomerDao;
import Model.Employee;
import Model.EmployeeDao;
import Model.Product;
import Model.ProductDao;
import Model.Purchase;
import Model.PurchaseDao;
import Model.Sale;
import Model.SaleDao;
import Model.Supplier;
import Model.SupplierDao;
import View.JF_Login;
import View.JF_Main;
import View.JF_Print;
import View.JF_System;
import View.JP_Category;
import View.JP_CustomerRegister;
import View.JP_Dashboard;
import View.JP_EmployeeRegister;
import View.JP_ProductRegister;
import View.JP_Profile;
import View.JP_Purchase;
import View.JP_Report;
import View.JP_Sale;
import View.JP_SupplierRegister;
import View.JP_TableCustomer;
import View.JP_TableEmployee;
import View.JP_TableProduct;
import View.JP_TableSupplier;

/**
 *
 * @author PIERO
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //instaciamos el Login
            
        JF_Login jfLogin = new JF_Login();
        JF_System jfSystem = new JF_System();
        JF_Main jfMain = new JF_Main();
        JF_Print jfPrint = new JF_Print(1);
        //JP_Menu jpMenu = new JP_Menu();
        JP_Profile jpProfile = new JP_Profile();
        JP_Category jpCategory = new JP_Category();
        JP_Purchase jpPurchase = new JP_Purchase();
        JP_Sale jpSale = new JP_Sale();
        JP_Report jpReport = new JP_Report();
        JP_Dashboard jpDashboard = new JP_Dashboard();
        
        JP_TableEmployee jpTableEmployee = new JP_TableEmployee();
        JP_EmployeeRegister jpEmployeeRegister = new JP_EmployeeRegister();
        JP_TableCustomer jpTableCustomer = new JP_TableCustomer();
        JP_CustomerRegister jpCustomerRegister = new JP_CustomerRegister();
        JP_TableSupplier jpTableSupplier = new JP_TableSupplier();
        JP_SupplierRegister jpSupplierRegister = new JP_SupplierRegister();
        JP_TableProduct jpTableProduct = new JP_TableProduct();
        JP_ProductRegister jpProductRegister = new JP_ProductRegister();
        
        
        Employee employee = new Employee();
        Customer customer = new Customer();
        Supplier supplier = new Supplier();
        Category category = new Category();
        Product product = new Product();
        Purchase objPurchase = new Purchase();
        Sale objSale = new Sale();
        
        EmployeeDao employeeDao = new EmployeeDao();
        CustomerDao customerDao = new CustomerDao();
        SupplierDao supplierDao = new SupplierDao();
        CategoryDao categoryDao = new CategoryDao();
        ProductDao productDao = new ProductDao();
        PurchaseDao objPurchaseDao = new PurchaseDao();
        SaleDao objSaleDao = new SaleDao();
        
        //SystemController systemCtrl = new SystemController(jfSystem);
        EmployeeController employeeCtrl = new EmployeeController(employee, employeeDao,jpTableEmployee,jpEmployeeRegister,jfMain,jpProfile);
        
        
        CustomerController customerCtrl = new CustomerController(customer, customerDao, jfMain,jpTableCustomer,jpCustomerRegister,jpSale);
        SupplierController supplierCtrl = new SupplierController(supplier, supplierDao, jfMain,jpTableSupplier,jpSupplierRegister,jpPurchase);
        CategoryController categoryCtrl = new CategoryController(category, categoryDao, jfMain,jpProductRegister,jpCategory,jpTableProduct);
        ProductController productCtrl = new ProductController(product, productDao, jfMain,jpTableProduct,jpProductRegister);
        PurchaseController purchaseCtrl = new PurchaseController(objPurchase, objPurchaseDao,jpPurchase,jfMain,jpReport);
        SaleController saleCtrl = new SaleController(objSaleDao, jpSale,jfMain,jpReport);
        
        ReportController reportCtrl = new ReportController(jpReport,jpDashboard,jfPrint,objSaleDao,objPurchaseDao);
        
        //LoginController loginCtrl = new LoginController(employee, employeeDao, jfLogin,jfSystem,employeeCtrl,customerCtrl,supplierCtrl,categoryCtrl,productCtrl,purchaseCtrl,saleCtrl);

        //Log objLogin = new Log(employee, employeeDao, jfLogin, jfSystem, employeeCtrl, customerCtrl, supplierCtrl, categoryCtrl, productCtrl, purchaseCtrl, saleCtrl, jfMain,jpTableEmployee,jpEmployeeRegister,jpTableCustomer,jpCustomerRegister,jpTableSupplier,jpSupplierRegister,jpTableProduct,jpProductRegister/*,jpMenu*/);
           
        Log objLogin = new Log(employee, employeeDao, jfLogin, jfSystem, employeeCtrl, customerCtrl, supplierCtrl, categoryCtrl, productCtrl, purchaseCtrl, saleCtrl, jfMain, jpTableEmployee,
                jpEmployeeRegister, jpTableCustomer, jpCustomerRegister, jpTableSupplier, jpSupplierRegister, jpTableProduct, jpTableProduct, jpProductRegister,jpProfile,jpCategory,jpPurchase,jpSale,jpReport,jpDashboard,reportCtrl);
        //loginCtrl.ViewJFLoginUser();
        
        objLogin.LoginUser();

        //employeeController.ListAllEmployee();
    }
    
}
