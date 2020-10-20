/**
 * Write a description of class MediumAI here.
 *
 * @author Joe Nunn
 * @version 20/10/2020
 */
public class MediumAI extends AI {
    /**
     * Constructor for objects of class MediumAI
     */
    public MediumAI() {
    }

    @Override public TargetReport chooseTarget(Grid playerGrid) {
        return new TargetReport();
    }
}
