package controleur;

import modele.capacite.Capacite;
import vue.capaciteVue.CapaciteVue;

import java.awt.*;

/**
 * Created by jeremy on 20/05/2017.
 */
public class CapaciteControleur {
    Capacite capacite;
    CapaciteVue capaciteVue;

    public CapaciteControleur(Capacite capacite, CapaciteVue capaciteVue) {
        this.capacite = capacite;
        this.capaciteVue = capaciteVue;
    }

    public void dessinerCapacite(Graphics graphics){
        capaciteVue.dessinerCapacite(graphics, capacite);
    }
}
