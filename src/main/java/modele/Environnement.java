package modele;

import modele.obstacle.Obstacle;

import java.util.ArrayList;

/**
 * Created by Mel on 03/05/2017.
 */
public class Environnement {

    private ArrayList<Obstacle> listeObstacle;
    private ArrayList<Tortue> listeTortue;

    public Environnement() {
        this.listeObstacle = new ArrayList<>();
        this.listeTortue = new ArrayList<>();
    }


    public ArrayList<Obstacle> getListeObstacle() {
        return listeObstacle;
    }

    public ArrayList<Tortue> getListeTortue() {
        return listeTortue;
    }
}
