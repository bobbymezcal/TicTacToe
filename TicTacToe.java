public class TicTacToe {
    public static void main(String[] args) {
        // Instance fields
        // Declare a boolean to keep track of whether the game is over
        boolean gameOver = false;
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