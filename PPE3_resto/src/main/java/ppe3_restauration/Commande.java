/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppe3_restauration;

import java.time.LocalDate;

/**
 *
 * @author sio2019
 */
public class Commande {
    private int id;
    private int idpatient;
    private int idrepas;
    private LocalDate date;

    public int getId() {
        return id;
    }

    public int getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(int idpatient) {
        this.idpatient = idpatient;
    }

    public int getIdrepas() {
        return idrepas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdrepas(int idrepas) {
        this.idrepas = idrepas;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Commande(int id, int idpatient, int idrepas, LocalDate date) {
        this.id = id;
        this.idpatient = idpatient;
        this.idrepas = idrepas;
        this.date = date;
    }

    public String toString() {
        return idpatient + "        -        " + idrepas + "        -        " + date;
    }
}
