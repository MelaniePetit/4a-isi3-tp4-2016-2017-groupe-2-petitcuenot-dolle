package modele.capacite;

import modele.Environnement;
import modele.Tortue;
import modele.TortueIntelligente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mel on 16/05/2017.
 */
public class CapaciteAttraction implements Capacite {
    TortueIntelligente currentTortue;
    List<Tortue> voisins;
    ArrayList<Tortue> toutesLesTortues;

    public CapaciteAttraction(TortueIntelligente currentTortue) {
        this.currentTortue = currentTortue;
        this.voisins = new ArrayList<>();
    }

    public boolean estDansMaVision(Tortue voisine) {
        int dist = distanceVoisine(voisine);
        if (dist < currentTortue.getRayon()) {
            return true;
        } else
            return false;
    }

    public int distanceVoisine(Tortue voisine) {
        return (int) Math.sqrt(Math.pow((double) voisine.getX() - (double) currentTortue.getX(), 2) + Math.pow((double) voisine.getY() - (double) currentTortue.getY(), 2));
    }

    public synchronized void detecterVoisines(ArrayList<Tortue> toutesLesTortues){
        List<Tortue> voisins = new ArrayList<>();
        for (Tortue autreTortue : toutesLesTortues) {
            if (this.equals(autreTortue)) {
                continue;
            }
            if (estDansMaVision(autreTortue)) {
                voisins.add(autreTortue);
            }
        }
        voisins.add(currentTortue);
        this.voisins = voisins;
    }

    public void attracter(){
        int distMin = Integer.MAX_VALUE;
        //Mettre une direction et une vitesse moyenne
        if (voisins.size() > 1) {
            int directioGlobal = 0;
            int vitesseGlobal = 0;
            int distTest = 0;
            for (Tortue tortueASuivre : voisins) {
                directioGlobal += tortueASuivre.getDir();
                vitesseGlobal += tortueASuivre.getVitesse();

                if (this.equals(tortueASuivre)) continue;
                distTest = this.distanceVoisine(tortueASuivre);
                if (distTest < distMin) {
                    distMin = distTest;
                }

            }
            directioGlobal /= voisins.size();
            vitesseGlobal /= voisins.size();

//            if (distMin < 20) {
//                vitesseGlobal = (int) (vitesseGlobal + 5 * Math.random());
//            }

            currentTortue.setDir(directioGlobal);
            currentTortue.setVitesse(vitesseGlobal);
        }
    }

    public void setToutesLesTortues(ArrayList<Tortue> toutesLesTortues) {
        this.toutesLesTortues = toutesLesTortues;
    }

    @Override
    public void lancerCapacité(Environnement environnement) {
        this.detecterVoisines(environnement.getListeTortue());
        attracter();
    }
}
