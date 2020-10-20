/**
 * Write a description of class EasyAI here.
 *
 * @author Joe Nunn
 * @version 20/10/2020
 */
public class EasyAI extends AI {
    /**
     * Constructor for objects of class EasyAI
     */
    public EasyAI() {
    }

    @Override public TargetReport chooseTarget(Grid playerGrid) {
        return new TargetReport();
    }
}
