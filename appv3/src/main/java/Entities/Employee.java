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
import javax.validation.constraints.Size;

/**
 *
 * @author fareskissoum
 * @version 3.0.0
 *
 */
@Resource(name = "DBJEE")
@Entity
@Table(name = "EMPLOYE")
@NamedQueries({
    @NamedQuery(name = "Employe.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employe.findById", query = "SELECT e FROM Employee e WHERE e.id = :id"),
    @NamedQuery(name = "Employe.findByNom", query = "SELECT e FROM Employee e WHERE e.nom = :nom"),
    @NamedQuery(name = "Employe.findByPrenom", query = "SELECT e FROM Employee e WHERE e.prenom = :prenom"),
    @NamedQuery(name = "Employe.findByTeldomicile", query = "SELECT e FROM Employee e WHERE e.telDomicile = :teldomicile"),
    @NamedQuery(name = "Employe.findByTelportable", query = "SELECT e FROM Employee e WHERE e.telPortable = :telportable"),
    @NamedQuery(name = "Employe.findByTelpro", query = "SELECT e FROM Employee e WHERE e.telPro = :telpro"),
    @NamedQuery(name = "Employe.findByAdresse", query = "SELECT e FROM Employee e WHERE e.adresse = :adresse"),
    @NamedQuery(name = "Employe.findByCodepostal", query = "SELECT e FROM Employee e WHERE e.codePostal = :codepostal"),
    @NamedQuery(name = "Employe.findByVille", query = "SELECT e FROM Employee e WHERE e.ville = :ville"),
    @NamedQuery(name = "Employe.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Represent employee ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    /**
     * Represent employee's name
     */
    @Size(max = 255)
    @Column(name = "NOM")
    private String nom;
    /**
     * Represent employee's surname
     */
    @Size(max = 255)
    @Column(name = "PRENOM")
    private String prenom;
    /**
     * Represent employee's house phone number
     */
    @Size(max = 255)
    @Column(name = "TELDOMICILE")
    private String telDomicile;
    /**
     * Represent employee's personal phone number
     */
    @Size(max = 255)
    @Column(name = "TELPORTABLE")
    private String telPortable;
    /**
     * Represent employee's professional phone number
     */
    @Size(max = 255)
    @Column(name = "TELPRO")
    private String telPro;
    /**
     * Represent employee's adress
     */
    @Size(max = 255)
    @Column(name = "ADRESSE")
    private String adresse;
    /**
     * Represent employee's zipcode
     */
    @Size(max = 255)
    @Column(name = "CODEPOSTAL")
    private String codePostal;
    /**
     * Represent employee's city
     */
    @Size(max = 255)
    @Column(name = "VILLE")
    private String ville;
    /**
     * Represent employee's email
     */
    @Size(max = 255)
    @Column(name = "EMAIL")
    private String email;

    /**
     * This is our constructor
     * @param nom
     * @param prenom
     * @param telDomicile
     * @param telPortable
     * @param telPro
     * @param adresse
     * @param codePostal
     * @param ville
     * @param email
     */
    public Employee(String nom, String prenom, String telDomicile, String telPortable, String telPro, String adresse, String codePostal, String ville, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.telDomicile = telDomicile;
        this.telPortable = telPortable;
        this.telPro = telPro;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.email = email;
    }

    /**
     * This is an empty constructor
     */
    public Employee() {
    }

    public Employee(int id) {
        this.id = id;
    }
    /**
     * This is an getter for ID
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * This is an setter for ID
     * @param  id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This is an getter for name
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * This is an setter for name
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * This is an getter for surname
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * This is an setter for surname
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * This is an getter for house phone number
     * @return telDomicile
     */
    public String getTelDomicile() {
        return telDomicile;
    }

    /**
     * This is an setter for house phone number
     * @param teldomicile
     */
    public void setTelDomicile(String teldomicile) {
        this.telDomicile = teldomicile;
    }

    /**
     * This is an getter for personal phone number
     * @return telPortable
     */
    public String getTelPortable() {
        return telPortable;
    }

    /**
     * This is an setter for personal phone number
     * @param telPortable
     */
    public void setTelPortable(String telPortable) {
        this.telPortable = telPortable;
    }

    /**
     * This is an getter for professional phone number
     * @return telPro
     */
    public String getTelPro() {
        return telPro;
    }

    /**
     * This is an setter for  profesional phone number
     * @param telPro
     */
    public void setTelPro(String telPro) {
        this.telPro = telPro;
    }

    /**
     * This is an getter for adress
     * @return adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * This is an setter for adress
     * @param adresse
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * This is an getter for zipcode
     * @return codePostal
     */
    public String getCodePostal() {
        return codePostal;
    }

    /**
     * This is an setter for zipcode
     * @param codepostal
     */
    public void setCodePostal(String codepostal) {
        this.codePostal = codepostal;
    }

    /**
     * This is an getter for city
     * @return ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * This is an setter for city
     * @param ville
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * This is an getter for email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * This is an setter for email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
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
        return "Entities.Employe[ id=" + id + " ]";
    }
}
