package modele;

import modele.obstacle.Obstacle;

import java.util.ArrayList;

/**
 * Created by Mel on 03/05/2017.
 */
public class Environnement {

    private ArrayList<Obstacle> listeObstacle;

    public Environnement() {
        this.listeObstacle = new ArrayList<>();
    }


    public ArrayList<Obstacle> getListeObstacle() {
        return listeObstacle;
    }
}
