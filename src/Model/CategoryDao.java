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
public class CategoryDao {
    ConnectionMySQL con = new ConnectionMySQL();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegisterCategoryQuery(Category category){
        String query = "INSERT INTO categories (name, created, updated) VALUES (?,?,?)";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try{
            conn=con.getConnection();
            ps=conn.prepareStatement(query);
            ps.setString(1, category.getName());
            ps.setTimestamp(2, datetime);
            ps.setTimestamp(3, datetime);
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: Register Category");
            System.err.println(e.toString());
            return false;
        }
    }
    
    public List ListCategoryQuery(String value){
        List<Category> list_category = new ArrayList<>();
        String query = "SELECT * FROM categories";
        String query_search = "SELECT * FROM categories WHERE name LIKE '%"+value+"%'";
        try{
            conn = con.getConnection();
            if(value.equalsIgnoreCase("")){
                ps=conn.prepareStatement(query);
                rs=ps.executeQuery();
            }else{
                ps=conn.prepareStatement(query_search);
                rs=ps.executeQuery();
            }
        while(rs.next()){
            Category category = new Category();
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));
            list_category.add(category);
        }
        return list_category;
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: List Category");
            System.err.println(e.toString());
        }
        return list_category;
    }
    
    public boolean UpdateCategoryQuery(Category category){
        String query = "UPDATE categories SET name=?,updated=? WHERE id=?";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try{
            conn = con.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, category.getName());
            ps.setTimestamp(2, datetime);
            ps.setInt(3, category.getId());
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: Update category");
            System.err.println(e.toString());
            return false;
        }
    }
    
    public boolean DeleteCategoryQuery(int id){
        String query = "DELETE FROM categories WHERE id="+id;
        try{
            conn=con.getConnection();
            ps=conn.prepareStatement(query);
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: Delete category");
            System.err.println(e.toString());
            return false;
        }
    }
    
    //COMBOBOX_Category
    public List<Category>fillCategorySql(){
        List<Category>listCategory = new ArrayList();
        //listArea.add(new Category(1,"Selecciona"));
    try {
        conn=con.getConnection();
        //st = conn.createStatement();
        ps=conn.prepareStatement("SELECT * FROM categories");
        rs=ps.executeQuery();
        while(rs.next()){
            Category objCategory = new Category();
            objCategory.setId(rs.getInt("id"));
            objCategory.setName(rs.getString("name"));
            listCategory.add(objCategory);
        }
        rs.close();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        JOptionPane.showMessageDialog(null, "Error List ComboBox category");
        //Logger.getLogger(Area.class.getName()).log(Level.SEVERE, null, ex);     
    }
        return listCategory;
    }
}
