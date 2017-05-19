package modele.environnement.factory;

import modele.environnement.AleatoireEnvironment;
import modele.environnement.Environment;

/**
 * Created by jeremy on 19/05/2017.
 */
public class AleatoireEnvironmentFactory implements EnvironementFactory{

    AleatoireEnvironment environment;

    @Override
    public Environment buildEnvironment() {
        environment = new AleatoireEnvironment();
        return environment.buildEnvironment();
    }
}
