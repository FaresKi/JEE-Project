/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.annotation.Resource;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author fareskissoum
 * @version 3.0.0
 */
@Resource(name = "DBJEE")
@Entity
@Table(name = "UTILISATEUR")
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "Utilisateur.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "Utilisateur.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "Utilisateur.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "Utilisateur.findByAdmin", query = "SELECT u FROM User u WHERE u.admin = :admin"),
    })
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Represent User ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    /**
     * Represent User username
     */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "USERNAME")
    private String username;
    /**
     * Represent User password
     */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PASSWORD")
    private String password;
    /**
     * Represent User right
     */
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADMIN")
    private boolean admin;

    /**
     * This is an empty constructor
     */
    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    /**
     * This is our constructor
     * @param username
     * @param password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * This is an getter for ID
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * This is an setter for id
     * @param username
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This is an getter for username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * This is an setter for username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This is an getter for password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This is an setter for password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This is an getter for right
     * @return admin
     */
    public boolean getAdmin() {
        return admin;
    }

    /**
     * This is an setter for right
     * @param void
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    /**
     * This is an override oh the hashcode method
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * This is an override of equals method
     * @return boolean
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * This is an override of to string method
     * @return string
     */
    @Override
    public String toString() {
        return "Entities.Utilisateur[ id=" + id + " ]";
    }

}
