import java.util.Scanner;

public class smartCal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0;
        String input;
        
        System.out.println("Welcome to Smart Calculator!");
        System.out.println("Available operations: +, -, *, /");
        System.out.println("Type 'clear' to reset the calculator, 'exit' to quit.");

        while (true) {
            System.out.print("Enter operation or 'exit': ");
            input = scanner.nextLine().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Exiting the calculator. Goodbye!");
                break;
            } else if (input.equals("clear")) {
                result = 0;
                System.out.println("Cleared. Current result: " + result);
                continue;
            }

            // Split the input by spaces to get the operator and operands
            String[] tokens = input.split(" ");

            if (tokens.length != 3) {
                System.out.println("Invalid input format. Try: [number] [operator] [number]");
                continue;
            }

            try {
                double num1 = Double.parseDouble(tokens[0]);
                double num2 = Double.parseDouble(tokens[2]);
                char operator = tokens[1].charAt(0);

                result = performOperation(num1, num2, operator);

                if (!Double.isNaN(result)) {
                    System.out.println("Result: " + result);
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter valid numbers.");
            }
        }

        scanner.close();
    }

    // Perform the arithmetic operation
    private static double performOperation(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    System.out.println("Error: Cannot divide by zero.");
                    return Double.NaN; // Return Not-a-Number for invalid division
                }
                return num1 / num2;
            default:
                System.out.println("Invalid operator. Please use one of: +, -, *, /");
                return Double.NaN;
        }
    }
}
