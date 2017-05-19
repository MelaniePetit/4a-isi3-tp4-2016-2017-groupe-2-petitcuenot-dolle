package modele.environnement;

import modele.obstacle.CarreObstacle;
import modele.obstacle.CercleObstacle;
import modele.obstacle.RectangleObstacle;
import vue.obstacleVue.CarreObstacleVue;
import vue.obstacleVue.CercleObstacleVue;
import vue.obstacleVue.ObstacleVue;
import vue.obstacleVue.RectangleObstacleVue;

import java.util.ArrayList;

/**
 * Created by jeremy on 19/05/2017.
 */
public class BorderedEnvironment extends Environment{


    @Override
    public Environment buildEnvironment() {
        int x=0;
        int y=-80;
        for (int i = 1 ; i<3 ; i++){
            getListeObstacle().add(new RectangleObstacle(900, x,y,100));
            getListObstacleVues().add(new RectangleObstacleVue());
            x = 0;
            y = 680;
        }
        x=-80;
        y=0;
        for (int i = 1 ; i<3 ; i++){
            getListeObstacle().add(new RectangleObstacle(100, x,y,700));
            getListObstacleVues().add(new RectangleObstacleVue());
            x=880;
        }
        return this;
    }
}
