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
public class Patient {

    private int id;
    private String nom;
    private String prenom;
    private int numchambre;
    private int idservice;

    public Patient(int pId, int pNumChambre, String pNom, String pPrenom, int pIdService) {
        id = pId;
        numchambre = pNumChambre;
        nom = pNom;
        prenom = pPrenom;
        idservice = pIdService;
    }

    public int getId() {
        return id;
    }

    public int getNumchambre() {
        return numchambre;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getIdservice() {
        return idservice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumchambre(int numchambre) {
        this.numchambre = numchambre;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setIdservice(int idservice) {
        this.idservice = idservice;
    }

    public String toString() {
        //Première lettre du prénom en Maj
        prenom = prenom.replaceFirst(".", (prenom.charAt(0) + "").toUpperCase());
        return  idservice + " - " + nom.toUpperCase() + " " + prenom ;
    }
}
