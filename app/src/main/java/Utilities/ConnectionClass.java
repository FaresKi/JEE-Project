package Utilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import JavaBeans.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fareskissoum
 */
public class ConnectionClass {

    private List<Employee> employeList = new ArrayList();
    

    String hostName = "jdbc:derby://localhost:1527/JEEPRJ";
    Properties properties = new Properties();

    public ConnectionClass() throws SQLException, ClassNotFoundException {
        

    }

    public void addNewEmployee(String nom, String prenom, String teldom, String telport, String telpro, String adresse, String codePostal, String ville, String email) {

        String query = "INSERT INTO EMPLOYE VALUES(?,?,?,?,?,?,?,?,?)";

        properties.put("user", "jee");
        properties.put("password", "jee");
         Employee emp ;
        try {
            Connection con = DriverManager.getConnection(hostName, properties);
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3, teldom);
            pstmt.setString(4, telport);
            pstmt.setString(5, telpro);
            pstmt.setString(6, adresse);
            pstmt.setString(7, codePostal);
            pstmt.setString(8, ville);
            pstmt.setString(9, email);

            pstmt.executeUpdate();
            emp = new Employee(nom, prenom, teldom, telport, telpro, adresse, codePostal, ville, email, null, null);
             
            this.employeList.add(emp);
            System.out.println("taille liste : " + employeList.size());
           
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            ConnectionClass connectionClass = new ConnectionClass();
            System.out.println("Size : " + connectionClass.getEmployeList().size() );
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Employee> getEmployeList() {
        return employeList;
    }

}
