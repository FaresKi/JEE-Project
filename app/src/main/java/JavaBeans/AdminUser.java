/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author fareskissoum
 */

@Entity
@Table(name="UTILISATEUR")
public class AdminUser extends User {
    
    public AdminUser(String userName, String password) {
        super(userName, password);
    }


    public AdminUser() {

    }
}
