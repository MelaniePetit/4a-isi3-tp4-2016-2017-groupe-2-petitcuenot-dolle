package controleur;

import modele.Tortue;
import vue.TortueVue;
import vue.FeuilleVue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mel on 12/04/2017.
 */
public class MainControleur implements ActionListener {

    private Tortue courante;
    private TortueVue feuille;
    private FeuilleVue vue;

    public MainControleur() {
        courante = new Tortue();
        feuille = new TortueVue();
        vue = new FeuilleVue(this);
        vue.logoInit();
        feuille = new TortueVue();
    }

    public void setCourante(Tortue courante) {
        this.courante = courante;
    }

    public Tortue getCourante() {
        return courante;
    }

    public TortueVue getFeuille() {
        return feuille;
    }

    /** la gestion des actions des boutons */
    public void actionPerformed(ActionEvent e)
    {
        String c = e.getActionCommand();

        // actions des boutons du haut
        if (c.equals("Avancer")) {
            System.out.println("command avancer");
            try {
                int v = Integer.parseInt(vue.getInputValue());
                courante.avancer(v);
                courante.notifyObservers();
            } catch (NumberFormatException ex){
                System.err.println("ce n'est pas un nombre : " + vue.getInputValue());
            }

        }
        else if (c.equals("Droite")) {
            try {
                int v = Integer.parseInt(vue.getInputValue());
                courante.droite(v);
                courante.notifyObservers();
            } catch (NumberFormatException ex){
                System.err.println("ce n'est pas un nombre : " + vue.getInputValue());
            }
        }
        else if (c.equals("Gauche")) {
            try {
                int v = Integer.parseInt(vue.getInputValue());
                courante.gauche(v);
                courante.notifyObservers();
            } catch (NumberFormatException ex){
                System.err.println("ce n'est pas un nombre : " + vue.getInputValue());
            }
        }
        else if (c.equals("Lever")) {
            courante.leverCrayon();
            courante.notifyObservers();
        }
        else if (c.equals("Baisser")) {
            courante.baisserCrayon();
            courante.notifyObservers();
        }

        // actions des boutons du bas
        else if (c.equals("Proc1")) {
            proc1();
            courante.notifyObservers();
        }
        else if (c.equals("Proc2")) {
            proc2();
            courante.notifyObservers();
        }
        else if (c.equals("Proc3")) {
            proc3();
            courante.notifyObservers();
        }
        else if (c.equals("Effacer")) {
            effacer();
            courante.notifyObservers();
        }
        else if (c.equals("Quitter"))
            quitter();

        feuille.repaint();
    }


    /** les procedures Logo qui combine plusieurs commandes..*/
    public void proc1() {
        courante.carre();
    }

    public void proc2() {
        courante.poly(60,8);
    }

    public void proc3() {
        courante.spiral(50,40,6);
    }

    // efface tout et reinitialise la feuille
    private void effacer() {
        feuille.reset();
        feuille.repaint();

        // Replace la tortue au centre
        Dimension size = feuille.getSize();
        courante.setPosition(size.width/2, size.height/2);
    }

    private void quitter() {
        System.exit(0);
    }

}
