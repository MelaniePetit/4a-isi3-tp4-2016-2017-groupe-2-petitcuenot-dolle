package modele.environnement.factory;

import modele.environnement.BorderedEnvironment;
import modele.environnement.Environment;
import modele.environnement.QuadriageEnironement;

/**
 * Created by jeremy on 21/05/2017.
 */
public class CadriageEnvironementFactory implements EnvironementFactory{

    @Override
    public Environment buildEnvironment() {
        Environment environment = new QuadriageEnironement();
        return environment.buildEnvironment();
    }
}
