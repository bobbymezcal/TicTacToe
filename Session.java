public class Session {
    // INSTANCE FIELDS
    private GameUI ui;                                                      // UI for game session
    private Match match;                                                    // current game round being played    
    private Scoreboard scoreboard;                                          // scoreboard to keep track of player scores

    // CONSTRUCTOR
    public Session() {
        this.ui = new ConsoleUI();                                          // create UI object to handle display/input
        createScoreboard();                                                 // call method to create new scoreboard  players
        sessionLoop();                                                      // call game session loop method
    }

    // CREATE SCOREBOARD AND PLAYERS
    private void createScoreboard() {                                       // prompt user for player names & create new scoreboard
        Player player1 = new Player(ui.getUserInput("Enter Player 1 name: "), 'X');     // create player 1
        Player player2 = new Player(ui.getUserInput("Enter Player 2 name: "), 'O');     // create player 2
        this.scoreboard = new Scoreboard(player1, player2, player1);        // create new scoreboard to hold players
    }

    // GAME SESSION LOOP
    private void sessionLoop() {                                            
        boolean continuePlaying = true;                                     // boolean to track when to stop playing
        while (continuePlaying) {                                           // game session loop
            char result = singleMatch();                                    // run a single match
            updateScoreboard(result);                                       // update scoreboard
            continuePlaying = ui.getUserInput("Play again? (yes/no): ").equalsIgnoreCase("yes");
            if(continuePlaying) scoreboard.switchSides();
        }
        ui.displayMessage("Later!");
    }

    // SINGLE MATCH
    private char singleMatch() {
        match = new Match(scoreboard, 3);
        match.setUI(ui);
        ui.setMatch(match);
        return match.matchLoop();
    }

    // UPDATE SCOREBOARD
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
    public void setCurrentGame(Match game) {
        this.match = game; 
    }

    // getter methods
    public Match getCurrentMatch() {
        return match; 
    }
    public GameUI getUI() {
        return ui; 
    }
    public Player getPlayer1() {
        return scoreboard.getPlayer1(); 
    }
    public Player getPlayer2() {
        return scoreboard.getPlayer2(); 
    }
}