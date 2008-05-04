package net.azib.java.students.t030633;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * CalculatorApplet
 * 
 * @author t030633
 */
public class CalculatorApplet extends JApplet implements ActionListener {

	JLabel display = new JLabel("0.0", JLabel.RIGHT);

	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	JButton button3 = new JButton("3");
	JButton button4 = new JButton("4");
	JButton button5 = new JButton("5");
	JButton button6 = new JButton("6");
	JButton button7 = new JButton("7");
	JButton button8 = new JButton("8");
	JButton button9 = new JButton("9");
	JButton button0 = new JButton("0");
	JButton buttonPlus = new JButton(CalculatorOperator.PLUS.getSign());
	JButton buttonMinus = new JButton(CalculatorOperator.MINUS.getSign());
	JButton buttonMultiply = new JButton(CalculatorOperator.MULTIPLY.getSign());
	JButton buttonDivide = new JButton(CalculatorOperator.DIVIDE.getSign());
	JButton buttonEquals = new JButton("=");
	JButton buttonClear = new JButton("C");

	private CalculatorOperator operator = CalculatorOperator.CLEAR;
	private double value = 0;
	boolean operatorWasPressed = false;

	@Override
	public void init() {

		setLayout(null);
		setSize(215, 265);

		display.setBounds(10, 10, 185, 40);

		button1.setBounds(10, 160, 45, 45);
		button2.setBounds(60, 160, 45, 45);
		button3.setBounds(110, 160, 45, 45);
		button4.setBounds(10, 110, 45, 45);
		button5.setBounds(60, 110, 45, 45);
		button6.setBounds(110, 110, 45, 45);
		button7.setBounds(10, 60, 45, 45);
		button8.setBounds(60, 60, 45, 45);
		button9.setBounds(110, 60, 45, 45);
		button0.setBounds(10, 210, 45, 45);
		buttonPlus.setBounds(110, 210, 45, 45);
		buttonMinus.setBounds(60, 210, 45, 45);
		buttonMultiply.setBounds(160, 110, 45, 45);
		buttonDivide.setBounds(160, 160, 45, 45);
		buttonEquals.setBounds(160, 210, 45, 45);
		buttonClear.setBounds(160, 60, 45, 45);

		add(display);

		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);
		add(button7);
		add(button8);
		add(button9);
		add(button0);
		add(buttonPlus);
		add(buttonMinus);
		add(buttonMultiply);
		add(buttonDivide);
		add(buttonEquals);
		add(buttonClear);

		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);
		button0.addActionListener(this);
		buttonPlus.addActionListener(this);
		buttonMinus.addActionListener(this);
		buttonMultiply.addActionListener(this);
		buttonDivide.addActionListener(this);
		buttonEquals.addActionListener(this);
		buttonClear.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src instanceof JButton) {
			if (src == buttonClear)
				clear();
			if (src == buttonEquals)
				calculate();
			else {
				String text = ((JButton) src).getText();
				try {
					int number = Integer.parseInt(text);
					numberButton(number);
				}
				catch (NumberFormatException exception) {
					operatorButton(text);
				}
			}
		}
	}

	private void calculate() {
		display.setText(String.valueOf(operator.operate(value, Double.parseDouble(display.getText()))));
		value = 0;
	}

	private void operatorButton(String text) {
		operatorWasPressed = true;
		for (CalculatorOperator op : CalculatorOperator.values()) {
			if (op.getSign().equals(text)) {
				operator = op;
			}
		}
		value = Double.parseDouble(display.getText());
	}

	private void numberButton(int number) {
		String s = display.getText();
		if (s.equals("0.0") || operatorWasPressed) {
			s = "";
			operatorWasPressed = false;
		}
		display.setText(s + String.valueOf(number));
	}

	private void clear() {
		display.setText("0.0");
		value = 0;
		operator = CalculatorOperator.CLEAR;
	}

}
