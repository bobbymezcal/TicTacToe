import java.util.HashMap;

public class TicTacToe {
    // Instance fields
    private String player1;                  // Declare a string to represent player 1
    private String player2;                  // Declare a string to represent player 2
    private boolean player1Turn;             // Declare a boolean to keep track of whose turn it is
    private boolean gameOver;                // Declare a boolean to keep track of whether the game is over
    private boolean successfulMove;          // Declare a boolean to keep track of whether the previous move was successful  
    private HashMap<String, Integer> winnerMap; // Declare a HashMap to keep track of the scores of the players 
    private TicTacToeBoard currentBoard; // Declare a TicTacToeBoard object to represent the current board


    // main method
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe("Bobby", "Pau"); // Create a new TicTacToe object
        game.singleGameLoop();

        /* TESTING BASIC GAME MECHANICS
        TicTacToeBoard board = new TicTacToeBoard(); // Create a new TicTacToeBoard object

        // Print the welcome message
        System.out.println("\n\nWelcome to Tic Tac Toe!\n");

        game.displayScores(90); // Display the scores
        System.out.println("\nX goes first!");
        System.out.println("\nHere is the board:");
        System.out.print(board.toString()); // Print the board
        System.out.println(game.winnerMap);

        game.displayScores(90); // Display the scores
        game.successfulMove = board.makeMove(1, 1); // Example move
        System.out.println("Player X made a move at (1, 1)"+ "\n");
        System.out.print(board.toString()); // Print the board again
        game.gameOver = board.isGameOver(); // Check for a winner
        System.out.println(game.gameOver ? "Game over! " + board.checkForWinner() + " has won!" : "No winner yet\n\n" + //
                        ""); // Print whether the game is over
        
        game.displayScores(90); // Display the scores
        game.successfulMove = board.makeMove(2, 2); // Example move
        System.out.println("Player X made a move at (2, 2)"+ "\n");
        System.out.print(board.toString()); // Print the board again
        game.gameOver = board.isGameOver(); // Check for a winner
        System.out.println(game.gameOver ? "Game over! " + board.checkForWinner() + " has won!" : "No winner yet\n\n" + //
                        ""); // Print whether the game is over

        game.displayScores(90); // Display the scores
        game.successfulMove = board.makeMove(1, 3); // Example move
        System.out.println("Player X made a move at (1, 3)"+ "\n");
        System.out.print(board.toString()); // Print the board again
        game.gameOver = board.isGameOver(); // Check for a winner
        System.out.println(game.gameOver ? "Game over! " + board.checkForWinner() + " has won!" : "No winner yet\n\n" + //
                        ""); // Print whether the game is over

        game.displayScores(90); // Display the scores
        game.successfulMove = board.makeMove(1, 2); // Example move
        System.out.println("Player X made a move at (1, 2)"+ "\n");
        System.out.print(board.toString()); // Print the board again
        game.gameOver = board.isGameOver(); // Check for a winner
        System.out.println(game.gameOver ? "Game over! " + board.checkForWinner() + " has won!" : "No winner yet\n\n" + //
                        ""); // Print whether the game is over

        game.displayScores(90); // Display the scores
        game.successfulMove = board.makeMove(3, 2); // Example move
        System.out.println("Player X made a move at (3, 2)"+ "\n");
        System.out.print(board.toString()); // Print the board again
        game.gameOver = board.isGameOver(); // Check for a winner
        System.out.println(game.gameOver ? "Game over! " + board.checkForWinner() + " has won!" : "No winner yet\n\n" + //
                        ""); // Print whether the game is over

        game.displayScores(90); // Display the scores
        game.successfulMove = board.makeMove(2, 1); // Example move
        System.out.println("Player X made a move at (2, 1)"+ "\n");
        System.out.print(board.toString()); // Print the board again
        game.gameOver = board.isGameOver(); // Check for a winner
        System.out.println(game.gameOver ? "Game over! " + board.checkForWinner() + " has won!" : "No winner yet\n\n"); // Print whether the game is over
        
        game.displayScores(90); // Display the scores
        game.successfulMove = board.makeMove(2, 3); // Example move
        System.out.println("Player X made a move at (2, 3)"+ "\n");
        System.out.print(board.toString()); // Print the board again
        game.gameOver = board.isGameOver(); // Check for a winner
        System.out.println(game.gameOver ? "Game over! " + board.checkForWinner() + " has won!" : "No winner yet\n\n"); // Print whether the game is over

        game.displayScores(90); // Display the scores
        game.successfulMove = board.makeMove(3, 3); // Example move
        System.out.println("Player X made a move at (3, 3)"+ "\n");
        System.out.print(board.toString()); // Print the board again
        game.gameOver = board.isGameOver(); // Check for a winner
        System.out.println(game.gameOver ? "Game over! " + board.checkForWinner() + " has won!" : "No winner yet\n\n"); // Print whether the game is over

        game.displayScores(90); // Display the scores
        game.successfulMove = board.makeMove(3, 1); // Example move
        System.out.println("Player X made a move at (3, 1)"+ "\n");
        System.out.print(board.toString()); // Print the board again
        game.gameOver = board.isGameOver(); // Check for a winner
        System.out.println(game.gameOver ? "Game over! " + board.checkForWinner() + " has won!" : "No winner yet\n\n"); // Print whether the game is over
        */
    }

    // constructor
    public TicTacToe(String player1, String player2) {
        this.player1 = player1; // Initialize player 1
        this.player2 = player2; // Initialize player 2
        this.gameOver = false;  // Set gameOver to false
        this.player1Turn = true; // Set player1Turn to true
        this.winnerMap = new HashMap<>(); // Initialize the winnerMap
        this.winnerMap.put(player1, 0); // Initialize player 1's score to 0
        this.winnerMap.put(player2, 0); // Initialize player 2's score to 0
        this.winnerMap.put("Tie", 0); // Initialize tie score to 0
        this.currentBoard = new TicTacToeBoard(); // Initialize the current board
    }



    // method to diplay a scoreboard
    public void displayScores(int displayWidth) {
        int totalWidth = displayWidth; // Total width of the display
        int offset = 5; // Offset for the scores
        
        String topBorder = createSpace(totalWidth, '_'); // Create the top border
        String bottomBorder = createSpace(totalWidth, '_', '|'); // Create the bottom border
        
        // Print the player name/order/score
        System.out.println(topBorder); // Print the top border

    
        if(this.player1Turn) {
            System.out.print(this.createLeftScoreSpace(totalWidth / 2, offset, this.player1 + ": Player X", '|'));
            System.out.print(this.createRightScoreSpace(totalWidth / 2, offset, this.player2 + ": Player O", '|') + "\n");
        } else {
            System.out.print(this.createLeftScoreSpace(totalWidth / 2, offset, this.player2 + ": Player X", '|'));
            System.out.print(this.createRightScoreSpace(totalWidth / 2, offset, this.player1 + ": Player O", '|') + "\n");

        }
        
        System.out.println(this.createCenterScoreSpace(totalWidth, "Ties: " + this.winnerMap.get("Tie"), '|'));
        System.out.println(this.createCenterScoreSpace(totalWidth, "", '|'));
        System.out.println(bottomBorder); // Print the bottom border
    }



    // helper methods for displaying the scoreboard
    public String createSpace(int length, char character) {
        String space = ""; // Initialize the space
        for (int i = 0; i < length; i++) {
            space += character; // adjust the space
        }
        return space; // Return the space
    }

    public String createSpace(int length, char character, char border) {
        String space = ""; // Initialize the space
        space += border; // add the left border
        for (int i = 0; i < length - 2; i++) {
            space += character; // adjust the space
        }
        space += border; // add the right border
        return space; // Return the space
    }

    public String createLeftScoreSpace(int length, int offset, String text, char border) {
        String scoreSpace = "";
        scoreSpace += border; // add the left border
        for (int i = 0; i < (length - 2 - text.length() - offset); i++) {
            scoreSpace += " "; // adjust the left spacing
        }
        scoreSpace += text; // add the text
        for (int i = 0; i < offset; i++) {
            scoreSpace += " "; // adjust the right spacing
        }
        scoreSpace += border; // add the right border
        return scoreSpace; // Return the score space
    }

    public String createRightScoreSpace(int length, int offset, String text, char border) {
        String scoreSpace = "";
        scoreSpace += border; // add the left border
        for (int i = 0; i < offset; i++) {
            scoreSpace += " "; // adjust the left spacing
        }
        scoreSpace += text; // add the text
        for (int i = 0; i < (length - 2 - text.length() - offset); i++) {
            scoreSpace += " "; // adjust the right spacing
        }
        scoreSpace += border; // add the right border
        return scoreSpace; // Return the score space
    }

    public String createCenterScoreSpace(int fullLength, String text, char border) {
        int length = fullLength % 2 == 0 ? fullLength : fullLength - 1; // Adjust the length for even numbers
        length = length / 2; // Divide the length by 2
        text = text.length() % 2 == 0 ? text : text + " "; // Adjust the text for even length
        String scoreSpace = "";
        String padding = "";
        scoreSpace += border; // add the left border
        for (int i = 0; i < (length - (text.length() / 2) - 2); i++) {
            padding += " "; // adjust the left spacing
        }
        scoreSpace += padding;
        scoreSpace += text; // add the text
        scoreSpace += padding;
        while (scoreSpace.length() < fullLength - 1) {
            scoreSpace += " "; // adjust the right spacing
        }
        scoreSpace += border; // add the right border
        return scoreSpace; // Return the score space
    }
    

    
    public void singleGameLoop() {
        while (!this.gameOver) {
            InputCollector input = new InputCollector(); // Create a new InputCollector object
            String player = player1Turn ? this.player1 : this.player2;
            String playerPrompt = "It's your turn, " + player + ". Which ROW would you like to play?";
            int row;
            int col;
            this.displayScores(90); // Display the scoreboard

            // Display the game board
            System.out.println("\nHere is the board:");
            System.out.print(this.currentBoard.toString()); // Print the board
            row = input.getIntResponse(playerPrompt, 1, 3);
            col = input.getIntResponse("And which COL?", 1, 3);
            this.gameOver = this.currentBoard.makeMove(row, col); // Make the move
        }

    }

}