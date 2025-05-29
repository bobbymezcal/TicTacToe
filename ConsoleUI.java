import java.util.Scanner;

public class ConsoleUI implements GameUI {
    // INSTANCE FIELDS
    private Scanner scanner;                                                            // Scanner for user input
    private Match match;                                                             // GameRound to manage current game state

    // CONSTRUCTOR 
    public ConsoleUI() {
        this.scanner = new Scanner(System.in);                                          // initialize ConsoleUI with Scanner for user input
    }

    // DISPLAY BOARD AND SCOREBOARD
    @Override
    public void displayBoard(GameBoard board, Scoreboard scoreboard) {                  // display current game board and scoreboard
        clearScreen();                                                                  // clear console screen for fresh display
        System.out.print(scoreboard.toString());                                        // print scoreboard using its toString method       
        System.out.println("Current Board:");                                         // print current board header
        char[][] boardState = board.getBoard();                                         // get current state of  board
        for (char[] row : boardState) {                                                 // iterate through each row of the board
            for (char cell : row) {
                System.out.print("[" + cell + "] ");                                    // print each cell in row with brackets
            }
            System.out.println();                                                       // print new line after each row
        }
    }

    // GET USER MOVE (must return valid moves only)
    @Override
    public int[] getUserMove(Player currentPlayer) {                                                       
        int row, col;                                                                   // variables to store user input for row and column
        while (true) {                                                                  // infinite loop to keep asking for valid input
            System.out.println("It's " + currentPlayer.getName() + "'s turn.");
            System.out.print("Enter row and column (e.g., '1 2') or 0 to exit: ");    // prompt user for input
            if (scanner.hasNextInt()) {                                                 // check if first input is integer
                row = scanner.nextInt();                                                // read row input
                if (row == 0) {                                                         // if user enters 0, exit game
                    System.out.println("Exiting game...");                            // print exit message
                    System.exit(0);                                              // force program to exit
                }
                if (scanner.hasNextInt()) {                                             // check if second input is integer                 
                    col = scanner.nextInt();                                            // read column input
                    scanner.nextLine();                                                 // clear buffer
                    if (row >= 1 && row <= match.getBoardSize() &&                       // check if row is within valid range
                    col >= 1 && col <= match.getBoardSize()) {                           // check if column is within valid range
                        return new int[]{row, col};                                     // return valid move as int array    
                    } else {
                        System.out.println("Invalid move. Enter numbers within board size.");   // print error message
                    }
                } else {
                    System.out.println("Invalid input. Enter two numbers separated by a space."); // print error message
                    scanner.nextLine();                                                 // clear invalid input
                }
            } else {
                System.out.println("Invalid input. Enter two numbers.");              // print error message
                scanner.next();                                                         // clear invalid input
            }
        }
    }

    // DISPLAY PROMPT AND GET USER INPUT
    @Override
    public String getUserInput(String prompt) {
        System.out.print(prompt);                                                       // print prompt string to console
        return scanner.nextLine();                                                      // get user input from console
    }

    // DISPLAY MESSAGE TO USER
    @Override
    public void displayMessage(String message) {
        System.out.println(message);                                                    // print string to console
    }

    // CLEAR CONSOLE SCREEN
    private static void clearScreen() {
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

    // SET GAME ROUND (GameRound as parameter)
    @Override
    public void setMatch(Match match) {
        this.match = match;                                                               // set current game round
    }

    // SET GAME ROUND (GameSession as parameter)
    @Override
    public void setMatch(Session gameSession) {
        this.match = gameSession.getCurrentMatch();                                       // set current game round
    }
}