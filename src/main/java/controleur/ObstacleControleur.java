package controleur;

import modele.obstacle.Obstacle;
import vue.obstacleVue.ObstacleVue;

import java.awt.*;

/**
 * Created by jeremy on 19/05/2017.
 */
public class ObstacleControleur {
    Obstacle obstacle;
    ObstacleVue obstacleVue;

    public ObstacleControleur(Obstacle obstacle, ObstacleVue obstacleVue) {
        this.obstacle = obstacle;
        this.obstacleVue = obstacleVue;
    }

    public void dessinerObstacle(Graphics graphics){
        obstacleVue.dessinerObctacle(graphics, obstacle);
    }
}
