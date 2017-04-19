package vue;

import controleur.LogoTortueControleur;
import modele.LogoTortue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Mel on 18/04/2017.
 */
public class LogoTortueControlableVue extends LogoTortueVue {

    private JTextField inputValue;

    public LogoTortueControlableVue(LogoTortue logoTortue, LogoTortueControleur controleur) {
        super(logoTortue, controleur);
    }

    @Override
    public void logoInit(){
        super.logoInit();

        initFormes();

        //ajouter première tortue

        feuilleDessin.ajouterTortue(logoTortue.getCouranteTortue());

    }

    public void initFormes(){
        // les boutons du bas
        JPanel p2 = new JPanel(new GridLayout());
        JButton b20 = new JButton("Proc1");
        p2.add(b20);
        b20.addActionListener(logoTortueControleur);
        JButton b21 = new JButton("Proc2");
        p2.add(b21);
        b21.addActionListener(logoTortueControleur);
        JButton b22 = new JButton("Proc3");
        p2.add(b22);
        b22.addActionListener(logoTortueControleur);

        getContentPane().add(p2,"South");

    }

    @Override
    public void optionMenu(JMenuBar menuBar) {
        JMenu menuCommandes=new JMenu("Commandes"); // on installe le premier menu
        menuBar.add(menuCommandes);
        addMenuItem(menuCommandes, "Avancer", "Avancer", -1);
        addMenuItem(menuCommandes, "Droite", "Droite", -1);
        addMenuItem(menuCommandes, "Gauche", "Gauche", -1);
        addMenuItem(menuCommandes, "Ajout", "Ajouter", -1);
        addMenuItem(menuCommandes, "Lever Crayon", "Lever", -1);
        addMenuItem(menuCommandes, "Baisser Crayon", "Baisser", -1);
    }

    @Override
    public void optionBouton(JToolBar toolBar) {
        inputValue=new JTextField("45",5);
        toolBar.add(inputValue);
        addButton(toolBar, "Avancer", "Avancer 50", null);
        addButton(toolBar, "Droite", "Droite 45", null);
        addButton(toolBar, "Gauche", "Gauche 45", null);
        addButton(toolBar, "Lever", "Lever Crayon", null);
        addButton(toolBar, "Baisser", "Baisser Crayon", null);
    }

    public String getInputValue(){
        String s = inputValue.getText();
        return(s);
    }

}
