package vue;

import controleur.TortueControleur;
import modele.Segment;
import modele.Tortue;

import java.awt.*;
import java.util.Iterator;

/**
 * Created by Mel on 18/04/2017.
 */
public class TortueVue {
    private Tortue tortue;
    private TortueControleur tortueControleur;
    private Polygon arrow;

    public TortueVue(Tortue tortue, TortueControleur controleur) {
        this.tortue = tortue;
        tortueControleur = controleur;
    }

    public void dessinerTortue(Graphics graph){
        if (graph==null)
            return;

        //Dessine les segments
        for(Iterator it = tortue.getListSegments().iterator(); it.hasNext();) {
            Segment seg = (Segment) it.next();
            drawSegment(graph, seg);
        }

        //Calcule les 3 coins du triangle a partir de
        // la position de la tortue p
        Point p = new Point(tortue.getX(), tortue.getY());
        arrow = new Polygon();

        //Calcule des deux bases
        //Angle de la droite
        double theta = Tortue.ratioDegRad*(-tortue.getDir());
        //Demi angle au sommet du triangle
        double alpha=Math.atan((float)Tortue.rb / (float)Tortue.rp );
        //Rayon de la fleche
        double r=Math.sqrt( Tortue.rp * Tortue.rp + Tortue.rb * Tortue.rb);
        //Sens de la fleche

        //Pointe
        Point p2=new Point((int) Math.round(p.x+r*Math.cos(theta)),
                (int) Math.round(p.y-r*Math.sin(theta)));
        arrow.addPoint(p2.x,p2.y);
        arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta + alpha) ),
                (int) Math.round( p2.y+r*Math.sin(theta + alpha) ));

        //Base2
        arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta - alpha)),
                (int) Math.round( p2.y+r*Math.sin(theta - alpha)));

        arrow.addPoint(p2.x,p2.y);

        graph.setColor(tortue.getTeteCouleur());
        graph.fillPolygon(arrow);

    }


    public void drawSegment(Graphics graph, Segment seg) {
        if (graph==null)
            return;

        graph.setColor(seg.getColor());
        graph.drawLine(seg.getPtStart().x, seg.getPtStart().y, seg.getPtEnd().x, seg.getPtEnd().y);
    }

    //Getters Setters

    public Tortue getTortue() {
        return tortue;
    }

    public Polygon getArrow() {
        return arrow;
    }
}
