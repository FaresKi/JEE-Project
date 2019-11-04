/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import Entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fareskissoum
 */
@Stateless
public class UserSB {
    @PersistenceContext
    EntityManager em;
    public User getUser (String userName, String password){
        String queryGetUser = "SELECT u FROM User u WHERE u.username = :username AND u.password=:password";
        User fetchedUser = (User) em.createQuery(queryGetUser).setParameter("username",userName).setParameter("password",password).getSingleResult();
        if(fetchedUser!=null){
            System.out.println("user not null");
            return fetchedUser;
        }
        System.out.println("user null");
        return null;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
