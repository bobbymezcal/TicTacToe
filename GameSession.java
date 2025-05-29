public class GameSession {
    // INSTANCE VARIABLES
    private GameUI ui;                                                      // UI for game session
    private GameRound currentGame;                                          // current game round being played    
    private Scoreboard scoreboard;                                          // scoreboard to keep track of player scores
    private Player whoGoesFirst;                                            // which player goes first

    // CONSTRUCTOR
    public GameSession() {
        this.ui = new ConsoleUI();                                          // create UI object to handle display/input
        createScoreboard();                                                 // call method to create new scoreboard  players
        startSession();                                                     // call game session loop method
    }

    // CREATE SCOREBOARD AND PLAYERS
    private void createScoreboard() {                                       // prompt user for player names & create new scoreboard
        Player player1 = new Player(ui.getUserInput("Enter Player 1 name: "), 'X');     // create player 1
        Player player2 = new Player(ui.getUserInput("Enter Player 2 name: "), 'O');     // create player 2
        this.whoGoesFirst = player1;                                        // track player who starts initial game
        this.scoreboard = new Scoreboard(player1, player2, player1);        // create new scoreboard to hold players
    }

    // START GAME SESSION LOOP
    private void startSession() {                                           // loop to play games until user decides to stop
        boolean continuePlaying = true;                                     // boolean to track when to stop playing
        while (continuePlaying) {                                           // game session loop
            currentGame = new GameRound(scoreboard, 3);           // create new GameRound object, pass in scoreboard
            currentGame.setUI(ui);                                          // pass UI to GameRound
            ui.setGameRound(currentGame);                                   // pass GameRound to UI
            char result = currentGame.playGame();                           // run SINGLE GAME LOOP in GameRound
            updateScoreboard(result);                                       // call helper method to update scoreboard on game end
            continuePlaying = ui.getUserInput("Play again? (yes/no): ").equalsIgnoreCase("yes");

            // Swap starting player for next round
            whoGoesFirst = (whoGoesFirst == scoreboard.getPlayer1()) ? scoreboard.getPlayer2() : scoreboard.getPlayer1();
        }

        ui.displayMessage("Thanks for playing! Final scores:");
        //String finalScores = String.format("%s: %d wins / %s: %d wins / Ties: %d\n",
        //        player1.getName(), player1.getWins(), player2.getName(), player2.getWins(), player1.getTies());
        //ui.displayMessage(finalScores);
    }

    private void updateScoreboard(char result) {
        Player playerX = scoreboard.getPlayerX();
        Player playerO = scoreboard.getPlayerO();
        if (result == 'X') {
            playerX.addWin();
            playerO.addLoss();
        } else if (result == 'O') {
            playerO.addWin();
            playerX.addLoss();
        } else if (result == 'T') {
            playerX.addTie();
            playerO.addTie();
        }

        String winnerMessage = "Scores: " + playerX.getName() + " [" + playerX.getWins() + " wins] vs ";
        winnerMessage += playerO.getName() + " [" + playerO.getWins() + " wins], Ties: " + playerX.getTies() + "\n";
        ui.displayMessage(winnerMessage);
    }
    

    // setter methods
    public void setUI(GameUI ui) {
        this.ui = ui; 
    }
    public void setCurrentGame(GameRound game) {
        this.currentGame = game; 
    }
    public void setCurrentStarter(Player starter) {
        this.whoGoesFirst = starter; 
    }

    // getter methods
    public GameRound getCurrentGame() {
        return currentGame; 
    }
    public GameUI getUI() {
        return ui; 
    }
    public Player getCurrentStarter() {
        return whoGoesFirst; 
    }
    public Player getPlayer1() {
        return scoreboard.getPlayer1(); 
    }
    public Player getPlayer2() {
        return scoreboard.getPlayer2(); 
    }
}