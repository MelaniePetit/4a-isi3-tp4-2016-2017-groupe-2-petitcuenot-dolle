package modele.capacite;

import modele.Environnement;
import modele.Tortue;
import modele.TortueIntelligente;
import modele.obstacle.Obstacle;

import java.awt.*;
import java.util.ArrayList;

import static modele.Tortue.rb;

/**
 * Created by Mel on 16/05/2017.
 */
public class CapaciteObstacle implements Capacite{
    private Point moustache;
    private TortueIntelligente currentTortue;
    private int size;

    public CapaciteObstacle(TortueIntelligente tortueIntelligente, int size) {
        currentTortue = tortueIntelligente;
        this.size = size;
        this.moustache = detecteurObstacle(size);
    }

    public Point detecteurObstacle(float size){
        double theta = Tortue.ratioDegRad*(-currentTortue.getDir());
        double r=Math.sqrt(Tortue.rp * Tortue.rp + Tortue.rb * Tortue.rb);

        if (currentTortue.getVitesse() > 20)
            size = size * 2;
        return new Point((int) Math.round(currentTortue.getX() + (size * r * Math.cos(theta))),
                (int) Math.round(currentTortue.getY() - (size * r * Math.sin(theta))));
    }

    public synchronized void detecterObstacle(ArrayList<Obstacle> obstacles){
        for (Obstacle o : obstacles) {
            if (o.estDansObstacle(moustache.x, moustache.y)){
                currentTortue.setDir(currentTortue.getDir() + 90);
                break;
            }
        }
    }

    @Override
    public void lancerCapacité(Environnement environnement) {
        detecterObstacle(environnement.getListeObstacle());
        moustache = detecteurObstacle(size);
    }
}
