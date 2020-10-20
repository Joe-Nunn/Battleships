import java.util.ArrayList;
/**
 * Represents a single game of battleships
 *
 * @author Joe Nunn
 * @version 20/10/2020
 */
public class BattleshipsGame
{
    private AI opponent;
    private Grid playerGrid, opponentGrid;
    private boolean shipsPlaced;
    private ArrayList<Ship> playerShips, opponentShips;
    private GameStatus gameStatus;

    /**
     * Constructor
     * @param difficulty the level of difficulty the opponent will play at
     */
    public BattleshipsGame(DifficultyLevel difficulty) {
        playerGrid = new Grid();
        opponentGrid = new Grid();
        playerShips = new ArrayList<>();
        opponentShips = new ArrayList<>();
        createOpponent(difficulty);
        shipsPlaced = false;
        GameStatus gameStatus = GameStatus.ONGOING;
    }

    /**
     * Creates opponent at the level of difficulty required
     * @param difficulty which the opponent will play at
     */
    private void createOpponent(DifficultyLevel difficulty) {
        switch (difficulty) {
            case VERY_EASY:
                opponent = new VeryEasyAI();
                break;
            case EASY:
                opponent = new EasyAI();
                break;
            case MEDIUM:
                opponent = new MediumAI();
                break;
            case HARD:
                opponent = new HardAI();
                break;
            case VERY_HARD:
                opponent = new VeryHardAI();
                break;
        }
    }

    /**
     * Places a ship on the players grid
     * If all 5 types of ship have been added to the players grid the opponent places its ships
     * onto its grid.
     * For the ship to be placed a ship of the same type must not be already placed onto the
     * grid, the ship must not overlap with other ships on the grid, and the type of the ship
     * must not be null.
     * @param coordinate The coordinate the ship starts from
     * @param direction The direction the ship continues in
     * @param shipType The type of ship
     * @return true if the ship has been placed, false if not
     */
    public boolean placeShip(Coordinate coordinate, Direction direction, ShipType shipType) {
        boolean shipPlaced = false;
        if (!shipsPlaced){
            if (newShipValid(shipType)) {
                Ship ship = new Ship(shipType);
                shipPlaced = playerGrid.placeShip(ship, coordinate, direction);
                if (shipPlaced) {
                    playerShips.add(ship);
                    if (playerShips.size() == 5) {
                        opponent.placeShips(opponentGrid);
                        shipsPlaced = true;
                    }
                }
            }
        }
        return shipPlaced;
    }

    /**
     * Determines if it is valid to add a ship of a certain type to playerShips.
     * The ship type must not be null.
     * Each ship type must be unique.
     * @param shipType The ship type to be checked if it is a valid addition to playerShips
     */
    private boolean newShipValid(ShipType shipType) {
        boolean valid = true;
        if (playerShips.size() >= 5){
            valid = false;
        } else {
            if (shipType == null) {
                valid = false;
            } else {
                int i = 0;
                while (i < playerShips.size() && valid) {
                    if (playerShips.get(i).getType().equals(shipType)) {
                        valid = false;
                    }
                }
            }
        }
        return valid;
    }

    /**
     * Carries out the players targetting action and then the opponents action.
     * The players action and opponents action are not carried out if not all ships have
     * been placed, or the player's coordinate is invalid or has already been targetted.
     * The player and/or opponent action(s) are not carried out if the game has been already
     * been won before their action.
     *
     * @param coordinate The coordinate of the tile the player has chosen to target
     * @return TurnReport The turn report detailing result of of the player and opponents
     *     targetting action as well as if either the player or opponent has won. If the player
     *     or opponents action did not take place their TargetReport will be null.
     */
    public TurnReport takeTurn(Coordinate coordinate) {
        TargetReport playerTargetReport = null;
        TargetReport opponentTargetReport = null;
        if (shipsPlaced){
            if (gameStatus == GameStatus.ONGOING){
                playerTargetReport = playerGrid.target(coordinate);
                if (!(playerTargetReport.getTargetResult() == TargetResult.ALREADY_TARGETED ||
                        playerTargetReport.getTargetResult() == TargetResult.INVALID_TARGET)) {
                    if (totalShipsHealth(opponentShips) < 1) {
                        gameStatus = GameStatus.PLAYER_VICTORY;
                    } else {
                        opponentTargetReport = opponent.chooseTarget(playerGrid);
                        if (totalShipsHealth(playerShips) < 1){
                            gameStatus = GameStatus.OPPONENT_VICTORY;
                        }
                    }
                }
            }
        }
        return new TurnReport(playerTargetReport, opponentTargetReport, gameStatus);
    }

    /**
     * Totals the health of all ships in an array
     * @param ships The array of ships to have their health totalled
     * @return the total of all the ship's health
     */
    private int totalShipsHealth(ArrayList<Ship> ships) {
        int totalHealth = 0;
        for (Ship ship : ships) {
            totalHealth += ship.getHealth();
        }
        return totalHealth;
    }
}
