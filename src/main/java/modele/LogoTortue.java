package modele;

import java.util.Observable;

/**
 * Created by Mel on 17/04/2017.
 */
public class LogoTortue extends Observable {

    private Tortue couranteTortue;		//Tortue contrôlable
    private FeuilleDessin dessin;	    //Feuille de dessin model
    private boolean avance = false;     //tortues en mouvement

    public LogoTortue() {
        couranteTortue = new Tortue();
        dessin = new FeuilleDessin();
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
                        Thread.sleep(60);
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
