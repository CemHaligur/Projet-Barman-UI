package home;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.*;
import java.util.HashMap;
import java.nio.*;

public class boissonNonAlcoolisee extends Boisson implements Serializable {

    private double degreSucre;
    private float quantite;

    public boissonNonAlcoolisee(String nom, double prix, double degreSucre, float quantite) {
        super(nom,prix);
        this.degreSucre = degreSucre;
        this.quantite = quantite;
    }

    // Getter
    public float getQuantite() {
        return quantite;
    }

    public double getDegreSucre() {
        return degreSucre;
    }

    // Autres Methodes

    public String toString() {
        return   this.getNom().toUpperCase() +
                " ⇒ Contenance : " + this.getContenance() + " ml " + "[DEGRÉ DE SUCRE : " + getDegreSucre() + "°] à " + this.getPrix() +
                "€ ";
    }


}

