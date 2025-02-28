package entities.armees;

import entities.Militaire;
import entities.references.Grade;
import entities.references.grades.Grade_MN;
import entities.references.specialites.SpecialiteAAE;
import entities.references.specialites.SpecialiteMN;

public class Marin extends Militaire {

    private Grade_MN grade;
    private SpecialiteMN specialite;


    public Marin(String nom, String prenom, Grade_MN grade, SpecialiteMN specialite) {
        super(nom, prenom);
        setGrade(grade);
        setSpecialite(specialite);

    }

    public Grade_MN getGrade() {
        return grade;
    }

    public void setGrade(Grade_MN grade) {
        this.grade = grade;
    }

    public SpecialiteMN getSpecialite() {
        return specialite;
    }

    public void setSpecialite(SpecialiteMN specialite) {
        this.specialite = specialite;
    }

    @Override
    public void sePresenter() {
        System.out.println("Marin : " + getGrade().getSymbol() + " " + getNom() + " " + getPrenom() + " \n Spécialité : " + getSpecialite());
    }
}
