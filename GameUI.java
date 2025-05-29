public interface GameUI {
    void displayBoard(GameBoard board, Scoreboard scoreboard);
    int[] getUserMove(Player currentPlayer);
    String getUserInput(String prompt);
    void displayMessage(String message);
    void setMatch(Match game);
    void setMatch(Session session);
}