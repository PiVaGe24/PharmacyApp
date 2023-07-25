/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PIERO
 */
public class SaleDao {

    ConnectionMySQL cn = new ConnectionMySQL();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    PreparedStatement pst2;
    ResultSet rs2;

    public boolean registerSaleQuery(int customer_id, int employee_id, double total) {
        String query = "INSERT INTO sales (customer_id, employee_id,  total, sale_date) VALUES (?,?,?,?)";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setInt(1, customer_id);
            pst.setInt(2, employee_id);
            pst.setDouble(3, total);
            pst.setTimestamp(4, datetime);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public boolean registerSaleDetailQuery(int product_id, double sale_id,int sale_quantity, double sale_price, double sale_subtotal) {
        String query = "INSERT INTO sales_details (product_id, sale_id, sale_quantity, sale_price, sale_subtotal) VALUES (?,?,?,?,?)";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setInt(1, product_id);
            pst.setDouble(2, sale_id);
            pst.setInt(3, sale_quantity);
            pst.setDouble(4, sale_price);
            pst.setDouble(5, sale_subtotal);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public int saleId() {
        int id = 0;
        String query = "SELECT MAX(id) AS id FROM sales";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }

    public List listAllSalesQuery() {
        List<Sale> list_sales = new ArrayList();
        String query = "SELECT s.id AS invoice, c.full_name AS customer, e.full_name AS employee, s.total, s.sale_date FROM sales s INNER JOIN customers c ON s.customer_id = c.id INNER JOIN employees e ON s.employee_id = e.id ORDER BY S.id DESC";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            //Recorrer 
            while (rs.next()) {
                Sale sale = new Sale();
                sale.setId(rs.getInt("invoice"));
                sale.setCustomer_name(rs.getString("customer"));
                sale.setEmployee_name(rs.getString("employee"));
                sale.setTotal_to_pay(rs.getDouble("total"));
                sale.setSale_date(rs.getString("sale_date"));
                list_sales.add(sale);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return list_sales;
    }
    
    public double TotalSalePrice(){
        double total = 0;
        String query = "SELECT SUM(unit_price*product_quantity) as total FROM products";
        try{
            conn = cn.getConnection();
            pst=conn.prepareStatement(query);
            rs=pst.executeQuery();
            if(rs.next()){
                total =rs.getDouble("total");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return total;
    }
    
    public int TotalQuantiyProductQuery(){
        int total = 0;
        String query = "SELECT SUM(product_quantity) as total FROM products";
        try{
            conn = cn.getConnection();
            pst=conn.prepareStatement(query);
            rs=pst.executeQuery();
            if(rs.next()){
                total =rs.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return total;
    }
    
    public List listTop3ProductSalesPriceQuery(int month) {
        List<Product> list_sales = new ArrayList();
        String query = "SELECT sum(sd.sale_quantity*sd.sale_price ) as total, pro.name,cat.name  as category FROM sales_details sd INNER JOIN products pro ON sd.product_id=pro.id INNER JOIN categories cat ON pro.category_id=cat.id INNER JOIN sales s ON sd.sale_id=s.id INNER JOIN customers c ON s.customer_id=c.id group by pro.id order by total desc limit 3";
        String query_month = "SELECT sum(sd.sale_quantity*sd.sale_price ) as total, pro.name,cat.name  as category FROM sales_details sd INNER JOIN products pro ON sd.product_id=pro.id INNER JOIN categories cat ON pro.category_id=cat.id INNER JOIN sales s ON sd.sale_id=s.id INNER JOIN customers c ON s.customer_id=c.id WHERE MONTH(s.sale_date)="+month+" group by pro.id order by total desc limit 3";
        try {
            conn = cn.getConnection();
            if(month>0){
                pst = conn.prepareStatement(query_month);
                rs = pst.executeQuery();
            }else{
                pst = conn.prepareStatement(query);
                rs = pst.executeQuery();
            }
            //Recorrer 
            while (rs.next()) {
                Product product = new Product();
                product.setUnit_price(rs.getDouble("total"));
                product.setName(rs.getString("name"));
                product.setCategory_name(rs.getString("category"));
                list_sales.add(product);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return list_sales;
    }
    
    public double[] TotalSaleMonth(){
        double[] list_sale = new double[6];
        String query = "SELECT COALESCE(SUM(total),0) as enero,(SELECT COALESCE(SUM(total),0) FROM sales WHERE MONTH(sale_date)=2) as febrero,(SELECT COALESCE(SUM(total),0) FROM sales WHERE MONTH(sale_date)=3) as marzo,(SELECT COALESCE(SUM(total),0) FROM sales WHERE MONTH(sale_date)=4) as abril,(SELECT COALESCE(SUM(total),0) FROM sales WHERE MONTH(sale_date)=5) as mayo,(SELECT COALESCE(SUM(total),0) FROM sales WHERE MONTH(sale_date)=6) as junio FROM sales WHERE MONTH(sale_date)=1";
        try{
            conn= cn.getConnection();
            pst=conn.prepareStatement(query);
            rs=pst.executeQuery();
            
            while(rs.next()){
                list_sale[0] =rs.getDouble("enero");
                list_sale[1]  =rs.getDouble("febrero");
                list_sale[2]  =rs.getDouble("marzo");
                list_sale[3]  =rs.getDouble("abril");
                list_sale[4]  =rs.getDouble("mayo");
                list_sale[5]  =rs.getDouble("junio");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: List all purchase");
            System.err.println(e.getMessage());
        }
        return list_sale;
    }
    
    public double ProgressSale(int month){
        String sale ="SELECT coalesce(SUM(total),0) as total FROM sales WHERE MONTH(sale_date)="+month;
        String purchase ="SELECT coalesce(SUM(total),0) as total FROM purchases WHERE MONTH(created)="+month;
        String sale2="SELECT COALESCE(SUM(total),0) as total FROM sales";
        String purchase2="SELECT COALESCE(SUM(total),0) as total FROM purchases";
        double s=0,p = 0;
            try {
                conn=cn.getConnection();
                if(month>0){
                    pst=conn.prepareStatement(sale);
                    rs=pst.executeQuery();
                    pst2=conn.prepareStatement(purchase);
                    rs2=pst2.executeQuery();
                }else{
                    pst=conn.prepareStatement(sale2);
                    rs=pst.executeQuery();
                    pst2=conn.prepareStatement(purchase2);
                    rs2=pst2.executeQuery();
                }
            if(rs.next()){
               s = rs.getDouble("total");
            }if(rs2.next()){
               p = rs2.getDouble("total");
            }

            if(p==0){
                return 0;
            }else{
                return (s*100)/p;
            }
                
            } catch (SQLException ex) {
                Logger.getLogger(SaleDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        return 0.01;
    }
    
    public List listTop3ProductSalesQuantityQuery(int month) {
        List<Product> list_sale_quantity = new ArrayList();
        String query = "SELECT SUM(sd.sale_quantity) as quantity,p.name, c.name as category, s.sale_date FROM sales_details sd INNER JOIN products p ON sd.product_id=p.id INNER JOIN sales s ON sd.sale_id=s.id INNER JOIN categories c ON p.category_id = c.id GROUP BY sd.product_id order by quantity DESC LIMIT 3";
        String query_month = "SELECT SUM(sd.sale_quantity) as quantity,p.name, c.name as category, s.sale_date FROM sales_details sd INNER JOIN products p ON sd.product_id=p.id INNER JOIN sales s ON sd.sale_id=s.id INNER JOIN categories c ON p.category_id = c.id  WHERE MONTH(s.sale_date)="+month+" GROUP BY sd.product_id  order by quantity DESC LIMIT 3;";

        try {
            conn = cn.getConnection();
            if(month>0){
                pst = conn.prepareStatement(query_month);
                rs = pst.executeQuery();
            }else{
                pst = conn.prepareStatement(query);
                rs = pst.executeQuery();
            }
            //Recorrer 
            while (rs.next()) {
                Product product = new Product();
                product.setProduct_quantity(rs.getInt("quantity"));
                product.setName(rs.getString("name"));
                product.setCategory_name(rs.getString("category"));
                list_sale_quantity.add(product);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return list_sale_quantity;
    }
    
    public List listTop3Customer(int month) {
        List<Product> list_customer = new ArrayList();
        String query = "SELECT s.sale_date,c.full_name,SUM(s.total) as total FROM sales s INNER JOIN customers c ON s.customer_id=c. id GROUP BY s.customer_id order by s.sale_date DESC LIMIT 3";
        String query_month = "SELECT s.id,s.sale_date,c.full_name,SUM(s.total) as total FROM sales s INNER JOIN customers c ON s.customer_id=c.id WHERE MONTH(s.sale_date)="+month+" GROUP BY s.customer_id order by s.sale_date DESC LIMIT 3";
        try {
            if(month>0){
                conn = cn.getConnection();
                pst = conn.prepareStatement(query_month);
            }else{
                conn = cn.getConnection();
                pst = conn.prepareStatement(query);
            }
            rs = pst.executeQuery();
            //Recorrer 
            while (rs.next()) {
                Product product = new Product();
                product.setName(rs.getString("full_name"));
                product.setUnit_price(rs.getDouble("total"));
                list_customer.add(product);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return list_customer;
    }
}
