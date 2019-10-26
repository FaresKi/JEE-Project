/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fareskissoum
 */
public class Employee implements Serializable {

    String nom;
    String prenom;
    String telDomicile;
    String telPortable;
    String telPro;
    String adresse;
    String codePostal;
    String ville;
    String email;

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

}
