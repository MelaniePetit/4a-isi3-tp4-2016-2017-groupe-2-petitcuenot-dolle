package modele.capacite;

import modele.Environnement;
import modele.Tortue;
import modele.TortueIntelligente;
import modele.obstacle.Obstacle;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Mel on 16/05/2017.
 */
public class CapaciteObstacle implements Capacite{
    private Point nez;
    private Point moustacheDroite;
    private Point moustacheGauche;
    private TortueIntelligente currentTortue;
    private int size;

    public CapaciteObstacle(TortueIntelligente tortueIntelligente, int size) {
        currentTortue = tortueIntelligente;
        this.size = size;
        this.nez = detecteurObstacle(size);
        this.moustacheDroite = moustacheDroiteObstacle(size);
        this.moustacheGauche = moustacheGaucheObstacle(size);
    }

    private Point moustacheDroiteObstacle(int size) {
        double theta = Tortue.ratioDegRad * (-currentTortue.getDir()+20);
        double r = Math.sqrt(Tortue.rp * Tortue.rp + Tortue.rb * Tortue.rb);

        if (currentTortue.getVitesse() > 20)
            size = size * 2;
        return new Point(
                (int) Math.round(currentTortue.getX() + (size * r * Math.cos(theta))),
                (int) Math.round(currentTortue.getY() - (size * r * Math.sin(theta)))
        );
    }

    private Point moustacheGaucheObstacle(int size) {
        double theta = Tortue.ratioDegRad * (-currentTortue.getDir()-20);
        double r = Math.sqrt(Tortue.rp * Tortue.rp + Tortue.rb * Tortue.rb);

        if (currentTortue.getVitesse() > 20)
            size = size * 2;
        return new Point(
                (int) Math.round(currentTortue.getX() + (size * r * Math.cos(theta))),
                (int) Math.round(currentTortue.getY() - (size * r * Math.sin(theta)))
        );
    }

    private Point detecteurObstacle(float size){
        double theta = Tortue.ratioDegRad * (-currentTortue.getDir());
        double r = Math.sqrt(Tortue.rp * Tortue.rp + Tortue.rb * Tortue.rb);

        if (currentTortue.getVitesse() > 20)
            size = size * 2;
        return new Point(
                (int) Math.round(currentTortue.getX() + (size * r * Math.cos(theta))),
                (int) Math.round(currentTortue.getY() - (size * r * Math.sin(theta)))
        );
    }


    private synchronized void detecterObstacle(ArrayList<Obstacle> obstacles){
        for (Obstacle o : obstacles) {
            if (o.estDansObstacle(moustacheDroite.x,moustacheDroite.y)){
                currentTortue.setDir(currentTortue.getDir() + 20);
                return;
            }
            if (o.estDansObstacle(moustacheGauche.x,moustacheGauche.y)){
                currentTortue.setDir(currentTortue.getDir() - 20);
                return;
            }
            if (o.estDansObstacle(nez.x, nez.y)){
                currentTortue.setDir(currentTortue.getDir() + 20);
            }
        }
    }

    @Override
    public void lancerCapacité(Environnement environnement) {
        detecterObstacle(environnement.getListeObstacle());
        nez = detecteurObstacle(size);
        moustacheDroite = this.moustacheDroiteObstacle(size);
        moustacheGauche = this.moustacheGaucheObstacle(size);
    }
}
