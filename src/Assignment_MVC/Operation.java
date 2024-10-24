package Assignment_MVC;

/**
 * Functional interface for arithmetic operations.
 * This interface defines a method for executing an operation with two double operands.
 */
@FunctionalInterface
public interface Operation {
    /**
     * Executes the arithmetic operation.
     *
     * @param a the first operand
     * @param b the second operand
     * @return the result of the operation
     */
    double execute(double a, double b);
}