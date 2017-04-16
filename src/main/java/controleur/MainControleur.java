package controleur;

import modele.Tortue;
import vue.TortueVue;
import vue.FeuilleVue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Mel on 12/04/2017.
 */
public class MainControleur implements ActionListener {

    private Tortue courante;
    private TortueVue tortueVue;
    private FeuilleVue feuilleVue;

    public MainControleur(Tortue tortue) {
        courante = tortue;
        tortueVue = new TortueVue();
        feuilleVue = new FeuilleVue(this);
        feuilleVue.logoInit();

    }

    /** la gestion des actions des boutons */
    public void actionPerformed(ActionEvent e)
    {
        String c = e.getActionCommand();

        // actions des boutons du haut
        if (c.equals("Avancer")) {
            System.out.println("command avancer");
            try {
                int v = Integer.parseInt(feuilleVue.getInputValue());
                courante.avancer(v);
                courante.notifyObservers();
            } catch (NumberFormatException ex){
                System.err.println("ce n'est pas un nombre : " + feuilleVue.getInputValue());
            }

        }
        else if (c.equals("Droite")) {
            try {
                int v = Integer.parseInt(feuilleVue.getInputValue());
                courante.droite(v);
                courante.notifyObservers();
            } catch (NumberFormatException ex){
                System.err.println("ce n'est pas un nombre : " + feuilleVue.getInputValue());
            }
        }
        else if (c.equals("Gauche")) {
            try {
                int v = Integer.parseInt(feuilleVue.getInputValue());
                courante.gauche(v);
                courante.notifyObservers();
            } catch (NumberFormatException ex){
                System.err.println("ce n'est pas un nombre : " + feuilleVue.getInputValue());
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
        else if (c.equals("Ajout")){
            Tortue t = new Tortue();
            t.setColor(courante.getCouleur());
            t.setTeteCouleur(courante.getCouleur());
            tortueVue.addTortue(t);
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

        tortueVue.repaint();
        feuilleVue.repaint();
    }


    /** les procedures Logo qui combine plusieurs commandes..*/
    public void proc1() {
        courante.carre();
    }

    public void proc2() {
        courante.poly(60,8);
    }

    public void proc3() {courante.spiral(50,40,6);}

    // efface tout et reinitialise la feuille
    private void effacer() {
        tortueVue.getTortues().clear();
        tortueVue.getTortues().add(courante);
        tortueVue.reset();
        tortueVue.repaint();

        // Replace la tortue au centre
        Dimension size = tortueVue.getSize();
        courante.setPosition(size.width/2, size.height/2);
    }

    private void quitter() {
        System.exit(0);
    }



    //GETTERS AND SETTERS

    public void setCourante(Tortue courante) {
        this.courante = courante;
    }

    public Tortue getCourante() {
        return courante;
    }

    public TortueVue getFeuille() {
        return tortueVue;
    }

    public void mouseClicked(MouseEvent e) {

    }

//    public void mousePressed(MouseEvent me) {
//        Point p = me.getPoint();
//        System.out.println("clic !");
//        for (Tortue t : tortues) {
//            if (t.getArrow().contains(p)) {
//                System.out.println("touche");
//            }
//        }
//    }


    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
