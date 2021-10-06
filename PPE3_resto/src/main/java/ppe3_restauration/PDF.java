/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppe3_restauration;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sio2020
 */
public class PDF {

    public static String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    public static final String SRC = "document.pdf";
    public static String DEST = date + "_Demandes_Particulieres.pdf";

    public static void fichierPdf() throws IOException {
        File file = new File(System.getProperty("user.home") + "/Downloads/", DEST);
        String newDEST = "" + file;
        file.getParentFile().mkdirs();
        PDF.createPdf(newDEST);
    }

    public static void createPdf(String dest) throws IOException {
        //Date et heure
        SimpleDateFormat s = new SimpleDateFormat("HH:mm");
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        Date heure = new Date();

        //Liste des commandes
        ArrayList<Commande> lesCommandes = new ArrayList<Commande>();
        lesCommandes = Passerelle.lesCommandes();

        //Liste des patients
        ArrayList<Patient> lesPatients = new ArrayList<Patient>();
        lesPatients = Passerelle.tousLesPatients();

        //Initialisation des documents
        try (PdfDocument document = new PdfDocument(new PdfReader(new FileInputStream(SRC)), new PdfWriter(new FileOutputStream(dest)))) {
            PdfPage page = document.getPage(1);
            PdfCanvas canvas = new PdfCanvas(page);

            //Taille position pdf
            int top = 550;

            //Font et Size
            PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
            canvas.setFontAndSize(font, 12);

            //Début du pdf
            canvas.beginText();

            //Date
            canvas.setTextMatrix(462, 761);
            canvas.showText("" + formatter.format(date));

            //Heure
            canvas.setTextMatrix(480, 739);
            canvas.showText("" + s.format(heure));

            //Affichage des repas
            for (Commande uneCommande : lesCommandes) {
                //Identifiant
                //canvas.setTextMatrix(305, 761);
                //canvas.showText("[NOM]");

                //Identifiant de la commande
                canvas.setTextMatrix(60, top);
                canvas.showText("" + uneCommande.getId());

                //N° Chambre du Patient
                int laChambre = 0;
                for (Patient unPatient : lesPatients) {
                    if (unPatient.getId() == uneCommande.getIdpatient()) {
                        laChambre = unPatient.getNumchambre();
                    }
                }
                canvas.setTextMatrix(150, top);
                canvas.showText("" + laChambre);

                //Nom et Prenom du patient
                String leNom = "", lePrenom = "", lePrenomMaj = "";
                for (Patient unPatient : lesPatients) {
                    if (unPatient.getId() == uneCommande.getIdpatient()) {
                        leNom = unPatient.getNom().toUpperCase();
                        lePrenom = unPatient.getPrenom();
                        lePrenomMaj = lePrenom.replaceFirst(".", (lePrenom.charAt(0) + "").toUpperCase());
                    }
                }
                canvas.setTextMatrix(238, top);
                canvas.showText("" + leNom + " " + lePrenomMaj);

                //Nom du repas
                int id_repas = uneCommande.getIdrepas();
                canvas.setTextMatrix(400, top);
                canvas.showText("" + Passerelle.unRepas(id_repas).getLibelle());

                top -= 20;
            }

            //Fin des documents et du pdf
            canvas.endText();
            document.close();
        }
    }
}
