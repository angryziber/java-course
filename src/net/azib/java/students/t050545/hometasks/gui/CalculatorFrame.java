package net.azib.java.students.t050545.hometasks.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CalculatorFrame extends JFrame {
	
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(){
				CalculatorFrame frame = new CalculatorFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

	public CalculatorFrame(){
		setTitle("Super puper mega calculator");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dimens = kit.getScreenSize();
		setSize((int)dimens.getWidth()/2, (int)dimens.getHeight()/2);
		setLocation((int)dimens.getWidth()/2, (int)dimens.getHeight()/2);
		CalcPanel numbers = new CalcPanel();
		add(numbers);
		pack();
		// TODO
	}

	
}

class CalcPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	
	
	public CalcPanel(){
		setLayout(new BorderLayout());
		result = 0;
		lastCommand = "=";
		start = true;
		display = new JButton("0");
		display.setEnabled(false);
		add(display, BorderLayout.NORTH);
		
		ActionListener insert = new InsertAction();
		ActionListener command = new CommandAction();
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,4));
		
		
		addButton("7", insert);
		addButton("8", insert);
		addButton("9", insert);
		addButton("*", command);
		
		addButton("4", insert);
		addButton("5", insert);
		addButton("6", insert);
		addButton("/", command);
		
		addButton("1", insert);
		addButton("2", insert);
		addButton("3", insert);
		addButton("-", command);
		
		addButton("0", insert);
		addButton(".", insert);
		addButton("=", command);
		addButton("+", command);
		
		add(panel,BorderLayout.CENTER);	
	}
	
	private void addButton(String label, ActionListener listener){
		JButton button = new JButton(label);
		button.addActionListener(listener);
		panel.add(button);
	}
	
	
	private class InsertAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String input = e.getActionCommand();
			if(start){
				display.setText("");
		        start = false;
			}
			display.setText(display.getText()+input);
			
		}
		
	}
	
	private class CommandAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if(start){
				if(command.equals("-")){
					display.setText(command);
					start=false;
				}
				else lastCommand = command;
			}
			else{
				calculate(Double.parseDouble(display.getText()));
				lastCommand = command;
				start = true;
			}
		}
	}
	
	public void calculate(double x){
		if(lastCommand.equals("+")) result +=x;
		else if(lastCommand.equals("-")) result -=x;
		else if(lastCommand.equals("*")) result *=x;
		else if(lastCommand.equals("/")) result /=x;
		else if(lastCommand.equals("=")) result = x;
		display.setText(""+result);
	}
	private JPanel panel;
	private JButton display;
	private double result;
	private String lastCommand;
	private boolean start;
	
}