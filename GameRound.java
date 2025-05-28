public class GameRound {
    // Instance fields
    private Player playerX, playerO, currentPlayer;                     // Declare Player objects for player X and player O
    private GameBoard currentBoard;                                     // Declare TicTacToeBoard object to represent current board
    private boolean gameOver;                                           // Declare boolean to keep track of whether current game is over
    private GameUI ui;                                                  // Declare GameUI object to handle user interface interactions

    // constructor
    public GameRound(String player1name, String player2name, int boardSize) {
        this.currentBoard = new GameBoard(boardSize);                   // Initialize current board
        this.playerX = new Player(player1name, 'X', true);                    // Initialize player 1
        this.playerO = new Player(player2name, 'O', false);                    // Initialize player 2
        this.currentPlayer = this.playerX;                              // Set current player to player X
        this.gameOver = false;                                          // Set game over to false
    }

    public void setUI(GameUI ui) {
        this.ui = ui;                                                   // Set the user interface
    }

    public char playGame() {
        char result = ' '; // Initialize result to empty character
        while (!gameOver) {
            ui.displayBoard(currentBoard);
            int[] move = ui.getUserMove();
            result = makeMove(move);  // Handles checking for winner and updating gameOver internally
        }
        System.out.println(getWinnerMessage()); // Game over message after exiting loop
        return result;
    }

    private void switchTurn() {
        this.currentPlayer = (this.currentPlayer == this.playerX) ? this.playerO : this.playerX; // Switch turn
    }



    public char makeMove(int[] move) {
        char result = currentBoard.makeMove(move[0], move[1], currentPlayer.getSymbol());
        if (result == 'E') {
            System.out.println("Invalid move! Try again.");
            return result;
        }

        if (result == 'X' || result == 'O' || result == 'T') {
            gameOver = true;  // End game if a winner or tie is detected
        } else {
            switchTurn();  // Only switch turns if the game isn't over
        }

        return result;
    }


    public boolean isGameOver() {
        return this.gameOver; // Return whether the game is over
    }
    public String getGameState() {
        return "Current Player: " + this.currentPlayer.getName() + " (" + this.currentPlayer.getSymbol() + ")";
    }
    public int getBoardSize() {
        return this.currentBoard.getSize(); // Return the size of the board
    }
    public char[][] getBoardState() {
        return this.currentBoard.getBoard(); // Return the current state of the board
    }
    public String getWinnerMessage() {
        char winner = currentBoard.checkForWinner();
        if (winner == 'T') return "It's a tie!";
        if (winner != ' ') return currentPlayer.getName() + " wins!";
        return "Game is still ongoing.";
    }


    public GameBoard getCurrentBoard() {
        return this.currentBoard; // Return the current board
    }
}