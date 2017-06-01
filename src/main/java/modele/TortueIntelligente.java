package modele;


import modele.capacite.*;
import modele.environnement.Environment;
import vue.capaciteVue.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Random;

/**
 * Tortue se déplaçant seule prenant en compte son environnement (tortues voisines)
 */

public class TortueIntelligente extends TortueAutonome {

    //Faire deux types de champs de vision, un pour les voisin assez large, un pour les obstacles plutot proche de corps

    private int distMin;

    private ArrayList<Capacite> listCapacites;
    private ArrayList<CapaciteVue> listCapacitesVues;

    public TortueIntelligente() {
        super();
//        rayon = 50;
        this.listCapacites = new ArrayList<>();
        this.listCapacitesVues = new ArrayList<>();
//        add(new CapaciteCouleurAttraction(this, 30),new CapaciteAttractionVue());
        add(new CapaciteObjectif(this, new Point(400,400)), new CapaciteObjectifPointVue());

        add(new CapaciteObstacle(this,6,20,15),new CapaciteInvisibleVue());
        add(new CapaciteObstacle(this,3,45,10),new CapaciteInvisibleVue());
        add(new CapaciteObstacle(this,1,90,5),new CapaciteInvisibleVue());

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

    public ArrayList<Capacite> getListCapacites() {
        return listCapacites;
    }

    public ArrayList<CapaciteVue> getListCapacitesVues() {
        return listCapacitesVues;
    }

    public void add(Capacite capacite, CapaciteVue vue){
        listCapacites.add(capacite);
        listCapacitesVues.add(vue);
    }
}

