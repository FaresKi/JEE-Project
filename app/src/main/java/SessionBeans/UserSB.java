/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import JavaBeans.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fareskissoum
 */
@Stateless
public class UserSB {

    @PersistenceContext(name="PERSISTENCE")
    EntityManager em;
    
    public User getUser (String userName, String password){
        String queryGetID = "SELECT u.id from User u where u.id: ";
        return new User();
    }







    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}