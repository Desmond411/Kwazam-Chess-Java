import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class Menus
{
    public Menus()
    {
        JFrame frame = new JFrame("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(400, 500);
        
        JButton startBtn = new JButton("Start");
        startBtn.setBackground(Color.LIGHT_GRAY);
        startBtn.setForeground(Color.BLACK);
        startBtn.addMouseListener(new HoverEffectAdapter(startBtn,Color.GREEN,Color.LIGHT_GRAY));
        startBtn.addActionListener(new ButtonController(frame));
        SaveLoad loadBtn = new SaveLoad("Load");
        startBtn.setBackground(Color.LIGHT_GRAY);
        startBtn.setForeground(Color.BLACK);
        
        ChessButtons[] chessBtnBox = new ChessButtons[40];
        Info chessTurn = new Info(); 
        
        loadBtn.getBtn().addActionListener(new ButtonController(chessBtnBox,chessTurn,frame));
        loadBtn.getBtn().addMouseListener(new HoverEffectAdapter(loadBtn.getBtn(),Color.GREEN,Color.LIGHT_GRAY));
        
        frame.setLayout(new GridLayout(2,1,0,0));
        JPanel panel = new JPanel(new GridLayout(1,1,0,0)) {
            private Image backgroundImage = new ImageIcon("images//chess_king.jpg").getImage();

                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // Draw the background image, scaled to fit the panel
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
        };
        //panel.setBackground(new Color(27,27,27));
        panel.add(startBtn);
        panel.setBorder(new EmptyBorder(90, 90,100,100));
        JPanel panel2 = new JPanel(new GridLayout(1,1,0,0)) {
            private Image backgroundImage = new ImageIcon("images//load_chess.jpg").getImage();

                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // Draw the background image, scaled to fit the panel
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
        };
        //panel2.setBackground(new Color(27,27,27));
        panel2.add(loadBtn.getBtn());
        panel2.setBorder(new EmptyBorder(90, 90, 100, 100));
        frame.add(panel,BorderLayout.NORTH);
        frame.add(panel2,BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
