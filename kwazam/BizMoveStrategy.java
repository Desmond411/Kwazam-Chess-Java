// Biz movement strategy
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class BizMoveStrategy implements MoveStrategy {
    @Override
    public void move(ChessButtons chessBtn, ChessButtons[] chessBox) {
        // Logic for Biz movement (from BtnModels.modelBiz)
        int currentPos = -1;
        for (int i = 0; i < 40; i++) {
            if (chessBox[i].getBtn() == chessBtn.getBtn()) {
                currentPos = i;
                break;
            }
        }

        int section = currentPos % 5;

        for (int i = 0; i < 40; i++) {
            chessBox[i].getBtn().setBackground(null);
            chessBox[i].getBtn().setEnabled(false);
        }

        if (section == 0) {
            checkAndHighlightMove(currentPos + 7, chessBox);
            checkAndHighlightMove(currentPos - 3, chessBox);
            checkAndHighlightMove(currentPos - 9, chessBox);
            checkAndHighlightMove(currentPos + 11, chessBox);
        } else if (section == 1) {
             checkAndHighlightMove(currentPos - 11, chessBox);  
            checkAndHighlightMove(currentPos + 9, chessBox);
            checkAndHighlightMove(currentPos - 9, chessBox);
            checkAndHighlightMove(currentPos - 3, chessBox);
            checkAndHighlightMove(currentPos + 7, chessBox);  // Left 2, Up 1
            checkAndHighlightMove(currentPos +11, chessBox);  // Left 2, Down 1
        }
        // Section 2 (middle)
        else if (section == 2) {
            checkAndHighlightMove(currentPos + 7, chessBox);
            checkAndHighlightMove(currentPos - 3, chessBox);
            checkAndHighlightMove(currentPos + 9, chessBox);
            checkAndHighlightMove(currentPos - 11, chessBox);
            checkAndHighlightMove(currentPos + 3, chessBox);
            checkAndHighlightMove(currentPos - 7, chessBox);
            checkAndHighlightMove(currentPos + 11, chessBox); // Right 1, Up 2
            checkAndHighlightMove(currentPos - 9, chessBox);  // Right 1, Down 2
        }
        // Section 3
        else if (section == 3) {
            checkAndHighlightMove(currentPos + 9, chessBox);
            checkAndHighlightMove(currentPos - 11, chessBox);
            checkAndHighlightMove(currentPos + 11, chessBox);
            checkAndHighlightMove(currentPos - 9, chessBox);
            checkAndHighlightMove(currentPos - 7, chessBox);
            checkAndHighlightMove(currentPos + 3, chessBox);
        }
        // Section 4 (rightmost column)
        else if (section == 4) {
            checkAndHighlightMove(currentPos + 3, chessBox);
            checkAndHighlightMove(currentPos - 7, chessBox);
            checkAndHighlightMove(currentPos - 11, chessBox);
            checkAndHighlightMove(currentPos + 9, chessBox);
        }

        chessBtn.getBtn().setBackground(Color.RED);
        chessBtn.getBtn().setEnabled(true);
    }

    private void checkAndHighlightMove(int newPos, ChessButtons[] chessBox) {
        if (newPos >= 0 && newPos < 40) {
            if (chessBox[newPos].getBtnType().equals("") || !chessBox[newPos].getBtnSide().equals(Info.sideTurn)) {
                chessBox[newPos].getBtn().setBackground(Color.GREEN);
                chessBox[newPos].getBtn().setEnabled(true);
            }
        }
    }
}