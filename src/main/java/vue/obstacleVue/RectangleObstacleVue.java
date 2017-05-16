package vue.obstacleVue;

import controleur.EnvironnementControleur;
import modele.obstacle.RectangleObstacle;

import java.awt.*;

/**
 * Created by Mel on 03/05/2017.
 */
public class RectangleObstacleVue extends ObstacleVue {


    public RectangleObstacleVue(EnvironnementControleur controleur) {
        super(controleur);
    }

    @Override
    public void dessinerObctacle(Graphics graphics) {
        RectangleObstacle obstacle = (RectangleObstacle) controleur.getObstacleVue(this);
        graphics.fillRect(obstacle.getX(),obstacle.getY(),obstacle.getTaille(),obstacle.getLargeur());
    }
}
