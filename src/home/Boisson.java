package home;

import java.io.Serializable;
import java.util.Objects;

public class Boisson extends BoissonMere implements Serializable {

    private double prix;
    private double alcool;
    private double sucre;

    public Boisson(String nom, double prix){
        super(nom);
        this.prix = prix;
    }



    // Getter Setter

    public double getSucre() {
        return sucre;
    }

    public double getAlcool() {
        return alcool;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setAlcool(double alcool) {
        this.alcool = alcool;
    }

    public void setSucre(double sucre) {
        this.sucre = sucre;
    }

    // Autre Methode

    public String toString() {
        return  this.getNom().toUpperCase() +
                " ⇒ Contenance : " + this.getContenance() + " ml à " + this.getPrix() +
                "€ ";
    }

}
