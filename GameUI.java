public interface GameUI {
    void displayBoard(GameBoard board, Scoreboard scoreboard);
    int[] getUserMove();
    String getUserInput(String prompt);
    void displayMessage(String message);
    void setGameRound(GameRound game);
    void setGameRound(GameSession session);
}