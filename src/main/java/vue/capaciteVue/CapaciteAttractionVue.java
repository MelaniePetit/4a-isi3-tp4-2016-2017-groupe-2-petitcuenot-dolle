package vue.capaciteVue;

import modele.Tortue;
import modele.TortueIntelligente;
import modele.capacite.Capacite;
import modele.capacite.CapaciteAttraction;
import modele.capacite.CapaciteObstacle;

import java.awt.*;

/**
 * Created by jeremy on 20/05/2017.
 */
public class CapaciteAttractionVue extends CapaciteVue {
    @Override
    public void dessinerCapacite(Graphics graphics, Capacite capacite) {
        CapaciteAttraction capaciteAttraction= (CapaciteAttraction) capacite;
        TortueIntelligente tortue = capaciteAttraction.getCurrentTortue();

        double r=Math.sqrt( Tortue.rp * Tortue.rp + Tortue.rb * Tortue.rb);
        double theta = Tortue.ratioDegRad*(-tortue.getDir());
        Point p = new Point(tortue.getX(), tortue.getY());
        Point p2 = new Point(
                (int) Math.round(p.x+r*Math.cos(theta)),
                (int) Math.round(p.y-r*Math.sin(theta))
        );

        graphics.setColor(tortue.getTeteCouleur());
        graphics.drawOval((tortue.getX() + p2.x)/2 - tortue.getRayon(), (tortue.getY() + p2.y)/2 - tortue.getRayon(), tortue.getRayon()*2, tortue.getRayon()*2);

    }
}
