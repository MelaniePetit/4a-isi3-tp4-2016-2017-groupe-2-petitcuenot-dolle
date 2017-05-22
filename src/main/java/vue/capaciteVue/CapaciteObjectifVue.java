package vue.capaciteVue;

import modele.Tortue;
import modele.TortueIntelligente;
import modele.capacite.Capacite;
import modele.capacite.CapaciteObjectif;
import modele.capacite.CapaciteObstacle;

import java.awt.*;

/**
 * Created by Mel on 22/05/2017.
 */
public class CapaciteObjectifVue extends CapaciteVue{
    @Override
    public void dessinerCapacite(Graphics graphics, Capacite capacite) {
        CapaciteObjectif capaciteObjectif = (CapaciteObjectif) capacite;
        TortueIntelligente tortue = capaciteObjectif.getTortue();

        double r=Math.sqrt( Tortue.rp * Tortue.rp + Tortue.rb * Tortue.rb);
        Point p = new Point(tortue.getX(), tortue.getY());
        double theta = Tortue.ratioDegRad*(-tortue.getDir());

        Point pointe=new Point((int) Math.round(p.x+r*Math.cos(theta)),
                (int) Math.round(p.y-r*Math.sin(theta)));

        graphics.setColor(tortue.getTeteCouleur());
        graphics.drawLine(pointe.x,pointe.y,((CapaciteObjectif) capacite).getPointObjectif().x,((CapaciteObjectif) capacite).getPointObjectif().y);
    }
}
