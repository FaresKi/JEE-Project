/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestServices.service;

import Entities.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(String json) {
        ObjectMapper mapper = new ObjectMapper();
        Employee emp = null;
        try{
                emp = mapper.readValue(json,Employee.class);
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }
        super.create(emp);
    }

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

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Employee find(@PathParam("id") Integer id) {
        return em.find(Employee.class,id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Employee> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Employee> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
