package controleur;

import modele.LogoTortue;
import modele.TortueIntelligente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mel on 24/04/2017.
 */
public class TortueIntelligenteControleur extends TortueControleur implements ActionListener {
        
    public TortueIntelligenteControleur(LogoTortue logo) {
        super(logo);
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
            TortueIntelligente tortue =  new TortueIntelligente();
            tortue.setTeteCouleur(logoTortue.getCouranteTortue().getCouleur());
            tortue.setColor(logoTortue.getCouranteTortue().getCouleur());
            mainVue.getFeuilleDessinVue().ajouterTortue(tortue);
        }
    }
}
