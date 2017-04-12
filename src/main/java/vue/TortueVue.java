package vue;// package logo;

import modele.Segment;
import modele.Tortue;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class TortueVue extends JPanel implements Observer {

	private ArrayList<Tortue> tortues; // la liste des tortues enregistrees

	
	public TortueVue() {
		tortues = new ArrayList<Tortue>();
	}

	public void addTortue(Tortue o) {
		tortues.add(o);
	}

	public void reset() {
		for (Iterator it = tortues.iterator(); it.hasNext();) {
			Tortue t = (Tortue) it.next();
			t.reset();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Color c = g.getColor();
		
		Dimension dim = getSize();
		g.setColor(Color.white);
		g.fillRect(0,0,dim.width, dim.height);
		g.setColor(c);

		showTurtles(g);
	}
	
	public void showTurtles(Graphics g) {
		for(Iterator it = tortues.iterator();it.hasNext();) {
			Tortue t = (Tortue) it.next();
			drawTurtle(g, t);
		}
	}

	public void drawTurtle (Graphics graph, Tortue tortue) {
		if (graph==null)
			return;
//		Graphics2D graph2D = (Graphics2D) graph;
		 //Dessine les segments
		for(Iterator it = tortue.getListSegments().iterator(); it.hasNext();) {
			Segment seg = (Segment) it.next();
			seg.drawSegment(graph);
		}

//		//Calcule les 3 coins du triangle a partir de
//		// la position de la tortue p
//		Point p = new Point(tortue.getX(), tortue.getY());
//		Polygon arrow = new Polygon();
//
//		//Calcule des deux bases
//		//Angle de la droite
//		double theta = Tortue.getRatioDegRad()*(-tortue.getDir());
//		//Demi angle au sommet du triangle
//		double alpha=Math.atan( Tortue.getRb() / Tortue.getRp() );
//		//Rayon de la fleche
//		double r=Math.sqrt( Tortue.getRp()*Tortue.getRp() + Tortue.getRb()*Tortue.getRb() );
//		//Sens de la fleche
//
//		//Pointe
//		Point p2=new Point((int) Math.round(p.x+r*Math.cos(theta)),
//				(int) Math.round(p.y-r*Math.sin(theta)));
//		arrow.addPoint(p2.x,p2.y);
//		arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta + alpha) ),
//				(int) Math.round( p2.y+r*Math.sin(theta + alpha) ));
//
//		//Base2
//		arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta - alpha) ),
//				(int) Math.round( p2.y+r*Math.sin(theta - alpha) ));
//
//		arrow.addPoint(p2.x,p2.y);

		graph.setColor(Color.GREEN);
		graph.drawOval(tortue.getX() - 10, tortue.getY() - 10, 2*10, 2*10);

		repaint();
	}

	public void update(Observable o, Object arg) {
		repaint();
	}
}
