package modele;


import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Tortue se déplaçant seule prenant en compte son environnement (tortues voisines)
 */

public class TortueIntelligente extends TortueAutonome {

    private int rayonVision = 50;
    private int distMin;

    public TortueIntelligente() {
        super();
    }

    @Override
    public void avancer(ArrayList<Tortue> toutesLesTortues) {
        //detecter les voisines
        ArrayList<Tortue> listeTortuesVoisines = new ArrayList<>();
        for (Tortue autreTortue : toutesLesTortues){
            if(this.equals(autreTortue)){continue;
            }
            if(this.estDansMaVision(autreTortue)){
                listeTortuesVoisines.add(autreTortue);
            }
        }
        listeTortuesVoisines.add(this);


        distMin = Integer.MAX_VALUE;
        //Mettre une direction et une vitesse moyenne
        if (listeTortuesVoisines.size() > 1){
            int directioGlobal = 0;
            int vitesseGlobal = 0;
            int distTest = 0;
            for (Tortue tortueASuivre : listeTortuesVoisines){
                directioGlobal += tortueASuivre.dir;
                vitesseGlobal += tortueASuivre.vitesse;

                if (this.equals(tortueASuivre)) continue;
                distTest = this.distanceVoisine(tortueASuivre);
                if (distTest < distMin){
                    distMin = distTest;
                }

            }
            directioGlobal /= listeTortuesVoisines.size();
            vitesseGlobal /= listeTortuesVoisines.size();

            if (distMin < 20){
                Random r = new Random();
                vitesseGlobal = (int)(vitesseGlobal + 5*Math.random());
            }

            this.dir = directioGlobal;
            this.vitesse = vitesseGlobal;
        }

        //si pas de voisine, la tortue modifie sa direction
        if (listeTortuesVoisines.size() == 1){
            Random rand = new Random();
            if (Math.random() == 0)
                dir =  dir + rand.nextInt(5)+1;
            else
                dir =  dir - rand.nextInt(5)+1;

        }

        super.avancer(toutesLesTortues);

    }

    @Override
    public void reset(){
        x = 1000/2;
        y = 800/2;

        Random r = new Random();
        x = r.nextInt(1000);
        y = r.nextInt(800);
        teteCouleur = decodeColor(r.nextInt(12));
        dir = r.nextInt(360)+1;
        vitesse = r.nextInt(50);

        notifier();

    }

    public int distanceVoisine(Tortue voisine){
        double i = Math.sqrt((voisine.getX() - this.x)^2 + (voisine.getY() - this.y)^2);

        int j = (int) Math.sqrt(Math.pow((double) voisine.getX() - (double) this.x, 2) + Math.pow((double) voisine.getY() - (double) this.y, 2));
        return j;
    }

    public boolean estDansMaVision(Tortue voisine){
        int dist = distanceVoisine(voisine);
        if (dist < rayonVision){
            return true;
        }
        else
            return false;

    }

    public void detecterVoisines(){

    }

    //Gerer la vision, le deplacement groupe, la vitesse moyenne et la direction

}
