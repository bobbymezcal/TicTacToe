import java.util.HashMap;

public class GameEngine {
    // Instance fields
    private Player playerX, playerO, currentPlayer;                     // Declare Player objects for player X and player O
    private GameBoard currentBoard;                                     // Declare TicTacToeBoard object to represent current board
    private boolean gameOver;                                           // Declare boolean to keep track of whether current game is over
    private GameUI ui;                                                  // Declare GameUI object to handle user interface interactions

    // constructor
    public GameEngine(String player1name, String player2name, int boardSize, GameUI ui) {
        this.currentBoard = new GameBoard(boardSize);                   // Initialize current board
        this.ui = ui;                                                   // Set user interface
        this.playerX = new Player(player1name, 'X');                    // Initialize player 1
        this.playerO = new Player(player2name, 'O');                    // Initialize player 2
        this.currentPlayer = this.playerX;                              // Set current player to player X
        this.gameOver = false;                                          // Set game over to false
    }

    public void startGame() {
        while (!gameOver) {
            ui.displayBoard(currentBoard);
            int move = ui.getUserMove();
            makeMove((move - 1) / currentBoard.getSize(), (move - 1) % currentBoard.getSize());
        }
    }
}



    public boolean makeMove(int row, int col) {
        if (this.gameOver) return false; // Prevent moves after game ends

        char result = this.currentBoard.makeMove(row, col, this.currentPlayer.getSymbol());

        if (result == 'E') {
            System.out.println("Invalid move! Try again.");
            return false;
        } else if (result == 'T' || result == 'X' || result == 'O') {
            this.gameOver = true;
            System.out.println("Game Over! " + (result == 'T' ? "It's a tie!" : this.currentPlayer.getName() + " wins!"));
        } else {
            this.currentPlayer = (this.currentPlayer == this.playerX) ? this.playerO : this.playerX; // Switch turns
        }
        return true;
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
    


}