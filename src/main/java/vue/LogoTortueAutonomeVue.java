package vue;

import controleur.LogoTortueControleur;
import modele.LogoTortue;
import modele.Tortue;
import modele.TortueAutonome;
import modele.TortueIntelligente;

import javax.swing.*;

/**
 * Created by Mel on 19/04/2017.
 */
public class LogoTortueAutonomeVue extends LogoTortueVue {

    private JTextField inputValue;


    public LogoTortueAutonomeVue(LogoTortue logoTortue, LogoTortueControleur controleur, int i) {
        super(logoTortue, controleur, i);
    }

    @Override
    public void logoInit(){
        super.logoInit();

        if (typeTortue == 1){
            //ajouter des tortues autonomes de base
            for (int i = 0; i < 10 ; i++){
                TortueAutonome t = new TortueAutonome();
                feuilleDessin.ajouterTortue(t);

            }
        }
        else{
            //ajouter des tortues intelligente
            for (int i = 0; i < 10 ; i++){
                TortueIntelligente t = new TortueIntelligente();
                feuilleDessin.ajouterTortue(t);

            }
        }


    }

    public void optionMenu(JMenuBar menuBar) {
        JMenu menuCommandes=new JMenu("Commandes"); // on installe le premier menu
        menuBar.add(menuCommandes);
        addMenuItem(menuCommandes, "Lance", "Lancer", -1);
        addMenuItem(menuCommandes, "Stop", "Stopper", -1);
    }

    public void optionBouton(JToolBar toolBar) {
        inputValue=new JTextField("45",5);
        toolBar.add(inputValue);
        addButton(toolBar, "Lance", "Lancer", null);
        addButton(toolBar, "Stop", "Stopper", null);
    }
}
