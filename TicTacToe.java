import java.util.HashMap;

public class TicTacToe {
    // Instance fields
    private String player1;                  // Declare a string to represent player 1
    private String player2;                  // Declare a string to represent player 2
    private boolean gameOver;                // Declare a boolean to keep track of whether the game is over
    private boolean successfulMove;          // Declare a boolean to keep track of whether the previous move was successful  


    // Declare a HashMap to keep track of the winners
    private static HashMap<Character, Integer> winnerMap = new HashMap<>(); 
    static {
        winnerMap.put('X', 0);     // Initialize the HashMap with the values for X
        winnerMap.put('O', 0);     // Initialize the HashMap with the values for O
        winnerMap.put('T', 0);     // Initialize the HashMap with the values for Tie
    }



    // main method
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe("Player 1", "Player 2"); // Create a new TicTacToe object
        TicTacToeBoard board = new TicTacToeBoard(); // Create a new TicTacToeBoard object

        // Print the welcome message
        System.out.println("\n\nWelcome to Tic Tac Toe!\n");
        System.out.println("Player X: " + game.player1);
        System.out.println("Player O: " + game.player2);
        System.out.println("\nX goes first!");
        System.out.println("\nHere is the board:");
        System.out.print(board.toString()); // Print the board

        game.successfulMove = board.makeMove(1, 1); // Example move
        System.out.println("Player X made a move at (1, 1)"+ "\n");
        System.out.print(board.toString()); // Print the board again
        game.gameOver = board.isGameOver(); // Check for a winner
        System.out.println(game.gameOver ? "Game over! " + board.checkForWinner() + " has won!" : "No winner yet\n\n" + //
                        ""); // Print whether the game is over

        game.successfulMove = board.makeMove(2, 2); // Example move
        System.out.println("Player X made a move at (2, 2)"+ "\n");
        System.out.print(board.toString()); // Print the board again
        game.gameOver = board.isGameOver(); // Check for a winner
        System.out.println(game.gameOver ? "Game over! " + board.checkForWinner() + " has won!" : "No winner yet\n\n" + //
                        ""); // Print whether the game is over

        game.successfulMove = board.makeMove(1, 3); // Example move
        System.out.println("Player X made a move at (2, 2)"+ "\n");
        System.out.print(board.toString()); // Print the board again
        game.gameOver = board.isGameOver(); // Check for a winner
        System.out.println(game.gameOver ? "Game over! " + board.checkForWinner() + " has won!" : "No winner yet\n\n" + //
                        ""); // Print whether the game is over

        game.successfulMove = board.makeMove(2, 2); // Example move
        System.out.println("Player X made a move at (2, 2)"+ "\n");
        System.out.print(board.toString()); // Print the board again
        game.gameOver = board.isGameOver(); // Check for a winner
        System.out.println(game.gameOver ? "Game over! " + board.checkForWinner() + " has won!" : "No winner yet\n\n" + //
                        ""); // Print whether the game is over

        game.successfulMove = board.makeMove(3, 3); // Example move
        System.out.println("Player X made a move at (2, 2)"+ "\n");
        System.out.print(board.toString()); // Print the board again
        game.gameOver = board.isGameOver(); // Check for a winner
        System.out.println(game.gameOver ? "Game over! " + board.checkForWinner() + " has won!" : "No winner yet\n\n" + //
                        ""); // Print whether the game is over

        game.successfulMove = board.makeMove(1, 2); // Example move
        System.out.println("Player X made a move at (2, 2)"+ "\n");
        System.out.print(board.toString()); // Print the board again
        game.gameOver = board.isGameOver(); // Check for a winner
        System.out.println(game.gameOver ? "Game over! " + board.checkForWinner() + " has won!" : "No winner yet\n\n"); // Print whether the game is over
        
    }

    // constructor
    public TicTacToe(String player1, String player2) {
        this.player1 = player1; // Initialize player 1
        this.player2 = player2; // Initialize player 2
        this.gameOver = false;  // Set gameOver to false
    }



        /*
        // Game loop
        while (!gameOver) {
            // Print welcome message
            // Get player names
            // Print the board
            // Get the next player's move
            // Update the board
            // Check if the game is over
                // if the game is over, ask if the players want to play again
            

        }
        */
    

}