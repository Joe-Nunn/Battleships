/**
 * Represents a 2D coordinate
 *
 * @author Joe Nunn
 * @version 20/10/2020
 */
public class Coordinate {
    int x, y;

    /**
     * Constructor where x and y are not given yet. They are set to origin 0.
     */
    public Coordinate() {
        x = 0;
        y = 0;
    }

    /**
     * Constructor where x and y are provided.
     * @param x The x value of the coordinate
     * @param y The y value of the coordinate
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter method for the x coordinate
     * @return the x coordinate
     */
    public int getX(){
        return x;
    }

    /**
     * Getter method for the y coordinate
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Setter method for the x coordinate
     * @param x the new x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Setter method for the y coordinate
     * @param y the new y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }
}