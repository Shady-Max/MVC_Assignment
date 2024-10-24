package Assignment_MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * The CalculatorController class represents the controller in the MVC pattern.
 * It handles user interactions, processes the arithmetic operations,
 * and updates the model and view accordingly.
 */
public class CalculatorController {

    private final Map<String, Operation> operations;

    /**
     * Constructs a CalculatorController instance that retrieves methods
     * from the CalculatorModel class to populate the operations map
     * when no operations have been added.
     *
     * @param model the calculator model that performs calculations
     * @param view the calculator view that displays the user interface
     */
    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this(model, view, new HashMap<>() {
            {
                Method[] publicMethods = CalculatorModel.class.getMethods();
                for (Method method : publicMethods) {
                    if (method.getParameterCount() == 2 && method.getReturnType() == double.class) {
                        Operation operation = (a, b) -> {
                            try {
                                return (double) method.invoke(new CalculatorModel(), a, b);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                                return 0;
                            }
                        };

                        put(method.getName(), operation);
                    }
                }
            }
        });
    }
    /**
     * Constructs a CalculatorController instance with the provided model,
     * view, and operations map. Initializes the operations and sets up
     * action listeners for the view.
     *
     * @param model the calculator model that performs calculations
     * @param view the calculator view that displays the user interface
     * @param operations a map that associates action commands with
     *                   their corresponding operations
     */
    public CalculatorController(CalculatorModel model, CalculatorView view, Map<String, Operation> operations) {
        this.operations = operations;

        view.addOperationListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double firstNum = view.getFirstNumber();
                    double secondNum = view.getSecondNumber();

                    Operation operation = operations.get(e.getActionCommand());

                    if (operation != null && e.getActionCommand().equals("divide") && secondNum == 0) {
                        view.setResult("Error: Division by zero");
                        return;
                    }

                    if (operation == null) {
                        view.setResult("Error: Something went wrong with operation");
                        return;
                    }

                    double result = operation.execute(firstNum, secondNum);

                    view.setResult(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    view.setResult("Error: Incorrect Input");
                } catch (ArithmeticException ex) {
                    view.setResult(ex.getMessage());
                } catch (NullPointerException ex) {
                    view.setResult("Error: Something went wrong");
                }
            }
        });
    }
}
