/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PIERO
 */
public class ConnectionMySQL {

    private final String database_name = "pharmacy_database";
    private final String user = "piero";
    private final String password = "piero1234";
    private final String url = "jdbc:mysql://localhost:3306/" + database_name;
    Connection conn = null;

    public Connection getConnection() {
        try {
            //Obtenemos el valor del Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Obtener la conexion
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            //Logger.getLogger(ConnectionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
