package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {

    private JTextField resultField;
    private StringBuilder currentInput;
    private double num1, num2;
    private char currentOperator;

    public CalculatorGUI() {
        this.num1 = this.num2 = 0;
        this.currentInput = new StringBuilder();
        this.resultField = new JTextField();
        this.resultField.setEditable(false);
        this.resultField.setHorizontalAlignment(JTextField.RIGHT);
        this.resultField.setPreferredSize(new Dimension(100, 50));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        String[] buttons = {
                "7", "8", "9", "+",
                "4", "5", "6", "-",
                "1", "2", "3", "*",
                "0", "C", "=", "/"
        };

        for (String label : buttons) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        this.setLayout(new BorderLayout(10, 10));
        this.add(resultField, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);

        this.setTitle("Basic Calculator");
        this.setSize(300, 400);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            currentInput.append(command);
            resultField.setText(currentInput.toString());
        } else if (command.equals("C")) {
            currentInput.setLength(0);
            resultField.setText(" ");
            num1 = num2 = 0;
            currentOperator = ' ';
        }else if (command.equals("=")){
            if (currentInput.length() > 0 && this.currentOperator != ' ') {
                this.num2 = Double.parseDouble(currentInput.toString());
                double result = 0;
                switch (this.currentOperator) {
                    case '+':
                        result = this.num1 + this.num2;
                        break;
                    case '-':
                        result = this.num1 - this.num2;
                        break;
                    case '/':
                        if (this.num2 != 0) {
                            result = this.num1 / this.num2;
                        } else {
                            resultField.setText("Error! Divided by zero");
                        }
                        break;
                }
                resultField.setText(String.valueOf(result));

            }

        }else {
            System.out.println("Clicked Operators !!!! " + currentInput.length());
            if (currentInput.length()>0) {
                this.num1 = Double.parseDouble(currentInput.toString());
                this.currentOperator = command.charAt(0);
                this.currentInput.setLength(0);

            }
        }

    }
}
