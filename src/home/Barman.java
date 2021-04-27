package home;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.*;
import java.util.HashMap;
import java.nio.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Barman implements Serializable{

    private String NomBarman;
    private String Mdp;
    private static List<Commande> Commande= new ArrayList<Commande>();
    protected List<BoissonMere> BoissonMere= new ArrayList<BoissonMere>();
    protected List<Boisson> BOI = new ArrayList<Boisson>();
    protected List<Float> Cont = new ArrayList<Float>();
    protected List<Cocktail> Cockt = new ArrayList<Cocktail>();
    protected List<boissonAlcoolisee> BoissonAl= new ArrayList<boissonAlcoolisee>();
    protected List<boissonNonAlcoolisee> BoissonNonAl= new ArrayList<boissonNonAlcoolisee>();
    protected List<Float> Montant = new ArrayList<Float>();
    protected float total=0;


    public List<Commande> getCommande() {
        return Commande;
    }

    public List<BoissonMere> getBoissonMere() {
        return BoissonMere;
    }

    public List<boissonAlcoolisee> getBoissonAlcoolisee() {
        return BoissonAl;
    }

    public List<boissonAlcoolisee> getBoissonAlcooliseeDispo() {
        List<boissonAlcoolisee> Aldispo = new ArrayList<boissonAlcoolisee>();
        for(int i=0;i<getBoissonAlcoolisee().size();i++) {
            if(getBoissonAlcoolisee().get(i).getQuantite()>0) {
                Aldispo.add(getBoissonAlcoolisee().get(i));
            }
        }
        return Aldispo;
    }

    public List<boissonNonAlcoolisee> getBoissonNonAlcooliseeDispo() {
        List<boissonNonAlcoolisee> Aldispo = new ArrayList<boissonNonAlcoolisee>();
        for(int i=0;i<getBoissonNonAlcoolisee().size();i++) {
            if(getBoissonNonAlcoolisee().get(i).getQuantite()>0) {
                Aldispo.add(getBoissonNonAlcoolisee().get(i));
            }
        }
        return Aldispo;
    }


    public List<boissonNonAlcoolisee> getBoissonNonAlcoolisee() {
        return BoissonNonAl;
    }

    public boolean ajouterBoissonMere(BoissonMere boiM) {

        boolean bool = true;
        if (BoissonMere.contains(boiM.getNom())) {
            bool = false;
        }
        else {
            bool=BoissonMere.add(boiM);

        }
        return bool;
    }

    public void sauvegarderBoissonNonAlcoolisee(String nomFichier){

        List<boissonNonAlcoolisee> str = new ArrayList<boissonNonAlcoolisee>();
        str = getBoissonNonAlcoolisee();
        int BUFSIZE=256;
        try {
            FileOutputStream fileOut = new FileOutputStream(nomFichier);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(str);
            out.close();
            fileOut.close();


            String inputFile = nomFichier;
            FileInputStream in = new FileInputStream(inputFile);
            FileChannel ch = in.getChannel();
            ByteBuffer buf = ByteBuffer.allocateDirect(BUFSIZE);

            Charset cs = Charset.forName("ASCII");

            int rd;
            while ( (rd = ch.read( buf )) != -1 ) {
                buf.rewind();
                CharBuffer chbuf = cs.decode(buf);
                buf.clear();
            }


        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Float> getCont() {
        return Cont;
    }

    public void sauvegarderCont(String nomFichier){

        List<Float> str = new ArrayList<Float>();
        str = getCont();
        int BUFSIZE=256;
        try {
            FileOutputStream fileOut = new FileOutputStream(nomFichier);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(str);
            out.close();
            fileOut.close();


            String inputFile = nomFichier;
            FileInputStream in = new FileInputStream(inputFile);
            FileChannel ch = in.getChannel();
            ByteBuffer buf = ByteBuffer.allocateDirect(BUFSIZE);

            Charset cs = Charset.forName("ASCII");

            int rd;
            while ( (rd = ch.read( buf )) != -1 ) {
                buf.rewind();
                CharBuffer chbuf = cs.decode(buf);
                buf.clear();
            }


        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sauvegarderCocktail(String nomFichier){

        List<Cocktail> str = new ArrayList<Cocktail>();
        str = getCockt();
        int BUFSIZE=256;
        try {
            FileOutputStream fileOut = new FileOutputStream(nomFichier);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(str);
            out.close();
            fileOut.close();


            String inputFile = nomFichier;
            FileInputStream in = new FileInputStream(inputFile);
            FileChannel ch = in.getChannel();
            ByteBuffer buf = ByteBuffer.allocateDirect(BUFSIZE);

            Charset cs = Charset.forName("ASCII");

            int rd;
            while ( (rd = ch.read( buf )) != -1 ) {
                buf.rewind();
                CharBuffer chbuf = cs.decode(buf);
                buf.clear();
            }


        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Boisson> getBOI() {
        return BOI;
    }

    public List<Cocktail> getCockt() {
        return Cockt;
    }


    public boolean ajouterBoissonAlcoolisee(boissonAlcoolisee boiM) {

        boolean bool = true;
        if (BoissonAl.contains(boiM.getNom())) {
            bool = false;
        }
        else {
            bool=BoissonAl.add(boiM);

        }
        return bool;
    }

    public boolean ajouterBoisson(Boisson boiM) {

        boolean bool = true;
        if (BOI.contains(boiM.getNom())) {
            bool = false;
        }
        else {
            bool=BOI.add(boiM);

        }
        return bool;
    }

    public boolean ajouterBoissonNonAlcoolisee(boissonNonAlcoolisee boiM) {

        boolean bool = true;
        if (BoissonNonAl.contains(boiM.getNom())) {
            bool = false;
        }
        else {
            bool=BoissonNonAl.add(boiM);

        }
        return bool;
    }

    public void sauvegarderBoisson(String nomFichier){

        List<Boisson> str = new ArrayList<Boisson>();
        str = getBOI();
        int BUFSIZE=256;
        try {
            FileOutputStream fileOut = new FileOutputStream(nomFichier);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(str);
            out.close();
            fileOut.close();


            String inputFile = nomFichier;
            FileInputStream in = new FileInputStream(inputFile);
            FileChannel ch = in.getChannel();
            ByteBuffer buf = ByteBuffer.allocateDirect(BUFSIZE);

            Charset cs = Charset.forName("ASCII");

            int rd;
            while ( (rd = ch.read( buf )) != -1 ) {
                buf.rewind();
                CharBuffer chbuf = cs.decode(buf);
                buf.clear();
            }


        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sauvegarderBoissonAlcoolisee(String nomFichier){

        List<boissonAlcoolisee> str = new ArrayList<boissonAlcoolisee>();
        str = getBoissonAlcoolisee();
        int BUFSIZE=256;
        try {
            FileOutputStream fileOut = new FileOutputStream(nomFichier);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(str);
            out.close();
            fileOut.close();


            String inputFile = nomFichier;
            FileInputStream in = new FileInputStream(inputFile);
            FileChannel ch = in.getChannel();
            ByteBuffer buf = ByteBuffer.allocateDirect(BUFSIZE);

            Charset cs = Charset.forName("ASCII");

            int rd;
            while ( (rd = ch.read( buf )) != -1 ) {
                buf.rewind();
                CharBuffer chbuf = cs.decode(buf);
                buf.clear();
            }


        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void chargerBoissonAlcoolisee(String nomFichier) {


        ArrayList<boissonAlcoolisee> str = new ArrayList<boissonAlcoolisee>();
        try {
            FileInputStream fileIn = new FileInputStream(nomFichier);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            str = (ArrayList) in.readObject();
            for (boissonAlcoolisee s : str) {
                BoissonAl.add(s);
            }
            in.close();
            fileIn.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Erreur de chargement :/ ");
            c.printStackTrace();
        }

    }

    public ArrayList<Float> chargerCont(String nomFichier) {


        ArrayList<Float> str = new ArrayList<Float>();
        try {
            FileInputStream fileIn = new FileInputStream(nomFichier);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            str = (ArrayList) in.readObject();
            for (Float s : str) {
                Cont.add(s);
            }
            in.close();
            fileIn.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Erreur de chargement :/ ");
            c.printStackTrace();
        }
        return str;
    }

    public ArrayList<Cocktail> chargerCocktail(String nomFichier) {


        ArrayList<Cocktail> str = new ArrayList<Cocktail>();
        try {
            FileInputStream fileIn = new FileInputStream(nomFichier);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            str = (ArrayList) in.readObject();
            for (Cocktail s : str) {
                Cockt.add(s);
            }
            in.close();
            fileIn.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Erreur de chargement :/ ");
            c.printStackTrace();
        }
        return str;
    }

    public void chargerBoissonNonAlcoolisee(String nomFichier) {


        ArrayList<boissonNonAlcoolisee> str = new ArrayList<boissonNonAlcoolisee>();
        try {
            FileInputStream fileIn = new FileInputStream(nomFichier);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            str = (ArrayList) in.readObject();
            for (boissonNonAlcoolisee s : str) {
                BoissonNonAl.add(s);
            }
            in.close();
            fileIn.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Erreur de chargement :/ ");
            c.printStackTrace();
        }
    }

    public ArrayList<Boisson> chargerBoisson(String nomFichier) {


        ArrayList<Boisson> str = new ArrayList<Boisson>();
        try {
            FileInputStream fileIn = new FileInputStream(nomFichier);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            str = (ArrayList) in.readObject();
            for (Boisson s : str) {
                BOI.add(s);
            }
            in.close();
            fileIn.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Erreur de chargement :/ ");
            c.printStackTrace();
        }
        return str;
    }


}


