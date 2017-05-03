package vue.obstacleVue;

import controleur.EnvironnementControleur;

import java.awt.*;

/**
 * Created by Mel on 03/05/2017.
 */
public abstract class ObstacleVue {

    EnvironnementControleur controleur;

    public ObstacleVue(EnvironnementControleur controleur) {
        this.controleur = controleur;
    }

    public abstract void dessinerObctacle(Graphics graphics);
}
