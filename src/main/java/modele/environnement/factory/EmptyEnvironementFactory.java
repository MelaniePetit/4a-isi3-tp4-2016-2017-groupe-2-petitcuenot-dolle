package modele.environnement.factory;

import modele.environnement.EmptyEnvironement;
import modele.environnement.Environment;

/**
 * Created by jeremy on 21/05/2017.
 */
public class EmptyEnvironementFactory implements EnvironementFactory {

    @Override
    public Environment buildEnvironment() {
        EmptyEnvironement environement = new EmptyEnvironement();
        return environement.buildEnvironment();
    }
}
