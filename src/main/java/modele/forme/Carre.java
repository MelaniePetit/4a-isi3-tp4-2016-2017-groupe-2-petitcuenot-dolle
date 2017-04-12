package modele.forme;

import modele.Tortue;

/**
 * Created by Mel on 12/04/2017.
 */
public class Carre extends Forme {

    public Carre(Tortue tortue) {
        super(tortue);
    }

    public void deplacement() {
        for (int i=0;i<4;i++) {
            tortue.avancer(100);
            tortue.droite(90);
        }
    }
}
