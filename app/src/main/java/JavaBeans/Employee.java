/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;

import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.Size;

/**
 *
 * @author fareskissoum
 */
@Entity
@Table(name = "EMPLOYE")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    @Size(max = 255)
    @Column(name = "NOM")
    public String nom;
    @Size(max = 255)
    @Column(name = "PRENOM")
    public String prenom;
    @Size(max = 255)
    @Column(name = "TELDOMICILE")
    public String telDomicile;
    @Size(max = 255)
    @Column(name = "TELPORTABLE")
    public String telPortable;
    @Size(max = 255)
    @Column(name = "TELPRO")
    public String telPro;
    @Size(max = 255)
    @Column(name = "ADRESSE")
    public String adresse;
    @Size(max = 255)
    @Column(name = "CODEPOSTAL")
    public String codePostal;
    @Size(max = 255)
    @Column(name = "VILLE")
    public String ville;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "EMAIL")
    public String email;


    public Employee() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void setTelDomicile(String telDomicile) {
        this.telDomicile = telDomicile;
    }

    public String getTelPortable() {
        return telPortable;
    }

    public void setTelPortable(String telPortable) {
        this.telPortable = telPortable;
    }

    public String getTelPro() {
        return telPro;
    }

    public void setTelPro(String telPro) {
        this.telPro = telPro;
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

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
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
        return "JavaBeans.Employee[ id=" + id + " ]";
    }
}
