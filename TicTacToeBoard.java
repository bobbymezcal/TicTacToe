import java.util.Arrays;
private static final int SIZE = 3;

public class TicTacToeBoard {
    // instance fields
    private char[][] board;                  // Declare char array to represent the board
    
    // constructor
    public TicTacToeBoard() {
        board = new char[SIZE][SIZE];
        for (char[] row : board) {
            Arrays.fill(row, ' ');
        }
    }

    // method to check for a winner or tie
    public char checkForWinner() {
        char winner = checkRowsCols();         // Check rows and columns for a winner
        if (winner != ' ') return winner;      // If a winner is found, return it

        winner = checkDiagonals();             // Check diagonals for a winner
        if (winner != ' ') return winner;      // If a winner is found, return it

        return checkForTie();                  // Check for a tie
    }
    // helper methods to check rows & columns, diagonals, and for a tie
    private char checkRowsCols() {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2])
                return board[i][0];  
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i])
                return board[0][i];  
        }
        return ' ';
    }
    private char checkDiagonals() {
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return board[0][0];  
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return board[0][2];  
        return ' ';
    }
    private char checkForTie() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') return ' '; // If an empty cell exists, no tie yet
            }
        }
        return 'T';  // No empty spaces = tie
    }
    
    // method to make a move
    public char makeMove(int row, int col, char currentPlayer) {
        row--; col--; // Adjust for 0-based index

        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) return 'E'; // Invalid index
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
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) return 'E'; // Error for invalid index
        return board[row][col];
}
}