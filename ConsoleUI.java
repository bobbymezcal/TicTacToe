import java.util.Scanner;

public class ConsoleUI implements GameUI {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayBoard(GameBoard board) {
        clearScreen();
        System.out.println("Current Board:");
        char[][] state = board.getBoard();
        for (char[] row : state) {
            for (char cell : row) {
                System.out.print("[" + cell + "] ");
            }
            System.out.println();
        }
    }

    @Override
    public int getUserMove() {
        System.out.println("Enter your move (1-9) or 0 to exit:");
        int move = scanner.nextInt();
        scanner.nextLine(); // Clear the input buffer
        return move;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
}
