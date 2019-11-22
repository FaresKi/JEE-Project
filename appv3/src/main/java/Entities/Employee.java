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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "NOM")
    private String nom;
    @Size(max = 255)
    @Column(name = "PRENOM")
    private String prenom;
    @Size(max = 255)
    @Column(name = "TELDOMICILE")
    private String telDomicile;
    @Size(max = 255)
    @Column(name = "TELPORTABLE")
    private String telPortable;
    @Size(max = 255)
    @Column(name = "TELPRO")
    private String telPro;
    @Size(max = 255)
    @Column(name = "ADRESSE")
    private String adresse;
    @Size(max = 255)
    @Column(name = "CODEPOSTAL")
    private String codePostal;
    @Size(max = 255)
    @Column(name = "VILLE")
    private String ville;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "EMAIL")
    private String email;

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

    public Employee() {
    }

    public Employee(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelDomicile() {
        return telDomicile;
    }

    public void setTelDomicile(String teldomicile) {
        this.telDomicile = teldomicile;
    }

    public String getTelPortable() {
        return telPortable;
    }

    public void setTelPortable(String telportable) {
        this.telPortable = telportable;
    }

    public String getTelPro() {
        return telPro;
    }

    public void setTelPro(String telpro) {
        this.telPro = telpro;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codepostal) {
        this.codePostal = codepostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

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

    @Override
    public String toString() {
        return "Entities.Employe[ id=" + id + " ]";
    }
    
}
