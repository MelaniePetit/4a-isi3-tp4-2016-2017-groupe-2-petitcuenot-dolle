// package logo;

import controleur.LogoTortueAutonomeControleur;
import controleur.LogoTortueControlableControleur;
import controleur.LogoTortueControleur;
import modele.LogoTortue;
import vue.LogoTortueAutonomeVue;
import vue.LogoTortueControlableVue;
import vue.LogoTortueVue;

import javax.swing.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		   SwingUtilities.invokeLater(new Runnable(){
				public void run(){

					ImageIcon icon = null;
					try {
						icon = new ImageIcon(new URL("http://www.pokepedia.fr/images/thumb/c/c9/Carapuce-DM2.png/150px-Carapuce-DM2.png"));		//mettre le fichier en local
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}

					String[] type = {"Controlable", "Autonome", "Intelligente"};
					JOptionPane jop = new JOptionPane();
					int rang = jop.showOptionDialog(null,
							"Veuillez choisir votre type de tortues :",
							"Super turtle",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							icon,
							type,
							type[2]);

					//Instanciation de l'application
					LogoTortue logo = new LogoTortue();
					LogoTortueControleur logoControleur;
					LogoTortueVue logoVue;
					if (rang == 0){
						logoControleur = new LogoTortueControlableControleur(logo);;
						logoVue = new LogoTortueControlableVue(logo, logoControleur);
					}

					else{
						logoControleur = new LogoTortueAutonomeControleur(logo);
						logoVue = new LogoTortueAutonomeVue(logo, logoControleur);
					}

					logoControleur.setLogoTortueVue(logoVue);
					logoVue.setVisible(true);
				}

			});

		}
}
