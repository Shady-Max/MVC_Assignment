package Assignment_MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * The CalculatorController class represents the controller in the MVC pattern.
 * It handles user interactions and updates the model and view accordingly.
 */
public class CalculatorController {

    private final Map<String, Operation> operations = new HashMap<>();

    /**
     * Functional interface for arithmetic operations.
     */
    @FunctionalInterface
    private interface Operation {
        double execute(double a, double b);
    }

    /**
     * Constructs a CalculatorController instance.
     * Initializes the operations map and sets up action listeners for the view.
     *
     * @param model the calculator model
     * @param view  the calculator view
     */
    public CalculatorController(CalculatorModel model, CalculatorView view) {

        operations.put("add", model::add);
        operations.put("subtract", model::subtract);
        operations.put("multiply", model::multiply);
        operations.put("divide", model::divide);

        view.addOperationListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double firstNum = view.getFirstNumber();
                    double secondNum = view.getSecondNumber();

                    Operation operation = operations.get(e.getActionCommand());
                    double result = operation.execute(firstNum, secondNum);

                    view.setResult(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    view.setResult("Error: Incorrect Input");
                } catch (ArithmeticException ex) {
                    view.setResult(ex.getMessage());
                }
            }
        });
    }
}
