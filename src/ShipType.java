/**
 * Represents the ship types and their sizes
 *
 * @author Joe Nunn
 * @version 20/10/2020
 */
public enum ShipType {
    AIRCRAFT_CARRIER(5,"Aircraft carrier"), BATTLESHIP(4,"Battleship"),
    SUBMARINE(3,"Submarine"), CRUISER(3,"Cruiser"), DESTROYER(2,"Destroyer");

    private final int size;
    private final String name;

    ShipType(int size, String name) {
        this.size = size;
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        return name;
    }
}
