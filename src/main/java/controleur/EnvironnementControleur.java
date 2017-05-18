package controleur;

import modele.Environnement;
import modele.obstacle.CarreObstacle;
import modele.obstacle.CercleObstacle;
import modele.obstacle.Obstacle;
import modele.obstacle.RectangleObstacle;
import vue.EnvironnementVue;
import vue.obstacleVue.CarreObstacleVue;
import vue.obstacleVue.CercleObstacleVue;
import vue.obstacleVue.ObstacleVue;
import vue.obstacleVue.RectangleObstacleVue;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Mel on 03/05/2017.
 */
public class EnvironnementControleur {

    private Environnement environnement;
    private EnvironnementVue environnementVue;
    private ArrayList<ObstacleVue> listObstacleVue;

    public EnvironnementControleur() {
        this.environnement = new Environnement();
        this.environnementVue = new EnvironnementVue(this);
        listObstacleVue = new ArrayList<>();
        genererObstacles();

    }

    public Environnement getEnvironnement() {
        return environnement;
    }

    public void dessinerObstacles(Graphics graphic){
        graphic.setColor(Color.DARK_GRAY);
        environnementVue.dessinerEnvironnement(graphic);
    }

    private void genererObstacles() {
        Random r = new Random();

        for (int i = 1 ; i<5 ; i++){
            int forme = r.nextInt(1);
            switch (forme){
                case 0 :
                    environnement.getListeObstacle().add(new CarreObstacle(200, r.nextInt(900),r.nextInt(700)));
                    listObstacleVue.add(new CarreObstacleVue(this));
                    break;
                case 1 :
                    environnement.getListeObstacle().add(new RectangleObstacle(200, r.nextInt(900), r.nextInt(700), 100));
                    listObstacleVue.add(new RectangleObstacleVue(this));
                    break;
                case 2 :
                    environnement.getListeObstacle().add(new CercleObstacle(200, r.nextInt(900), r.nextInt(700)));
                    listObstacleVue.add(new CercleObstacleVue(this));
                    break;
            }
        }
    }

    public ArrayList<ObstacleVue> getListObstacleVue() {
        return listObstacleVue;
    }

    public Obstacle getObstacleVue(ObstacleVue vue){
        int index = this.getListObstacleVue().indexOf(vue);
        return this.getEnvironnement().getListeObstacle().get(index);
    }

    public ArrayList<Obstacle> getObstaclesListe(){
        return environnement.getListeObstacle();
    }
}
