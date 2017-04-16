// package logo;

import controleur.AccueilControleur;
import controleur.MainControleur;
import modele.Tortue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;

public class Main {

	public static final Dimension VGAP = new Dimension(1,5);
	public static final Dimension HGAP = new Dimension(5,1);

	private static MainControleur controleur;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		   SwingUtilities.invokeLater(new Runnable(){
				public void run(){
					Tortue tortue = new Tortue();
					controleur = new MainControleur(tortue);
					controleur.setCourante(tortue);
				}
			});

		}
}
