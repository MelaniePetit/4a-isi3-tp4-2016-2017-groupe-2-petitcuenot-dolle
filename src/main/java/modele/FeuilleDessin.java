package modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

/**
 * Created by Mel on 18/04/2017.
 */
public class FeuilleDessin extends Observable {
    private ArrayList<Tortue> tortues;

    public FeuilleDessin() {
        tortues = new ArrayList<Tortue>();
    }

    public void ajouterTortue(Tortue t) {
        tortues.add(t);
    }

    public void supprimerTortue(Tortue tortue){
        if (tortues.size() > 1){
            for (Tortue t : tortues) {
                if (t == tortue){
                    tortues.remove(t);
                    return;
                }
            }
        }
        else{
            System.out.println("Impossible de supprimer la tortue, il doit en rester une");
        }
    }

    public void reset() {
        for (Iterator it = tortues.iterator(); it.hasNext();) {
            Tortue t = (Tortue) it.next();
            t.reset();
        }
    }

    public void faireAvancerTortuesAutonomes() {
        for (Tortue tortue : tortues) {
            ((TortueAutonome) tortue).avancer();
        }
    }

    //GETTERS SETTERS
    public ArrayList<Tortue> getTortues() {
        return tortues;
    }
}
