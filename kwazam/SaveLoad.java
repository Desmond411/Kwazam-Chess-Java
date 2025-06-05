import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class SaveLoad
{
    private String buttonText;
    private JButton btn;
    public static ChessButtons[] savedChessBox;

    public SaveLoad(String btnText)
    {
        this.buttonText = btnText;
        this.btn = new JButton(buttonText);
        btn.setPreferredSize(new Dimension(50, 10));
    }
    
    public JButton getBtn()
    {
        return btn;
    }
    
    public String getBtnText()
    {
        return buttonText;
    }
}
