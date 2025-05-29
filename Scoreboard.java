public class Scoreboard {
    private Player player1, player2, selectedPlayer;
    
    public Scoreboard(Player player1, Player player2, Player selectedPlayer) {
        this.player1 = player1;
        this.player2 = player2;
        this.selectedPlayer = selectedPlayer;         
    }
    
    public void switchSelectedPlayer() {
        if (selectedPlayer.equals(player1)) {
            selectedPlayer = player2; 
        } else {
            selectedPlayer = player1; 
        }
    }
    public void switchXOPlayers() {
        player1.setSymbol(player1.getSymbol() == 'X' ? 'O' : 'X');
        player2.setSymbol(player2.getSymbol() == 'X' ? 'O' : 'X');
    }

    // getter methods
    public Player getPlayerX() {
        return player1.getSymbol() == 'X' ? player1 : player2;
    }
    public Player getPlayerO() {
        return player1.getSymbol() == 'O' ? player1 : player2;
    }
    public Player getPlayer1() {
        return player1;
    }
    public String getPlayer1Name() {
        return player1.getName();
    }
    public char getPlayer1Symbol() {
        return player1.getSymbol();
    }
    public Player getPlayer2() {
        return player2;
    }
    public String getPlayer2Name() {
        return player2.getName();
    }
    public char getPlayer2Symbol() {
        return player2.getSymbol();
    }
    public Player getSelectedPlayer() {
        return selectedPlayer;
    }
    public String getSelectedPlayerName() {
        return selectedPlayer.getName();
    }
    public int getPlayer1Wins() {
        return player1.getWins();
    }
    public int getPlayer2Wins() {
        return player2.getWins();
    }
    public int getTies() {
        return player1.getTies();
    }
    @Override
    public String toString() {
        return String.format("Scoreboard:\n%s: %d wins\n%s: %d wins\nTies: %d",
                player1.getName(), player1.getWins(), player2.getName(), player2.getWins(), player1.getTies());
    }
}
