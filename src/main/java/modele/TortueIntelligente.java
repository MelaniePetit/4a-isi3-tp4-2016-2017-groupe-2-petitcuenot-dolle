package modele;


import modele.obstacle.Obstacle;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Tortue se déplaçant seule prenant en compte son environnement (tortues voisines)
 */

public class TortueIntelligente extends TortueAutonome {

    //Faire deux types de champs de vision, un pour les voisin assez large, un pour les obstacles plutot proche de corps

    private int distMin;
    private Point nez;
    private Point moustache;

    public TortueIntelligente() {
        super();
        rayon = 50;
        nez = detecteurObstacle(1);
        moustache = detecteurObstacle(2);
    }

    @Override
    public void avancer(ArrayList<Tortue> toutesLesTortues, ArrayList<Obstacle> obstacles) {
        //detecter les voisines
        ArrayList<Tortue> listeTortuesVoisines = new ArrayList<>();
        detecterVoisines(toutesLesTortues, listeTortuesVoisines);

        distMin = Integer.MAX_VALUE;
        //Mettre une direction et une vitesse moyenne
        if (listeTortuesVoisines.size() > 1) {
            int directioGlobal = 0;
            int vitesseGlobal = 0;
            int distTest = 0;
            for (Tortue tortueASuivre : listeTortuesVoisines) {
                directioGlobal += tortueASuivre.dir;
                vitesseGlobal += tortueASuivre.vitesse;

                if (this.equals(tortueASuivre)) continue;
                distTest = this.distanceVoisine(tortueASuivre);
                if (distTest < distMin) {
                    distMin = distTest;
                }

            }
            directioGlobal /= listeTortuesVoisines.size();
            vitesseGlobal /= listeTortuesVoisines.size();

            if (distMin < 20) {
                vitesseGlobal = (int) (vitesseGlobal + 5 * Math.random());
            }

            this.dir = directioGlobal;
            this.vitesse = vitesseGlobal;
        }

        detecterObstacle(obstacles);
        nez = detecteurObstacle(1);
        moustache = detecteurObstacle(2);

//        //si pas de voisine, la tortue modifie sa direction
//        if (listeTortuesVoisines.size() == 1){
//            Random rand = new Random();
//            if (Math.random() == 0)
//                dir =  dir + rand.nextInt(5)+1;
//            else
//                dir =  dir - rand.nextInt(5)+1;
//
//        }
        super.avancer(toutesLesTortues, obstacles);

    }

    @Override
    public void reset() {
        x = 1000 / 2;
        y = 800 / 2;

        Random r = new Random();
        x = r.nextInt(1000);
        y = r.nextInt(800);
        teteCouleur = decodeColor(r.nextInt(12));
        dir = r.nextInt(360) + 1;
        vitesse = r.nextInt(30);

        notifier();

    }

    public Point detecteurObstacle(float size){
        double theta = Tortue.ratioDegRad*(-dir);
        double r=Math.sqrt(rp * rp + rb * rb);

        if (vitesse > 20)
            size = size * 2;
        return new Point((int) Math.round(x + (size * r * Math.cos(theta))),
                (int) Math.round(y - (size * r * Math.sin(theta))));
    }

    public int distanceVoisine(Tortue voisine) {
        return (int) Math.sqrt(Math.pow((double) voisine.getX() - (double) this.x, 2) + Math.pow((double) voisine.getY() - (double) this.y, 2));
    }

    public boolean estDansMaVision(Tortue voisine) {
        int dist = distanceVoisine(voisine);
        if (dist < rayon) {
            return true;
        } else
            return false;

    }

    public synchronized void detecterObstacle(ArrayList<Obstacle> obstacles){
        for (Obstacle o : obstacles) {
            if (o.estDansObstacle(nez.x, nez.y) || o.estDansObstacle(moustache.x, moustache.y)){
                dir = dir + 90;
                break;
            }
        }
    }

    public synchronized void detecterVoisines(ArrayList<Tortue> toutesLesTortues,  ArrayList<Tortue> listeTortuesVoisines){
        for (Tortue autreTortue : toutesLesTortues) {
            if (this.equals(autreTortue)) {
                continue;
            }
            if (estDansMaVision(autreTortue)) {
                listeTortuesVoisines.add(autreTortue);
            }
        }
        listeTortuesVoisines.add(this);
    }

    public Point getMoustache() {
        return moustache;
    }
}

