package modele.environnement.factory;

import modele.environnement.Environment;
import modele.obstacle.RectangleObstacle;
import vue.obstacleVue.RectangleObstacleVue;

/**
 * Created by jeremy on 19/05/2017.
 */
public class BorderedEnvironmentFactory extends EnvironementFactory {


    @Override
    public Environment buildEnvironment() {
        environment = new Environment();
        int x=0;
        int y=-80;
        for (int i = 1 ; i<3 ; i++){
            environment.getListeObstacle().add(new RectangleObstacle(900, x,y,100));
            environment.getListObstacleVues().add(new RectangleObstacleVue());
            x = 0;
            y = 680;
        }
        x=-80;
        y=0;
        for (int i = 1 ; i<3 ; i++){
            environment.getListeObstacle().add(new RectangleObstacle(100, x,y,700));
            environment.getListObstacleVues().add(new RectangleObstacleVue());
            x=880;
        }
        return environment;
    }

}
