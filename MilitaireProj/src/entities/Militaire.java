package entities;

import entities.references.Grade;

import java.util.Objects;

public class Militaire extends Personne {

    public Grade Grade;

    public Militaire(String nom, String prenom, Grade grade) {
        super(nom,prenom);
        setGrade(grade);
    }

    public Grade getGrade() {
        return Grade;
    }

    public void setGrade(Grade grade) {
        Grade = grade;
    }

    @Override
    public String toString() {
        return "Militaire{" +
                "Nom='" + getNom() + '\'' +
                "Prenom='" + getPrenom() + '\'' +
                "Grade='" + getGrade().getCodeOTAN() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if(this==o) return true;

        if (!(o instanceof Militaire militaire)) return false;

        return this.hashCode() == militaire.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom(), getPrenom());
    }
}
