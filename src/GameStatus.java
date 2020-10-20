/**
 * Constants are possible outcomes after a turn of the game
 *
 * @author Joe Nunn
 * @version 20/10/2020
 */
public enum GameStatus {
    PLAYER_VICTORY("Player victory"), OPPONENT_VICTORY("AI player victory"), ONGOING("Ongoing");

    private final String name;

    GameStatus(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}