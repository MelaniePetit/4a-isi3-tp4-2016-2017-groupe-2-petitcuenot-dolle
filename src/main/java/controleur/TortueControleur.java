package controleur;

import modele.LogoTortue;
import vue.FenetreTortueControlableVue;
import vue.MainVue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mel on 17/04/2017.
 */
public class TortueControleur implements ActionListener {

    protected LogoTortue logoTortue;
    protected MainVue mainVue;

    public TortueControleur(LogoTortue logo) {
        logoTortue = logo;
    }

    public int testNombre(){
        try{
            return Integer.parseInt(((FenetreTortueControlableVue) mainVue).getInputValue());
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

    public MainVue getMainVue() {
        return mainVue;
    }

    public LogoTortue getLogoTortue() {
        return logoTortue;
    }

    public void setMainVue(MainVue mainVue) {
        this.mainVue = mainVue;
    }


}
