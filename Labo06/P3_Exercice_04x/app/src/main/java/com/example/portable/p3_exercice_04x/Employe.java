package com.example.portable.p3_exercice_04x;


import java.io.Serializable;


public class Employe implements Serializable{
    private String matricule;
    private String nom;
    private String prenom;
    private String sexe;
    private String etatCivil;
    private String langue;
    private String salaire;

    @Override
    public String toString() {
        return  matricule + ';' + nom + ';'+ prenom + ';'+ sexe +';' + etatCivil + ';' + langue + ';' + salaire;
    }

    public Employe(String matricule, String nom, String prenom, String sexe, String etatCivil, String langue, String salaire) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.etatCivil = etatCivil;
        this.langue = langue;
        this.salaire = salaire;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setEtatCivil(String etatCivil) {
        this.etatCivil = etatCivil;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public void setSalaire(String salaire) {
        this.salaire = salaire;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public String getEtatCivil() {
        return etatCivil;
    }

    public String getLangue() {
        return langue;
    }

    public String getSalaire() {
        return salaire;
    }
}
