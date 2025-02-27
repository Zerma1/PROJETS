package lanceurs;

import commons.utils.AffichageConsole;
import commons.utils.LectureConsole;
import entities.Militaire;
import entities.Stage;
import entities.references.Grade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProgMain {

    private static Stage PO85 = new Stage(
            "PO85",
            LocalDate.of(2024,12,2),
            LocalDate.of(2025,07,25));

    public static void main(String[] args) {

        init();
        int choix;
        do{
            afficherNbJourAvantFinStage(PO85);

            AffichageConsole.afficherMenu("MENU PRINCIPAL");

            choix = LectureConsole.lectureChoixInt(0,3);

            gestionMenu(choix);

        }while(choix != 0);
    }

    public static void gestionMenu(int choix){
        switch (choix){
            case 1 -> afficherLaSection();
            case 2 -> ajouterMembreSection();
            case 3 -> retirerMembreSection();
        }
    }

    private static void afficherLaSection(){

        int nbMilitaire = 1;
        for (Militaire militaire : PO85.getSection()) {
            System.out.println(nbMilitaire++ + " : " + militaire.getGrade().getSymbol() + " " + militaire.getNom() + " " + militaire.getPrenom());
        }
    }

    private static void ajouterMembreSection(){
        //Créer un militaire
        Militaire nouveauMilitaire = saisirMilitaire();

        //Ajouter le militaire
        PO85.ajouterMilitaire(nouveauMilitaire);

    }

    private static Militaire saisirMilitaire(){

        String nom = LectureConsole.lectureChaineCaracteres("Saisir le nom : ");
        String prenom = LectureConsole.lectureChaineCaracteres("Saisir le prénom : ");

        Grade grade = saisirGrade();

        return new Militaire(nom, prenom, grade);
    }

    private static Grade saisirGrade(){

        for(int i = 0; i<Grade.values().length; i++){
            System.out.println(i+1 + " "  + Grade.values()[i]);
        }

        int choix = LectureConsole.lectureChoixInt(1,Grade.values().length);

        return Grade.values()[choix-1];
    }

    private static void retirerMembreSection(){
        afficherLaSection();
        int choix = LectureConsole.lectureChoixInt(1, PO85.getSection().size());

        Militaire militaire = PO85.getSection().get(choix-1);

        PO85.supprimerMiltaire(militaire);
    }

    public static void afficherNbJourAvantFinStage(Stage stage){

        long nbTotalJour = nbJourEntreDeuxDate(stage.getDateDebut(), stage.getDateFin());
        long nbJourAvantFin = nbJourEntreDeuxDate(LocalDate.now(), stage.getDateFin());

        System.out.println("Nombre de jour avant la fin du stage " + nbJourAvantFin + "/" + nbTotalJour);
    }

    private static long nbJourEntreDeuxDate(LocalDate dateDebut, LocalDate dateFin){

        return ChronoUnit.DAYS.between(dateDebut, dateFin);
    }









    private static void init(){
        //Création de la section
        PO85.ajouterMilitaire(new Militaire("ZERMANI", "Baptiste",Grade.QUARTIER_MAITRE));
        PO85.ajouterMilitaire(new Militaire("LE GLUDIC", "Quentin",Grade.MAITRE));
        PO85.ajouterMilitaire(new Militaire("FONTAINE", "Baptiste", Grade.SERGENT));
        PO85.ajouterMilitaire(new Militaire("FAURE", "Bryce", Grade.SERGENT));
        PO85.ajouterMilitaire(new Militaire("BOUTANT", "Matthieu", Grade.SERGENT));
        PO85.ajouterMilitaire(new Militaire("LEMARTINEL", "Thomas", Grade.SERGENT));
        PO85.ajouterMilitaire(new Militaire("EUZEN", "Ashley", Grade.SERGENT));
        PO85.ajouterMilitaire(new Militaire("VILLENEUVE", "Harry", Grade.SERGENT));
        PO85.ajouterMilitaire(new Militaire("JOLY", "Simon", Grade.SERGENT));
        PO85.ajouterMilitaire(new Militaire("KILCHEM", "Thomas", Grade.SERGENT));
        PO85.ajouterMilitaire(new Militaire("MICHELENA", "Patxi", Grade.SERGENT));
        PO85.ajouterMilitaire(new Militaire("LENOBLE", "Cyril", Grade.SERGENT));
        PO85.ajouterMilitaire(new Militaire("OLSEN", "Yves", Grade.SERGENT));
        PO85.ajouterMilitaire(new Militaire("ROKOTOBE", "Tsriniaina", Grade.SERGENT));
    }




}
