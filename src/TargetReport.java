/**
 * Holds information from a targeting action
 *
 * @author Joe Nunn
 * @version 20/10/2020
 */
public class TargetReport {
    private Coordinate coordinate;
    private TargetResult targetResult;
    private ShipType shipType;

    public TargetReport() {
        targetResult = null;
        shipType = null;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setTargetResult(TargetResult targetResult) {
        this.targetResult = targetResult;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public TargetResult getTargetResult() {
        return targetResult;
    }

    public ShipType getShipType() {
        return shipType;
    }
}
