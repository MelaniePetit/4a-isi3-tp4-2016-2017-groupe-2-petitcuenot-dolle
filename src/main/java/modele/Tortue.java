package modele;

import modele.forme.Carre;
import modele.forme.Polyg;
import modele.forme.Spiral;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Mel on 12/04/2017.
 */
public class Tortue extends Observable{

    public static final int rp=10, rb=5; // Taille de la pointe et de la base de la fleche
    public static final double ratioDegRad = 0.0174533; // Rapport radians/degres (pour la conversion)

    protected Color teteCouleur;
    protected int couleur;
    protected boolean crayon;
    protected ArrayList<Segment> listSegments; // Trace de la tortue
    protected int x, y;
    protected int dir;
    protected int vitesse;



    public Tortue() {
        listSegments = new ArrayList<Segment>();
        reset();
    }

    public void reset() {
        x = 1000/2;
        y = 800/2;
        dir = -90;
        couleur = 0;
        teteCouleur = decodeColor(5);
        crayon = true;
        listSegments.clear();

        notifier();
    }

    public void avancer(int dist) {
        int newX = (int) Math.round(x+dist*Math.cos(ratioDegRad*dir));
        int newY = (int) Math.round(y+dist*Math.sin(ratioDegRad*dir));

        if (crayon) {
            Segment seg = new Segment();

            seg.getPtStart().x = x;
            seg.getPtStart().y = y;
            seg.getPtEnd().x = newX;
            seg.getPtEnd().y = newY;
            seg.setColor(decodeColor(couleur));

            listSegments.add(seg);
        }

        x = newX;
        y = newY;
        notifier();
    }

    public void droite(int ang) {
        dir = (dir + ang) % 360;
        notifier();
    }

    public void gauche(int ang) {
        dir = (dir - ang) % 360;
        notifier();
    }

    public Color decodeColor(int c) {
        switch(c) {
            case 0: return(Color.black);
            case 1: return(Color.blue);
            case 2: return(Color.cyan);
            case 3: return(Color.darkGray);
            case 4: return(Color.red);
            case 5: return(Color.green);
            case 6: return(Color.lightGray);
            case 7: return(Color.magenta);
            case 8: return(Color.orange);
            case 9: return(Color.gray);
            case 10: return(Color.pink);
            case 11: return(Color.yellow);
            default : return(Color.black);
        }
    }

    public void baisserCrayon() {
        crayon = true;
        notifier();
    }

    public void leverCrayon() {
        crayon = false;
        notifier();
    }

    public void couleur(int n) {
        couleur = n % 12;
        notifier();
    }

    public void couleurSuivante() {
        couleur(couleur ++);
        notifier();
    }

    protected void notifier() {
        setChanged();
        notifyObservers();
    }

    /** quelques classiques */

    public void carre() {
        new Carre(this);
    }

    public void poly(int a, int n) {
       new Polyg(this, a, n);
    }

    public void spiral(int n, int k, int a) {
        new Spiral(this, n, k, a);
    }


    //GETTERS AND SETTERS
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDir() {
        return dir;
    }

    public ArrayList<Segment> getListSegments() {
        return listSegments;
    }

    public int getCouleur() {
        return couleur;
    }

    public Color getTeteCouleur() {
        return teteCouleur;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setPosition(int newX, int newY) {
        x = newX;
        y = newY;
        notifier();
    }

    public void setTeteCouleur(int couleur) {
        teteCouleur = decodeColor(couleur);
    }

    public void setColor(int n) {
        couleur = n;
        notifier();
    }

    public void setDir(int dir) {
        this.dir = dir;
    }


}
