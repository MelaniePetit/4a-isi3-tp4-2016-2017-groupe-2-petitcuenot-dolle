package modele.environnement;

/**
 * Created by jeremy on 21/05/2017.
 */
public class EmptyEnvironement extends Environment {
    @Override
    public Environment buildEnvironment() {
        return this;
    }
}
