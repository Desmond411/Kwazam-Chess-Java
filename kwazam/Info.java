import javax.swing.*;
import java.awt.*;
 
public class Info
{
    private JTextField textField;
    public static int Rounds = 1;
    public static int numSideTurns = 0;
    public static String sideTurn = "Red";
    public static boolean transfered = false;
    
    public Info()
    {
        this.textField = new JTextField();
        textField.setEditable(false);
    }
    
    public void setTurn()
    {
        if(numSideTurns%2 == 1){
            sideTurn = "Blue";
        }else{
            sideTurn = "Red";
        }
    }
    
    public void setTextField()
    {
        textField.setText("Side: " + sideTurn + "  Rounds: " + Rounds);
    }
    
    public static void incTurn()
    {
        numSideTurns++;
    }
    
    public static void setTransfered(boolean transfer)
    {
        transfered = transfer;
    }
    
    public static void incRounds()
    {
        if(numSideTurns%2 == 0 && numSideTurns != 0){
            Rounds++;
        }
    }
    
    public JTextField getTextField()
    {
        return textField;
    }
}
