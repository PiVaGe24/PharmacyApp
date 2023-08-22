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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PIERO
 */
public class RolDao {
    ConnectionMySQL con = new ConnectionMySQL();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean registerRolQuery(String name_rol){
        String query = "call CreateRoleWithPermissions(?)";
        try{
            conn = con.getConnection();
            ps=conn.prepareStatement(query);
            ps.setString(1, name_rol);
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: Register Rol Query");
            System.err.println(e.toString());
            return false;
        }
    }
    
    public boolean deleteRolQuery(int id_rol){
        String query = "CALL DeleteRoleAndPermissions(?)";
        try {
            conn=con.getConnection();
            ps=conn.prepareStatement(query);
            ps.setInt(1, id_rol);
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RolDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }  
    }
    
    public boolean updateRolQuery(String name,int id_rol){
        String query = "UPDATE roles SET rol_name = ? WHERE id = ?";
        try {
            conn = con.getConnection();
            ps=conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, id_rol);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RolDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean updatePermissionsRolQuery(boolean status,int id_rol,int id_permission){
        String query = "UPDATE rol_permissions SET status=? WHERE id_rol=? and id_permission=?";
        try {
            conn = con.getConnection();
            ps=conn.prepareStatement(query);
            ps.setBoolean(1, status);
            ps.setInt(2, id_rol);
            ps.setInt(3, id_permission);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: Delete Permission Rol");
            System.err.println(e.toString());
            return false;
        }
    }  
    
    public List ListRolQuery(){
        List<Rol> customer_rol = new ArrayList();
        String query = "SELECT * FROM roles where id>2";
        try {
            conn = con.getConnection();
            ps=conn.prepareStatement(query);
            rs=ps.executeQuery();

            while(rs.next()){
                Rol objRol = new Rol();
                objRol.setId(rs.getInt("id"));
                objRol.setName(rs.getString("rol_name"));
                customer_rol.add(objRol);
            }
            return customer_rol;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer_rol;
    }
    
    //COMBOBOX
    public List<Rol>fillRolSql(int num){
        List<Rol> listRol = new ArrayList();
        try {
            conn=con.getConnection();
            if(num==1){
                ps=conn.prepareStatement("SELECT * FROM roles where id>2");
                rs=ps.executeQuery();

            }else{
                ps=conn.prepareStatement("SELECT * FROM roles");
                rs=ps.executeQuery();
            }
            while(rs.next()){
                Rol objRol = new Rol();
                objRol.setId(rs.getInt("id"));
                objRol.setName(rs.getString("rol_name"));
                listRol.add(objRol);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error List ComboBox Roles");
            Logger.getLogger(RolDao.class.getName()).log(Level.SEVERE, null, e);     
        }
            return listRol;
    }
}
