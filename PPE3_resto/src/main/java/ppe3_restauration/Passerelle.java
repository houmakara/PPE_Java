/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppe3_restauration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 *
 * @author sio2019
 */
public class Passerelle {

    //[CONNEXION]
    public static Users userConnecte;
    public static Personnel personnelConnecte;

    public static Personnel getPersonnel() {
        return personnelConnecte;
    }

    public static Users getUser() {
        return userConnecte;
    }

    /*Connexion pour PostGreSQL
    public static Connection connection() {
        Connection conn = null;
        try {
            //POSTGRES : jdbc:postgresql://192.168.1.245:5432/database_name
            String url = "jdbc:postgresql://192.168.1.245:5432/PPE2021_restauration_hou";
            String user = "guendouzi", password = "guendouzi";
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion effective !");
        } catch (SQLException ex) {
            Logger.getLogger(Passerelle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }*/
 /*Connexion pour PhpMyAdmin en Local */
    public static Connection connection() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/ppe2021_restauration_hou?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
            String user = "root", password = "";
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion effective !");

        } catch (SQLException ex) {
            Logger.getLogger(Passerelle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    //[AUTHENTIFICATION]
    public static boolean authentificationPersonnel(String username, String password) {
        Statement state = null;
        Connection conn = connection();
        boolean test = false;

        try {
            state = conn.createStatement();
            ResultSet jeuResultat;
            jeuResultat = state.executeQuery("SELECT * FROM users WHERE username='" + username + "'");
            while (jeuResultat.next()) {
                int id = jeuResultat.getInt("id");
                int idPersonnel = jeuResultat.getInt("idPersonnel");
                String theUsername = jeuResultat.getString("username");
                String thePassword = jeuResultat.getString("password");

                Users unUtilisateur = new Users(id, idPersonnel, theUsername, thePassword);
                Passerelle.userConnecte = unUtilisateur;
                if (checkPass(password, Passerelle.userConnecte.getPassword()) == true) {
                    test = true;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erreur");
            Logger.getLogger(Passerelle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return test;
    }

    public static boolean checkPass(String password, String hashedPassword) {
        boolean ok = false;
        if (BCrypt.checkpw(password, hashedPassword)) {
            ok = true;
        }
        return ok;
    }

    //[PATIENTS]
    public static ArrayList tousLesPatients() {
        Statement state = null;
        Connection conn = connection();
        Patient unPatient = null;
        ArrayList<Patient> lesPatients = new ArrayList<Patient>();
        try {
            state = conn.createStatement();
            ResultSet jeuResultat;
            jeuResultat = state.executeQuery("SELECT * FROM patient ORDER BY id, idservice, nom");
            while (jeuResultat.next()) {
                int id = jeuResultat.getInt("id");
                int numchambre = jeuResultat.getInt("numchambre");
                String nom = jeuResultat.getString("nom");
                String prenom = jeuResultat.getString("prenom");
                int idservice = jeuResultat.getInt("idservice");
                unPatient = new Patient(id, numchambre, nom, prenom, idservice);
                lesPatients.add(unPatient);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Passerelle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesPatients;
    } //Insert Patient

    public static int lastId() {
        int id = -1;
        Statement state = null;
        Connection conn = connection();
        Commande uneCommande = null;
        try {
            state = conn.createStatement();
            ResultSet jeuResultat;
            jeuResultat = state.executeQuery("SELECT max(id) as lastId FROM patient");
            while (jeuResultat.next()) {
                id = jeuResultat.getInt("lastId");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Passerelle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public static boolean creerPatient(Patient unPatient) {
        Statement state = null;
        String prenom = unPatient.getPrenom().toLowerCase();
        String prenomMaj = prenom.replaceFirst(".", (prenom.charAt(0) + "").toUpperCase());
        String nom = unPatient.getNom().toUpperCase();
        int id = lastId()+1;
        String requete = ("INSERT INTO patient VALUES (" + id + ", '" + nom + "', '" + prenomMaj + "'," + unPatient.getNumchambre() + "," + unPatient.getIdservice() + ")");
        Connection conn = connection();
        boolean test = false;
        try {
            state = conn.createStatement();
            int nb = state.executeUpdate(requete);
            test = true;
        } catch (SQLException ex) {
            Logger.getLogger(Passerelle.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur insertion pour id=" + unPatient.getId() + "\n****************" + ex.getMessage());
        }
        return test;
    }

    public static boolean modifierPatient(Patient unPatient) {
        Statement state = null;
        String prenom = unPatient.getPrenom().toLowerCase();
        String prenomMaj = prenom.replaceFirst(".", (prenom.charAt(0) + "").toUpperCase());
        String nom = unPatient.getNom().toUpperCase();
        String requete = ("UPDATE patient SET nom = '" + nom + "', prenom = '"
                + prenomMaj + "', numchambre = " + unPatient.getNumchambre() + ", idservice = " + unPatient.getIdservice() + " WHERE id = " + unPatient.getId());
        Connection conn = connection();
        boolean test = false;
        try {
            state = conn.createStatement();
            int nb = state.executeUpdate(requete);
            test = true;
        } catch (SQLException ex) {
            Logger.getLogger(Passerelle.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur insertion pour id = " + unPatient.getId() + "\n****************" + ex.getMessage());
        }
        return test;
    }
    
    public static boolean supprimerPatient(int id) {
        Statement state = null;
        String requete = ("DELETE FROM patient WHERE id = " + id);
        Connection conn = connection();
        boolean test = false;
        try {
            state = conn.createStatement();
            int nb = state.executeUpdate(requete);
            test = true;
        } catch (SQLException ex) {
            Logger.getLogger(Passerelle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return test;
    }
    
    public static Patient unPatient(int pId) {
        Statement state = null;
        Connection conn = connection();
        Patient unPatient = null;

        try {
            state = conn.createStatement();
            ResultSet jeuResultat;
            jeuResultat = state.executeQuery("SELECT * FROM patient WHERE id = " + pId);
            while (jeuResultat.next()) {
                int id = jeuResultat.getInt("id");
                int numchambre = jeuResultat.getInt("numchambre");
                String nom = jeuResultat.getString("nom");
                String prenom = jeuResultat.getString("prenom");
                int idservice = jeuResultat.getInt("idservice");
                unPatient = new Patient(id, numchambre, nom, prenom, idservice);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Passerelle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unPatient;
    }
    
    //[PERSONNELS]
    public static ArrayList tousLePersonnels() {
        Statement state = null;
        Connection conn = connection();
        Personnel unPersonnel = null;
        ArrayList<Personnel> lesPersonnels = new ArrayList<Personnel>();
        try {
            state = conn.createStatement();
            ResultSet jeuResultat;
            jeuResultat = state.executeQuery("SELECT * FROM personnel ORDER BY idservice, nom");
            while (jeuResultat.next()) {
                int id = jeuResultat.getInt("id");
                int idService = jeuResultat.getInt("idservice");
                String nom = jeuResultat.getString("nom");
                String prenom = jeuResultat.getString("prenom");
                unPersonnel = new Personnel(id, idService, nom, prenom);
                lesPersonnels.add(unPersonnel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Passerelle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesPersonnels;
    }

    public static Personnel donnerUnPersonnel(int id) {
        Statement state = null;
        Connection conn = connection();
        Personnel unPersonnel = null;
        try {
            state = conn.createStatement();
            ResultSet jeuResultat;
            jeuResultat = state.executeQuery("SELECT * FROM personnel WHERE id = " + id);
            while (jeuResultat.next()) {
                int newId = jeuResultat.getInt("id");
                int idService = jeuResultat.getInt("idservice");
                String nom = jeuResultat.getString("nom");
                String prenom = jeuResultat.getString("prenom");
                unPersonnel = new Personnel(newId, idService, nom, prenom);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Passerelle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unPersonnel;
    }

    public static String donnerNomPersonnel(int id) {
        Statement state = null;
        Connection conn = connection();
        String prenom = null;
        try {
            state = conn.createStatement();
            ResultSet jeuResultat;
            jeuResultat = state.executeQuery("SELECT prenom FROM personnel WHERE id = " + id);
            while (jeuResultat.next()) {
                prenom = jeuResultat.getString("prenom");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Passerelle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prenom;
    }

    //[REPAS]
    public static ArrayList tousLesRepas() {
        Statement state = null;
        Connection conn = connection();
        Repas unRepas = null;
        ArrayList<Repas> lesRepas = new ArrayList<Repas>();
        try {
            state = conn.createStatement();
            ResultSet jeuResultat;
            jeuResultat = state.executeQuery("SELECT * FROM repas ORDER BY id");
            while (jeuResultat.next()) {
                int id = jeuResultat.getInt("id");
                String libelle = jeuResultat.getString("libelle");
                unRepas = new Repas(id, libelle);
                lesRepas.add(unRepas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Passerelle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesRepas;
    }

    public static Repas unRepas(int pId) {
        Statement state = null;
        Connection conn = connection();
        Repas unRepas = null;
        try {
            state = conn.createStatement();
            ResultSet jeuResultat;
            jeuResultat = state.executeQuery("SELECT * FROM repas WHERE id = " + pId);
            while (jeuResultat.next()) {
                int id = jeuResultat.getInt("id");
                String libelle = jeuResultat.getString("libelle");
                unRepas = new Repas(id, libelle);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Passerelle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unRepas;
    }

    public static boolean limiteRepas(int id) {
        //Affiche si le patient a atteint sa limite de repas
        boolean ok = false;
        int nbRepas = 0;
        LocalDate date = LocalDate.now();

        Statement state = null;
        Connection conn = connection();
        try {
            state = conn.createStatement();
            ResultSet jeuResultat;
            //count(idpatient) commence à 0
            String requete = "SELECT count(idpatient)+1 as nb FROM Commande WHERE idpatient = " + id + " AND date = '" + date + "' GROUP BY idpatient";
            jeuResultat = state.executeQuery(requete);
            while (jeuResultat.next()) {
                int nbRepasClient = jeuResultat.getInt("nb");
                nbRepas = nbRepasClient;
            }
            if (nbRepas <= 3) {
                ok = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Passerelle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }

    //[SERVICES]
    public static ArrayList tousLesServices() {
        Statement state = null;
        Connection conn = connection();
        Service unService = null;
        ArrayList<Service> lesServices = new ArrayList<Service>();
        try {
            state = conn.createStatement();
            ResultSet jeuResultat;
            jeuResultat = state.executeQuery("SELECT * FROM service ORDER BY id");
            while (jeuResultat.next()) {
                int id = jeuResultat.getInt("id");
                String libelle = jeuResultat.getString("libelle");
                unService = new Service(id, libelle);
                lesServices.add(unService);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Passerelle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesServices;
    }

    public static Service donnerNomService(int pId) {
        Statement state = null;
        Connection conn = connection();
        Service unService = null;
        try {
            state = conn.createStatement();
            ResultSet jeuResultat;
            jeuResultat = state.executeQuery("SELECT * FROM service WHERE id = " + pId);
            while (jeuResultat.next()) {
                int id = jeuResultat.getInt("id");
                String libelle = jeuResultat.getString("libelle");
                unService = new Service(id, libelle);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Passerelle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unService;
    }

    public static ArrayList tousLesNomsServices() {
        Statement state = null;
        Connection conn = connection();
        Service unService = null;
        ArrayList<String> lesServices = new ArrayList<String>();
        try {
            state = conn.createStatement();
            ResultSet jeuResultat;
            jeuResultat = state.executeQuery("SELECT libelle FROM service");
            while (jeuResultat.next()) {
                String libelle = jeuResultat.getString("libelle");
                lesServices.add(libelle);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Passerelle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesServices;
    }

    //[COMMANDES]
    public static boolean commander(Patient unPatient, Repas unRepas) {
        boolean test = false;
        Statement state = null;
        Connection conn = connection();
        LocalDate date = LocalDate.now();

        try {
            state = conn.createStatement();
            String requete = "INSERT INTO commande(idpatient, idrepas, date) VALUES (" + unPatient.getId() + " , " + unRepas.getId() + " , '" + date + "')";
            int nb = state.executeUpdate(requete);
            test = true;
        } catch (SQLException ex) {
            Logger.getLogger(Passerelle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return test;
    }

    public static ArrayList lesCommandes() {
        LocalDate date = LocalDate.now();
        Statement state = null;
        Connection conn = connection();
        Commande uneCommande = null;
        ArrayList<Commande> lesCommandes = new ArrayList<Commande>();
        try {
            state = conn.createStatement();
            ResultSet jeuResultat;
            jeuResultat = state.executeQuery("SELECT * FROM commande WHERE date = \'" + date + "\'");
            while (jeuResultat.next()) {
                int id = jeuResultat.getInt("id");
                int idpatient = jeuResultat.getInt("idpatient");
                int idrepas = jeuResultat.getInt("idrepas");
                date = LocalDate.parse(jeuResultat.getString("date"));
                uneCommande = new Commande(id, idpatient, idrepas, date);
                lesCommandes.add(uneCommande);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Passerelle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesCommandes;
    }

    public static boolean supprimerCommande(Commande uneCommande) {
        Statement state = null;
        Connection conn = connection();
        boolean test = false;
        try {
            state = conn.createStatement();
            int nb = state.executeUpdate("DELETE FROM commande WHERE idpatient=" + uneCommande.getIdpatient() + " AND idrepas=" + uneCommande.getIdrepas() + " AND id=" + uneCommande.getId());
            test = true;
        } catch (SQLException ex) {
            Logger.getLogger(Passerelle.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur" + ex.getMessage());
        }
        return test;
    }

    //[ADMINISTRATEURS UTILISATEURS] CREATE UPDATE DELETE PERSONNEL
    public static boolean createUser(String username, String password, int idPersonnel) {
        Statement state = null;
        Connection conn = connection();
        String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));
        boolean test = false;
        try {
            state = conn.createStatement();
            int nb = state.executeUpdate("INSERT INTO users(username, password, idPersonnel) VALUES('" + username + "', '" + hashPassword + "', " + idPersonnel + ")");
            test = true;
        } catch (SQLException ex) {
            Logger.getLogger(Passerelle.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur" + ex.getMessage());
        }
        return test;
    }

    public static int donnerIdPersonnel(String username) {
        Statement state = null;
        Connection conn = connection();
        int id = -1;
        try {
            state = conn.createStatement();
            ResultSet jeuResultat;
            jeuResultat = state.executeQuery("SELECT idPersonnel FROM users WHERE username='" + username + "'");
            while (jeuResultat.next()) {
                id = jeuResultat.getInt("idPersonnel");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Passerelle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    //[ADMINISTRATEUR PATIENTS] CREATE UPDATE DELETE PATIENT
}
