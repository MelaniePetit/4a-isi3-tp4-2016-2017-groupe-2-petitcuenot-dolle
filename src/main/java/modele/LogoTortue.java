package modele;

import java.util.Observable;

/**
 * Created by Mel on 17/04/2017.
 */
public class LogoTortue extends Observable {

    protected Tortue couranteTortue;		//Tortue contrôlable
    protected FeuilleDessin dessin;	        //Feuille de dessin
    protected int couranteCouleur;			//Couleur courante
    protected boolean avance = false;               //tortues en mouvement

    public LogoTortue() {
        couranteTortue = new Tortue();
        dessin = new FeuilleDessin();
        couranteCouleur = 0;
    }

    public void lancerTortues() {

        if(avance)
            return;

        avance = true;

        Thread t = new Thread(new Runnable() {
            public void run() {
                while(avance) {
                    dessin.faireAvancerTortuesAutonomes();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
    }

    //Getters Setters

    public Tortue getCouranteTortue() {
        return couranteTortue;
    }

    public void setCouranteTortue(Tortue couranteTortue) {
        this.couranteTortue = couranteTortue;
    }

    public FeuilleDessin getDessin() {
        return dessin;
    }

    public void setAvance(boolean avance) {
        this.avance = avance;
    }
}
