package SessionBeans;

import Entities.Employee;
import Entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless

public class EntitiesSB {
    @PersistenceContext
    EntityManager em;

    public List<Employee> getAllEmployees() {

        String query = "SELECT e FROM Employee e ";
        Query q = em.createQuery(query);
        List<Employee> employees = q.getResultList();
        if (employees != null) {
            return employees;
        }
        return null;
    }

    public void addNewEmployee(String nom, String prenom, String teldom, String telport, String telpro, String adresse, String codePostal, String ville, String email) {

        Employee emp = new Employee(nom, prenom, teldom, telport, telpro, adresse, codePostal, ville, email);
        em.persist(emp);
    }

    public void deleteEmployee(int id) {
        Employee employee = em.find(Employee.class, id);
        em.remove(employee);
    }

    public void updateEmployee(String nom, String prenom, String teldom, String telport, String telpro, String adresse, String codePostal, String ville, String email, int id) {

        Employee emp = em.find(Employee.class, id);
        emp.setNom(nom);
        emp.setPrenom(prenom);
        emp.setTelDomicile(teldom);
        emp.setTelPortable(telport);
        emp.setTelPro(telpro);
        emp.setAdresse(adresse);
        emp.setCodePostal(codePostal);
        emp.setVille(ville);
        emp.setEmail(email);
    }

    public Employee getSpecificEmployee(int id) {
        return em.find(Employee.class, id);
    }


    public User getUser(String userName, String password) {
        String queryGetUser = "SELECT u FROM User u WHERE u.username = :username AND u.password=:password";
        try {
            User fetchedUser = (User) em.createQuery(queryGetUser).setParameter("username", userName).setParameter("password", password).getSingleResult();
            return fetchedUser;
        } catch (javax.persistence.NoResultException e) {
            return null;
        }

    }
}
