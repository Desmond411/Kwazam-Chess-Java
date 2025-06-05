

public class EndGame
{
    public EndGame()
    {
    }
    
    public static String checkWinner(boolean blueSauSide , boolean redSauSide){
        String playerWin;
        if(blueSauSide){
            playerWin="Blue";
        }
        else{
            playerWin="Red";
        }
        return playerWin;
    }
}
