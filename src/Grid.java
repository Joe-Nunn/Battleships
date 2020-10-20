/**
 * Represents a grid in Battleships
 *
 * @author Joe Nunn
 * @version 20/10/2020
 */
public class Grid
{
    final static int WIDTH = 10, HEIGHT = 10;
    Tile[][] tiles;

    /**
     * Constructor for objects of class Grid
     * Creates a new Tile object for each index in the grid
     */
    public Grid(){
        tiles = new Tile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x++){
            for (int y = 0; y < HEIGHT; y++){
                tiles[x][y] = new Tile();
            }
        }
    }

    /**
     * Checks the validity of a coordinate.
     * Coordinates must be greater or equal to 0. x must be lower than WIDTH. Y must be lower
     * than HEIGHT.
     *
     * @param coordinate The coordinate to be validated
     * @return true if valid false if not
     */
    private boolean validCoordinate(Coordinate coordinate){
        if (coordinate.getX() >= 0 || coordinate.getX() < WIDTH ||
                coordinate.getY() >= 0 || coordinate.getY() < HEIGHT){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Target the tile at the given coordinate to damage any occupying ship.
     * @param coordinate describing x and y coordinate to target
     * @return target report
     */
    public TargetReport target(Coordinate coordinate){
        TargetReport targetReport;
        if (validCoordinate(coordinate)){
            targetReport = tiles[coordinate.getX()][coordinate.getY()].target();
        } else {
            targetReport = new TargetReport();
            targetReport.setTargetResult(TargetResult.INVALID_TARGET);
        }
        targetReport.setCoordinate(coordinate);
        return targetReport;
    }

    /**
     * Checks that a ship of a given length starting at a given coordinate continuing in a line
     * in a given direction will stay within the confines of the grid and will not overlap with
     * an already placed ship
     * @param length how long the ship is
     * @param coordinate describing x and y coordinate of the start of the ship
     * @param direction The direction that the ship continues in
     * @return true if valid false if not
     */
    private boolean placementValid(int length, Coordinate coordinate, Direction direction) {
        boolean valid = true;
        int i = 0;
        while (valid && i < length) {
            if (validCoordinate(coordinate)) {
                if (tiles[coordinate.getX()][coordinate.getY()].containsShip()) {
                    valid = false;
                } else {
                    i++;
                    coordinate = direction.move(coordinate);
                }
            } else {
                valid = false;
            }
        }
        return valid;
    }

    /**
     * Places the ship on the grip starting from the given coordinate in the given direction
     * @param ship The ship to be placed on the grid
     * @param coordinate The coordinate that the ship starts from
     * @param direction The direction the ship continues in
     * @return true if the ship was placed, false if the ship placement location is invalid
     */
    public boolean placeShip(Ship ship, Coordinate coordinate, Direction direction) {
        if (placementValid(ship.getType().getSize(), coordinate, direction)){
            for (int i = 0; i < ship.getType().getSize(); i++){
                tiles[coordinate.getX()][coordinate.getY()].placeShip(ship);
                coordinate = direction.move(coordinate);
            }
            return true;
        }else{
            return false;
        }
    }
}
