package modele.forme;

import modele.Tortue;

/**
 * Created by Mel on 12/04/2017.
 */
public class Spiral extends Forme {

    private int n;
    private int k;
    private int a;

    public Spiral(Tortue tortue, int n, int k, int a) {
        super(tortue);
        this.n = n;
        this.a = a;
        this.k = k;
        deplacement();
    }

    public void deplacement() {
        for (int i = 0; i < k; i++) {
            tortue.couleurSuivante();
            tortue.couleur(tortue.getCouleur()+1);
            tortue.avancer(n);
            tortue.droite(360/a);
            n = n+1;
        }
    }
}
