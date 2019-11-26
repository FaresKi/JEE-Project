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

    /**
     * get all Employees
     *
     * @return List<Employee>
     */
    public List<Employee> getAllEmployees() {
        String query = "SELECT e FROM Employee e ";
        Query q = em.createQuery(query);
        List<Employee> employees = q.getResultList();
        return employees;
    }

    /**
     * Add new Employee
     *
     * @param nom
     * @param prenom
     * @param telDom
     * @param telPort
     * @param telPro
     * @param adresse
     * @param codePostal
     * @param ville
     * @param email
     */
    public void addNewEmployee(String nom, String prenom, String telDom, String telPort, String telPro, String adresse, String codePostal, String ville, String email) {

        Employee emp = new Employee(nom, prenom, telDom, telPort, telPro, adresse, codePostal, ville, email);
        em.persist(emp);
    }

    /**
     * delete Employee
     *
     * @param id
     */
    public void deleteEmployee(int id) {
        Employee employee = em.find(Employee.class, id);
        em.remove(employee);
    }

    /**
     * update Employee
     *
     * @param nom
     * @param prenom
     * @param telDom
     * @param telPort
     * @param telPro
     * @param adresse
     * @param codePostal
     * @param ville
     * @param email
     */
    public void updateEmployee(String nom, String prenom, String telDom, String telPort, String telPro, String adresse, String codePostal, String ville, String email, int id) {

        Employee emp = em.find(Employee.class, id);
        emp.setNom(nom);
        emp.setPrenom(prenom);
        emp.setTelDomicile(telDom);
        emp.setTelPortable(telPort);
        emp.setTelPro(telPro);
        emp.setAdresse(adresse);
        emp.setCodePostal(codePostal);
        emp.setVille(ville);
        emp.setEmail(email);
    }

    /**
     * get one Employee
     *
     * @param id
     */
    public Employee getSpecificEmployee(int id) {
        return em.find(Employee.class, id);
    }

    /**
     * get one User
     *
     * @param userName
     * @param password
     *
     * @return User
     */
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

