package Assignment_MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CalculatorController {

    private final Map<String, Operation> operations = new HashMap<>();

    @FunctionalInterface
    interface Operation {
        double execute(double a, double b);
    }

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
