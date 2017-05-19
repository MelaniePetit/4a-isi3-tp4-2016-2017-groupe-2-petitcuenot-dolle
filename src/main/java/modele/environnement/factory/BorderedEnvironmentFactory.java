package modele.environnement.factory;

import modele.environnement.BorderedEnvironment;
import modele.environnement.Environment;

/**
 * Created by jeremy on 19/05/2017.
 */
public class BorderedEnvironmentFactory implements EnvironementFactory {

    BorderedEnvironment environment;

    @Override
    public Environment buildEnvironment() {
        environment = new BorderedEnvironment();
        return environment.buildEnvironment();
    }

}
