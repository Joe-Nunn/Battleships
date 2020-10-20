/**
 * Write a description of class HardAI here.
 *
 * @author Joe Nunn
 * @version 20/10/2020
 */
public class HardAI extends AI {
    /**
     * Constructor for objects of class HardAI
     */
    public HardAI() {
    }

    @Override public TargetReport chooseTarget(Grid playerGrid) {
        return new TargetReport();
    }
}
