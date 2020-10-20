/**
 * Represents the state of a ship in Battleships. Its name and its health.
 * @author Joe Nunn
 * @version 20/10/2020
 */
public class Ship {
    private ShipType type;
    private int health;

    public Ship(ShipType type) {
        this.type = type;
        health = type.getSize();
    }

    /**
     * Getter method for ship's health.
     * @return health of the ship.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Getter method for the type of this ship
     * @return type of the ship
     */
    public ShipType getType() {
        return type;
    }

    /**
     * Decrements health of ship returns consequence of the damage .
     * @return targeting result HIT or SUNK added set in Target Report and ship type
     */
    public TargetReport target() {
        TargetReport targetReport = new TargetReport();
        health--;
        if (health < 1){
            targetReport.setTargetResult(TargetResult.SUNK);
        } else {
            targetReport.setTargetResult(TargetResult.HIT);
        }
        targetReport.setShipType(type);
        return targetReport;
    }
}