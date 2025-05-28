import java.util.Scanner;

public class GameSession {
    private Player player1, player2, currentStarter;
    private int winsP1 = 0, winsP2 = 0, ties = 0;
    private Scanner scanner;

    public GameSession() {
        scanner = new Scanner(System.in);
        initializePlayers();
    }

    private void initializePlayers() {
        System.out.print("Enter Player 1 name: ");
        String name1 = scanner.nextLine();
        System.out.print("Enter Player 2 name: ");
        String name2 = scanner.nextLine();

        player1 = new Player(name1, 'X', true);
        player2 = new Player(name2, 'O', false);
        this.currentStarter = player1; // Player 1 starts first game
    }

    public void startSession() {
        ConsoleUI ui = new ConsoleUI(null);
        boolean continuePlaying = true;

        while (continuePlaying) {
            GameRound game = new GameRound(player1.getName(), player2.getName(), 3);
            game.setUI(ui);
            ui.setGameRound(game);
            char result = game.playGame();

            // Track results
            if (result == 'X') winsP1++;
            else if (result == 'O') winsP2++;
            else if (result == 'T') ties++;

            System.out.printf("Scores: %s [%d wins] vs %s [%d wins], Ties: %d\n",
                    player1.getName(), winsP1, player2.getName(), winsP2, ties);

            System.out.print("Play again? (yes/no): ");
            continuePlaying = scanner.nextLine().equalsIgnoreCase("yes");

            // Swap starting player for next round
            currentStarter = (currentStarter == player1) ? player2 : player1;
        }

        System.out.println("Thanks for playing! Final scores:");
        System.out.printf("%s: %d wins, %s: %d wins, Ties: %d\n",
                player1.getName(), winsP1, player2.getName(), winsP2, ties);
    }
}