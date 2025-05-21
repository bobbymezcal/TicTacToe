import java.util.HashMap;

public class TicTacToe {
    // Instance fields
    private String player1;                  // Declare a string to represent player 1
    private String player2;                  // Declare a string to represent player 2
    private boolean gameOver;                // Declare a boolean to keep track of whether the game is over  

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
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Player X: " + game.player1);
        System.out.println("Player O: " + game.player2);
        System.out.println("X goes first!");
        System.out.println("Here is the board:");
        System.out.print(board.toString()); // Print the board
        
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