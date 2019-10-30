/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import JavaBeans.AdminUser;
import JavaBeans.Employee;
import JavaBeans.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fareskissoum
 */
public class JPAUtil {

    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
    private static EntityManagerFactory factory;
    private static EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    public static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        //entityManager.getTransaction().begin();

        /*
        Employee emp = new Employee("test","test","","","","","","","");
        entityManager.getTransaction().begin();
        entityManager.persist(emp);
        entityManager.getTransaction().commit();


        List<Employee> employees = new ArrayList<>();
        String queryAllEmployees = "SELECT * FROM EMPLOYE";
        employees = entityManager.createNativeQuery(queryAllEmployees, Employee.class).getResultList();
        for (Employee empTest : employees) {
            System.out.println("Nom : " + empTest.getNom());
        }
         */

        String admin = "admin";
        User user = entityManager.find(User.class,admin);
        System.out.println("username : " + user.getUserName());

        // Check database version
        String sql = "select version()";
        /*
        String result = (String) entityManager.createNativeQuery(sql).getSingleResult();
        System.out.println(result);
         */
        //entityManager.getTransaction().commit();
        entityManager.close();

        JPAUtil.shutdown();
    }

    public void addNewEmployee(String nom, String prenom, String teldom, String telport, String telpro, String adresse, String codePostal, String ville, String email) {

        Employee emp = new Employee(nom, prenom, teldom, telport, telpro, adresse, codePostal, ville, email);
        entityManager.getTransaction().begin();
        entityManager.persist(emp);
        entityManager.getTransaction().commit();
    }

    public List<Employee> getAllEmployees() {
        String queryAllEmployees = "SELECT * FROM EMPLOYE";
        return entityManager.createNativeQuery(queryAllEmployees, Employee.class).getResultList();
    }

    public void deleteEmployee(int id) {
        String queryDeleteEmployee = "DELETE FROM EMPLOYE WHERE ID=?";
        entityManager.createNativeQuery(queryDeleteEmployee)
                .setParameter(1, id)
                .executeUpdate();
    }

    public void updateEmployee(String nom, String prenom, String teldom, String telport, String telpro, String adresse, String codePostal, String ville, String email, int id) {

        Employee emp = entityManager.find(Employee.class, id);
        entityManager.getTransaction().begin();
        emp.setNom(nom);
        emp.setPrenom(prenom);
        emp.setTelDomicile(teldom);
        emp.setTelPortable(telport);
        emp.setTelPro(telpro);
        emp.setAdresse(adresse);
        emp.setCodePostal(codePostal);
        emp.setVille(ville);
        emp.setEmail(email);
        entityManager.getTransaction().commit();
    }

    public  Employee getSpecificEmployee(int id) {
        return entityManager.find(Employee.class, id);
    }


    public  User getUser(String userName, String password) {

        User user = entityManager.find(User.class,userName);
        if(user==null){
            System.out.println("null merde");
        }
        if (password.equals(user.getPassword())) {
            System.out.println("good password");
            String query = "SELECT ADMIN FROM UTILISATEUR WHERE USERNAME = ?";
            int isAdmin = (int) entityManager.createNativeQuery(query, Integer.class)
                    .setParameter(1, userName)
                    .getSingleResult();
            if (isAdmin==1) {
                AdminUser adminUser = (AdminUser) user;
                return adminUser;
            }
            return user;
        }
        return user;

    }

}
