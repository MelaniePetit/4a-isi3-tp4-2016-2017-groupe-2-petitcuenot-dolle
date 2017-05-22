package modele.environnement.factory;

import modele.environnement.Environment;
import modele.obstacle.CarreObstacle;
import modele.obstacle.CercleObstacle;
import vue.obstacleVue.CarreObstacleVue;
import vue.obstacleVue.CercleObstacleVue;

import java.util.Random;

/**
 * Created by jeremy on 20/05/2017.
 */
public class MazeEnvironementFactory extends EnvironementFactory {

    @Override
    public Environment buildEnvironment() {
        environment = new Environment();
        for (int i=0; i<environment.getWidth() ; i+=40){
            for (int j=0; j<environment.getHeight(); j+=40){
                Random r = new Random();
                if (i==0 || j==0 || i==environment.getWidth()-40 || j==environment.getHeight()-40){
                    environment.getListeObstacle().add(new CarreObstacle(40, i,j));
                    environment.getListObstacleVues().add(new CarreObstacleVue());
                }
                else if(70<r.nextInt(100)){
                    environment.getListeObstacle().add(new CercleObstacle(40, i,j));
                    environment.getListObstacleVues().add(new CercleObstacleVue());
                }
            }
        }
        return environment;
    }
}