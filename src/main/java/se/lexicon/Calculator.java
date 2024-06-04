package se.lexicon;

public class Calculator {
    public static double performOperation(char operator, double number1, double number2) {
        double result;
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
            default:
                throw new UnsupportedOperationException("Invalid operator: " + operator);
        }
        return result;
    }
}