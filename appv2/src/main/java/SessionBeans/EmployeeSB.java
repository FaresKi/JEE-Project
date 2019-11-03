/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import Entities.Employee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author fareskissoum
 */
@Stateless
public class EmployeeSB {
    @PersistenceContext
    EntityManager em;

    public List<Employee> getAllEmployees(){

        String query = "SELECT e FROM Employee e ";
        Query q  = em.createQuery(query);
        List<Employee> employees = q.getResultList();
        if(employees!=null){
            System.out.println("c'est pas null list size : " + q.getResultList().size());
            for(Employee emp:employees){
                System.out.println("id  : " + emp.getId());
            }
            return employees;
        }
        System.out.println("c'est null");
        return employees;
    }

    public void addNewEmployee(String nom, String prenom, String teldom, String telport, String telpro, String adresse, String codePostal, String ville, String email) {

        Employee emp = new Employee(nom, prenom, teldom, telport, telpro, adresse, codePostal, ville, email);
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();
    }
    public void deleteEmployee(int id) {
        Employee employee = em.find(Employee.class, id);

        em.getTransaction().begin();
        em.remove(employee);
        em.getTransaction().commit();
    }

    public void updateEmployee(String nom, String prenom, String teldom, String telport, String telpro, String adresse, String codePostal, String ville, String email, int id) {

        Employee emp = em.find(Employee.class, id);
        em.getTransaction().begin();
        emp.setNom(nom);
        emp.setPrenom(prenom);
        emp.setTelDomicile(teldom);
        emp.setTelPortable(telport);
        emp.setTelPro(telpro);
        emp.setAdresse(adresse);
        emp.setCodePostal(codePostal);
        emp.setVille(ville);
        emp.setEmail(email);
        em.getTransaction().commit();
    }

    public  Employee getSpecificEmployee(int id) {
        return em.find(Employee.class, id);
    }


    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
