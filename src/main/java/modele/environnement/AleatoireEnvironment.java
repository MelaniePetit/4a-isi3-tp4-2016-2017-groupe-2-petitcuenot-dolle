package modele.environnement;

import modele.obstacle.CarreObstacle;
import modele.obstacle.CercleObstacle;
import modele.obstacle.RectangleObstacle;
import vue.obstacleVue.CarreObstacleVue;
import vue.obstacleVue.CercleObstacleVue;
import vue.obstacleVue.ObstacleVue;
import vue.obstacleVue.RectangleObstacleVue;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jeremy on 19/05/2017.
 */
public class AleatoireEnvironment extends Environment {

    @Override
    public Environment buildEnvironment() {
        Random r = new Random();

        for (int i = 1 ; i<6 ; i++){
            int forme = r.nextInt(3);
            switch (forme){
                case 0 :
                    getListeObstacle().add(new CarreObstacle(200, r.nextInt(900),r.nextInt(700)));
                    getListObstacleVues().add(new CarreObstacleVue());
                    break;
                case 1 :
                    getListeObstacle().add(new RectangleObstacle(200, r.nextInt(900), r.nextInt(700), 100));
                    getListObstacleVues().add(new RectangleObstacleVue());
                    break;
                case 2 :
                    getListeObstacle().add(new CercleObstacle(200, r.nextInt(900), r.nextInt(700)));
                    getListObstacleVues().add(new CercleObstacleVue());
                    break;
            }
        }
        return this;
    }
}
