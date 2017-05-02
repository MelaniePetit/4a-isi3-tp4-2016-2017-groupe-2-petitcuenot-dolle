package vue;

import controleur.LogoTortueControlableControleur;
import controleur.LogoTortueControleur;
import modele.FeuilleDessin;
import modele.Tortue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Mel on 18/04/2017.
 */
public class FeuilleDessinVue extends JPanel implements Observer, MouseListener{

    protected ArrayList<TortueVue> tortues;
    protected FeuilleDessin dessin;
    protected LogoTortueControleur logoTortueControleur;

    public FeuilleDessinVue(FeuilleDessin feuille, LogoTortueControleur logoControleur) {
        logoTortueControleur = logoControleur;
        dessin = feuille;
        tortues = new ArrayList<TortueVue>();
        dessin.addObserver(this);
        addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color c = g.getColor();

        Dimension dim = getSize();
        g.setColor(Color.white);
        g.fillRect(0,0,dim.width, dim.height);
        g.setColor(c);

        afficherTortues(g);
    }

    public void ajouterTortue(Tortue tortue) {
        TortueVue tortueVue = new TortueVue(tortue, logoTortueControleur);
        tortue.addObserver(this);
        tortues.add(tortueVue);
        dessin.ajouterTortue(tortue);
        repaint();
    }

    public void afficherTortues(Graphics graph) {
        //Copie de la liste pour éviter les erreurs
        ArrayList<TortueVue> tortuesAffichages = new ArrayList<TortueVue>(tortues);

        for(TortueVue tortueVue : tortuesAffichages) {
            tortueVue.dessinerTortue(graph);
        }
    }

    public void supprimerTortue(Tortue tortue){
        if (tortues.size() > 1) {
            for (int i = tortues.size()-1 ; i > 0 ; i--) {
                if (tortues.get(i).getTortue() == tortue) {
                    tortues.remove(i);
                }
            }
        }
    }

    public void update(Observable o, Object arg) {
        repaint();
    }

    //Getters Setters

    public ArrayList<TortueVue> getTortues() {
        return tortues;
    }

    public void mouseClicked(MouseEvent e) {
        for (TortueVue t: getTortues()) {
            if (t.getArrow().contains(e.getX(), e.getY())){
                logoTortueControleur.getLogoTortue().setCouranteTortue(t.getTortue());
            }
        }
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}