package Utilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author fareskissoum
 */
public class ConnectionClass {
    
   
        

    public ConnectionClass() throws SQLException, ClassNotFoundException {
        String hostName ="jdbc:derby://localhost:1527/JEEPRJ"  ;
        Connection con;   
        Properties properties = new Properties();
            properties.put("user", "jee");
            properties.put("password", "jee");
        con = DriverManager.getConnection(hostName,properties);
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
        try {
             new ConnectionClass();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}


