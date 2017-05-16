package vue.obstacleVue;


import controleur.EnvironnementControleur;
import modele.obstacle.Obstacle;

import java.awt.*;

/**
 * Created by Mel on 03/05/2017.
 */
public class CercleObstacleVue extends ObstacleVue {

    public CercleObstacleVue(EnvironnementControleur controleur) {
        super(controleur);
    }

    @Override
    public void dessinerObctacle(Graphics graphics) {
        Obstacle obstacle = controleur.getObstacleVue(this);
        graphics.fillOval(obstacle.getX(),obstacle.getY(),obstacle.getTaille(),obstacle.getTaille());
    }
}
