import java.util.HashMap;

public class TicTacToeBoard {
    // instance fields
    private char[][] board;                  // Declare a 3x3 char array to represent the board
    private char currentPlayer;              // Declare a char to keep track of whose turn it is
    private boolean gameOver;                // Declare booleans to keep track of whether the game is over or if there is a tie
    private boolean isTie;                   // Declare booleans to keep track of whether the game is over or if there is a tie
    private char winner;                     // Declare a char to keep track of the winner


    // constructor
    public TicTacToeBoard() {
        board = new char[3][3];              // Initialize the board to be empty
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';           // Fill the board with empty spaces
            }
        }
        currentPlayer = 'X';                 // Set the current player to 'X'
        gameOver = false;                    // Set gameOver to false
        isTie = false;                       // Set isTie to false
    }


    // instance methods
    public char checkForWinner() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                this.gameOver = true;        // Set gameOver to true
                this.isTie = false;          // Set isTie to false
                return board[i][0];          // Return the winner
            }
        }
        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                this.gameOver = true;        // Set gameOver to true
                this.isTie = false;          // Set isTie to false
                return board[0][j];
            }
        }
        // Check diagonals
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2];
        }
        // No winner
        return ' ';
    }

    public boolean makeMove(int row, int col) {
        row--; // Adjust for 0-based index
        col--; // Adjust for 0-based index
        if (board[row][col] == ' ') {          // Check if the cell is empty
            board[row][col] = currentPlayer;   // Update the board
            this.winner = checkForWinner();    // Check for a winner
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // Switch players
            return true;                       // Return true if the move was successful
        } else {
            System.out.println("Cell already occupied. Try again.");
            return false;                      // Return false if the move was not successful
        }
    }

    // getter methods
    public String toString() {
        String board = "        COL 1 | COL 2 | COL 3\n";
        board += "------------------------------\n";
        for (int i = 0; i < 3; i++) {
            board += "ROW " + (i + 1) + " |";
            for (int j = 0; j < 3; j++) {
                board += "   " + this.board[i][j] + "   ";
                if (j < 2) {
                    board += "|";
                } else {
                    board += "|\n";
                }
            }
            if (i < 2) {
                board += "------------------------------\n";
            } else {
                board += "------------------------------\n";
            }
        }
        return board;
    }

    public boolean isGameOver() {
        return gameOver;                      // Return whether the game is over
    }

}
