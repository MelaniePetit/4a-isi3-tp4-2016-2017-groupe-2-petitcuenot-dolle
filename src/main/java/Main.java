// package logo;

import controleur.TortueAutonomeControleur;
import controleur.TortueControlableControleur;
import controleur.TortueControleur;
import controleur.TortueIntelligenteControleur;
import modele.LogoTortue;
import vue.FenetreTortueAutonomeVue;
import vue.FenetreTortueControlableVue;
import vue.MainVue;

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
					TortueControleur logoControleur;
					MainVue logoVue;
					if (rang == 0){
						logoControleur = new TortueControlableControleur(logo);
						logoVue = new FenetreTortueControlableVue(logo, (TortueControlableControleur) logoControleur);
						logoControleur.setMainVue(logoVue);
						logoVue.setVisible(true);
					}

					else if (rang == 1){
						logoControleur = new TortueAutonomeControleur(logo);
						logoVue = new FenetreTortueAutonomeVue(logo, (TortueAutonomeControleur) logoControleur, rang);
						logoControleur.setMainVue(logoVue);
						logoVue.setVisible(true);
					}

					else if (rang == 2){
						logoControleur = new TortueIntelligenteControleur(logo);
						logoVue = new FenetreTortueAutonomeVue(logo, (TortueIntelligenteControleur) logoControleur, rang);
						logoControleur.setMainVue(logoVue);
						logoVue.setVisible(true);
					}

					else {
						System.exit(0);
					}

				}

			});

		}
}
