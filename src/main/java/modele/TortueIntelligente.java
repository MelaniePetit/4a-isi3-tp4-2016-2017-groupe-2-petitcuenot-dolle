package modele;


import modele.capacite.Capacite;
import modele.capacite.CapaciteAttraction;
import modele.capacite.CapaciteObstacle;
import modele.environnement.Environment;

import java.util.ArrayList;
import java.util.Random;

/**
 * Tortue se déplaçant seule prenant en compte son environnement (tortues voisines)
 */

public class TortueIntelligente extends TortueAutonome {

    //Faire deux types de champs de vision, un pour les voisin assez large, un pour les obstacles plutot proche de corps

    private int distMin;

    private ArrayList<Capacite> listCapacites;

    public TortueIntelligente() {
        super();
        rayon = 50;
        this.listCapacites = new ArrayList<>();

        listCapacites.add(new CapaciteAttraction(this));
        listCapacites.add(new CapaciteObstacle(this,6, 15,20));
        listCapacites.add(new CapaciteObstacle(this,2,35,20));
    }

    @Override
    public void avancer(ArrayList<Tortue> toutesLesTortues, Environment environment) {
        for (Capacite c : listCapacites) {
            c.lancerCapacité(environment);
        }
        super.avancer(toutesLesTortues, environment);
    }

    @Override
    public void reset() {
        x = 1000 / 2;
        y = 800 / 2;

        Random r = new Random();
        x = r.nextInt(1000);
        y = r.nextInt(800);
        teteCouleur = decodeColor(r.nextInt(12));
        dir = r.nextInt(360) + 1;
        vitesse = 10;

        notifier();
    }
}

