package modele.environnement.factory;

import modele.environnement.Environment;
import modele.environnement.MazeEnvironement;

/**
 * Created by jeremy on 20/05/2017.
 */
public class MazeEnvironementFactory implements EnvironementFactory {

    MazeEnvironement mazeEnvironement;

    @Override
    public Environment buildEnvironment() {
        mazeEnvironement = new MazeEnvironement();
        return mazeEnvironement.buildEnvironment();
    }
}
