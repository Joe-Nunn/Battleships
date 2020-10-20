/**
 * Makes decisions on which tiles to target and where to position ships
 *
 * @author Joe Nunn
 * @version  20/10/2020
 */
public abstract class AI {
    public AI() {
    }

    abstract public TargetReport chooseTarget(Grid playerGrid);

    public void placeShips(Grid grid) {
    }
}