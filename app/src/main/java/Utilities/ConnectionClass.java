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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    String hostName = "jdbc:derby://localhost:1527/JEEPRJ";
    Properties properties = new Properties();

    public ConnectionClass() throws SQLException, ClassNotFoundException {

    }

    public void addNewEmployee(String nom, String prenom, String teldom, String telport, String telpro, String adresse, String codePostal, String ville, String email) {

        String query = "INSERT INTO EMPLOYE VALUES(?,?,?,?,?,?,?,?,?)";
        properties.put("user", "jee");
        properties.put("password", "jee");
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

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> list = new ArrayList<>();
        properties.put("user", "jee");
        properties.put("password", "jee");
        String query = "SELECT * FROM EMPLOYE";
        Connection con = DriverManager.getConnection(hostName, properties);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            Employee emp;
            String nom = rs.getString("NOM");
            String prenom = rs.getString("PRENOM");
            String teldom = rs.getString("TELDOMICILE");
            String telport = rs.getString("TELPORTABLE");
            String telpro = rs.getString("TELPRO");
            String adresse = rs.getString("ADRESSE");
            String codePostal = rs.getString("CODEPOSTAL");
            String ville = rs.getString("VILLE");
            String email = rs.getString("EMAIL");
            emp = new Employee(nom, prenom, teldom, telport, telpro, adresse, codePostal, ville, email);
            list.add(emp);
        }
        return list;

    }

    public void deleteEmployee(String nom) throws SQLException {
        properties.put("user", "jee");
        properties.put("password", "jee");
        String query = "DELETE FROM EMPLOYE WHERE NOM=?";
        Connection con = DriverManager.getConnection(hostName, properties);
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, nom);
        pstmt.executeUpdate();

    }

    public Employee getSpecificEmployee(String modifiedName) throws SQLException {
        Employee emp = null;
        properties.put("user", "jee");
        properties.put("password", "jee");
        String query = "SELECT * FROM EMPLOYE WHERE NOM=?";
        Connection con = DriverManager.getConnection(hostName, properties);
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, modifiedName);
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
            emp = new Employee(nom, prenom, teldom, telport, telpro, adresse, codePostal, ville, email);
        }
        return emp;
    }

    public void updateEmployee(String nom, String prenom, String teldom, String telport, String telpro, String adresse, String codePostal, String ville, String email, String selectName) throws SQLException {
        properties.put("user", "jee");
        properties.put("password", "jee");
        String query = "UPDATE EMPLOYE "
                + "SET NOM=?,PRENOM=?,TELDOMICILE=?,  TELPORTABLE=?,  TELPRO=?, ADRESSE=?,  CODEPOSTAL=?,  VILLE=?, EMAIL=? "
                + "WHERE NOM=?";
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
        pstmt.setString(10, selectName);

        pstmt.executeUpdate();

    }

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            ConnectionClass connectionClass = new ConnectionClass();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
