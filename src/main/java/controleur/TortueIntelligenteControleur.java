package controleur;

import modele.LogoTortue;
import modele.TortueIntelligente;
import vue.capaciteVue.CapaciteVue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mel on 24/04/2017.
 */
public class TortueIntelligenteControleur extends TortueControleur implements ActionListener {

    private List<CapaciteVue> capaciteVueList;
    private TortueIntelligente tortue;
    public TortueIntelligenteControleur(LogoTortue logo) {
        super(logo);
        capaciteVueList = new ArrayList<>();
    }

    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();

        // actions des boutons du haut
        if (c.equals("Lance")) {
            System.out.println("command Lancer");
            logoTortue.lancerTortues();
        } else if (c.equals("Stop")) {
            System.out.println("command Stopper");
            logoTortue.setAvance(false);
        }
        else if (c.equals("Ajout")){
            System.out.println("ajout tortue");
            tortue = new TortueIntelligente();
            tortue.setTeteCouleur(logoTortue.getCouranteTortue().getCouleur());
            tortue.setColor(logoTortue.getCouranteTortue().getCouleur());
            mainVue.getFeuilleDessinVue().ajouterTortueIntelligente(tortue);
        }
    }

    public void genererCapaciteVues(Graphics graphics, TortueIntelligente tortueIntelligente) {
        for (int i = 0; i < tortueIntelligente.getListCapacites().size(); i++) {
            CapaciteControleur controleur = new CapaciteControleur(tortueIntelligente.getListCapacites().get(i), tortueIntelligente.getListCapacitesVues().get(i));
            controleur.dessinerCapacite(graphics);
        }
    }
}
