package modele.capacite;

import modele.environnement.Environment;
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
    int rayon;

    public CapaciteAttraction(TortueIntelligente currentTortue, int rayon) {
        this.currentTortue = currentTortue;
        this.voisins = new ArrayList<>();
        this.rayon = rayon;
    }

    public boolean estDansMaVision(Tortue voisine) {
        int dist = distanceVoisine(voisine);
        return dist < rayon;
    }

    public int distanceVoisine(Tortue voisine) {
        return (int) Math.sqrt(Math.pow((double) voisine.getX() - (double) currentTortue.getX(), 2) + Math.pow((double) voisine.getY() - (double) currentTortue.getY(), 2));
    }

    public void detecterVoisines(ArrayList<Tortue> toutesLesTortues){
        List<Tortue> voisins = new ArrayList<>();
        for (Tortue autreTortue : toutesLesTortues) {
            if (currentTortue.equals(autreTortue)) {
                continue;
            }
            if (estDansMaVision(autreTortue)) {
                voisins.add(autreTortue);
            }
        }
        if (!voisins.contains(currentTortue))
            voisins.add(currentTortue);
        this.voisins = voisins;
    }

    public synchronized void attracter(){
        int distMin = Integer.MAX_VALUE;

        //Mettre une direction et une vitesse moyenne
        if (!voisins.isEmpty()) {
            int directioGlobal = 0;
            int vitesseGlobal = 0;
            int distTest = 0;
            for (Tortue tortueASuivre : voisins) {
                directioGlobal += tortueASuivre.getDir();
                vitesseGlobal += tortueASuivre.getVitesse();

                if (currentTortue.equals(tortueASuivre)) continue;
                distTest = this.distanceVoisine(tortueASuivre);
                if (distTest < distMin) {
                    distMin = distTest;
                }
            }

            directioGlobal /= voisins.size();
            vitesseGlobal /= voisins.size();

            for (Tortue t : voisins) {
                t.setDir(directioGlobal);
                t.setVitesse(vitesseGlobal);
            }

            if(distMin < 5) {
                vitesseGlobal = vitesseGlobal - 10;
            }


        }
    }

    public void setToutesLesTortues(ArrayList<Tortue> toutesLesTortues) {
        this.toutesLesTortues = toutesLesTortues;
    }

    @Override
    public void lancerCapacité(Environment environment) {
        this.detecterVoisines(environment.getListeTortue());
        attracter();
    }

    public TortueIntelligente getCurrentTortue() {
        return currentTortue;
    }

    public int getRayon() {
        return rayon;
    }

}
