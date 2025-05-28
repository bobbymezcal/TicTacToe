public class Player {
    private String name;
    private char symbol;
    private int wins, losses, ties;
    private boolean isTurn;

    public Player(String name, char symbol, boolean isFirst) {
        this.name = name;
        this.symbol = symbol;
        this.wins = 0;
        this.losses = 0;
        this.ties = 0;
        this.isTurn = isFirst;
    }

    public String getName() { return name; }
    public char getSymbol() { return symbol; }
    public int getWins() { return wins; }
    public int getLosses() { return losses; }
    public int getTies() { return ties; }
    public boolean isTurn() { return isTurn; }

    public void addWin() { wins++; }
    public void addLoss() { losses++; }
    public void addTie() { ties++; }
    public void setTurn(boolean turn) { isTurn = turn; }

    @Override
    public String toString() {
        return String.format("%s (Wins: %d, Losses: %d, Ties: %d)", name, wins, losses, ties);
    }
}