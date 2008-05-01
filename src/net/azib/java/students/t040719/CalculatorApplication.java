package net.azib.java.students.t040719;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Point;


/**
 * CalculatorApplication
 *
 * @author romi
 */
public class CalculatorApplication extends JFrame implements ActionListener{

	private JPanel jContentPane = null;
	private JButton jbZero = null;
	private JButton jbOne = null;
	private JButton jbTwo = null;
	private JButton jbThree = null;
	private JButton jbFour = null;
	private JButton jbFive = null;
	private JButton jbSix = null;
	private JButton jbSeven = null;
	private JButton jbEight = null;
	private JButton jbNine = null;
	private JButton jbMultiply = null;
	private JButton jbDivide = null;
	private JButton jbAdd = null;
	private JButton jbSubtract = null;
	private JButton jbAns = null;
	private JButton jbClear = null;
	private JLabel jlDisplay = null;
	private JLabel jlError = null;
	private JTextArea jtHistory = null;
	private String newline = "\n";  //  @jve:decl-index=0:
	private long var=0;
	private long ans=0;
	
	private enum Operation{
		ADD,SUBTRACT,MULTIPLY,DIVIDE;
	}
	private Operation op = null;  //  @jve:decl-index=0:
	/**
	 * This method initializes 
	 * 
	 */
	public CalculatorApplication() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
        this.setSize(new Dimension(366, 203));
        this.setContentPane(getJContentPane());
        this.setTitle("Calculator");
        this.setContentPane(getJContentPane());
        this.addWindowListener(new java.awt.event.WindowAdapter() {
        	public void windowClosing(java.awt.event.WindowEvent e) {
        		System.out.println("windowClosing()");
        	}
        });
        
			
	}

	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJbZero(), null);
			jContentPane.add(getJbOne(), null);
			jContentPane.add(getJbTwo(), null);
			jContentPane.add(getJbThree(), null);
			jContentPane.add(getJbFour(), null);
			jContentPane.add(getJbFive(), null);
			jContentPane.add(getJbSix(), null);
			jContentPane.add(getJbSeven(), null);
			jContentPane.add(getJbEight(), null);
			jContentPane.add(getJbNine(), null);
			jContentPane.add(getJbMultiply(), null);
			jContentPane.add(getJbDivide(), null);
			jContentPane.add(getJbAdd(), null);
			jContentPane.add(getJbSubtract(), null);
			jContentPane.add(getJbAns(), null);
			jContentPane.add(getJbClear(), null);
			jContentPane.add(getJlDisplay(), null);
			jContentPane.add(getJlError(), null);
			jContentPane.add(getJtHistory(), null);
		}
		return jContentPane;
	}
	
	/**
	 * This method initializes jbOne	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbZero() {
		if (jbZero == null) {
			jbZero = new JButton();
			jbZero.setText("0");
			jbZero.setBounds(new Rectangle(60, 135, 41, 26));
			jbZero.setFocusable(false);
			jbZero.addActionListener(this);
		}
		return jbZero;
	}
	
	/**
	 * This method initializes jbOne	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbOne() {
		if (jbOne == null) {
			jbOne = new JButton();
			jbOne.setText("1");
			jbOne.setBounds(new Rectangle(15, 45, 41, 26));
			jbOne.setFocusable(false);
			jbOne.addActionListener(this);
		}
		return jbOne;
	}

	/**
	 * This method initializes jbTwo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbTwo() {
		if (jbTwo == null) {
			jbTwo = new JButton();
			jbTwo.setBounds(new Rectangle(60, 45, 41, 26));
			jbTwo.setText("2");
			jbTwo.setFocusable(false);
			jbTwo.addActionListener(this);
		}
		return jbTwo;
	}

	/**
	 * This method initializes jbThree	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbThree() {
		if (jbThree == null) {
			jbThree = new JButton();
			jbThree.setBounds(new Rectangle(105, 45, 41, 26));
			jbThree.setText("3");
			jbThree.setFocusable(false);
			jbThree.addActionListener(this);
		}
		return jbThree;
	}

	/**
	 * This method initializes jbFour	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbFour() {
		if (jbFour == null) {
			jbFour = new JButton();
			jbFour.setBounds(new Rectangle(15, 75, 41, 26));
			jbFour.setText("4");
			jbFour.setFocusable(false);
			jbFour.addActionListener(this);
		}
		return jbFour;
	}

	/**
	 * This method initializes jbFive	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbFive() {
		if (jbFive == null) {
			jbFive = new JButton();
			jbFive.setBounds(new Rectangle(60, 75, 41, 26));
			jbFive.setText("5");
			jbFive.setFocusable(false);
			jbFive.addActionListener(this);
		}
		return jbFive;
	}

	/**
	 * This method initializes jbSix	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbSix() {
		if (jbSix == null) {
			jbSix = new JButton();
			jbSix.setBounds(new Rectangle(105, 75, 41, 26));
			jbSix.setText("6");
			jbSix.setFocusable(false);
			jbSix.addActionListener(this);
		}
		return jbSix;
	}

	/**
	 * This method initializes jbSeven	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbSeven() {
		if (jbSeven == null) {
			jbSeven = new JButton();
			jbSeven.setBounds(new Rectangle(15, 105, 41, 26));
			jbSeven.setText("7");
			jbSeven.setFocusable(false);
			jbSeven.addActionListener(this);
		}
		return jbSeven;
	}

	/**
	 * This method initializes jbEight	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbEight() {
		if (jbEight == null) {
			jbEight = new JButton();
			jbEight.setBounds(new Rectangle(60, 105, 41, 26));
			jbEight.setText("8");
			jbEight.setFocusable(false);
			jbEight.addActionListener(this);
		}
		return jbEight;
	}

	/**
	 * This method initializes jbNine	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbNine() {
		if (jbNine == null) {
			jbNine = new JButton();
			jbNine.setBounds(new Rectangle(105, 105, 41, 26));
			jbNine.setText("9");
			jbNine.setFocusable(false);
			jbNine.addActionListener(this);
		}
		return jbNine;
	}

	/**
	 * This method initializes jbMultiply	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbMultiply() {
		if (jbMultiply == null) {
			jbMultiply = new JButton();
			jbMultiply.setBounds(new Rectangle(165, 75, 46, 26));
			jbMultiply.setText("*");
			jbMultiply.setFocusable(false);
			jbMultiply.addActionListener(this);
		}
		return jbMultiply;
	}

	/**
	 * This method initializes jbDivide	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbDivide() {
		if (jbDivide == null) {
			jbDivide = new JButton();
			jbDivide.setBounds(new Rectangle(210, 75, 46, 26));
			jbDivide.setText("/");
			jbDivide.setFocusable(false);
			jbDivide.addActionListener(this);
		}
		return jbDivide;
	}

	/**
	 * This method initializes jbAdd	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbAdd() {
		if (jbAdd == null) {
			jbAdd = new JButton();
			jbAdd.setBounds(new Rectangle(165, 45, 46, 26));
			jbAdd.setText("+");
			jbAdd.setFocusable(false);
			jbAdd.addActionListener(this);
		}
		return jbAdd;
	}

	/**
	 * This method initializes jbSubtract	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbSubtract() {
		if (jbSubtract == null) {
			jbSubtract = new JButton();
			jbSubtract.setBounds(new Rectangle(210, 45, 46, 26));
			jbSubtract.setText("-");
			jbSubtract.setFocusable(false);
			jbSubtract.addActionListener(this);
		}
		return jbSubtract;
	}

	/**
	 * This method initializes jbAns	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbAns() {
		if (jbAns == null) {
			jbAns = new JButton();
			jbAns.setBounds(new Rectangle(210, 15, 46, 26));
			jbAns.setText("=");
			jbAns.setFocusable(false);
			jbAns.addActionListener(this);
		}
		return jbAns;
	}

	/**
	 * This method initializes jbClear	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbClear() {
		if (jbClear == null) {
			jbClear = new JButton();
			jbClear.setBounds(new Rectangle(165, 105, 91, 26));
			jbClear.setText("Clear");
			jbClear.setFocusable(false);
			jbClear.addActionListener(this);
		}
		return jbClear;
	}
	
	/**
	 * This method initializes jlDisplay	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JLabel getJlDisplay() {
		if (jlDisplay == null) {
			jlDisplay = new JLabel();
			jlDisplay.setBounds(new Rectangle(15, 15, 181, 26));
			jlDisplay.setText("0");
			jlDisplay.setFont(new Font("Courier New", Font.BOLD,18));
			jlDisplay.setHorizontalAlignment(JLabel.RIGHT);
			jlDisplay.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		}
		return jlDisplay;
	}
	
	/**
	 * This method initializes jlError	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JLabel getJlError() {
		if (jlError == null) {
			jlError = new JLabel();
			jlError.setBounds(new Rectangle(165, 135, 91, 26));
			jlError.setFont(new Font("Courier New", Font.BOLD,18));
			jlError.setHorizontalAlignment(JLabel.RIGHT);
			jlError.setForeground(Color.RED);
		}
		return jlError;
	}
	
	/**
	 * This method initializes jtHistory	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JTextArea getJtHistory() {
		if (jtHistory == null) {
			jtHistory = new JTextArea(5,10);
			jtHistory.setEditable(false);
			jtHistory.setSize(76, 145);
			jtHistory.setLocation(270, 15);
			//jtHistory.setBounds(new Rectangle(270, 30));
			jtHistory.setFont(new Font("Courier New", Font.BOLD,10));
			jtHistory.setBackground(null);
		}
		return jtHistory;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton){
			if (e.getSource() == jbClear){
				var=0; ans=0; jlDisplay.setText("0"); op = null; jlError.setText(""); jtHistory.setText("");
			}else if (e.getSource() == jbAdd){
				calculate();
				//jtHistory.append("+"+newline);
				jtHistory.setText("+"+newline+jtHistory.getText());
				op = Operation.ADD;
			}else if (e.getSource() == jbSubtract){
				calculate();
				//jtHistory.append("-"+newline);
				jtHistory.setText("-"+newline+jtHistory.getText());
				op = Operation.SUBTRACT;
			}else if (e.getSource() == jbMultiply){
				calculate();
				jtHistory.setText("*"+newline+jtHistory.getText());
				//jtHistory.append("*"+newline);
				op = Operation.MULTIPLY;
			}else if (e.getSource() == jbDivide){
				calculate();
				jtHistory.setText("/"+newline+jtHistory.getText());
				//jtHistory.append("/"+newline);
				op = Operation.DIVIDE;
			}else if (e.getSource() == jbAns){
				calculate();
				//jtHistory.append("="+newline+((Integer)ans).toString()+newline);
				jtHistory.setText(((Long)ans).toString()+newline+"="+newline+jtHistory.getText());
				if (jlError.getText() != "DIV 0"){
					op = null;
					jlDisplay.setText(((Long)ans).toString());
				}
			} else{
				if (Integer.valueOf(jlDisplay.getText())!=0 && op == null)
					jlDisplay.setText(jlDisplay.getText()+((JButton)e.getSource()).getText());
				else if (op != null)
					if (var==0)
						jlDisplay.setText(((JButton)e.getSource()).getText());
					else
						jlDisplay.setText(((Long)var).toString()+((JButton)e.getSource()).getText());
				else
					jlDisplay.setText(((JButton)e.getSource()).getText());
				if (op == null)
					ans = Long.parseLong(jlDisplay.getText());
				else
					var = Long.parseLong(jlDisplay.getText());
			}
		}
	}
	private void calculate(){
		if (op!=null){
			switch (op) {
				case ADD:
					//jtHistory.append("+"+newline);
					ans += var;
//					jtHistory.append(((Integer)var).toString()+newline);
					jtHistory.setText(((Long)var).toString()+newline+jtHistory.getText());
					jlError.setText("");
					break;
				case SUBTRACT:
					//jtHistory.append("-"+newline);
					ans -= var;
//					jtHistory.append(((Integer)var).toString()+newline);
					jtHistory.setText(((Long)var).toString()+newline+jtHistory.getText());
					jlError.setText("");
					break;
				case MULTIPLY:
					//jtHistory.append("*"+newline);
					ans *= var;
					jtHistory.setText(((Long)var).toString()+newline+jtHistory.getText());
					//jtHistory.append(((Integer)var).toString()+newline);
					jlError.setText("");
					break;
				case DIVIDE:
					if (var != 0){
						ans /=var;
						jtHistory.setText(((Long)var).toString()+newline+jtHistory.getText());
						jlError.setText("");
					}else
						jlError.setText("DIV 0");
					break;			
			}
		jlDisplay.setText("0");
		var=0;
		}else{
			//jtHistory.append(((Integer)ans).toString()+newline);
			jtHistory.setText(((Long)ans).toString()+newline+jtHistory.getText());
		}
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
