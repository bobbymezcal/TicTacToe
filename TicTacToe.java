public class TicTacToe {
    public static void main(String[] args) {
        // Instance fields
        // Declare booleans to keep track of whether the game is over or if there is a tie
        boolean gameOver = false;
        boolean isTie = false;
        // Declare a char to keep track of whose turn it is
        char currentPlayer = 'X';

        // Declare a 3x3 char array to represent the board
        char[][] board = new char[3][3];
        // Initialize the board to be empty
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        // Method to check for a winner
        public char checkForWinner(char[][] board){
            // Check rows
            for (int i = 0; i < 3; i++) {
                if(board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                    return board[i][0];
                }
            }
            // Check columns
            for (int j = 0; j < 3; j++) {
                if(board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                    return board[0][j];
                }
            }
            // Check diagonals
            if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
                return board[0][0];
            }
            if(board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
                return board[0][2];
            }
            // No winner
            return ' ';

        }



        // Game loop
        while (!gameOver) {
            // Print the board
            // Get the player's move
            // Update the board
            // Check if the game is over
            // Clear the console
            // Switch players
        }
    }

}