// package logo;

import controleur.LogoTortueAutonomeControleur;
import controleur.LogoTortueControlableControleur;
import controleur.LogoTortueControleur;
import controleur.LogoTortueIntelligenteControleur;
import modele.LogoTortue;
import vue.LogoTortueAutonomeVue;
import vue.LogoTortueControlableVue;
import vue.LogoTortueVue;

import javax.swing.*;

public class Main {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		   SwingUtilities.invokeLater(new Runnable(){
				public void run(){

					ImageIcon icon = null;

					icon = new ImageIcon("src\\main\\java\\ressources\\carapuce.png");		//mettre le fichier en local


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
						logoControleur = new LogoTortueControlableControleur(logo);
						logoVue = new LogoTortueControlableVue(logo, (LogoTortueControlableControleur) logoControleur);
						logoControleur.setLogoTortueVue(logoVue);
						logoVue.setVisible(true);
					}

					else if (rang == 1){
						logoControleur = new LogoTortueAutonomeControleur(logo);
						logoVue = new LogoTortueAutonomeVue(logo, (LogoTortueAutonomeControleur) logoControleur, rang);
						logoControleur.setLogoTortueVue(logoVue);
						logoVue.setVisible(true);
					}

					else if (rang == 2){
						logoControleur = new LogoTortueIntelligenteControleur(logo);
						logoVue = new LogoTortueAutonomeVue(logo, (LogoTortueIntelligenteControleur) logoControleur, rang);
						logoControleur.setLogoTortueVue(logoVue);
						logoVue.setVisible(true);
					}

					else {
						System.exit(0);
					}

				}

			});

		}
}
