package modele;

import java.util.Random;

/**
 * Created by Mel on 18/04/2017.
 */
public class TortueAutonome extends Tortue {

    protected int vitesse;

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
        vitesse = r.nextInt(100);

        notifier();
    }


    public void avancer(){
            avancer(this.vitesse);

        //Pour avoir un écran toroïdal
        this.setPosition(
                Math.floorMod(this.getX(), 1000),
                Math.floorMod(this.getY(), 800));

        notifier();

    }

}
