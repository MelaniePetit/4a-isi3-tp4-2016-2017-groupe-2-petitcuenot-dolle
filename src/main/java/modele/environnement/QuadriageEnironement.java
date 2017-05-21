package modele.environnement;

import modele.obstacle.CarreObstacle;
import modele.obstacle.CercleObstacle;
import modele.obstacle.RectangleObstacle;
import vue.obstacleVue.CarreObstacleVue;
import vue.obstacleVue.CercleObstacleVue;
import vue.obstacleVue.RectangleObstacleVue;

import java.util.Random;

/**
 * Created by jeremy on 21/05/2017.
 */
public class QuadriageEnironement extends Environment {
    private int width=900;
    private int height=700;

    @Override
    public Environment buildEnvironment() {
        for (int col=0; col<=width/100 ; col++){
            if(col%2==0){
                for (int row = 0; row < height/100; row+=2) {
                    if (col==0 || col==(width/100)-1){
                        getListeObstacle().add(new RectangleObstacle(100, col*100,row*100, 200));
                        getListObstacleVues().add(new RectangleObstacleVue());
                    }
                    else{
                        getListeObstacle().add(new CarreObstacle(100, col*100,row*100));
                        getListObstacleVues().add(new CarreObstacleVue());
                    }
                }
            }
            else {
                for (int row = 0; row < height/100; row+=2) {
                    if (row==0 || row==(height/100)-1){
                        getListeObstacle().add(new CarreObstacle(100, col*100,row*100));
                        getListObstacleVues().add(new CarreObstacleVue());
                    }
                }
            }

        }
        return this;
    }
}