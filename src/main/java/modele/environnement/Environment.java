package modele.environnement;

import modele.Tortue;
import modele.obstacle.Obstacle;
import vue.obstacleVue.ObstacleVue;

import java.util.ArrayList;

/**
 * Created by Mel on 03/05/2017.
 */
public abstract class Environment {

    private ArrayList<Obstacle> listeObstacle;
    private ArrayList<ObstacleVue> listObstacleVues;
    private ArrayList<Tortue> listeTortue;

    public Environment() {
        this.listeObstacle = new ArrayList<>();
        this.listeTortue = new ArrayList<>();
        this.listObstacleVues = new ArrayList<>();
    }

    public abstract Environment buildEnvironment();

    public ArrayList<ObstacleVue> getListObstacleVues() {
        return listObstacleVues;
    }

    public ArrayList<Obstacle> getListeObstacle() {
        return listeObstacle;
    }

    public ArrayList<Tortue> getListeTortue() {
        return listeTortue;
    }
}
