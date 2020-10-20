/**
 * Represents a tile in Battleships. Can only contain one ship.
 *
 * @author Joe Nunn
 * @version 20/10/2020
 */
public class Tile {
    private boolean hasBeenTargeted;
    private Ship ship;

    public Tile() {
        hasBeenTargeted = false;
        ship = null;
    }

    /**
     * Sets a ship as occupying this tile
     * @param ship the ship to be set as occupying the tile
     */
    public void placeShip(Ship ship) {
        this.ship = ship;
    }

    /**
     * Determines if a ship occupies this tile or not.
     * @return true if a ship occupies this tile, false if not.
     */
    public boolean containsShip() {
        if (ship == null){
            return false;
        } else {
            return true;
        }
    }

    /**
     * Getter method for the ship that occupies the ship
     * @return ship that occupies the tile, can be null
     */
    public Ship getShip() {
        return ship;
    }

    /**
     * Determines if target() has been called before.
     * @return true if previously targeted, false or not.
     */
    public boolean previouslyTargeted() {
        return hasBeenTargeted;
    }

    /**
     * Target this tile to damage any occupying ship.
     * @return targeting report with ship type and target result
     */
    public TargetReport target() {
        TargetReport targetReport;
        if (hasBeenTargeted){
            targetReport = new TargetReport();
            targetReport.setTargetResult(TargetResult.ALREADY_TARGETED);
        } else {
            if (containsShip()){
                targetReport = (ship.target());
            } else {
                targetReport = new TargetReport();
                targetReport.setTargetResult(TargetResult.MISS);
            }
        }
        return targetReport;
    }
}
