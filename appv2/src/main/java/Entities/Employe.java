/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fareskissoum
 */
@Entity
@Table(name = "EMPLOYE")
@NamedQueries({
    @NamedQuery(name = "Employe.findAll", query = "SELECT e FROM Employe e"),
    @NamedQuery(name = "Employe.findById", query = "SELECT e FROM Employe e WHERE e.id = :id"),
    @NamedQuery(name = "Employe.findByNom", query = "SELECT e FROM Employe e WHERE e.nom = :nom"),
    @NamedQuery(name = "Employe.findByPrenom", query = "SELECT e FROM Employe e WHERE e.prenom = :prenom"),
    @NamedQuery(name = "Employe.findByTeldomicile", query = "SELECT e FROM Employe e WHERE e.teldomicile = :teldomicile"),
    @NamedQuery(name = "Employe.findByTelportable", query = "SELECT e FROM Employe e WHERE e.telportable = :telportable"),
    @NamedQuery(name = "Employe.findByTelpro", query = "SELECT e FROM Employe e WHERE e.telpro = :telpro"),
    @NamedQuery(name = "Employe.findByAdresse", query = "SELECT e FROM Employe e WHERE e.adresse = :adresse"),
    @NamedQuery(name = "Employe.findByCodepostal", query = "SELECT e FROM Employe e WHERE e.codepostal = :codepostal"),
    @NamedQuery(name = "Employe.findByVille", query = "SELECT e FROM Employe e WHERE e.ville = :ville"),
    @NamedQuery(name = "Employe.findByEmail", query = "SELECT e FROM Employe e WHERE e.email = :email")})
public class Employe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private String teldomicile;
    @Size(max = 255)
    @Column(name = "TELPORTABLE")
    private String telportable;
    @Size(max = 255)
    @Column(name = "TELPRO")
    private String telpro;
    @Size(max = 255)
    @Column(name = "ADRESSE")
    private String adresse;
    @Size(max = 255)
    @Column(name = "CODEPOSTAL")
    private String codepostal;
    @Size(max = 255)
    @Column(name = "VILLE")
    private String ville;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "EMAIL")
    private String email;

    public Employe() {
    }

    public Employe(Integer id) {
        this.id = id;
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

    public String getTeldomicile() {
        return teldomicile;
    }

    public void setTeldomicile(String teldomicile) {
        this.teldomicile = teldomicile;
    }

    public String getTelportable() {
        return telportable;
    }

    public void setTelportable(String telportable) {
        this.telportable = telportable;
    }

    public String getTelpro() {
        return telpro;
    }

    public void setTelpro(String telpro) {
        this.telpro = telpro;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(String codepostal) {
        this.codepostal = codepostal;
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
        if (!(object instanceof Employe)) {
            return false;
        }
        Employe other = (Employe) object;
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
