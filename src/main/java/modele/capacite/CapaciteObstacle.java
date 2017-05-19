package modele.capacite;

import modele.environnement.Environment;
import modele.Tortue;
import modele.TortueIntelligente;
import modele.obstacle.Obstacle;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Mel on 16/05/2017.
 */
public class CapaciteObstacle implements Capacite{
    private Point moustacheDroite;
    private Point moustacheGauche;
    private TortueIntelligente currentTortue;
    private int size;
    private int angle;
    private int ecart;

    public CapaciteObstacle(TortueIntelligente tortueIntelligente, int size, int angle, int ecart) {
        currentTortue = tortueIntelligente;
        this.size = size;
        this.angle = angle;
        this.ecart = ecart;
        this.moustacheDroite = moustacheDroiteObstacle(size);
        this.moustacheGauche = moustacheGaucheObstacle(size);
    }

    private Point moustacheDroiteObstacle(int size) {
        double theta = Tortue.ratioDegRad * (-currentTortue.getDir()+ecart);
        double r = Math.sqrt(Tortue.rp * Tortue.rp + Tortue.rb * Tortue.rb);

        if (currentTortue.getVitesse() > 20)
            size = size * 2;
        return new Point(
                (int) Math.round(currentTortue.getX() + (size * r * Math.cos(theta))),
                (int) Math.round(currentTortue.getY() - (size * r * Math.sin(theta)))
        );
    }

    private Point moustacheGaucheObstacle(int size) {
        double theta = Tortue.ratioDegRad * (-currentTortue.getDir()-ecart);
        double r = Math.sqrt(Tortue.rp * Tortue.rp + Tortue.rb * Tortue.rb);

        if (currentTortue.getVitesse() > 20)
            size = size * 2;
        return new Point(
                (int) Math.round(currentTortue.getX() + (size * r * Math.cos(theta))),
                (int) Math.round(currentTortue.getY() - (size * r * Math.sin(theta)))
        );
    }

    private synchronized void detecterObstacle(ArrayList<Obstacle> obstacles){
        boolean turn = true;
        for (Obstacle o : obstacles) {
            if (o.estDansObstacle(moustacheDroite.x,moustacheDroite.y)){
                currentTortue.setDir(currentTortue.getDir() + angle);
                return;
            }
            if (o.estDansObstacle(moustacheGauche.x,moustacheGauche.y)){
                currentTortue.setDir(currentTortue.getDir() - angle);
                return;
            }
        }
    }

    @Override
    public void lancerCapacité(Environment environment) {
        detecterObstacle(environment.getListeObstacle());
        moustacheDroite = this.moustacheDroiteObstacle(size);
        moustacheGauche = this.moustacheGaucheObstacle(size);
    }
}
