package modele.environnement;

import modele.obstacle.CarreObstacle;
import modele.obstacle.CercleObstacle;
import modele.obstacle.RectangleObstacle;
import vue.obstacleVue.CarreObstacleVue;
import vue.obstacleVue.CercleObstacleVue;
import vue.obstacleVue.RectangleObstacleVue;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jeremy on 20/05/2017.
 */
public class MazeEnvironement extends Environment{
    private ArrayList<CarreObstacle> murs;
    private int width=800;
    private int height=600;

    @Override
    public Environment buildEnvironment() {
        for (int i=0; i<width ; i+=40){
            for (int j=0; j<height ; j+=40){
                Random r = new Random();
                if (i==0 || j==0 || i==width-40 || j==height-40){
                    getListeObstacle().add(new CarreObstacle(40, i,j));
                    getListObstacleVues().add(new CarreObstacleVue());
                }
                else if(70<r.nextInt(100)){
                    getListeObstacle().add(new CercleObstacle(40, i,j));
                    getListObstacleVues().add(new CercleObstacleVue());
                }
            }
        }
        return this;
    }
}
