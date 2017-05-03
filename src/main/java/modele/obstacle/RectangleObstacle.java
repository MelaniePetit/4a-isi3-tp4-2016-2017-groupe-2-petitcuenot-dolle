package modele.obstacle;

/**
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
        return (x >= this.x && x <= this.x + largeur) && (y >= this.y && y <= this.y + taille);

    }

    public int getLargeur() {
        return largeur;
    }
}
