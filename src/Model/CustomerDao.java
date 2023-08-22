/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.swing.search.DataSearch;
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
public class CustomerDao {
    ConnectionMySQL con = new ConnectionMySQL();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public boolean RegisterCustomerQuery(Customer customer){
        String query = "INSERT INTO customers(id,full_name,address,telephone,email,created,updated) VALUES(?,?,?,?,?,?,?)";
        Timestamp datetime = new Timestamp(new Date().getTime());
        conn = con.getConnection();
        try {
            ps=conn.prepareStatement(query);
            ps.setInt(1, customer.getId());
            ps.setString(2, customer.getFull_name());
            ps.setString(3, customer.getAddress());
            ps.setString(4, customer.getTelephone());
            ps.setString(5, customer.getEmail());
            ps.setTimestamp(6, datetime);
            ps.setTimestamp(7, datetime);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: Register customer");
            System.err.println(e.toString());
            //Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    
    public List ListCustomerQuery(String value){
        List<Customer> customer_list = new ArrayList();
        String query = "SELECT * FROM customers";
        String query_search_name = "SELECT * FROM customers WHERE full_name LIKE ?";
        try {
            conn = con.getConnection();
            if(value.equalsIgnoreCase("")){
                ps=conn.prepareStatement(query);
                rs=ps.executeQuery();
            }else{
                ps=conn.prepareStatement(query_search_name);
                ps.setString(1, "%"+value+"%");
                rs=ps.executeQuery();
            }
            while(rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFull_name(rs.getString("full_name"));
                customer.setAddress(rs.getString("address"));
                customer.setTelephone(rs.getString("telephone"));
                customer.setEmail(rs.getString("email"));
                customer_list.add(customer);
            }
            return customer_list;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer_list;
    }
    
    public List<DataSearch> ListSearchCustomerQuery(String value){
        List<DataSearch> list_customer = new ArrayList<>();
        String query = "SELECT * FROM customers ORDER BY full_name ASC LIMIT 7";
        String query_search_customer = "SELECT * FROM customers WHERE full_name LIKE ? LIMIT 7";
        try{
            conn=con.getConnection();
            //Compara dos strings para ver si son iguales ignorando las diferencias entre mayúsculas y minúsculas
            if(value.equalsIgnoreCase("")){
                ps=conn.prepareStatement(query);
                rs=ps.executeQuery();
            }else {
                ps=conn.prepareStatement(query_search_customer);
                ps.setString(1,"%"+value+"%");
                rs=ps.executeQuery();
            }
        while(rs.next()){
            String name = rs.getString("full_name");
            int id = rs.getInt("id");
            //boolean story = isStory(name);
            //if (story) {
                list_customer.add(0, new DataSearch(id,name,false));
            //} else {
            //    list.add(new DataSearch(name, story));
            //}
        }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return list_customer;
    }

    public List ListCustomer5Query(String value){
        List<Customer> customer_list = new ArrayList();
        String query = "SELECT * FROM customers LIMIT 5";
        String query_search_name = "SELECT * FROM customers WHERE full_name LIKE '%"+value+"%' LIMIT 5";
        try {
            conn = con.getConnection();
            if(value.equalsIgnoreCase("")){
                ps=conn.prepareStatement(query);
                rs=ps.executeQuery();
            }else{
                ps=conn.prepareStatement(query_search_name);
                rs=ps.executeQuery();
            }
            while(rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFull_name(rs.getString("full_name"));
                customer_list.add(customer);
            }
            return customer_list;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer_list;
    }
    
    public boolean UpdateCustomerQuery(Customer customer){
        String query = "UPDATE customers SET full_name=?,address=?,telephone=?,email=?,updated=? WHERE id=?";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try{
            conn = con.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, customer.getFull_name());
            ps.setString(2, customer.getAddress());
            ps.setString(3, customer.getTelephone());
            ps.setString(4, customer.getEmail());
            ps.setTimestamp(5, datetime);
            ps.setInt(6, customer.getId());
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: Update customer");
            System.err.println(e.toString());
            return false;
        }
    }
    
    public boolean DeleteCustomerQuery(int id){
        String query = "DELETE FROM customers WHERE id="+id;
        try{
            conn = con.getConnection();
            ps=conn.prepareStatement(query);
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error:Delete customers");
            System.err.println(e.toString());
            return false;
        }
    }
    
    public Customer CallCustomerQueryxId(int id){
        String query = "SELECT c.full_name FROM customers c WHERE c.id=?";
        Customer customer = new Customer();
        try{
            conn = con.getConnection();
            ps= conn.prepareStatement(query);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                customer.setFull_name(rs.getString("full_name"));
            }
            return customer;
            }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: CallProduct");
            System.err.println(e.getMessage());
            return customer;
        }
    }
    //COMBOBOX_Category
    public List<Customer>fillCustomerSql(){
        List<Customer>listCustomer = new ArrayList();
        //listArea.add(new Category(1,"Selecciona"));
    try {
        conn=con.getConnection();
        //st = conn.createStatement();
        ps=conn.prepareStatement("SELECT * FROM customers");
        rs=ps.executeQuery();
        while(rs.next()){
            Customer objCustomer = new Customer();
            objCustomer.setId(rs.getInt("id"));
            objCustomer.setFull_name(rs.getString("full_name"));
            listCustomer.add(objCustomer);
        }
        rs.close();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        JOptionPane.showMessageDialog(null, "Error List ComboBox category");
        //Logger.getLogger(Area.class.getName()).log(Level.SEVERE, null, ex);     
    }
        return listCustomer;
    }
}
