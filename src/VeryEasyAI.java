/**
 * Write a description of class VeryEasyAI here.
 *
 * @author Joe Nunn
 * @version 20/10/2020
 */
public class VeryEasyAI extends AI {
    /**
     * Constructor for objects of class VeryEasyAI
     */
    public VeryEasyAI() {
    }

    @Override public TargetReport chooseTarget(Grid playerGrid) {
        return new TargetReport();
    }
}
