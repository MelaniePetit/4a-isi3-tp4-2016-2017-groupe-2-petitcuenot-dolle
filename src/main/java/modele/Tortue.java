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

    private Color teteCouleur;
    private int couleur;
    private boolean crayon;
    private ArrayList<Segment> listSegments; // Trace de la tortue
    private int x, y;
    private int dir;


    public Tortue() {
        listSegments = new ArrayList<Segment>();
        reset();
    }

    public void reset() {
        x = 500/2;
        y = 400/2;
        dir = -90;
        couleur = 0;
        teteCouleur = decodeColor(5);
        crayon = true;
        listSegments.clear();
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
    }

    public void droite(int ang) {
        dir = (dir + ang) % 360;
    }

    public void gauche(int ang) {
        dir = (dir - ang) % 360;
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
    }

    public void leverCrayon() {
        crayon = false;
    }

    public void couleur(int n) {
        couleur = n % 12;
    }

    public void couleurSuivante() {
        couleur(couleur ++);
    }

    public void setColor(int n) {couleur = n;}


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
    public static int getRp() {
        return rp;
    }

    public static int getRb() {
        return rb;
    }

    public static double getRatioDegRad() {
        return ratioDegRad;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public ArrayList<Segment> getListSegments() {
        return listSegments;
    }

    public int getCouleur() {
        return couleur;
    }

    public void setPosition(int newX, int newY) {
        x = newX;
        y = newY;
    }

    public Color getTeteCouleur() {
        return teteCouleur;
    }

    public void setTeteCouleur(int couleur) {
        teteCouleur = decodeColor(couleur);
    }
}
