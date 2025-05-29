public class Match {
    // INSTANCE VARIABLES
    private GameUI ui;                                                  // declare GameUI object to handle user interface interactions
    private Scoreboard scoreboard;                                      // declare Scoreboard object to keep track of players and scores
    private GameBoard board;                                            // declare TicTacToeBoard object to represent current board
    private boolean gameOver;                                           // declare boolean to keep track of whether current game is over
    
    // CONSTRUCTOR to initialize GameRound with Scoreboard and board size
    public Match(Scoreboard scoreboard, int boardSize) {            
        this.board = new GameBoard(boardSize);                          // initialize current board
        this.scoreboard = scoreboard;                                   // set scoreboard
        this.gameOver = false;                                          // set game over to false
    }

    // SETTER METHOD TO SET UI
    public void setUI(GameUI ui) {                                      
        this.ui = ui;                                                   // set user interface
    }

    // MATCH LOOP
    public char matchLoop() {
        char matchResult = ' ';
        while (matchResult == ' ') {
            matchResult = singleTurn();
        }
        return matchResult;
    }

    // SINGLE TURN
    public char singleTurn() {                                            
        ui.displayBoard(board, scoreboard);                             // display current board and scoreboard
        int[] move = ui.getUserMove(scoreboard.getSelectedPlayer());    // get user input for move (method only returns valid moves)
        return makeMove(move);                                          // call makeMove (which checks for winner, updates gameOver, and switches turns)
    }

    // METHOD TO MAKE MOVE (move *must* be validated by UI before calling this method)
    public char makeMove(int[] move) {                                  
        Player currentPlayer = scoreboard.getSelectedPlayer();           // get current player from scoreboard
        char activeSymbol  = currentPlayer.getSymbol();                 // get current player's symbol
        char result = board.makeMove(move[0], move[1], activeSymbol);   // make move on the board with the current player's symbol
        if (result == 'X' || result == 'O' || result == 'T') {          // check if the move resulted in win or tie
            gameOver = true;                                            // end game if a winner or tie is detected
        } else {
            switchTurn();                                               // switch turns if the game isn't over
        }
        return result;                                                  // return the result of the move
    }
    
    // HELPER METHOD TO SWITCH TURNS BETWEEN PLAYERS (after a valid move only)
    private void switchTurn() {    
        System.out.println("SWITCHING SELCTED PLAYER NOW");                                         
        scoreboard.switchTurns();                              // Switch the selected player in the scoreboard
    }

    public boolean isGameOver() {
        return this.gameOver; // Return whether the game is over
    }
    public int getBoardSize() {
        return this.board.getSize(); // Return the size of the board
    }
    public char[][] getBoardState() {
        return this.board.getBoard(); // Return the current state of the board
    }
    public String getWinnerMessage() {
        char winner = board.checkForWinner();
        if (winner == 'T') return "It's a tie!";
        if (winner != 'X') return scoreboard.getPlayerX().getName() + " wins!";
        if (winner != 'O') return scoreboard.getPlayerO().getName() + " wins!";
        return "Game is still ongoing.";
    }
    public GameBoard getCurrentBoard() {
        return this.board; // Return the current board
    }
}