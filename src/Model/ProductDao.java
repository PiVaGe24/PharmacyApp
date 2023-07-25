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
public class ProductDao {
    ConnectionMySQL con = new ConnectionMySQL();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegisterProductQuery(Product product){
        String query = "INSERT INTO products (code,name,description,unit_price,created,updated,category_id) VALUES (?,?,?,?,?,?,?)";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try{
            conn=con.getConnection();
            ps= conn.prepareStatement(query);
            ps.setString(1, product.getCode());
            ps.setString(2, product.getName());
            ps.setString(3, product.getDescription());
            ps.setDouble(4, product.getUnit_price());
            ps.setTimestamp(5, datetime);
            ps.setTimestamp(6, datetime);
            ps.setInt(7, product.getCategory_id());
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: Register Product");
            System.err.println(e.toString());
            return false;
        }
    }
    
    public List ListProductQuery(String value,int idcategory){
        List<Product> list_product = new ArrayList();
        String query = "SELECT pro.*,ca.name AS category_name  FROM products pro INNER JOIN categories ca ON pro.category_id = ca.id";
        String query_search_product="SELECT pro.*,ca.name AS category_name  FROM products pro INNER JOIN categories ca ON pro.category_id = ca.id WHERE pro.name LIKE '%"+value+"%'";
        String query_search_product_category="SELECT pro.*,ca.name AS category_name  FROM products pro INNER JOIN categories ca ON pro.category_id = ca.id WHERE pro.name LIKE '%"+value+"%' AND ca.id="+idcategory;
        
        try{
            conn=con.getConnection();
            if(value.equalsIgnoreCase("")&&idcategory==0){
                ps=conn.prepareStatement(query);
                rs=ps.executeQuery();
            }else if(idcategory==0){
                ps=conn.prepareStatement(query_search_product);
                rs=ps.executeQuery();
            }else{
                ps=conn.prepareStatement(query_search_product_category);
                rs=ps.executeQuery();
            }
            while (rs.next()) {                
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setCode(rs.getString("code"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setUnit_price(rs.getDouble("unit_price"));
                product.setProduct_quantity(rs.getInt("product_quantity"));
                product.setCategory_name(rs.getString("category_name"));
                list_product.add(product);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: List product");
            System.err.println(e.toString());
        }
        return list_product;
    }
    
    public boolean  UpdateProductQuery(Product product){
        String query = "UPDATE products SET code=?,name=?,description=?,unit_price=?,updated=?,category_id=? WHERE id=?";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try{
            conn=con.getConnection();
            ps=conn.prepareStatement(query);
            ps.setString(1, product.getCode());
            ps.setString(2, product.getName());
            ps.setString(3, product.getDescription());
            ps.setDouble(4, product.getUnit_price());
            ps.setTimestamp(5, datetime);
            ps.setInt(6, product.getCategory_id());
            ps.setInt(7, product.getId());
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: Update product");
            System.err.println(e.toString());
            return false;
        }
    }
    
    public boolean DeleteProductQuery(int id){
        String query = "DELETE FROM products WHERE id="+id;
        try{
            conn = con.getConnection();
            ps= conn.prepareStatement(query);
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: Delete Product");
            System.err.println(e.toString());
            return false;
        }
    }
    
    public Product CallProductQueryxId(int id){
        String query = "SELECT pro.*,ca.name AS category_name  FROM products pro INNER JOIN categories ca ON pro.category_id = ca.id WHERE pro.id=?";
        Product product = new Product();
        try{
            conn = con.getConnection();
            ps= conn.prepareStatement(query);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                product.setId(rs.getInt("id"));
                product.setCode(rs.getString("code"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setUnit_price(rs.getDouble("unit_price"));
                product.setCategory_id(rs.getInt("category_id"));
                product.setCategory_name(rs.getString("category_name"));
            }
            }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: CallProduct");
            System.err.println(e.getMessage());
        }
        return product;
    }
    
    public Product CallProductQueryxCode(String code){
        String query = "SELECT pro.id,pro.name,pro.product_quantity,pro.unit_price FROM products pro WHERE pro.code=?";
        Product product = new Product();
        try{
            conn = con.getConnection();
            ps= conn.prepareStatement(query);
            ps.setString(1, code);
            rs=ps.executeQuery();
            if(rs.next()){
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setProduct_quantity(rs.getInt("product_quantity"));
                product.setUnit_price(rs.getDouble("unit_price"));
            }
            }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: CallProduct");
            System.err.println(e.getMessage());
        }
        return product;
    }
    
    public Product CallQuantityProductQuery(int id){
        String query = "SELECT pro.product_quantity FROM products pro WHERE pro.id=?";
        Product product = new Product();
        try{
            conn=con.getConnection();
            ps=conn.prepareStatement(query);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                product.setProduct_quantity(rs.getInt("product_quantity"));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: CallQuantityProduct");
            System.err.println(e.toString());
        }
        return product;
    }
    
    public boolean UpdateStockQuery(int amount,int product_id){
        String query = "UPDATE products SET product_quantity=? WHERE id=?";
        try{
            conn=con.getConnection();
            ps=conn.prepareStatement(query);
            ps.setInt(1, amount);
            ps.setInt(2, product_id);
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: Update Stock Query");
            System.err.println(e.toString());
            return false;
        }
    }
    
}
