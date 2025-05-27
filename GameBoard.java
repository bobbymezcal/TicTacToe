import java.util.Arrays;

public class GameBoard {
    // instance fields
    private char[][] board;                                             // Declare char array to represent board
    private int size;                                                   // Size of the board 

    // constructor
    public GameBoard(int size) {
        this.size = size;                                               // Initialize size
        if (size < 3 || size > 10) {                                   // Validate size
            throw new IllegalArgumentException("Size must be between 3 and 10.");
        }
        board = new char[size][size];
        for (char[] row : board) {
            Arrays.fill(row, ' ');
        }
    }

    // method to check for winner or tie
    public char checkForWinner() {
        char winner = checkRowsCols();         // Check rows and columns for a winner
        if (winner != ' ') return winner;      // If a winner is found, return it

        winner = checkDiagonals();             // Check diagonals for a winner
        if (winner != ' ') return winner;      // If a winner is found, return it

        return checkForTie();                  // Check for a tie
    }
    // methods to check rows & columns, diagonals, and for tie
    private char checkRowsCols() {
        for (int i = 0; i < size; i++) {
            if (checkLine(board[i])) return board[i][0];      // Check row
            if (checkLine(getColumn(i))) return board[0][i];  // Check column
        }
        return ' ';
    }
    private char checkDiagonals() {
        if (checkLine(getMainDiagonal())) return board[0][0];
        if (checkLine(getAntiDiagonal())) return board[0][size - 1];
        return ' ';
    }
    // method to check for tie
    private char checkForTie() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') return ' '; // If an empty cell exists, no tie yet
            }
        }
        return 'T';  // No empty spaces = tie
    }
    // helper method to get column as array
    private char[] getColumn(int colIndex) {
        char[] column = new char[size];
        for (int i = 0; i < size; i++) {
            column[i] = board[i][colIndex];
        }
        return column;
    }
    // helper method to extract main diagonal
    private char[] getMainDiagonal() {
        char[] diagonal = new char[size];
        for (int i = 0; i < size; i++) {
            diagonal[i] = board[i][i];
        }
        return diagonal;
    }
    // helper method to extract anti-diagonal
    private char[] getAntiDiagonal() {
        char[] diagonal = new char[size];
        for (int i = 0; i < size; i++) {
            diagonal[i] = board[i][size - 1 - i];
        }
        return diagonal;
    }
    // helper method to check if all elements in row/column match
    private boolean checkLine(char[] line) {
        char first = line[0];
        if (first == ' ') return false;  // Ignore empty spaces
        for (char cell : line) {
            if (cell != first) return false;
        }
        return true;  // All elements matched
    }

    // method to make a move
    public char makeMove(int row, int col, char currentPlayer) {
        row--; col--; // Adjust for 0-based index

        if (row < 0 || row >= this.size || col < 0 || col >= this.size) return 'E'; // Invalid index
        if (board[row][col] != ' ') return 'E';  // Space already occupied

        board[row][col] = currentPlayer;
        return checkForWinner();
}

    // getter methods
    public char[][] getBoard() {
        return board;                          // Return the current state of the board
    }
    public char getCell(int row, int col) {
        row--; col--; // Adjust for 0-based index
        if (row < 0 || row >= this.size || col < 0 || col >= this.size) return 'E'; // Error for invalid index
        return board[row][col];
}
}