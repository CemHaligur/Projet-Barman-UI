package home;

import java.io.Serializable;

abstract class BoissonMere implements Serializable {

    private String nom;
    protected double contenance;

    //Constructeur

    protected BoissonMere(String nom){
        this.nom = nom;
        this.contenance = contenance;
    }

    //Getters

    public String getNom(){
        return this.nom;
    }

    public double getContenance(){
        return this.contenance;
    }


    //Autres Methodes

}