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
import javax.swing.JOptionPane;

/**
 *
 * @author PIERO
 */
public class PurchaseDao {
    ConnectionMySQL con = new ConnectionMySQL();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegisterPurchaseQuery(int supplier_id,int employee_id,double total){
        String query = "INSERT INTO purchases(supplier_id,employe_id,total,created) VALUES (?,?,?,?)";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try {
            conn = con.getConnection();
            ps=conn.prepareStatement(query);
            ps.setInt(1, supplier_id);
            ps.setInt(2, employee_id);
            ps.setDouble(3, total);
            ps.setTimestamp(4, datetime);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: Register Purchase");
            System.err.println(e.getMessage());
            return false;
        }
    }
    
    public boolean RegisterPurchaseDetailQuery(double purchase_price,int purchase_amount,double purchase_subtotal,int purchase_id,int product_id){
        String query="INSERT INTO purchase_details(purchase_price,purchase_amount,purchase_subtotal,purchase_id,product_id) VALUES (?,?,?,?,?)";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try{
            conn=con.getConnection();
            ps=conn.prepareStatement(query);
            ps.setDouble(1, purchase_price);
            ps.setInt(2, purchase_amount);
            ps.setDouble(3, purchase_subtotal);
            ps.setInt(4, purchase_id);
            ps.setInt(5, product_id);
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: Register purchase Detail");
            System.out.println(e);
            return false;
        }
    }
    
    public int purchaseId(){
        int id=0;
        String query = "SELECT MAX(id) AS id FROM purchases";
        try{
            conn=con.getConnection();
            ps=conn.prepareStatement(query);
            rs=ps.executeQuery();
            if(rs.next()){
                id=rs.getInt("id");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: purchase id");
            System.err.println(e.getMessage());
        }
        return id;
    }
    
    public List ListAllPurchaseQuery(){
        List<Purchase> list_purchase = new ArrayList();
        String query = "SELECT p.id,s.name as supplier_name,p.total,p.created FROM purchases p INNER JOIN suppliers s ON p.supplier_id=s.id;";
        try{
            conn= con.getConnection();
            ps=conn.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()){
                Purchase purchase = new Purchase();
                purchase.setId(rs.getInt("id"));
                purchase.setSupplier_name_product(rs.getString("supplier_name"));
                purchase.setTotal(rs.getDouble("total"));
                purchase.setCreated(rs.getString("created"));
                list_purchase.add(purchase);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: List all purchase");
            System.err.println(e.getMessage());
        }
        return list_purchase;
    }
    
    public List ListPurchaseDetailQuery(int id){
        List<Purchase> list_purchase = new ArrayList();
        String query = "SELECT pu.created,pude.purchase_price,pude.purchase_amount,pude.purchase_subtotal,su.name AS supplier_name,pro.name AS product_name,em.full_name FROM purchases pu INNER JOIN purchase_details pude ON pu.id = pude.purchase_id INNER JOIN products pro ON pude.product_id = pro.id INNER JOIN suppliers su ON pu.supplier_id = su.id INNER JOIN employees em ON pu.employe_id = em.id WHERE pu.id = ?";
        try{
            conn=con.getConnection();
            ps=conn.prepareStatement(query);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
                Purchase purchase = new Purchase();
                purchase.setProduct_name(rs.getString("product_name"));
                purchase.setPurchase_amount(rs.getInt("purchase_amount"));
                purchase.setPurchase_price(rs.getDouble("purchase_price"));
                purchase.setPurchase_subtotal(rs.getDouble("purchase_subtotal"));
                purchase.setSupplier_name_product(rs.getString("supplier_name"));
                purchase.setCreated(rs.getString("created"));
                purchase.setPurcharser(rs.getString("full_name"));
                list_purchase.add(purchase);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: List purchase detail");
            System.err.println(e.getMessage());
        }
        return list_purchase; 
    }
    
    public double[] TotalPurchaseMonth(){
        double[] list_purchase = new double[6];
        String query = "SELECT COALESCE(SUM(total),0) as enero, (SELECT COALESCE(SUM(total),0) FROM purchases WHERE MONTH(created)=2) as febrero,(SELECT COALESCE(SUM(total),0) FROM purchases WHERE MONTH(created)=3) as marzo,(SELECT COALESCE(SUM(total),0) FROM purchases WHERE MONTH(created)=4) as abril,(SELECT COALESCE(SUM(total),0) FROM purchases WHERE MONTH(created)=5) as mayo,(SELECT COALESCE(SUM(total),0) FROM purchases WHERE MONTH(created)=6) as junio FROM purchases WHERE MONTH(created)=1";
        try{
            conn= con.getConnection();
            ps=conn.prepareStatement(query);
            rs=ps.executeQuery();
            
            while(rs.next()){
                list_purchase[0] =rs.getDouble("enero");
                list_purchase[1]  =rs.getDouble("febrero");
                list_purchase[2]  =rs.getDouble("marzo");
                list_purchase[3]  =rs.getDouble("abril");
                list_purchase[4]  =rs.getDouble("mayo");
                list_purchase[5]  =rs.getDouble("junio");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: List all purchase");
            System.err.println(e.getMessage());
        }
        return list_purchase;
        
    }

}
