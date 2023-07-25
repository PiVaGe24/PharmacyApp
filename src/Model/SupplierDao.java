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
public class SupplierDao {
    ConnectionMySQL con = new ConnectionMySQL();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegisterSupplierQuery(Supplier supplier){
        String query = "INSERT INTO suppliers (id, name, description, telephone, address, email, city, created, updated) VALUES (?,?,?,?,?,?,?,?,?) ";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try{
            conn = con.getConnection();
            ps= conn.prepareStatement(query);
            ps.setInt(1, supplier.getId());
            ps.setString(2, supplier.getName());
            ps.setString(3, supplier.getDescription());
            ps.setString(4, supplier.getTelephone());
            ps.setString(5, supplier.getAddress());
            ps.setString(6, supplier.getEmail());
            ps.setString(7, supplier.getCity());
            ps.setTimestamp(8, datetime);
            ps.setTimestamp(9, datetime);
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: Register Suppplier");
            System.err.println(e.toString());
            return false;
        }
    }
    
    public List ListSupplierQuery(String value,String city){
        List<Supplier> list_supplier = new ArrayList();
        String query = "SELECT * FROM suppliers";
        String query_search = "SELECT * FROM suppliers WHERE name LIKE '%"+value+"%'";
        String query_search_city = "SELECT * FROM suppliers WHERE name LIKE '%"+value+"%' AND city ='"+city+"'";
        try{
            conn = con.getConnection();
            if(value.equalsIgnoreCase("")&&city.equals("All")){
                ps=conn.prepareStatement(query);
                rs=ps.executeQuery();
            }else if(city.equals("All")){
                ps=conn.prepareStatement(query_search);
                rs=ps.executeQuery();
            }else{
                ps=conn.prepareStatement(query_search_city);
                rs=ps.executeQuery();
            }
            while(rs.next()){
                Supplier supplier = new Supplier();
                supplier.setId(rs.getInt("id"));
                supplier.setName(rs.getString("name"));
                supplier.setDescription(rs.getString("description"));
                supplier.setTelephone(rs.getString("telephone"));
                supplier.setAddress(rs.getString("address"));
                supplier.setEmail(rs.getString("email"));
                supplier.setCity(rs.getString("city"));
                list_supplier.add(supplier);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: List Supplier");
            System.err.println(e.toString());
        }
        return list_supplier;
    } 
    
    public boolean UpdateSupplierQuery(Supplier supplier){
        String query = "UPDATE suppliers SET name=?,description=?,telephone=?,address=?,email=?,city=?,updated=? WHERE id=?";
        Timestamp datetime= new Timestamp(new Date().getTime());
        try{
            conn= con.getConnection();
            ps= conn.prepareStatement(query);
            ps.setString(1, supplier.getName());
            ps.setString(2, supplier.getDescription());
            ps.setString(3, supplier.getTelephone());
            ps.setString(4, supplier.getAddress());
            ps.setString(5, supplier.getEmail());
            ps.setString(6, supplier.getCity());
            ps.setTimestamp(7, datetime);
            ps.setInt(8, supplier.getId());
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: updated supplier");
            System.err.println(e.toString());
            return false;
        }
    }
    
    public boolean DeleteSupplierQuery(int id){
        String query = "DELETE FROM suppliers WHERE id="+id;
        try{
            conn = con.getConnection();
            ps = conn.prepareStatement(query);
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: Delete supplier");
            System.err.println(e.toString());
            return false;
        }
    }
}
