package modele.capacite;

import modele.Tortue;
import modele.TortueIntelligente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeremy on 21/05/2017.
 */
public class CapaciteCouleurAttraction extends CapaciteAttraction {

    public CapaciteCouleurAttraction(TortueIntelligente currentTortue, int rayon) {
        super(currentTortue, rayon);
    }

    @Override
    public void detecterVoisines(ArrayList<Tortue> toutesLesTortues) {
        List<Tortue> voisins = new ArrayList<>();
        for (Tortue autreTortue : toutesLesTortues) {
            if (currentTortue.equals(autreTortue)) {
                continue;
            }
            if (estDansMaVision(autreTortue)) {
                if(autreTortue.getTeteCouleur() == currentTortue.getTeteCouleur())
                    voisins.add(autreTortue);
            }
        }
        if (!voisins.contains(currentTortue))
            voisins.add(currentTortue);
        this.voisins = voisins;
    }
}
