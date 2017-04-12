package modele.forme;

import modele.Tortue;

/**
 * Created by Mel on 12/04/2017.
 */
public class Polyg extends Forme {

    private int a;
    private int n;

    public Polyg(Tortue tortue, int a, int n) {
        super(tortue);
        this.a = a;
        this.n = n;
    }

    public void deplacement() {
        for (int j=0;j<a;j++) {
            tortue.avancer(n);
            tortue.droite(360/a);
        }
    }
}
