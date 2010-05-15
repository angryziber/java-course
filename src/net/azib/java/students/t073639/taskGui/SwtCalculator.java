package net.azib.java.students.t073639.taskGui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * SwingCalculator
 *
 * @author kir
 */
public class SwtCalculator {
	private Calculator c=new Calculator();  //  @jve:decl-index=0:
	private Shell sShell = null;  //  @jve:decl-index=0:visual-constraint="30,10"
	private Label label = null;
	private Button buttonDivide = null;
	private Button buttonMultiply = null;
	private Button buttonSub = null;
	private Button button0 = null;
	private Button buttonClr = null;
	private Button buttonEqual = null;
	private Button buttonAdd = null;
	private Button button1 = null;
	private Button button2 = null;
	private Button button3 = null;
	private Button button4 = null;
	private Button button5 = null;
	private Button button6 = null;
	private Button button7 = null;
	private Button button8 = null;
	private Button button9 = null;
	protected double d1=0;
	protected double d2=0;
	protected Object object=null;  //  @jve:decl-index=0:
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Before this is run, be sure to set up the launch configuration (Arguments->VM Arguments)
		 * for the correct SWT library path in order to run with the SWT dlls. 
		 * The dlls are located in the SWT plugin jar.  
		 * For example, on Windows the Eclipse SWT 3.1 plugin jar is:
		 *       installation_directory\plugins\org.eclipse.swt.win32_3.1.0.jar
		 */
		Display display = Display.getDefault();
		SwtCalculator thisClass = new SwtCalculator();
		thisClass.createSShell();
		thisClass.sShell.open();
		while (!thisClass.sShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	/**
	 * This method initializes sShell
	 */
	private void createSShell() {
		sShell = new Shell();
		sShell.setText("Calculator (SWT)");
		sShell.setLayout(null);
		sShell.setSize(new Point(245, 337));
		label = new Label(sShell, SWT.RIGHT | SWT.VERTICAL);
		label.setText("");
		label.setFont(new Font(Display.getDefault(), "UnDotum", 18, SWT.NORMAL));
		label.setBounds(new Rectangle(10, 5, 219, 40));
		buttonDivide = new Button(sShell, SWT.BUTTON1);
		buttonDivide.setBounds(new Rectangle(175, 80, 50, 50));
		buttonDivide.setText("/");
		buttonDivide.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				setObject(e.getSource());
				if (d1==0){
					setD1(Double.parseDouble(label.getText()));
					label.setText("");
				}
				else{
					calculate();
				}
				
			}
		});
		buttonMultiply = new Button(sShell, SWT.NONE);
		buttonMultiply.setBounds(new Rectangle(175, 135, 50, 50));
		buttonMultiply.setText("*");
		buttonMultiply.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				setObject(e.getSource());
				if (d1==0){
					setD1(Double.parseDouble(label.getText()));
					label.setText("");
				}
				else{
					calculate();
				}
			}
			// TODO Переделать calculate добавить clear 
		});
		buttonSub = new Button(sShell, SWT.NONE);
		buttonSub.setBounds(new Rectangle(175, 190, 50, 50));
		buttonSub.setText("-");
		buttonSub.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				setObject(e.getSource());
				if (d1==0){
					setD1(Double.parseDouble(label.getText()));
					label.setText("");
				}
				else{
					calculate();
				}
			}
		});
		button0 = new Button(sShell, SWT.NONE);
		button0.setBounds(new Rectangle(10, 245, 50, 50));
		button0.setText("0");
		button0.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				label.setText(label.getText()+((Button)e.getSource()).getText());
			}
		});
		buttonClr = new Button(sShell, SWT.NONE);
		buttonClr.setBounds(new Rectangle(65, 245, 50, 50));
		buttonClr.setText("Clr");
		buttonClr.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				clear();
			}
		});
		buttonEqual = new Button(sShell, SWT.NONE);
		buttonEqual.setBounds(new Rectangle(120, 245, 50, 50));
		buttonEqual.setText("=");
		buttonEqual.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				calculate();
			}
		});
		
		buttonAdd = new Button(sShell, SWT.NONE);
		buttonAdd.setBounds(new Rectangle(175, 245, 50, 50));
		buttonAdd.setText("+");
		buttonAdd.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				setObject(e.getSource());
				if (d1==0){
					setD1(Double.parseDouble(label.getText()));
					label.setText("");
				}
				else{
					calculate();
				}
			}
		});
		button1 = new Button(sShell, SWT.NONE);
		button1.setBounds(new Rectangle(10, 190, 50, 50));
		button1.setText("1");
		button1.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				label.setText(label.getText()+((Button)e.getSource()).getText());
			}
		});
		button2 = new Button(sShell, SWT.NONE);
		button2.setBounds(new Rectangle(65, 190, 50, 50));
		button2.setText("2");
		button2.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				label.setText(label.getText()+((Button)e.getSource()).getText());
			}
		});
		button3 = new Button(sShell, SWT.NONE);
		button3.setBounds(new Rectangle(120, 190, 50, 50));
		button3.setText("3");
		button3.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				label.setText(label.getText()+((Button)e.getSource()).getText());
			}
		});
		button4 = new Button(sShell, SWT.NONE);
		button4.setBounds(new Rectangle(10, 135, 50, 50));
		button4.setText("4");
		button4.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				label.setText(label.getText()+((Button)e.getSource()).getText());
			}
		});
		button5 = new Button(sShell, SWT.NONE);
		button5.setBounds(new Rectangle(65, 135, 50, 50));
		button5.setText("5");
		button5.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				label.setText(label.getText()+((Button)e.getSource()).getText());
			}
		});
		button6 = new Button(sShell, SWT.NONE);
		button6.setBounds(new Rectangle(120, 135, 50, 50));
		button6.setText("6");
		button6.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				label.setText(label.getText()+((Button)e.getSource()).getText());
			}
		});
		button7 = new Button(sShell, SWT.NONE);
		button7.setBounds(new Rectangle(10, 80, 50, 50));
		button7.setText("7");
		button7.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				label.setText(label.getText()+((Button)e.getSource()).getText());
			}
		});
		button8 = new Button(sShell, SWT.NONE);
		button8.setBounds(new Rectangle(65, 80, 50, 50));
		button8.setText("8");
		button8.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				label.setText(label.getText()+((Button)e.getSource()).getText());
			}
		});
		button9 = new Button(sShell, SWT.NONE);
		button9.setBounds(new Rectangle(120, 80, 50, 50));
		button9.setText("9");
		button9.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				label.setText(label.getText()+((Button)e.getSource()).getText());
			}
		});
	}

	/**
	 * 
	 */
	protected void clear() {
		setD1(0);
		setD2(0);
		setObject(null);
		label.setText("");
	}

	/**
	 * 
	 */
	protected void calculate() {
			setD2(Double.parseDouble(label.getText()));
			if ((Button)object==buttonAdd) label.setText(String.valueOf(c.add(d1, d2)));
			else if ((Button)object==buttonDivide) label.setText(String.valueOf(c.divide(d1, d2)));
			else if ((Button)object==buttonMultiply) label.setText(String.valueOf(c.multiply(d1, d2)));
			else if ((Button)object==buttonSub) label.setText(String.valueOf(c.subtract(d1, d2)));
			else {}
		}
	/**
	 * @param d1 the d1 to set
	 */
	public void setD1(double d1) {
		this.d1 = d1;
	}

	/**
	 * @return the d1
	 */
	public double getD1() {
		return d1;
	}

	/**
	 * @param d2 the d2 to set
	 */
	public void setD2(double d2) {
		this.d2 = d2;
	}

	/**
	 * @return the d2
	 */
	public double getD2() {
		return d2;
	}

	/**
	 * @param object the object to set
	 */
	public void setObject(Object object) {
		this.object = object;
	}

	/**
	 * @return the object
	 */
	public Object getObject() {
		return object;
	}

}
