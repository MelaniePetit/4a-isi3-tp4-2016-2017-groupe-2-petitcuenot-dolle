package modele.obstacle;

/**
 * Created by Mel on 03/05/2017.
 */
public class CercleObstacle extends Obstacle {

    public CercleObstacle(int taille, int x, int y) {
        super(taille, x, y);
    }

    @Override
    public boolean estDansObstacle(int x, int y) {
        int distance = (int) Math.sqrt(Math.pow((double)x - (double) this.x, 2) + Math.pow((double) y - (double) this.y, 2));
        return distance <= taille;
    }
}
