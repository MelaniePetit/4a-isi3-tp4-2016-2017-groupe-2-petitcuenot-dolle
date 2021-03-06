package modele;

import modele.environnement.Environment;

import java.util.ArrayList;
import java.util.Random;

/**
 * Tortue se déplaçant seule en ligne droite à vitesse constante
 */
public class TortueAutonome extends Tortue {

    public TortueAutonome() {
        super();
    }

    public void reset() {
        x = 1000/2;
        y = 800/2;

        Random r = new Random();
        x = r.nextInt(1000);
        y = r.nextInt(800);
        teteCouleur = decodeColor(r.nextInt(12));
        dir = r.nextInt(360)+1;
        vitesse = r.nextInt(30);

        notifier();
    }

    public void avancer(ArrayList<Tortue> voisines, Environment environment){
        avancer(this.vitesse);

        //Pour avoir un écran toroïdal
        this.setPosition(
                Math.floorMod(this.getX(), 1000),
                Math.floorMod(this.getY(), 800));

        notifier();

    }

}
