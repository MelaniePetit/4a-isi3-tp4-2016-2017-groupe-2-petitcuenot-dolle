package modele.capacite;

import modele.Tortue;
import modele.TortueIntelligente;
import modele.environnement.Environment;

import java.awt.*;

/**
 * Created by Mel on 16/05/2017.
 */
public class CapaciteObjectif implements Capacite {
    private TortueIntelligente tortue;
    private Point pointObjectif;

    public CapaciteObjectif(TortueIntelligente tortue, Point pointObjectif) {
        this.tortue = tortue;
        this.pointObjectif = pointObjectif;
    }

    public synchronized void suivre(){

        int[] vecteurCible = new int[2];
        vecteurCible[0] = pointObjectif.x - tortue.getX();
        vecteurCible[1] = pointObjectif.y - tortue.getY();

        //on prend comme vecteurs références i : (1,0) et j : (0,1)
        double theta = (vecteurCible[0] * 1 + vecteurCible[1] * 0) /
                            (Math.sqrt(vecteurCible[0]*vecteurCible[0] + vecteurCible[1]*vecteurCible[1]));
        double angleRad = Math.acos(theta);
        int angleDeg = (int) Math.round(180 * (angleRad) / Math.PI);

        if (pointObjectif.y > tortue.getY()){
            tortue.setDir(angleDeg);
        }
        else
            tortue.setDir(-angleDeg);

    }

    @Override
    public void lancerCapacité(Environment environment) {
        this.suivre();
    }

    public TortueIntelligente getTortue() {
        return tortue;
    }

    public Point getPointObjectif() {
        return pointObjectif;
    }
}
