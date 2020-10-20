/**
 * Holds the information from both the player's targetting attempt and the opponents
 *
 * @author Joe Nunn
 * @version 20/10/2020
 */
public class TurnReport
{
    TargetReport playerTargetReport, opponentTargetReport;
    GameStatus gameStatus;

    public TurnReport(
            TargetReport playerTargetReport,
            TargetReport opponentTargetReport,
            GameStatus gameStatus){

        this.playerTargetReport = playerTargetReport;
        this.opponentTargetReport = opponentTargetReport;
        this.gameStatus = gameStatus;
    }

    public TargetReport getPlayerTargetReport(){
        return playerTargetReport;
    }

    public TargetReport getOpponentTargetReport(){
        return opponentTargetReport;
    }

    public GameStatus getGameStatus(){
        return gameStatus;
    }
}
