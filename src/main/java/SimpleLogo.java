// package logo;

import controleur.MainControleur;
import modele.Tortue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/*************************************************************************

	Un petit Logo minimal qui devra etre ameliore par la suite

				J. Ferber - 1999-2001

				Cours de DESS TNI - Montpellier II

	@version 2.0
	@date 25/09/


**************************************************************************/


public class SimpleLogo{

	public static final Dimension VGAP = new Dimension(1,5);
	public static final Dimension HGAP = new Dimension(5,1);

	private static MainControleur mainControleur;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		   SwingUtilities.invokeLater(new Runnable(){
				public void run(){
					Tortue tortue = new Tortue();
					mainControleur = new MainControleur(tortue);
//					mainControleur.setCourante(tortue);
				}
			});

		}
}
