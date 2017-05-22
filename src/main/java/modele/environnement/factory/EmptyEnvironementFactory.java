package modele.environnement.factory;

import modele.environnement.Environment;

/**
 * Created by jeremy on 21/05/2017.
 */
public class EmptyEnvironementFactory extends EnvironementFactory {

    @Override
    public Environment buildEnvironment() {
        environment = new Environment();
        return environment;
    }
}
