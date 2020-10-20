/**
 * Constants are possible results from targeting a tile
 *
 * @author Joe Nunn
 * @version 20/10/2020
 */
public enum TargetResult {
    MISS("Miss"), HIT("Hit"), SUNK("Sunk"), ALREADY_TARGETED("Already targeted"),
    INVALID_TARGET("Invalid target");

    private final String name;

    TargetResult(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
