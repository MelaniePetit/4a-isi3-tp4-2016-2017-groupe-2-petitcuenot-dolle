package modele.obstacle;


import vue.obstacleVue.RectangleObstacleVue;

/**
 *
 * Created by Mel on 03/05/2017.
 */
public class RectangleObstacle extends Obstacle {

    private int largeur;

    public RectangleObstacle(int longueur, int x, int y, int largeur) {
        super(longueur, x, y);
        this.largeur = largeur;
    }


    @Override
    public boolean estDansObstacle(int x, int y) {
        return (x >= this.x && x <= this.x + taille) && (y >= this.y && y <= this.y + largeur);

    }

    public int getLargeur() {
        return largeur;
    }
}
