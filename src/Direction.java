/**
 * Constants are all the possible directions in the game
 *
 * @author Joe Nunn
 * @version 20/10/2020
 */
public enum Direction{
    UP("Up"){
        @Override Coordinate move(Coordinate coordinate){
            coordinate.setY(coordinate.getY() + 1);
            return coordinate;
        }
    },
    DOWN("Down"){
        @Override Coordinate move(Coordinate coordinate){
            coordinate.setY(coordinate.getY() - 1);
            return coordinate;
        }
    },
    LEFT("Left"){
        @Override Coordinate move(Coordinate coordinate){
            coordinate.setX(coordinate.getX() - 1);
            return coordinate;
        }
    },
    RIGHT("Right"){
        @Override Coordinate move(Coordinate coordinate){
            coordinate.setY(coordinate.getY() +1 );
            return coordinate;
        }
    };

    private final String name;

    Direction(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

    /**
     * Moves the coordinate towards the direction by 1
     * @param  coordinate to be moved
     * @return the coordinate moved towards the direction by 1
     */
    abstract Coordinate move(Coordinate coordinate);
}