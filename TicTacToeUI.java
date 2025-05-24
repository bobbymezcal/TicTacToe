import java.util.Scanner;

public class TicTacToeUI {
    private static char[][] board = {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'}
    };

    private static int highlightedRow = -1, highlightedCol = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            clearScreen(); // Clear the console
            printBoard(); // Show the board
            
            System.out.println("\nPress a number (1-9) to highlight, 0 to select & exit:");
            int input = scanner.nextInt();
            scanner.nextLine(); // Clear input buffer

            if (input == 0) {
                System.out.println("\nSelected: " + 
                    (highlightedRow != -1 ? board[highlightedRow][highlightedCol] : "None"));
                System.out.println("Exiting...");
                running = false;
            } else if (input >= 1 && input <= 9) {
                highlightSquare(input);
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }

        scanner.close();
    }

    private static void highlightSquare(int input) {
        int row = (input - 1) / 3;
        int col = (input - 1) % 3;

        highlightedRow = row;
        highlightedCol = col;
    }

    private static void printBoard() {
        System.out.println("\nTic-Tac-Toe Board:");

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (r == highlightedRow && c == highlightedCol) {
                    System.out.print("[" + board[r][c] + "] "); // Highlighted square
                } else {
                    System.out.print(" " + board[r][c] + "  ");
                }
            }
            System.out.println();
        }
    }

    public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
}
}