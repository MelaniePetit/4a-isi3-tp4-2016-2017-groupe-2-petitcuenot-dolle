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

        //Dessine le cercle de vision
//        graph.setColor(tortue.getTeteCouleur());
//        graph.drawOval((tortue.getX() + p2.x)/2 - tortue.getRayon(), (tortue.getY() + p2.y)/2 - tortue.getRayon(), tortue.getRayon()*2, tortue.getRayon()*2);


        graph.setColor(Color.BLACK);
        graph.fillRect(
                (int)Math.round(tortue.getX() + (6 * r * Math.cos(theta))),
                (int)Math.round(tortue.getY() - (6 * r * Math.sin(theta))),
                2,
                2
        );
//        double theta2 = Tortue.ratioDegRad*(-tortue.getDir()+10);
//        double theta3 = Tortue.ratioDegRad*(-tortue.getDir()-10);
//
//        graph.fillRect(
//                (int)Math.round(tortue.getX() + (6 * r * Math.cos(theta2))),
//                (int)Math.round(tortue.getY() - (6 * r * Math.sin(theta2))),
//                2,
//                2
//        );
//        graph.fillRect(
//                (int)Math.round(tortue.getX() + (6 * r * Math.cos(theta3))),
//                (int)Math.round(tortue.getY() - (6 * r * Math.sin(theta3))),
//                2,
//                2
//        );
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
