import java.util.Scanner;

public class InputCollector {
    // instance variables
    private Scanner scanner; // Scanner object for input

    // constructor
    public InputCollector() {
        this.scanner = new Scanner(System.in); // Initialize the scanner
    }

    public boolean getBooleanResponse(String prompt, char trueChar, char falseChar) {
        System.out.print(prompt); // Print the prompt
        try {
            char response = scanner.nextLine().charAt(0); // Get the input
            if (response == trueChar) { // Check if the input is equal to trueChar
                return true; // Return true
            } else if (response == falseChar) { // Check if the input is equal to falseChar
                return false; // Return false
            } else {
                System.out.println("Invalid input. Please enter '" + trueChar + "' or '" + falseChar + "'."); // Print error message
                return getBooleanResponse(prompt, trueChar, falseChar); // Recursively call the method until valid input is received
            }
        } catch (Exception e) { // Catch any exceptions
            System.out.println("Invalid input. Please enter '" + trueChar + "' or '" + falseChar + "'."); // Print error message
            return getBooleanResponse(prompt, trueChar, falseChar); // Recursively call the method until valid input is received
        }
    }

    public int getIntResponse(String prompt, int min, int max) {
        int response = min - 1; // Initialize response
        while (response < min || response > max) { // Loop until valid input is received
            System.out.print(prompt); // Print the prompt
            try {
                response = Integer.parseInt(scanner.nextLine()); // Get the input
            } catch (NumberFormatException e) { // Catch invalid input
                System.out.println("Invalid input. Please enter a number between " + min + " and " + max + "."); // Print error message
            }
        }
        return response; // Return the valid input
    }
    
}
