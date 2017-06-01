package modele.capacite;

import modele.Tortue;
import modele.TortueIntelligente;
import modele.environnement.Environment;

import java.awt.*;

/**
 * Created by Mel on 22/05/2017.
 */
public class CapaciteCurseur extends CapaciteObjectif {

    public CapaciteCurseur(TortueIntelligente tortue) {
        super(tortue, new Point(100,100));

    }

    @Override
    public void lancerCapacité(Environment environment) {
        setPointObjectif( MouseInfo.getPointerInfo().getLocation());
        super.lancerCapacité(environment);
    }
}
