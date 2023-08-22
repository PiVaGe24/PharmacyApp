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

/**
 *
 * @author PIERO
 */
public class MenuItemDao {
    ConnectionMySQL con = new ConnectionMySQL();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public List ListPermissionsQuery(int id){
        List<MenuItem> list_menu = new ArrayList();
        String query = "SELECT p.name as name, p.img as img FROM employees e JOIN roles r ON e.id_rol = r.id JOIN rol_permissions up ON  up.id_rol=e.id_rol JOIN permissions p ON p.id_permission=up.id_permission WHERE e.id ="+id+" AND up.status=1";
        //String query = "SELECT p.name as name , p.img as img FROM user_permissions up JOIN user_roles ur ON ur.id = up.id_user_rol JOIN permissions p ON p.id_permission = up.id_permission WHERE ur.employees_id ="+id+" AND up.status =1 ORDER BY p.id_permission ASC";
        try {
            conn = con.getConnection();
            if(id!=0){
                ps=conn.prepareStatement(query);
                rs=ps.executeQuery();
            }
            while(rs.next()){
                MenuItem menuItem = new MenuItem();
                menuItem.setName(rs.getString("name"));
                menuItem.setIcon(rs.getString("img"));
                list_menu.add(menuItem);
            }
            list_menu.add(new MenuItem("Profile","/com/icon/8.png",0));
            list_menu.add(new MenuItem("Logout","/com/icon/logout.png",0));
            return list_menu;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_menu;
    }
    
    public List<Permission> loadPermissionsFromDatabase(int id) {
        List<Permission> permissions = new ArrayList<>();
        String query = "Call SearchRolPermissions(?)";
        try {
            conn=con.getConnection();
            ps=conn.prepareStatement(query);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
                Permission permission = new Permission();
                permission.setId(rs.getInt("id_permission"));
                permission.setName(rs.getString("name"));
                permission.setStatus(rs.getBoolean("status"));
                permissions.add(permission);
            }
            return permissions;
        } catch (SQLException e) {
            return permissions;
        }
    }
    
    
}
