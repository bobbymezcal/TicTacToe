import java.util.Scanner;

public class ConsoleUI implements GameUI {
    private Scanner scanner;
    private GameEngine game;

    public ConsoleUI(GameEngine game) {
        this.game = game;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayBoard(GameBoard board) {  // Now correctly follows the interface
        clearScreen();
        System.out.println("Current Board:");
        char[][] boardState = board.getBoard();  
        for (char[] row : boardState) {
            for (char cell : row) {
                System.out.print("[" + cell + "] ");
            }
            System.out.println();
        }
    }

    @Override
    public int[] getUserMove() {
        int row, col;
        while (true) {
            System.out.print("Enter row and column (e.g., '1 2') or 0 to exit: ");
            if (scanner.hasNextInt()) {
                row = scanner.nextInt();
                if (row == 0) {
                    System.out.println("Exiting game...");
                    System.exit(0); // Force program to exit
                }
                if (scanner.hasNextInt()) {
                    col = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    if (row >= 1 && row <= game.getBoardSize() && col >= 1 && col <= game.getBoardSize()) {
                        return new int[]{row, col}; 
                    } else {
                        System.out.println("Invalid move. Enter numbers within board size.");
                    }
                } else {
                    System.out.println("Invalid input. Enter two numbers separated by a space.");
                    scanner.nextLine(); // Consume invalid input
                }
            } else {
                System.out.println("Invalid input. Enter two numbers.");
                scanner.next(); // Consume incorrect input
            }
        }
    }

    public void startGame() {
        while (!game.isGameOver()) {
            displayBoard((GameBoard) this.game.getCurrentBoard());  // Now correctly passing the current board
            System.out.println(game.getGameState());

            int[] move = getUserMove();
            if (!game.makeMove(move)) { // Now correctly passing the move array
                System.out.println("Invalid move! Try again.");
            }
        }

        displayGameResult();
    }

    private void displayGameResult() {
        System.out.println("Game Over! " + game.getWinnerMessage());
    }

    public static void clearScreen() {
        String os = System.getProperty("os.name").toLowerCase();
        String shell = System.getenv("SHELL");

        try {
            if (os.contains("win") && (shell == null || shell.contains("cmd"))) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor(); // Works in Bash, MacOS, Linux
            }
        } catch (Exception e) {
            System.out.println("\n".repeat(50)); // Fallback method
        }
    }

}


