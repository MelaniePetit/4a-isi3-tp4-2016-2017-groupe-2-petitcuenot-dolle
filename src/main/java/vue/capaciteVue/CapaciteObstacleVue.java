package vue.capaciteVue;

import modele.Tortue;
import modele.TortueIntelligente;
import modele.capacite.Capacite;
import modele.capacite.CapaciteObstacle;

import java.awt.*;

/**
 * Created by jeremy on 20/05/2017.
 */
public class CapaciteObstacleVue extends CapaciteVue {
    @Override
    public void dessinerCapacite(Graphics graphics, Capacite capacite) {
        CapaciteObstacle capaciteObstacle = (CapaciteObstacle) capacite;
        TortueIntelligente tortue = capaciteObstacle.getCurrentTortue();

        double r=Math.sqrt( Tortue.rp * Tortue.rp + Tortue.rb * Tortue.rb);
        double theta = Tortue.ratioDegRad * (-tortue.getDir()+capaciteObstacle.getEcart());
        double theta2 = Tortue.ratioDegRad * (-tortue.getDir()-capaciteObstacle.getEcart());

        graphics.setColor(tortue.getTeteCouleur());
        graphics.fillRect(
                (int)Math.round(tortue.getX() + (capaciteObstacle.getSize() * r * Math.cos(theta))),
                (int)Math.round(tortue.getY() - (capaciteObstacle.getSize() * r * Math.sin(theta))),
                2,
                2
        );
        graphics.fillRect(
                (int)Math.round(tortue.getX() + (capaciteObstacle.getSize() * r * Math.cos(theta2))),
                (int)Math.round(tortue.getY() - (capaciteObstacle.getSize() * r * Math.sin(theta2))),
                2,
                2
        );
    }
}
