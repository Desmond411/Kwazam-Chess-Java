import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ButtonController implements ActionListener {
    private ChessButtons chessBtn; 
    private ChessButtons[] chessBox;
    private Info chessTurn;
    private JFrame frame;
    private boolean isInMoveMode = false; 

    public ButtonController(JFrame frame) {
        this.frame = frame;
    }

    public ButtonController(ChessButtons[] chessBox, Info chessTurn, JFrame frame) {
        this.chessBox = chessBox;
        this.chessTurn = chessTurn;
        this.frame = frame;
    }

    public ButtonController(ChessButtons chessBtn, ChessButtons[] chessBox, Info chessTurn, JFrame frame) {
        this.chessBtn = chessBtn;
        this.chessBox = chessBox;
        this.chessTurn = chessTurn;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String clickedBtn = e.getActionCommand();

        // Handle Start button click
        if (clickedBtn.equals("Start")) {
            BtnModels.modelStart(frame);
        }
        // Handle Save button click
        else if (clickedBtn.equals("Save")) {
            BtnModels.modelSave(chessBox, chessTurn);
        }
        // Handle Load button click
        else if (clickedBtn.equals("Load")) {
            BtnModels.modelLoad(frame, chessBox);
        }
        // Handle Green button click (valid move)
        else if (chessBtn.getBtn().getBackground() == Color.GREEN) {
            BtnModels.greenBtn(chessBtn, chessBox, chessTurn, frame);
            isInMoveMode = false; 
        }
        // Handle Red button click (invalid move or cancel)
        else if (chessBtn.getBtn().getBackground() == Color.RED) {
            BtnModels.redBtn(chessBtn, chessBox);
            isInMoveMode = false;
        }
        // Handle piece selection and movement
        else if (chessBtn.getBtnSide().equals(Info.sideTurn)) {
            // Use the Strategy Pattern to handle piece movement
            chessBtn.move(chessBox); // Delegate movement logic to the ChessButtons object
            isInMoveMode = true;
            ChessButtons.setLastButtonMemory(chessBtn); // Save the last clicked button
        }
    }
}