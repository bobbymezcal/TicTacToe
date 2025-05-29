public class Player {
    private String name;
    private char symbol;
    private int wins, losses, ties;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        this.wins = 0;
        this.losses = 0;
        this.ties = 0;
    }

    // getter methods
    public String getName() { return name; }
    public char getSymbol() { return symbol; }
    public int getWins() { return wins; }
    public int getLosses() { return losses; }
    public int getTies() { return ties; }

    // setter methods
    public void addWin() { wins++; }
    public void addLoss() { losses++; }
    public void addTie() { ties++; }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return String.format("%s (Wins: %d, Losses: %d, Ties: %d)", name, wins, losses, ties);
    }
}