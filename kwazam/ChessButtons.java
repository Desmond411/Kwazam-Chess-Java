import javax.swing.*;
import java.awt.*;

public class ChessButtons
{
    private String buttonType;
    private String buttonSide;
    private JButton btn;
    private ImageIcon image;
    private boolean moveEnd;
    private MoveStrategy moveStrategy; 
    public static ChessButtons buttonSaver;
    
    
    public ChessButtons(String btnType,String buttonSide,boolean moveEnd)
    {
        this.buttonType = btnType;
        this.buttonSide = buttonSide;
        this.moveEnd = moveEnd;
        this.btn = new JButton();
        
        switch (btnType) {
            case "Ram":
                this.moveStrategy = new RamMoveStrategy();
                break;
            case "Biz":
                this.moveStrategy = new BizMoveStrategy();
                break;
            case "Tor":
                this.moveStrategy = new TorMoveStrategy();
                break;
            case "Xor":
                this.moveStrategy = new XorMoveStrategy();
                break;
            case "Sau":
                this.moveStrategy = new SauMoveStrategy();
                break;
            default:
                this.moveStrategy = null; // No movement for empty squares
        }
        
        
        if(buttonType.equals("Ram")){
            if(buttonSide.equals("Red")){
                ImageIcon image = new ImageIcon("images//Ram_R.png");
                Image scaledImage = image.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                ImageIcon resizedImage = new ImageIcon(scaledImage);
                this.image = resizedImage;
                btn.setIcon(resizedImage);
                //need to put a pic here for Red Ram 
            }else if(buttonSide.equals("Blue")){
                ImageIcon image = new ImageIcon("images//Ram_B.jpg");
                Image scaledImage = image.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                ImageIcon resizedImage = new ImageIcon(scaledImage);
                this.image = resizedImage;
                btn.setIcon(resizedImage);
                //need to put a pic here for Blue Ram
            }
            // for checking every button work (del this)
            //ImageIcon image = new ImageIcon("D:\\Degree_Year2\\Degree_Y2_SEM1\\CCP6224-OOAD\\BlueJ\\Tutorial_Lab\\OOAD-Assignment-Test3\\images\\Ram_B.jpg");
            
        }else if(buttonType.equals("Biz")){
             if(buttonSide.equals("Red")){
                ImageIcon image = new ImageIcon("images//Biz_R.png");
                Image scaledImage = image.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                ImageIcon resizedImage = new ImageIcon(scaledImage);
                this.image = resizedImage;
                btn.setIcon(resizedImage);
                //need to put a pic here for Red Ram 
            }else if(buttonSide.equals("Blue")){
                ImageIcon image = new ImageIcon("images//Biz_B.png");
                Image scaledImage = image.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                ImageIcon resizedImage = new ImageIcon(scaledImage);
                this.image = resizedImage;
                btn.setIcon(resizedImage);
                //need to put a pic here for Blue Ram
            }
        }else if(buttonType.equals("Tor")){
            if(buttonSide.equals("Red")){
                ImageIcon image = new ImageIcon("images//Tor_R.jpg");
                Image scaledImage = image.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                ImageIcon resizedImage = new ImageIcon(scaledImage);
                this.image = resizedImage;
                btn.setIcon(resizedImage);
            }else if(buttonSide.equals("Blue")){
                ImageIcon image = new ImageIcon("images//Tor_B.png");
                Image scaledImage = image.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                ImageIcon resizedImage = new ImageIcon(scaledImage);
                this.image = resizedImage;
                btn.setIcon(resizedImage);
            }    
        }else if(buttonType.equals("Xor")){
            if(buttonSide.equals("Red")){
                ImageIcon image = new ImageIcon("images//bishop_R.jpg");
                Image scaledImage = image.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                ImageIcon resizedImage = new ImageIcon(scaledImage);
                this.image = resizedImage;
                btn.setIcon(resizedImage);
                }else if(buttonSide.equals("Blue")){
                ImageIcon image = new ImageIcon("images//bishop_B.png");
                Image scaledImage = image.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                ImageIcon resizedImage = new ImageIcon(scaledImage);
                this.image = resizedImage;
                btn.setIcon(resizedImage);
            }
        }else if(buttonType.equals("Sau")){
             if(buttonSide.equals("Red")){
                ImageIcon image = new ImageIcon("images//Sau_R.png");
                Image scaledImage = image.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                ImageIcon resizedImage = new ImageIcon(scaledImage);
                this.image = resizedImage;
                btn.setIcon(resizedImage);
                //need to put a pic here for Red Ram 
            }else if(buttonSide.equals("Blue")){
                ImageIcon image = new ImageIcon("images//Sau_B.png");
                Image scaledImage = image.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                ImageIcon resizedImage = new ImageIcon(scaledImage);
                this.image = resizedImage;
                btn.setIcon(resizedImage);
                //need to put a pic here for Blue Ram
            }
        }
        btn.setPreferredSize(new Dimension(50, 50));
    }
    
    public void move(ChessButtons[] chessBox) {
        if (moveStrategy != null) {
            moveStrategy.move(this, chessBox);
        }
    }

    
    public JButton getBtn()
    {
        return btn;
    }
    
    public void setBtnMoveEnd(boolean RamMoveEnd)
    {
        this.moveEnd = RamMoveEnd;
    }
    
    public boolean getBtnMoveEnd()
    {
        return moveEnd;
    }
    
    public void setBtnSide(String buttonSide)
    {
        this.buttonSide = buttonSide;
    }
    
    public String getBtnSide()
    {
        return buttonSide;
    }
    
    public void setBtnType(String buttonType)
    {
        this.buttonType = buttonType;
    }
    
    public String getBtnType()
    {
        return buttonType;
    }
    
    public void setBtnImage(ImageIcon img)
    {
        this.image = img;
    }
    
    public ImageIcon getBtnImage()
    {
        return image;
    }
    
    public void clearBtn()
    {
        this.buttonType = "";
        this.buttonSide = "";
    }
    
    public static void setLastButtonMemory(ChessButtons lastButton)
    {
        buttonSaver = lastButton;
    }
}
