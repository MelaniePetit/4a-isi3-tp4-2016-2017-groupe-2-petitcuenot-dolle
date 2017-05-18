package vue;

import controleur.TortueControleur;
import modele.LogoTortue;
import modele.TortueAutonome;
import modele.TortueIntelligente;

import javax.swing.*;

/**
 * Created by Mel on 19/04/2017.
 */
public class FenetreTortueAutonomeVue extends MainVue {

    private JTextField inputValue;


    public FenetreTortueAutonomeVue(LogoTortue logoTortue, TortueControleur controleur, int i) {
        super(logoTortue, controleur, i);
    }

    @Override
    public void fenetreInit(){
        super.fenetreInit();

        if (typeTortue == 1){
            //ajouter des tortues autonomes de base
            for (int i = 0; i < 10 ; i++){
                TortueAutonome t = new TortueAutonome();
                feuilleDessinVue.ajouterTortue(t);

            }
        }
        else{
            //ajouter des tortues intelligente
            for (int i = 0; i < 100 ; i++){
                TortueIntelligente t = new TortueIntelligente();
                feuilleDessinVue.ajouterTortue(t);

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
