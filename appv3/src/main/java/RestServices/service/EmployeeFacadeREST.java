/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestServices.service;

import Entities.Employee;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author fareskissoum
 */
@Stateless
@Path("/employee")
public class EmployeeFacadeREST extends AbstractFacade<Employee> {

    @PersistenceContext(unitName = "m1se_appv2_war_1.0PU")
    private EntityManager em;

    public EmployeeFacadeREST() {
        super(Employee.class);
    }

    /**
     * POST
     * Add new Employee
     *
     * @param emp
     */
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Employee emp) {
        super.create(emp);
    }

    /**
     * PUT
     * Mofidy Employee
     *
     * @param id
     * @param emp
     */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Employee emp) {
        Employee modifiedEmployee = em.find(Employee.class,id);
        if(emp.getNom()!=null){
            modifiedEmployee.setNom(emp.getNom());
        }
        if(emp.getPrenom()!=null){
            modifiedEmployee.setPrenom(emp.getPrenom());
        }
        if(emp.getTelDomicile()!=null){
            modifiedEmployee.setTelDomicile(emp.getTelDomicile());
        }
        if(emp.getTelPortable()!=null){
            modifiedEmployee.setTelPortable(emp.getTelPortable());
        }
        if(emp.getTelPro()!=null){
            modifiedEmployee.setTelPro(emp.getTelPro());
        }
        if(emp.getAdresse()!=null){
            modifiedEmployee.setAdresse(emp.getAdresse());
        }
        if(emp.getCodePostal()!=null){
            modifiedEmployee.setCodePostal(emp.getCodePostal());
        }
        if(emp.getVille()!=null){
            modifiedEmployee.setVille(emp.getVille());
        }
        if(emp.getEmail()!=null){
            modifiedEmployee.setEmail(emp.getEmail());
        }
        em.merge(modifiedEmployee);

    }

    /**
     * DELETE
     * Delete one Employee
     *
     * @param id
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    /**
     * GET
     * get one employee
     *
     * @return Employee
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Employee find(@PathParam("id") Integer id) {
        return em.find(Employee.class,id);
    }

    /**
     * GET
     * get all employee
     *
     * @return List<Employee>
     */
    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Employee> findAll() {
        return super.findAll();
    }

    /**
     * GET
     * get range of employees
     *
     * @return List<Employee>
     */
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Employee> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    /**
     * GET
     * get number of employees
     *
     * @return String
     */
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    /**
     * getter of entity manager
     *
     * @return EntityManager
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
