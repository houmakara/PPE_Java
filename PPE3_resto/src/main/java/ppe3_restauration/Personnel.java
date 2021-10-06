/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppe3_restauration;

/**
 *
 * @author sio2019
 */
public class Personnel {
    private int id;
    private int idservice;
    private String nom;
    private String prenom;

    public Personnel(int id, int idservice, String nom, String prenom) {
        this.id = id;
        this.idservice = idservice;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public int getIdservice() {
        return idservice;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdservice(int idservice) {
        this.idservice = idservice;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
