// Ram movement strategy
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class RamMoveStrategy implements MoveStrategy {
    @Override
    public void move(ChessButtons chessBtn, ChessButtons[] chessBox) {
        // Logic for Ram movement (from BtnModels.modelRam)
        int validMove = -1;
        for (int i = 0; i < 40; i++) {
            if (chessBox[i].getBtn() == chessBtn.getBtn() && i < 6) {
                chessBox[i].setBtnMoveEnd(true);
            } else if (chessBox[i].getBtn() == chessBtn.getBtn() && i > 34) {
                chessBox[i].setBtnMoveEnd(false);
            }

            if (chessBox[i].getBtn() == chessBtn.getBtn() && i - 5 >= 0 && chessBox[i].getBtnMoveEnd() == false) {
                chessBox[i - 5].getBtn().setBackground(Color.GREEN);
                chessBox[i - 5].getBtn().setEnabled(true);
                validMove = i - 5;
            } else if (chessBox[i].getBtn() == chessBtn.getBtn() && i + 5 <= 39 && chessBox[i].getBtnMoveEnd() == true) {
                chessBox[i + 5].getBtn().setBackground(Color.GREEN);
                chessBox[i + 5].getBtn().setEnabled(true);
                validMove = i + 5;
            } else if (i != validMove) {
                chessBox[i].getBtn().setBackground(null);
                chessBox[i].getBtn().setEnabled(false);
            }
        }
        chessBtn.getBtn().setBackground(Color.RED);
        chessBtn.getBtn().setEnabled(true);
        validMove = -1;
    }
}