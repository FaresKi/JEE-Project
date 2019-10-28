/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import JavaBeans.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * @author fareskissoum
 */
public class JPAUtil {

    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
    private static EntityManagerFactory factory;
    private EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

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
        entityManager.getTransaction().begin();

        // Check database version
        String sql = "select version()";

        String result = (String) entityManager.createNativeQuery(sql).getSingleResult();
        System.out.println(result);

        entityManager.getTransaction().commit();
        entityManager.close();

        JPAUtil.shutdown();
    }

    public void addNewEmployee(String nom, String prenom, String teldom, String telport, String telpro, String adresse, String codePostal, String ville, String email) {

        String queryAddNewEmployee = "INSERT INTO EMPLOYE (NOM, PRENOM, TELDOMICILE, TELPORTABLE, TELPRO, ADRESSE, CODEPOSTAL, VILLE, EMAIL) VALUES(?,?,?,?,?,?,?,?,?)";
        entityManager.createNativeQuery(queryAddNewEmployee)
                .setParameter(1, nom)
                .setParameter(2, prenom)
                .setParameter(3, teldom)
                .setParameter(4, telport)
                .setParameter(5, telpro)
                .setParameter(6, adresse)
                .setParameter(7, codePostal)
                .setParameter(8, ville)
                .setParameter(9, email)
                .executeUpdate();
    }

    public List<Employee> getAllEmployees() {
        String queryAllEmployees = "SELECT * FROM EMPLOYE";
        return entityManager.createNativeQuery(queryAllEmployees).getResultList();
    }

    public void deleteEmployee(int id){
        String queryDeleteEmployee = "DELETE FROM EMPLOYE WHERE ID=?";
        entityManager.createNativeQuery(queryDeleteEmployee)
                .setParameter(1,id)
                .executeUpdate();
    }
    public Employee getSpecificEmployee(int id){
        String queryGetSpecificEmployee = "SELECT * FROM EMPLOYE WHERE ID=?";
       return (Employee) entityManager.createNativeQuery(queryGetSpecificEmployee)
                .setParameter(1,id)
                .getSingleResult();

    }

}
