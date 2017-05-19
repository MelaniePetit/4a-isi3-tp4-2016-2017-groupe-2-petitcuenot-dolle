package modele;

import modele.environnement.Environment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

/**
 * Created by Mel on 18/04/2017.
 */
public class FeuilleDessin extends Observable {
    private ArrayList<Tortue> tortues;
    private Environment environment = null;

    public FeuilleDessin() {
        tortues = new ArrayList<Tortue>();
    }

    public void ajouterTortue(Tortue t) {
        tortues.add(t);
        environment.getListeTortue().add(t);
    }

    public void supprimerTortue(){
        if (tortues.size() > 1) {
            tortues.remove(tortues.size()-1);
            return;
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
            ((TortueAutonome) tortue).avancer(tortues, environment);
        }
    }

    //GETTERS SETTERS
    public ArrayList<Tortue> getTortues() {
        return tortues;
    }
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
