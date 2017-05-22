package modele.environnement.factory;

import modele.environnement.Environment;

/**
 * Created by jeremy on 19/05/2017.
 */
public abstract class EnvironementFactory {

    Environment environment;
    public abstract Environment buildEnvironment();
}
