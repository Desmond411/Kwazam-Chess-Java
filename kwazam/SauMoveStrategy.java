import java.awt.*;
import javax.swing.*;
import java.io.*;


public class SauMoveStrategy implements MoveStrategy{
    @Override
    public void move(ChessButtons chessBtn, ChessButtons[] chessBox) {
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
    
        int[] directions = {-6, -5, -4, -1, +1, +4, +5, +6}; // One step in all directions
        int currentRow = currentPos / 5;
        int currentCol = currentPos % 5;
    
        for (int dir : directions) {
            int newPos = currentPos + dir;
            if (newPos >= 0 && newPos < 40) {
                int newRow = newPos / 5;
                int newCol = newPos % 5;
    
                // Ensure the move is within bounds (e.g., no wrapping across rows)
                if (Math.abs(newRow - currentRow) <= 1 && Math.abs(newCol - currentCol) <= 1) {
                    checkAndHighlightMoveSau(newPos, chessBox);
                }
            }
        }
    
        // Highlight selected piece
        chessBtn.getBtn().setBackground(Color.RED);
        chessBtn.getBtn().setEnabled(true);
    }
    
    
private static boolean checkAndHighlightMoveSau(int newPos, ChessButtons[] chessBox) {
        if (newPos >= 0 && newPos < 40) {
            // If the square is empty
            if (chessBox[newPos].getBtnType().equals("")) {
                chessBox[newPos].getBtn().setBackground(Color.GREEN);
                chessBox[newPos].getBtn().setEnabled(true);
                return true;
            }
            // If the square has an enemy piece
            else if (!chessBox[newPos].getBtnSide().equals(Info.sideTurn)) {
                chessBox[newPos].getBtn().setBackground(Color.GREEN); // Mark as capturable
                chessBox[newPos].getBtn().setEnabled(true);
                return true; // Path not blocked
            }
        }
        return false; // Invalid move
    }
}