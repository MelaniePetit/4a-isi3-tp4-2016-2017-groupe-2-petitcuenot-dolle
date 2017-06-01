package vue.capaciteVue;

import modele.capacite.Capacite;
import modele.capacite.CapaciteObjectif;

import java.awt.*;

/**
 * Created by jeremy on 24/05/2017.
 */
public class CapaciteObjectifPointVue extends CapaciteVue {
    @Override
    public void dessinerCapacite(Graphics graphics, Capacite capacite) {
        CapaciteObjectif capaciteObjectif = (CapaciteObjectif) capacite;

        graphics.fillOval((int)capaciteObjectif.getPointObjectif().getX()-5,(int)capaciteObjectif.getPointObjectif().getY()-5,10,10);
    }
}
