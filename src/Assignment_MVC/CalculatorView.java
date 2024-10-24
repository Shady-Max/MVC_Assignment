package Assignment_MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {

    private final JTextField firstNumber = new JTextField(10);
    private final JTextField secondNumber = new JTextField(10);
    private final JTextField result = new JTextField(10);
    private final JButton addButton = new JButton("+");
    private final JButton subButton = new JButton("-");
    private final JButton mulButton = new JButton("*");
    private final JButton divButton = new JButton("/");

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

    public double getFirstNumber () {
        return Double.parseDouble(firstNumber.getText());
    }

    public double getSecondNumber () {
        return Double.parseDouble(secondNumber.getText());
    }

    public void setResult (String resultText) {
        result.setText(resultText);
    }

    public void addOperationListener(ActionListener listener) {
        addButton.addActionListener(listener);
        subButton.addActionListener(listener);
        mulButton.addActionListener(listener);
        divButton.addActionListener(listener);
    }

}
