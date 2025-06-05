import java.awt.*;
import javax.swing.*;
import java.io.*;


public class XorMoveStrategy implements MoveStrategy{
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
        int startRow = currentPos / 5;
        int startCol = currentPos % 5;
        // Check top-left diagonal
        for (int pos = currentPos - 6; pos >= 0; pos -= 6) {
            int newRow = pos / 5;
            int newCol = pos % 5;
            if (newRow != startRow - 1 || newCol != startCol - 1) break; // Stop if not diagonal
            if (!checkAndHighlightMove1(pos, chessBox)) break; // Stop if blocked
            startRow--;
            startCol--;
        }
        startRow = currentPos / 5;
        startCol = currentPos % 5;
        // Check top-right diagonal
        for (int pos = currentPos - 4; pos >= 0; pos -= 4) {
            int newRow = pos / 5;
            int newCol = pos % 5;
            if (newRow != startRow - 1 || newCol != startCol + 1) break; // Stop if not diagonal
            if (!checkAndHighlightMove1(pos, chessBox)) break; // Stop if blocked
            startRow--;
            startCol++;
        }
        startRow = currentPos / 5;
        startCol = currentPos % 5;
        // Check bottom-left diagonal
        for (int pos = currentPos + 4; pos < 40; pos += 4) {
            int newRow = pos / 5;
            int newCol = pos % 5;
            if (newRow != startRow + 1 || newCol != startCol - 1) break; // Stop if not diagonal
            if (!checkAndHighlightMove1(pos, chessBox)) break; // Stop if blocked
            startRow++;
            startCol--;
        }
        startRow = currentPos / 5;
        startCol = currentPos % 5;
        // Check bottom-right diagonal
        for (int pos = currentPos + 6; pos < 40; pos += 6) {
            int newRow = pos / 5;
            int newCol = pos % 5;
            if (newRow != startRow + 1 || newCol != startCol + 1) break; // Stop if not diagonal
            if (!checkAndHighlightMove1(pos, chessBox)) break; // Stop if blocked
            startRow++;
            startCol++;
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