/*

import java.util.Scanner;

public class ConsoleUI implements GameUI {
    private Scanner scanner;
    private GameEngine game;

    public ConsoleUI(GameEngine game) {
        this.game = game;
        this.scanner = new Scanner(System.in);
    }

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
    public int[] getUserMove() {
        int row, col;
        while (true) {
            System.out.print("Enter row and column (e.g., '1 2') or 0 to exit: ");
            if (scanner.hasNextInt()) {
                row = scanner.nextInt();
                if (scanner.hasNextInt()) {
                    col = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer

                    if (row >= 1 && row <= game.getBoardSize() && col >= 1 && col <= game.getBoardSize()) {
                        return new int[]{row - 1, col - 1};  // Adjust for zero-based indexing
                    } else {
                        System.out.println("Invalid move. Enter numbers within board size.");
                    }
                } else {
                    System.out.println("Invalid input. Enter two numbers separated by a space.");
                    scanner.nextLine(); // Consume invalid input
                }
            } else {
                System.out.println("Invalid input. Enter two numbers.");
                scanner.next(); // Consume incorrect input
            }
        }
    }

  
    public static void clearScreen() {
        String os = System.getProperty("os.name").toLowerCase();
        String shell = System.getenv("SHELL");

        try {
            if (os.contains("win") && (shell == null || shell.contains("cmd"))) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor(); // Works in Bash, MacOS, Linux
            }
        } catch (Exception e) {
            System.out.println("\n".repeat(50)); // Fallback method
        }
    }






    
    public void startGame() {
        while (!game.isGameOver()) {
            displayBoard();
            System.out.println(game.getGameState());

            int[] move = getUserMove();
            if (!game.makeMove((move - 1) / game.getBoardSize(), (move - 1) % game.getBoardSize())) {
                System.out.println("Invalid move! Try again.");
            }
        }

        displayGameResult();
    }

    

    private void displayBoard() {
        char[][] boardState = game.getBoardState();
        System.out.println("\nTic-Tac-Toe Board:");
        for (char[] row : boardState) {
            for (char cell : row) {
                System.out.print("[" + cell + "] ");
            }
            System.out.println();
        }
    }

    private void displayGameResult() {
        System.out.println("Game Over! " + game.getWinnerMessage());
    }
}









/*

        // method to diplay a scoreboard
    public void displayScores(int displayWidth) {
        int totalWidth = displayWidth; // Total width of the display
        int offset = 5; // Offset for the scores
        
        String topBorder = createSpace(totalWidth, '_'); // Create the top border
        String bottomBorder = createSpace(totalWidth, '_', '|'); // Create the bottom border
        
        // Print the player name/order/score
        System.out.println(topBorder); // Print the top border

    
        if(this.player1Turn) {
            System.out.print(this.createLeftScoreSpace(totalWidth / 2, offset, this.player1 + ": Player X", '|'));
            System.out.print(this.createRightScoreSpace(totalWidth / 2, offset, this.player2 + ": Player O", '|') + "\n");
        } else {
            System.out.print(this.createLeftScoreSpace(totalWidth / 2, offset, this.player2 + ": Player X", '|'));
            System.out.print(this.createRightScoreSpace(totalWidth / 2, offset, this.player1 + ": Player O", '|') + "\n");

        }
        
        System.out.println(this.createCenterScoreSpace(totalWidth, "Ties: " + this.winnerMap.get("Tie"), '|'));
        System.out.println(this.createCenterScoreSpace(totalWidth, "", '|'));
        System.out.println(bottomBorder); // Print the bottom border
    }



    // helper methods for displaying the scoreboard
    public String createSpace(int length, char character) {
        String space = ""; // Initialize the space
        for (int i = 0; i < length; i++) {
            space += character; // adjust the space
        }
        return space; // Return the space
    }

    public String createSpace(int length, char character, char border) {
        String space = ""; // Initialize the space
        space += border; // add the left border
        for (int i = 0; i < length - 2; i++) {
            space += character; // adjust the space
        }
        space += border; // add the right border
        return space; // Return the space
    }

    public String createLeftScoreSpace(int length, int offset, String text, char border) {
        String scoreSpace = "";
        scoreSpace += border; // add the left border
        for (int i = 0; i < (length - 2 - text.length() - offset); i++) {
            scoreSpace += " "; // adjust the left spacing
        }
        scoreSpace += text; // add the text
        for (int i = 0; i < offset; i++) {
            scoreSpace += " "; // adjust the right spacing
        }
        scoreSpace += border; // add the right border
        return scoreSpace; // Return the score space
    }

    public String createRightScoreSpace(int length, int offset, String text, char border) {
        String scoreSpace = "";
        scoreSpace += border; // add the left border
        for (int i = 0; i < offset; i++) {
            scoreSpace += " "; // adjust the left spacing
        }
        scoreSpace += text; // add the text
        for (int i = 0; i < (length - 2 - text.length() - offset); i++) {
            scoreSpace += " "; // adjust the right spacing
        }
        scoreSpace += border; // add the right border
        return scoreSpace; // Return the score space
    }

    public String createCenterScoreSpace(int fullLength, String text, char border) {
        int length = fullLength % 2 == 0 ? fullLength : fullLength - 1; // Adjust the length for even numbers
        length = length / 2; // Divide the length by 2
        text = text.length() % 2 == 0 ? text : text + " "; // Adjust the text for even length
        String scoreSpace = "";
        String padding = "";
        scoreSpace += border; // add the left border
        for (int i = 0; i < (length - (text.length() / 2) - 2); i++) {
            padding += " "; // adjust the left spacing
        }
        scoreSpace += padding;
        scoreSpace += text; // add the text
        scoreSpace += padding;
        while (scoreSpace.length() < fullLength - 1) {
            scoreSpace += " "; // adjust the right spacing
        }
        scoreSpace += border; // add the right border
        return scoreSpace; // Return the score space
    }
        */
        
