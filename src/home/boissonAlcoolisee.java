package home;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.*;
import java.util.HashMap;
import java.nio.*;

public class boissonAlcoolisee extends Boisson implements Serializable {

    private double degreAlcool;
    private float quantite;


    public boissonAlcoolisee(String nom, double prix,float quantite ,double degreAlcool) {
        super(nom,prix);
        this.degreAlcool = degreAlcool;
        this.quantite = quantite;
    }

    // Getter

    public float getQuantite() {
        return quantite;
    }


    public double getDegreAlcool() {
        return degreAlcool;

    }

    public String toString() {
        return  this.getNom().toUpperCase() +
                " ⇒ Contenance : " + this.getContenance() + " ml " + "[DEGRÉ D'ALCOOL : " + getDegreAlcool() + "°] à " + this.getPrix() +
                "€ ";
    }


}
