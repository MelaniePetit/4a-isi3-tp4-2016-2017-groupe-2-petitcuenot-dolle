package controleur;

import modele.environnement.Environment;
import modele.environnement.factory.*;
import modele.obstacle.Obstacle;
import vue.EnvironnementVue;
import vue.obstacleVue.ObstacleVue;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Mel on 03/05/2017.
 */
public class EnvironnementControleur {

    private EnvironementFactory environementFactory;
    private Environment environement;
    private EnvironnementVue environnementVue;
    private ArrayList<ObstacleVue> listObstacleVue;

    public EnvironnementControleur() {
        this.environementFactory = new CadriageEnvironementFactory();
        this.environnementVue = new EnvironnementVue(this);
        listObstacleVue = new ArrayList<>();
        genererObstacles();
    }

    public void dessinerObstacles(Graphics graphic){
        graphic.setColor(Color.DARK_GRAY);
        environnementVue.dessinerEnvironnement(graphic);
    }

    private void genererObstacles() {
        environement = environementFactory.buildEnvironment();
    }

    public void genererObstaclesVues(Graphics graphics) {
        for(int i =0 ; i<environement.getListeObstacle().size() ; i++){
            ObstacleControleur controleur = new ObstacleControleur(environement.getListeObstacle().get(i), environement.getListObstacleVues().get(i));
            controleur.dessinerObstacle(graphics);
        }

    }

    public ArrayList<ObstacleVue> getListObstacleVue() {
        return listObstacleVue;
    }

    public Obstacle getObstacleVue(ObstacleVue vue){
        int index = this.getListObstacleVue().indexOf(vue);
        return this.getEnvironement().getListeObstacle().get(index);
    }

    public Environment getEnvironement() {
        return environement;
    }

    public ArrayList<Obstacle> getObstaclesListe(){
        return environement.getListeObstacle();
    }

}
