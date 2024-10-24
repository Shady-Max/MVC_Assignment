package Assignment_MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The CalculatorView class represents the view in the MVC pattern.
 * It displays the user interface for the calculator and handles user input.
 */
public class CalculatorView extends JFrame {

    private final JTextField firstNumber = new JTextField(10);
    private final JTextField secondNumber = new JTextField(10);
    private final JTextField result = new JTextField(10);
    private final JButton addButton = new JButton("+");
    private final JButton subButton = new JButton("-");
    private final JButton mulButton = new JButton("*");
    private final JButton divButton = new JButton("/");

    /**
     * Constructs a CalculatorView instance.
     * Initializes the user interface components and sets up the layout.
     */
    public CalculatorView() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.add(new JLabel("Number 1:"));
        panel.add(firstNumber);
        panel.add(new JLabel("Number 2:"));
        panel.add(secondNumber);
        panel.add(new JLabel("Result:"));
        panel.add(result);
        addButton.setActionCommand("add");
        subButton.setActionCommand("subtract");
        mulButton.setActionCommand("multiply");
        divButton.setActionCommand("divide");
        panel.add(addButton);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(divButton);

        result.setEditable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);
        this.add(panel);
    }

    /**
     * Retrieves the first number input by the user.
     *
     * @return the first number as a double
     */
    public double getFirstNumber () {
        return Double.parseDouble(firstNumber.getText());
    }

    /**
     * Retrieves the second number input by the user.
     *
     * @return the second number as a double
     */
    public double getSecondNumber () {
        return Double.parseDouble(secondNumber.getText());
    }

    /**
     * Sets the result text in the result field.
     *
     * @param resultText the result text to display
     */
    public void setResult (String resultText) {
        result.setText(resultText);
    }

    /**
     * Adds action listeners for the calculator operation buttons.
     *
     * @param listener the ActionListener to be added
     */
    public void addOperationListener(ActionListener listener) {
        addButton.addActionListener(listener);
        subButton.addActionListener(listener);
        mulButton.addActionListener(listener);
        divButton.addActionListener(listener);
    }

}
