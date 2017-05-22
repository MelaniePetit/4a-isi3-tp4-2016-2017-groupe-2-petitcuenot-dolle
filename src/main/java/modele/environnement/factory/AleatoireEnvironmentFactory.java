package modele.environnement.factory;

import modele.environnement.Environment;
import modele.obstacle.CarreObstacle;
import modele.obstacle.CercleObstacle;
import modele.obstacle.RectangleObstacle;
import vue.obstacleVue.CarreObstacleVue;
import vue.obstacleVue.CercleObstacleVue;
import vue.obstacleVue.RectangleObstacleVue;

import java.util.Random;

/**
 * Created by jeremy on 19/05/2017.
 */
public class AleatoireEnvironmentFactory extends EnvironementFactory{

    @Override
    public Environment buildEnvironment() {
        environment = new Environment();
        Random r = new Random();

        for (int i = 1 ; i<6 ; i++){
            int forme = r.nextInt(3);
            switch (forme){
                case 0 :
                    environment.getListeObstacle().add(new CarreObstacle(200, r.nextInt(900),r.nextInt(700)));
                    environment.getListObstacleVues().add(new CarreObstacleVue());
                    break;
                case 1 :
                    environment.getListeObstacle().add(new RectangleObstacle(200, r.nextInt(900), r.nextInt(700), 100));
                    environment.getListObstacleVues().add(new RectangleObstacleVue());
                    break;
                case 2 :
                    environment.getListeObstacle().add(new CercleObstacle(200, r.nextInt(900), r.nextInt(700)));
                    environment.getListObstacleVues().add(new CercleObstacleVue());
                    break;
            }
        }
        return environment;
    }


}
