package Assignment_MVC;

public class CalculatorModel {

    public double add (double a, double b) {
        return a + b;
    }

    public double subtract (double a, double b) {
        return a - b;
    }

    public double multiply (double a, double b) {
        return a * b;
    }

    public double divide (double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Error: division by zero");
        }
        return a / b;
    }
}
