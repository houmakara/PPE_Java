/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppe3_restauration;

/**
 *
 * @author Makara
 */
public class Users {
    private int id;
    private String username;
    private String password;
    private int idPersonnel;

    public Users(int id, int idPersonnel, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.idPersonnel = idPersonnel;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getIdPersonnel() {
        return idPersonnel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIdPersonnel(int idPersonnel) {
        this.idPersonnel = idPersonnel;
    }
    
    
}
