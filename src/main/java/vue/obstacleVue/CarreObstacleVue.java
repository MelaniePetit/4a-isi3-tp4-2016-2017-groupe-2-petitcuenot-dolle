package vue.obstacleVue;

import controleur.EnvironnementControleur;
import modele.obstacle.Obstacle;
import modele.obstacle.RectangleObstacle;

import java.awt.*;

/**
 * Created by Mel on 03/05/2017.
 */
public class CarreObstacleVue extends ObstacleVue {

    public CarreObstacleVue(EnvironnementControleur controleur) {
        super(controleur);
    }

    @Override
    public void dessinerObctacle(Graphics graphics) {
        Obstacle obstacle = controleur.getObstacle(this);
        graphics.fillRect(obstacle.getX(),obstacle.getY(),obstacle.getTaille(),obstacle.getTaille());
    }
}
