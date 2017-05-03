package modele.obstacle;

import java.awt.*;

/**
 * Created by Mel on 03/05/2017.
 */
public abstract class Obstacle {

    int taille;
    int x;              //coordonnée x du premier point dessiné
    int y;              //coordonnée x du premier point dessiné

    public Obstacle(int taille, int x, int y) {
        this.taille = taille;
        this.x = x;
        this.y = y;
    }

    public abstract boolean estDansObstacle(int x, int y);

    public int getTaille() {
        return taille;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
