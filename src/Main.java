import Assignment_MVC.*;
import jdk.incubator.vector.VectorOperators;


import java.util.HashMap;
import java.util.Map;

/**
 * The Main class is the entry point of the calculator application.
 */
public class Main {

    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();

        Map<String, Operation> operations = new HashMap<>();

        /* old way
        operations.put("add", model::add);
        operations.put("subtract", model::subtract);
        operations.put("multiply", model::multiply);
        operations.put("divide", model::divide);
        CalculatorController controller = new CalculatorController(model, view, operations);*/

        // new way
        CalculatorController controller = new CalculatorController(model, view);

        view.setVisible(true);
    }
}