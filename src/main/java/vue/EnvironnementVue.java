package vue;

import controleur.EnvironnementControleur;
import modele.obstacle.Obstacle;
import vue.obstacleVue.ObstacleVue;

import java.awt.*;

/**
 * Created by Mel on 03/05/2017.
 */
public class EnvironnementVue {
    private EnvironnementControleur environnementControleur;

    public EnvironnementVue(EnvironnementControleur controleur) {
        environnementControleur = controleur;
    }

    public void dessinerEnvironnement(Graphics graphics){
        for(ObstacleVue obstacleVue : environnementControleur.getListObstacleVue()){
            obstacleVue.dessinerObctacle(graphics);
        }
    }
}
