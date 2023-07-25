/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PIERO
 */
public class EmployeeDao {
    //Intance tha connection
    ConnectionMySQL con = new ConnectionMySQL();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    MessageDigest md;
    byte[] hash;
    //Variables para enviar datos entre interfaces
    public static int id_user = 0;
    public static String full_name = "";
    public static String username_user = "";
    public static String address_user = "";
    public static String telephone_user = "";
    public static String email_user = "";
    public static String rol_user="";
    
    //Metodo Login
    public Employee LoginQuery(String user,String password){
        String query = "SELECT * FROM employees WHERE username = ? AND password = ?";
        Employee employee = new Employee();
        try{
            conn = con.getConnection();
            ps = conn.prepareStatement(query);
            //Enviar parametros
            ps.setString(1, user);
            ps.setString(2, password);
            rs=ps.executeQuery();
            if(rs.next()){
                employee.setId(rs.getInt("id"));
                id_user = employee.getId();
                employee.setFull_name(rs.getString("full_name"));
                full_name = employee.getFull_name();
                employee.setUsername(rs.getString("username"));
                username_user = employee.getUsername();
                employee.setAddress(rs.getString("address"));
                address_user = employee.getAddress();
                employee.setTelephone(rs.getString("telephone"));
                telephone_user = employee.getTelephone();
                employee.setEmail(rs.getString("email"));
                email_user = employee.getEmail();
                employee.setRol(rs.getString("rol"));
                rol_user = employee.getRol();
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return employee;
    }
    
    //Register Employee
    public boolean RegisterEmployeeQuery(Employee employee){
        String query = "INSERT INTO employees(id,full_name,username,address,telephone,email,password,rol,created,updated) VALUES(?,?,?,?,?,?,?,?,?,?)";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try{
            md = MessageDigest.getInstance("SHA-256");
            hash = md.digest(employee.getPassword().getBytes(StandardCharsets.UTF_8));            
            String encodedHash = Base64.getEncoder().encodeToString(hash);
            
            conn = con.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, employee.getId());
            ps.setString(2,employee.getFull_name());
            ps.setString(3,employee.getUsername());
            ps.setString(4,employee.getAddress());
            ps.setString(5,employee.getTelephone());
            ps.setString(6,employee.getEmail());
            ps.setString(7,employee.getPassword());
            ps.setString(8,employee.getRol());
            ps.setTimestamp(9,datetime);
            ps.setTimestamp(10,datetime);
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al registrar EMPLEADO");
            System.err.println(e.getMessage());
            return false;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //List employee
    public List ListEmployeeQuery(String value,String rol){
        List<Employee> list_Employee = new ArrayList<>();
        String query = "SELECT * FROM employees ORDER BY rol ASC";
        String query_search_employee = "SELECT * FROM employees WHERE id LIKE '%" + value + "%'";
        String query_search_employee_rol = "SELECT * FROM employees WHERE id LIKE '%" + value + "%' AND rol='"+rol+"'";
        try{
            conn=con.getConnection();
            //Compara dos strings para ver si son iguales ignorando las diferencias entre mayúsculas y minúsculas
            if(value.equalsIgnoreCase("")&&rol.equals("All")){
                ps=conn.prepareStatement(query);
                rs=ps.executeQuery();
            }else if(rol.equalsIgnoreCase("All")){
                ps=conn.prepareStatement(query_search_employee);
                rs=ps.executeQuery();
            }else{
                ps=conn.prepareStatement(query_search_employee_rol);
                rs=ps.executeQuery();
            }
        while(rs.next()){
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setFull_name(rs.getString("full_name"));
            employee.setUsername(rs.getString("username"));
            employee.setAddress(rs.getString("address"));
            employee.setTelephone(rs.getString("telephone"));
            employee.setEmail(rs.getString("email"));
            employee.setRol(rs.getString("rol"));
            list_Employee.add(employee);
        }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return list_Employee;
    }
    
    //Update employee
    public boolean UpdateEmployeeQuery(Employee employee){
        String query = "UPDATE employees SET full_name=?,username=?,address=?,telephone=?,email=?,rol=?,updated=? WHERE id=?";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try{
            conn=con.getConnection();
            ps=conn.prepareStatement(query);
            ps.setString(1, employee.getFull_name());
            ps.setString(2, employee.getUsername());
            ps.setString(3, employee.getAddress());
            ps.setString(4, employee.getTelephone());
            ps.setString(5, employee.getEmail());
            ps.setString(6, employee.getRol());
            ps.setTimestamp(7, datetime);
            ps.setInt(8, employee.getId());
            ps.execute();
            return true;
            }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error Update Employee");
            System.err.println(e.toString());
            return false;
        }
    }
    
    //delete employee
    public boolean DeleteEmployeeQuery(int id){
        String query= "DELETE FROM employees WHERE id="+id;
        try{
            conn=con.getConnection();
            ps=conn.prepareStatement(query);
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Imposible Eliminar este usuario");
            System.err.println(e.toString());
            return false;
        }
    }
    
    //Change password
    public boolean updateEmployeePasswordQuery(Employee employee){
        String query = "UPDATE employees SET password = ? WHERE username ='"+username_user+"'";
        try{
            conn = con.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, employee.getPassword());
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: Change the password");
            System.err.println(e.toString());
            return false;
        }
    }

}
