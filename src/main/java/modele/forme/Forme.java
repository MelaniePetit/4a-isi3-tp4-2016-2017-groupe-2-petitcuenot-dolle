package modele.forme;

import modele.Tortue;

/**
 * Created by Mel on 12/04/2017.
 */
public abstract class Forme {

    protected Tortue tortue;

    public Forme(Tortue tortue) {
        this.tortue = tortue;
    }

    public abstract void deplacement();

}
