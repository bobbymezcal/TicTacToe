public class TicTacToeTest {
    public static void main(String[] args) {
        GameEngine game = new GameEngine("Player 1", "Player 2", 3);  // 3x3 board
        ConsoleUI ui = new ConsoleUI(game);
        game.setUI(ui);  // Set the UI for the game engine
        ui.startGame();
    }
}