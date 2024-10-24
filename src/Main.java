import Assignment_MVC.*;

/**
 * The Main class is the entry point of the calculator application.
 */
public class Main {

    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);

        view.setVisible(true);
    }
}