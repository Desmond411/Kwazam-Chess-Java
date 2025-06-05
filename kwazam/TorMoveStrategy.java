
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class TorMoveStrategy implements MoveStrategy {
    @Override
    public void move(ChessButtons chessBtn, ChessButtons[] chessBox){
        int currentPos = -1;
        for (int i = 0; i < 40; i++) {
            if (chessBox[i].getBtn() == chessBtn.getBtn()) {
                currentPos = i;
                break;
            }
        }
        
        // Disable all buttons initially
        for (int i = 0; i < 40; i++) {
            chessBox[i].getBtn().setBackground(null);
            chessBox[i].getBtn().setEnabled(false);
        }
        
        // Check up direction
        for (int pos = currentPos - 5; pos >= 0; pos -= 5) {
            if (!checkAndHighlightMove1(pos, chessBox)) break; // Stop if blocked
        }
        
        // Check down direction
        for (int pos = currentPos + 5; pos < 40; pos += 5) {
            if (!checkAndHighlightMove1(pos, chessBox)) break; // Stop if blocked
        }
        
        // Check left direction
        int row = currentPos / 5;
        int startOfRow = row * 5;
        for (int pos = currentPos - 1; pos >= startOfRow; pos--) {
            if (!checkAndHighlightMove1(pos, chessBox)) break; // Stop if blocked
        }
        
        // Check right direction
        int endOfRow = startOfRow + 4;
        for (int pos = currentPos + 1; pos <= endOfRow; pos++) {
            if (!checkAndHighlightMove1(pos, chessBox)) break; // Stop if blocked
        }
        
        // Highlight selected piece
        chessBtn.getBtn().setBackground(Color.RED);
        chessBtn.getBtn().setEnabled(true);
    }

    private static boolean checkAndHighlightMove1(int newPos, ChessButtons[] chessBox) {
        if (newPos >= 0 && newPos < 40) {
            // If square is empty
            if (chessBox[newPos].getBtnType().equals("")) {
                chessBox[newPos].getBtn().setBackground(Color.GREEN);
                chessBox[newPos].getBtn().setEnabled(true);
                return true; // Path not blocked
            }
            // If square has enemy piece
            else if (!chessBox[newPos].getBtnSide().equals(Info.sideTurn)) {
                chessBox[newPos].getBtn().setBackground(Color.GREEN);
                chessBox[newPos].getBtn().setEnabled(true);
                return false; // Path blocked by capturable piece
            }
            return false; // Path blocked by friendly piece
        }
        return false; // Out of bounds
    }
}