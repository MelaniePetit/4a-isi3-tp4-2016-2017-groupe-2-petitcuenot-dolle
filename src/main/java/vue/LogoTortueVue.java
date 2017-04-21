package vue;

import controleur.LogoTortueControleur;
import modele.LogoTortue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Mel on 17/04/2017.
 */
public abstract class LogoTortueVue extends JFrame implements Observer{

    protected LogoTortue logoTortue;
    protected FeuilleDessinVue feuilleDessin;
    protected LogoTortueControleur logoTortueControleur;

    public static final Dimension HGAP = new Dimension(5,1);

    public LogoTortueVue(LogoTortue logoTortue, LogoTortueControleur controleur){
        super("Super Turtle");

        logoTortueControleur = controleur;

        this.logoTortue = logoTortue;
        logoTortue.addObserver(this);
        feuilleDessin = new FeuilleDessinVue(logoTortue.getDessin(), logoTortueControleur);

        logoInit();

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    protected void logoInit() {
        getContentPane().setLayout(new BorderLayout(10,10));

        initMenu();
        initBouton();

        //Feuille Dessin
        feuilleDessin.setBackground(Color.white);
        feuilleDessin.setSize(new Dimension(1000,800));
        feuilleDessin.setPreferredSize(new Dimension(1000,800));
        getContentPane().add(feuilleDessin,"Center");

    }

    //utilitaires pour installer des boutons et des menus
    public void addMenuItem(JMenu m, String label, String command, int key) {
        JMenuItem menuItem;
        menuItem = new JMenuItem(label);
        m.add(menuItem);

        menuItem.setActionCommand(command);
        menuItem.addActionListener(logoTortueControleur);
        if (key > 0) {
            if (key != KeyEvent.VK_DELETE)
                menuItem.setAccelerator(KeyStroke.getKeyStroke(key, Event.CTRL_MASK, false));
            else
                menuItem.setAccelerator(KeyStroke.getKeyStroke(key, 0, false));
        }
    }

    public abstract void optionMenu(JMenuBar menu);

    public void initMenu() {
        // Menus
        JMenuBar menubar = new JMenuBar();
        JMenu menuFile = new JMenu("File"); // on installe le premier menu
        menubar.add(menuFile);
        addMenuItem(menuFile, "Ajouter Tortue", "Ajout", -1);
        addMenuItem(menuFile, "Supprimer Tortue", "Supprime", -1);
        addMenuItem(menuFile, "Effacer", "Effacer", -1);
        addMenuItem(menuFile, "Quitter", "Quitter", -1);

        optionMenu(menubar);

        JMenu menuHelp = new JMenu("Aide"); // on installe le premier menu
        menubar.add(menuHelp);
        addMenuItem(menuHelp, "Aide", "Help", -1);
        addMenuItem(menuHelp, "A propos", "About", -1);

        setJMenuBar(menubar);    // on installe le menu bar
    }

    public void addButton(JComponent p, String name, String tooltiptext, String imageName) {
        JButton b;
        if ((imageName == null) || (imageName.equals(""))) {
            b = (JButton)p.add(new JButton(name));
        }
        else {
            java.net.URL u = this.getClass().getResource(imageName);
            if (u != null) {
                ImageIcon im = new ImageIcon (u);
                b = (JButton) p.add(new JButton(im));
            }
            else
                b = (JButton) p.add(new JButton(name));
            b.setActionCommand(name);
        }

        b.setToolTipText(tooltiptext);
        b.setBorder(BorderFactory.createRaisedBevelBorder());
        b.setMargin(new Insets(0,0,0,0));
        b.addActionListener(logoTortueControleur);
    }

    public abstract void optionBouton(JToolBar toolbar);

    public void initBouton(){
        // Boutons
        JToolBar toolBar = new JToolBar();

        optionBouton(toolBar);

        addButton(toolBar, "Ajout", "Ajouter Tortue", null);
        addButton(toolBar, "Supprimer", "Supprimer Tortue", null);
        addButton(toolBar,"Effacer","Nouveau dessin",null);

        toolBar.add(Box.createRigidArea(HGAP));

        // Create the combo box
        String[] colorStrings = {"noir", "bleu", "cyan","gris fonce","rouge",
                "vert", "gris clair", "magenta", "orange",
                "gris", "rose", "jaune"};

        toolBar.add(Box.createRigidArea(HGAP));
        JLabel colorLabel = new JLabel("   Couleur: ");
        toolBar.add(colorLabel);
        JComboBox colorList = new JComboBox(colorStrings);
        toolBar.add(colorList);

        colorList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                int n = cb.getSelectedIndex();
                logoTortueControleur.getLogoTortue().getCouranteTortue().setColor(n);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(toolBar);

        getContentPane().add(toolBar,"North");

    }

    public void update(Observable o, Object arg) {
        repaint();
    }

    //Getters Setters

    public FeuilleDessinVue getFeuilleDessinVue() {
        return feuilleDessin;
    }
}
