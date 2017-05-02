package controleur;

import modele.LogoTortue;
import modele.Tortue;
import vue.LogoTortueControlableVue;
import vue.LogoTortueVue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mel on 17/04/2017.
 */
public class LogoTortueControleur implements ActionListener {

    protected LogoTortue logoTortue;
    protected LogoTortueVue logoTortueVue;

    public LogoTortueControleur(LogoTortue logo) {
        logoTortue = logo;
    }

    public int testNombre(){
        try{
            return Integer.parseInt(((LogoTortueControlableVue)logoTortueVue).getInputValue());
        }catch (NumberFormatException e){
            System.out.println("Erreur, nombre incorrect");
            return 0;
        }
    }

    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();
        if (c.equals("Effacer")) {
            System.out.println("reset la feuille de dessin");
            logoTortue.getDessin().reset();
        }
        else if (c.equals("Supprimer")){
            System.out.println("Supprime la dernière tortue");
            logoTortue.getDessin().supprimerTortue();
        }
        else if (c.equals("Quitter"))
            System.exit(0);
    }

    //Getters Setters

    public LogoTortueVue getLogoTortueVue() {
        return logoTortueVue;
    }

    public LogoTortue getLogoTortue() {
        return logoTortue;
    }

    public void setLogoTortueVue(LogoTortueVue logoTortueVue) {
        this.logoTortueVue = logoTortueVue;
    }
}
