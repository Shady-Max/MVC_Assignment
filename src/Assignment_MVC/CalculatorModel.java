package Assignment_MVC;

/**
 * The CalculatorModel class represents the model in the MVC pattern.
 * It provides methods for basic arithmetic operations: addition, subtraction, multiplication, and division.
 */
public class CalculatorModel {

    /**
     * Adds two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the sum of a and b
     */
    public double add (double a, double b) {
        return a + b;
    }

    /**
     * Subtracts the second number from the first number.
     *
     * @param a the first number
     * @param b the second number
     * @return the result of a minus b
     */
    public double subtract (double a, double b) {
        return a - b;
    }

    /**
     * Multiplies two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the product of a and b
     */
    public double multiply (double a, double b) {
        return a * b;
    }

    /**
     * Divides the first number by the second number.
     *
     * @param a the numerator
     * @param b the denominator
     * @return the result of a divided by b
     * @throws ArithmeticException if b is zero
     */
    public double divide (double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Error: division by zero");
        }
        return a / b;
    }
}
