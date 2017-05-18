package modele.obstacle;

import java.awt.*;

/**
 * Created by Mel on 03/05/2017.
 */
public class CercleObstacle extends Obstacle {

    public CercleObstacle(int taille, int x, int y) {
        super(taille, x, y);
    }

    private Point getCentre(){
        return new Point(x + taille/2,y + taille/2);
    }

    @Override
    public boolean estDansObstacle(int x, int y) {
        Point centre = getCentre();
        int distance = (int) Math.sqrt(Math.pow((double)x - (double) centre.x, 2) + Math.pow((double) y - (double) centre.y, 2));
        return distance <= taille/2;
    }
}
