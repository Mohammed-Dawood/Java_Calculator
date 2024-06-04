package se.lexicon;

import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char operator;
        double number1, number2, result;

        while (true) {
            System.out.println("Please choose an operator: +, -, *, or / (or 'q + Enter' to quit):");
            operator = input.next().charAt(0);

            if (operator == 'q') {
                break;
            }

            switch (operator) {
                case '+':
                case '-':
                case '*':
                case '/':
                    try {
                        System.out.println("Please enter the first number and press enter:");
                        number1 = input.nextDouble();
                        System.out.println("Please enter the second number and press enter:");
                        number2 = input.nextDouble();

                        result = performOperation(operator, number1, number2);

                        System.out.println("Result = " + result);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter numerical values.");
                        input.next(); // clear the invalid input
                    } catch (ArithmeticException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Invalid operator!");
                    break;
            }

            input.nextLine(); // clear the buffer
        }

        input.close();
    }

    public static double performOperation(char operator, double number1, double number2) {
        double result = 0;
        switch (operator) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                if (number2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero.");
                }
                result = number1 / number2;
                break;
        }
        return result;
    }
}