package controleur;

import modele.LogoTortue;
import modele.Tortue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mel on 18/04/2017.
 */
public class LogoTortueControlableControleur extends LogoTortueControleur implements ActionListener {

    public LogoTortueControlableControleur(LogoTortue logo) {
        super(logo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();

        // actions des boutons du haut
        if (c.equals("Avancer")) {
            System.out.println("command avancer");
            logoTortue.getCouranteTortue().avancer(testNombre());
        }
        else if (c.equals("Droite")) {
            System.out.println("command droite");
            logoTortue.getCouranteTortue().droite(testNombre());
        }
        else if (c.equals("Gauche")) {
            System.out.println("command gauche");
            logoTortue.getCouranteTortue().gauche(testNombre());
        }
        else if (c.equals("Lever")) {
            System.out.println("command lever");
            logoTortue.getCouranteTortue().leverCrayon();
        }
        else if (c.equals("Ajout")){
            System.out.println("ajout tortue");
            Tortue tortue =  new Tortue();
            tortue.setTeteCouleur(logoTortue.getCouranteTortue().getCouleur());
            tortue.setColor(logoTortue.getCouranteTortue().getCouleur());
            logoTortueVue.getFeuilleDessinVue().ajouterTortue(tortue);
        }
        else if (c.equals("Baisser")) {
            System.out.println("command baisser");
            logoTortue.getCouranteTortue().baisserCrayon();
        }
        else if (c.equals("Supprimer")){            //A REVOIR
//            Tortue t = logoTortue.getCouranteTortue();
//            logoTortue.setCouranteTortue(logoTortue.getDessin().getTortues().get(0));
//            logoTortue.getDessin().supprimerTortue(t);
//            logoTortueVue.getFeuilleDessinVue().supprimerTortue(t);

        }

        // actions des boutons du bas
        else if (c.equals("Proc1")) {
            System.out.println("command proc1");
            proc1();
            logoTortue.getCouranteTortue().notifyObservers();
        }
        else if (c.equals("Proc2")) {
            System.out.println("command proc2");
            proc2();
            logoTortue.getCouranteTortue().notifyObservers();
        }
        else if (c.equals("Proc3")) {
            System.out.println("command proc3");
            proc3();
            logoTortue.getCouranteTortue().notifyObservers();
        }
    }

    /** les procedures LogoTortue qui combine plusieurs commandes..*/
    public void proc1() {
        logoTortue.getCouranteTortue().carre();
    }

    public void proc2() {
        logoTortue.getCouranteTortue().poly(60,8);
    }

    public void proc3() {logoTortue.getCouranteTortue().spiral(50,40,6);}

}
