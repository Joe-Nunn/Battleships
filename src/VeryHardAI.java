/**
 * Write a description of class VeryHardAI here.
 *
 * @author Joe Nunn
 * @version 20/10/2020
 */
public class VeryHardAI extends AI {
    /**
     * Constructor for objects of class VeryHardAI
     */
    public VeryHardAI() {
    }

    @Override public TargetReport chooseTarget(Grid playerGrid) {
        return new TargetReport();
    }
}
