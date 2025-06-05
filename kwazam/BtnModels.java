import java.awt.*;
import javax.swing.*;
import java.io.*;

public class BtnModels
{
    
    protected static void greenBtn(ChessButtons chessBtn, ChessButtons[] chessBox, Info chessTurn,JFrame frame)
    {
        chessBtn.getBtn().setIcon(ChessButtons.buttonSaver.getBtnImage());
        chessBtn.setBtnType(ChessButtons.buttonSaver.getBtnType());
        chessBtn.setBtnImage(ChessButtons.buttonSaver.getBtnImage());
        chessBtn.setBtnSide(ChessButtons.buttonSaver.getBtnSide());
        chessBtn.setBtnMoveEnd(ChessButtons.buttonSaver.getBtnMoveEnd());
        //System.out.println(chessBtn.getBtnType() + " 101");
        
        for (int i = 0; i < 40; i++) {
            if(chessBox[i].getBtn().getBackground() == Color.RED){
                chessBox[i].getBtn().setIcon(null);
                chessBox[i].clearBtn();
            }
            chessBox[i].getBtn().setBackground(null);
            chessBox[i].getBtn().setEnabled(true);
        }
        Info.incTurn();
        Info.incRounds();
        
        if((Info.Rounds % 4 == 3 || Info.Rounds % 4 == 1) && Info.transfered == false && Info.Rounds != 1){
            new ChessView(chessBox,frame);
        }else{
            new ChessView(frame,chessBox);
        }
        frame.dispose();
        
    }
    
    protected static void redBtn(ChessButtons chessBtn, ChessButtons[] chessBox)
    {
        for (int i = 0; i < 40; i++) {
            if(chessBtn.getBtn().getBackground() == Color.GREEN){
                chessBox[i].setBtnSide("");
            }
            chessBox[i].getBtn().setBackground(null); // Reset all button backgrounds
            chessBox[i].getBtn().setEnabled(true);    // Re-enable all buttons
        }
    }
    
    
    
    protected static void modelStart(JFrame frame)
    {
        SoundPlayer.playSound("audio//game_start.wav");
        frame.dispose();
        new ChessView(frame);
    }
    
    protected static void modelSave(ChessButtons[] chessBox, Info chessTurn)
    {
        try (BufferedWriter writeTxt = new BufferedWriter(new FileWriter("game_save.txt"))) {
            // Save the current turn ,which side and rounds
            writeTxt.write("Rounds: " + Info.Rounds + "\n");
            writeTxt.write("Turn: " + chessTurn.numSideTurns + "\n");
            writeTxt.write("SideTurn: " + chessTurn.sideTurn + "\n");
    
            // Save the chess board state, including positions and sides
            for (int i = 0; i < 40; i++) {
                ChessButtons button = chessBox[i];
                String pieceSide = button.getBtnSide();  // Blue or Red side
                String pieceType = button.getBtnType();  // Type of piece
                
                // Only save information with a piece on them
                //Ignore empty space with no piece
                if (!pieceSide.isEmpty()) {
                    writeTxt.write(i + "," + pieceSide + "," + pieceType + "\n");
                }
            }
            writeTxt.write("End");  // Mark the end of the game state
            
            //Show success message 
            JOptionPane.showMessageDialog(null,"Game saved successfully!", "Save Successful", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace(); //Show error mesage for debug
        }
    }
    
    protected static void modelLoad(JFrame frame,ChessButtons[] loadedBox) {

        Info loadedTurn = new Info(); // Object to store the restored turn
        
        boolean loadSuccess = true; 
    
        try (BufferedReader readTxt = new BufferedReader(new FileReader("game_save.txt"))) {
        
            String[] roundsData = readTxt.readLine().split(": ");
            if (roundsData[0].equals("Rounds")) {
                loadedTurn.Rounds = Integer.parseInt(roundsData[1]); // Restore the number of rounds
            }
            
            String[] turnData = readTxt.readLine().split(": ");
            if (turnData[0].equals("Turn")) {
                loadedTurn.numSideTurns = Integer.parseInt(turnData[1]); // Restore turn count
            }
    
            String[] sideTurnData = readTxt.readLine().split(": ");
            if (sideTurnData[0].equals("SideTurn")) {
                loadedTurn.sideTurn = sideTurnData[1]; // Restore which side's turn it is
            }
            
            for (int i = 0; i < 40; i++) {
                loadedBox[i] = new ChessButtons("", "", false); 
            }
    
            // Read the saved buttons from the file
            String line;
            while (!(line = readTxt.readLine()).equals("End")) {
                String[] data = line.split(",");  
                int position = Integer.parseInt(data[0]);  
                String pieceSide = data[1];  
                String pieceType = data[2];  
    
                loadedBox[position] = new ChessButtons(pieceType, pieceSide, false);
            }
        } catch (IOException e) {
            loadSuccess = false; // Handle any file reading errors
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to load game!", "Load Error", JOptionPane.ERROR_MESSAGE);
        }
    
        // If the load is successful, display the chessboard using the constructor
        if (loadSuccess) {
            ChessView.handleGameLoad(frame, loadedBox, loadedTurn);//constructor
        }
    }
}
