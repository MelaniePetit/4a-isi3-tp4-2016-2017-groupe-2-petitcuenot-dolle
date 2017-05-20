package vue;

import controleur.TortueControleur;
import controleur.TortueIntelligenteControleur;
import modele.Tortue;
import modele.TortueIntelligente;

import java.awt.*;

/**
 * Created by jeremy on 20/05/2017.
 */
public class TortueIntelligenteVue extends TortueVue {

    private TortueIntelligenteControleur controller;
    private TortueIntelligente tortue;
    public TortueIntelligenteVue(TortueIntelligente tortue, TortueIntelligenteControleur controleur) {
        super(tortue, controleur);
        controller =controleur;
        this.tortue = tortue;
    }

    @Override
    public void dessinerTortue(Graphics graph) {
        super.dessinerTortue(graph);
        getTortueControleur().genererCapaciteVues(graph,tortue);
    }

    public TortueIntelligenteControleur getTortueControleur(){
        return controller;
    }

    @Override
    public TortueIntelligente getTortue() {
        return tortue;
    }
}
