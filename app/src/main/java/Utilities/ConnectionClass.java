package Utilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import JavaBeans.AdminUser;
import JavaBeans.Employee;
import JavaBeans.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionClass {

    String hostName = "jdbc:derby://localhost:1527/JEEPRJ";
    Properties properties = new Properties();

    public ConnectionClass() throws SQLException, ClassNotFoundException {

    }

    public void addNewEmployee(String nom, String prenom, String teldom, String telport, String telpro, String adresse, String codePostal, String ville, String email) throws SQLException {

        String query = "INSERT INTO EMPLOYEE (NOM,PRENOM,TELDOMICILE,TELPORTABLE,TELPRO,ADRESSE,CODEPOSTAL,VILLE,EMAIL) VALUES(?,?,?,?,?,?,?,?,?)";
        properties.put("user", "jee");
        properties.put("password", "jee");
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
    }

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> list = new ArrayList<>();
        properties.put("user", "jee");
        properties.put("password", "jee");
        String query = "SELECT * FROM EMPLOYEE";
        Connection con = DriverManager.getConnection(hostName, properties);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            Employee emp;
            Integer id = rs.getInt("ID");
            String nom = rs.getString("NOM");
            String prenom = rs.getString("PRENOM");
            String teldom = rs.getString("TELDOMICILE");
            String telport = rs.getString("TELPORTABLE");
            String telpro = rs.getString("TELPRO");
            String adresse = rs.getString("ADRESSE");
            String codePostal = rs.getString("CODEPOSTAL");
            String ville = rs.getString("VILLE");
            String email = rs.getString("EMAIL");
            emp = new Employee(id, nom, prenom, teldom, telport, telpro, adresse, codePostal, ville, email);
            list.add(emp);
        }
        return list;

    }

    public void deleteEmployee(Integer id) throws SQLException {
        properties.put("user", "jee");
        properties.put("password", "jee");
        String query = "DELETE FROM EMPLOYEE WHERE ID=?";
        Connection con = DriverManager.getConnection(hostName, properties);
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, id.toString());
        pstmt.executeUpdate();

    }

    public Employee getSpecificEmployee(Integer id) throws SQLException {
        Employee emp = null;
        properties.put("user", "jee");
        properties.put("password", "jee");
        String query = "SELECT * FROM EMPLOYEE WHERE ID=?";
        Connection con = DriverManager.getConnection(hostName, properties);
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, id.toString());
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            String nom = rs.getString("NOM");
            String prenom = rs.getString("PRENOM");
            String teldom = rs.getString("TELDOMICILE");
            String telport = rs.getString("TELPORTABLE");
            String telpro = rs.getString("TELPRO");
            String adresse = rs.getString("ADRESSE");
            String codePostal = rs.getString("CODEPOSTAL");
            String ville = rs.getString("VILLE");
            String email = rs.getString("EMAIL");
            emp = new Employee(id, nom, prenom, teldom, telport, telpro, adresse, codePostal, ville, email);
        }
        return emp;
    }

    public void updateEmployee(Integer id, String nom, String prenom, String teldom, String telport, String telpro, String adresse, String codePostal, String ville, String email) throws SQLException {
        properties.put("user", "jee");
        properties.put("password", "jee");
        String query = "UPDATE EMPLOYEE "
                + "SET NOM=?,PRENOM=?,TELDOMICILE=?,  TELPORTABLE=?,  TELPRO=?, ADRESSE=?,  CODEPOSTAL=?,  VILLE=?, EMAIL=? "
                + "WHERE ID=?";
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
        pstmt.setString(10, id.toString());
        pstmt.executeUpdate();
    }

    public User getUser(String userName, String password) throws SQLException {
        String query = "SELECT PASSWORD,ADMIN FROM UTILISATEUR WHERE USERNAME = ?";
        properties.put("user", "jee");
        properties.put("password", "jee");

        Connection con = DriverManager.getConnection(hostName, properties);
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, userName);
        User user = null;
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            if (password.equals(rs.getString("PASSWORD"))) {
                if (rs.getBoolean("ADMIN")) {
                    return new AdminUser(userName, password);
                }
                return new User(userName, password);
            }
        }
        return user;
    }
}
