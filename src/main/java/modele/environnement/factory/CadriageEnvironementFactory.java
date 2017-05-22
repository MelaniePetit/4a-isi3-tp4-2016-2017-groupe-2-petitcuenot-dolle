package modele.environnement.factory;

import modele.environnement.Environment;
import modele.obstacle.CarreObstacle;
import modele.obstacle.RectangleObstacle;
import vue.obstacleVue.CarreObstacleVue;
import vue.obstacleVue.RectangleObstacleVue;

/**
 * Created by jeremy on 21/05/2017.
 */
public class CadriageEnvironementFactory extends EnvironementFactory{

    @Override
    public Environment buildEnvironment() {
        environment = new Environment();
        for (int col=0; col<=environment.getWidth()/100 ; col++){
            if(col%2==0){
                for (int row = 0; row < environment.getHeight()/100; row+=2) {
                    if (col==0 || col==(environment.getWidth()/100)-1){
                        environment.getListeObstacle().add(new RectangleObstacle(100, col*100,row*100, 200));
                        environment.getListObstacleVues().add(new RectangleObstacleVue());
                    }
                    else{
                        environment.getListeObstacle().add(new CarreObstacle(100, col*100,row*100));
                        environment.getListObstacleVues().add(new CarreObstacleVue());
                    }
                }
            }
            else {
                for (int row = 0; row < environment.getHeight()/100; row+=2) {
                    if (row==0 || row==(environment.getHeight()/100)-1){
                        environment.getListeObstacle().add(new CarreObstacle(100, col*100,row*100));
                        environment.getListObstacleVues().add(new CarreObstacleVue());
                    }
                }
            }

        }
        return environment;
    }
}
