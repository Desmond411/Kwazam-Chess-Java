import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ChessView
{
    private Info chessTurn;
    
    public ChessView(JFrame frame)
    {
        frame.getContentPane().removeAll();
        frame.repaint();
        frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(400, 500);
        
        chessTurn = new Info(); 
        chessTurn.setTextField();
        
        JPanel infoOptionPanel = new JPanel();
        infoOptionPanel.setLayout(new GridLayout(1,3));
        infoOptionPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
        infoOptionPanel.add(chessTurn.getTextField());
        
        JPanel chessPanel = new JPanel();
        chessPanel.setLayout(new GridLayout(8, 5));
        
        ChessButtons[] chessBtnBox = new ChessButtons[40];
        
        SaveLoad saveBtn = new SaveLoad("Save");
        saveBtn.getBtn().addActionListener(new ButtonController(chessBtnBox,chessTurn,frame));
        SaveLoad loadBtn = new SaveLoad("Load");
        loadBtn.getBtn().addActionListener(new ButtonController(chessBtnBox,chessTurn,frame));
        infoOptionPanel.add(saveBtn.getBtn());
        infoOptionPanel.add(loadBtn.getBtn());
        
        
        for (int i = 0; i < 40; i++) {
            if(i == 5 || i == 6 || i == 7 || i == 8 || i == 9)
            {
                ChessButtons chessBtn = new ChessButtons("Ram","Blue",false);
                chessBtn.getBtn().addActionListener(new ButtonController(chessBtn,chessBtnBox,chessTurn,frame));
                chessBtnBox[i] = chessBtn;
            }else if(i == 30 || i == 31 || i == 32 || i == 33 || i == 34){
                ChessButtons chessBtn = new ChessButtons("Ram","Red",false);
                chessBtn.getBtn().addActionListener(new ButtonController(chessBtn,chessBtnBox,chessTurn,frame));
                chessBtnBox[i] = chessBtn;
            }else if(i==1 || i==3) 
        {
           // Positions for Red Biz
            ChessButtons chessBtn = new ChessButtons("Biz","Blue",false);
            chessBtn.getBtn().addActionListener(new ButtonController(chessBtn,chessBtnBox,chessTurn,frame));
            chessBtnBox[i] = chessBtn;
        
        }
        else if(i==0){
                ChessButtons chessBtn = new ChessButtons("Tor","Blue",false);
                chessBtn.getBtn().addActionListener(new ButtonController(chessBtn,chessBtnBox,chessTurn,frame));
                chessBtnBox[i] = chessBtn;
        }
        else if(i==39){
                ChessButtons chessBtn = new ChessButtons("Tor","Red",false);
                chessBtn.getBtn().addActionListener(new ButtonController(chessBtn,chessBtnBox,chessTurn,frame));
                chessBtnBox[i] = chessBtn;
        }
        else if(i==4){
                ChessButtons chessBtn = new ChessButtons("Xor","Blue",false);
                chessBtn.getBtn().addActionListener(new ButtonController(chessBtn,chessBtnBox,chessTurn,frame));
                chessBtnBox[i] = chessBtn;
        }
        else if(i==35){
                ChessButtons chessBtn = new ChessButtons("Xor","Red",false);
                chessBtn.getBtn().addActionListener(new ButtonController(chessBtn,chessBtnBox,chessTurn,frame));
                chessBtnBox[i] = chessBtn;
        }
        else if(i==2){
                ChessButtons chessBtn = new ChessButtons("Sau","Blue",false);
                chessBtn.getBtn().addActionListener(new ButtonController(chessBtn,chessBtnBox,chessTurn,frame));
                chessBtnBox[i] = chessBtn;
        }
        else if(i==37){
                ChessButtons chessBtn = new ChessButtons("Sau","Red",false);
                chessBtn.getBtn().addActionListener(new ButtonController(chessBtn,chessBtnBox,chessTurn,frame));
                chessBtnBox[i] = chessBtn;
        }
        else if(i==36 || i==38) 
        {
           // Positions for Red Biz
            ChessButtons chessBtn = new ChessButtons("Biz","Red",false);
            chessBtn.getBtn().addActionListener(new ButtonController(chessBtn,chessBtnBox,chessTurn,frame));
            chessBtnBox[i] = chessBtn;
        
        }
            else{
                ChessButtons chessBtn = new ChessButtons("","",false);
                chessBtn.getBtn().addActionListener(new ButtonController(chessBtn,chessBtnBox,chessTurn,frame));
                chessBtnBox[i] = chessBtn;
            }
            chessPanel.add(chessBtnBox[i].getBtn());
        }
        
        frame.add(infoOptionPanel,BorderLayout.NORTH);
        frame.add(chessPanel,BorderLayout.CENTER);
        frame.setVisible(true);
        frame.revalidate();
    }
    
    public ChessView(JFrame frame,ChessButtons[] chessBox)
    {
        frame.getContentPane().removeAll();
        frame.repaint();
        frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(400, 500);
        
        chessTurn = new Info(); 
        chessTurn.setTurn();
        chessTurn.setTextField();
        
        JPanel infoOptionPanel = new JPanel();
        infoOptionPanel.setLayout(new GridLayout(1,3));
        infoOptionPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
        infoOptionPanel.add(chessTurn.getTextField());
        
        JPanel chessPanel = new JPanel();
        chessPanel.setLayout(new GridLayout(8, 5));
        
        ChessButtons[] chessBtnBox = new ChessButtons[40];
        
        SaveLoad saveBtn = new SaveLoad("Save");
        saveBtn.getBtn().addActionListener(new ButtonController(chessBtnBox,chessTurn,frame));
        SaveLoad loadBtn = new SaveLoad("Load");
        loadBtn.getBtn().addActionListener(new ButtonController(chessBtnBox,chessTurn,frame));
        infoOptionPanel.add(saveBtn.getBtn());
        infoOptionPanel.add(loadBtn.getBtn());
        
        int flip = 0;
        boolean blueSauSide = false;
        boolean redSauSide = false;
        for(int i = 39; i >= 0; i--) {
            chessBtnBox[flip] = chessBox[i];
            if(chessBox[i].getBtnType().equals("Ram")){
                ChessButtons chessBtn = new ChessButtons("Ram",chessBox[i].getBtnSide(),chessBox[i].getBtnMoveEnd());
                chessBtn.getBtn().addActionListener(new ButtonController(chessBtn,chessBtnBox,chessTurn,frame));
                chessBtnBox[flip] = chessBtn;
            }else if(chessBox[i].getBtnType().equals("Biz")) {  // Add this condition
                ChessButtons chessBtn = new ChessButtons("Biz",chessBox[i].getBtnSide(),chessBox[i].getBtnMoveEnd());
                chessBtn.getBtn().addActionListener(new ButtonController(chessBtn,chessBtnBox,chessTurn,frame));
                chessBtnBox[flip] = chessBtn;
            }else if(chessBox[i].getBtnType().equals("Tor")) {  // Add this condition
                ChessButtons chessBtn = new ChessButtons("Tor",chessBox[i].getBtnSide(),chessBox[i].getBtnMoveEnd());
                chessBtn.getBtn().addActionListener(new ButtonController(chessBtn,chessBtnBox,chessTurn,frame));
                chessBtnBox[flip] = chessBtn;
            }else if(chessBox[i].getBtnType().equals("Xor")) {  // Add this condition
                ChessButtons chessBtn = new ChessButtons("Xor",chessBox[i].getBtnSide(),chessBox[i].getBtnMoveEnd());
                chessBtn.getBtn().addActionListener(new ButtonController(chessBtn,chessBtnBox,chessTurn,frame));
                chessBtnBox[flip] = chessBtn;
            }else if(chessBox[i].getBtnType().equals("Sau")) {  // Add this condition
                ChessButtons chessBtn = new ChessButtons("Sau",chessBox[i].getBtnSide(),chessBox[i].getBtnMoveEnd());
                if(chessBox[i].getBtnSide().equals("Blue")){
                    blueSauSide = true;
                }else if(chessBox[i].getBtnSide().equals("Red")){
                    redSauSide = true;
                }
                chessBtn.getBtn().addActionListener(new ButtonController(chessBtn,chessBtnBox,chessTurn,frame));
                chessBtnBox[flip] = chessBtn;
            }else{
                ChessButtons chessBtn = new ChessButtons("","",chessBox[i].getBtnMoveEnd());
                chessBtn.getBtn().addActionListener(new ButtonController(chessBtn,chessBtnBox,chessTurn,frame));
                chessBtnBox[flip] = chessBtn;
            }
            
            chessPanel.add(chessBtnBox[flip].getBtn());
            flip++;
        }
        Info.setTransfered(false);
        frame.add(infoOptionPanel,BorderLayout.NORTH);
        frame.add(chessPanel,BorderLayout.CENTER);
        frame.setVisible(true);
        frame.revalidate();
        String Winner = "None";
        
        if(blueSauSide == false || redSauSide == false){
            for(int i = 0; i < 40; i++){
                chessBtnBox[i].getBtn().setEnabled(false);
            }
            Winner = EndGame.checkWinner(blueSauSide,redSauSide);
            GameEnd(Winner);
        }
        
    }
    
    public ChessView(ChessButtons[] chessBox,JFrame frame)
    {
        frame.getContentPane().removeAll();
        frame.repaint();
        frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(400, 500);
        
        chessTurn = new Info(); 
        chessTurn.setTurn();
        chessTurn.setTextField();
        
        JPanel infoOptionPanel = new JPanel();
        infoOptionPanel.setLayout(new GridLayout(1,3));
        infoOptionPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
        infoOptionPanel.add(chessTurn.getTextField());
        
        JPanel chessPanel = new JPanel();
        chessPanel.setLayout(new GridLayout(8, 5));
        
        ChessButtons[] chessBtnBox = new ChessButtons[40];
        
        SaveLoad saveBtn = new SaveLoad("Save");
        saveBtn.getBtn().addActionListener(new ButtonController(chessBtnBox,chessTurn,frame));
        SaveLoad loadBtn = new SaveLoad("Load");
        loadBtn.getBtn().addActionListener(new ButtonController(chessBtnBox,chessTurn,frame));
        infoOptionPanel.add(saveBtn.getBtn());
        infoOptionPanel.add(loadBtn.getBtn());
        
        int flip = 0;
        boolean blueSauSide = false;
        boolean redSauSide = false;
        for(int i = 39; i >= 0; i--) {
            chessBtnBox[flip] = chessBox[i];
            if(chessBox[i].getBtnType().equals("Ram")){
                ChessButtons chessBtn = new ChessButtons("Ram",chessBox[i].getBtnSide(),chessBox[i].getBtnMoveEnd());
                chessBtn.getBtn().addActionListener(new ButtonController(chessBtn,chessBtnBox,chessTurn,frame));
                chessBtnBox[flip] = chessBtn;
            }else if(chessBox[i].getBtnType().equals("Biz")) {  // Add this condition
                ChessButtons chessBtn = new ChessButtons("Biz",chessBox[i].getBtnSide(),chessBox[i].getBtnMoveEnd());
                chessBtn.getBtn().addActionListener(new ButtonController(chessBtn,chessBtnBox,chessTurn,frame));
                chessBtnBox[flip] = chessBtn;
            }else if(chessBox[i].getBtnType().equals("Tor")) {  // Add this condition
                ChessButtons chessBtn = new ChessButtons("Xor",chessBox[i].getBtnSide(),chessBox[i].getBtnMoveEnd());
                chessBtn.getBtn().addActionListener(new ButtonController(chessBtn,chessBtnBox,chessTurn,frame));
                chessBtnBox[flip] = chessBtn;
            }else if(chessBox[i].getBtnType().equals("Xor")) {  // Add this condition
                ChessButtons chessBtn = new ChessButtons("Tor",chessBox[i].getBtnSide(),chessBox[i].getBtnMoveEnd());
                chessBtn.getBtn().addActionListener(new ButtonController(chessBtn,chessBtnBox,chessTurn,frame));
                chessBtnBox[flip] = chessBtn;
            }else if(chessBox[i].getBtnType().equals("Sau")) {  // Add this condition
                ChessButtons chessBtn = new ChessButtons("Sau",chessBox[i].getBtnSide(),chessBox[i].getBtnMoveEnd());
                if(chessBox[i].getBtnSide().equals("Blue")){
                    blueSauSide = true;
                }else if(chessBox[i].getBtnSide().equals("Red")){
                    redSauSide = true;
                }
                chessBtn.getBtn().addActionListener(new ButtonController(chessBtn,chessBtnBox,chessTurn,frame));
                chessBtnBox[flip] = chessBtn;
            }else{
                ChessButtons chessBtn = new ChessButtons("","",chessBox[i].getBtnMoveEnd());
                chessBtn.getBtn().addActionListener(new ButtonController(chessBtn,chessBtnBox,chessTurn,frame));
                chessBtnBox[flip] = chessBtn;
            }
            
            chessPanel.add(chessBtnBox[flip].getBtn());
            flip++;
        }
        Info.setTransfered(true);
        frame.add(infoOptionPanel,BorderLayout.NORTH);
        frame.add(chessPanel,BorderLayout.CENTER);
        frame.setVisible(true);
        frame.revalidate();
        String Winner = "None";
        
        if(blueSauSide == false || redSauSide == false){
            for(int i = 0; i < 40; i++){
                chessBtnBox[i].getBtn().setEnabled(false);
            }
            Winner = EndGame.checkWinner(blueSauSide,redSauSide);
            GameEnd(Winner);
        }
    }
    
    public ChessView(JFrame frame, ChessButtons[] loadedBox, Info chessTurn) 
    {
        frame.getContentPane().removeAll();
        frame.repaint();
        frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(400, 500);
        
        chessTurn = new Info(); 
        chessTurn.setTurn();
        chessTurn.setTextField();
        
        JPanel infoOptionPanel = new JPanel();
        infoOptionPanel.setLayout(new GridLayout(1,3));
        infoOptionPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
        infoOptionPanel.add(chessTurn.getTextField());
        
        JPanel chessPanel = new JPanel();
        chessPanel.setLayout(new GridLayout(8, 5));
        
        SaveLoad saveBtn = new SaveLoad("Save");
        saveBtn.getBtn().addActionListener(new ButtonController(loadedBox,chessTurn,frame));
        SaveLoad loadBtn = new SaveLoad("Load");
        loadBtn.getBtn().addActionListener(new ButtonController(loadedBox,chessTurn,frame));
        infoOptionPanel.add(saveBtn.getBtn());
        infoOptionPanel.add(loadBtn.getBtn());
        
        
        for (int i = 0; i < 40; i++) {
            loadedBox[i].getBtn().addActionListener(new ButtonController(loadedBox[i], loadedBox, chessTurn, frame));
            chessPanel.add(loadedBox[i].getBtn());
        }
        
        frame.add(infoOptionPanel, BorderLayout.NORTH);
        frame.add(chessPanel, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.revalidate();
    }
    
    public static void handleGameLoad(JFrame frame, ChessButtons[] loadedBox, Info loadedTurn) 
    {
        JOptionPane.showMessageDialog(null, "Game loaded successfully!", "Load Successful", JOptionPane.INFORMATION_MESSAGE);
        new ChessView(frame, loadedBox, loadedTurn);
        frame.dispose(); 
    }
    
    public void GameEnd(String Winner){
        JOptionPane.showMessageDialog(null, Winner+" won the game!!", "Winner:", 
                                           JOptionPane.INFORMATION_MESSAGE);
    }
    
    
}

    
