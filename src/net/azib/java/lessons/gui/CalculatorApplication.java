package net.azib.java.lessons.gui;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Text;

/**
 * CalculatorApplication
 *
 * @author anton
 */
public class CalculatorApplication {

	private Shell sShell = null;
	private Button button = null;
	private Button radioButton = null;
	private Text text = null;
	
	

	public CalculatorApplication() {
		createSShell();
	}


	/**
	 * This method initializes sShell
	 */
	private void createSShell() {
		sShell = new Shell();
		sShell.setText("Shell");
		sShell.setSize(new Point(300, 200));
		sShell.setLayout(null);
		button = new Button(sShell, SWT.NONE);
		button.setBounds(new Rectangle(31, 68, 101, 49));
		button.setText("Click Me!");
		radioButton = new Button(sShell, SWT.RADIO);
		radioButton.setBounds(new Rectangle(174, 100, 100, 28));
		text = new Text(sShell, SWT.BORDER);
		text.setBounds(new Rectangle(138, 154, 142, 24));
	}
	
	public void open() {
		sShell.open();
		Display display = Display.getDefault();
		  while (!sShell.isDisposed()) {
		     if (!display.readAndDispatch())
		        display.sleep();
		  }
		  display.dispose ();
	}
	
	
	public static void main(String[] args) {
		CalculatorApplication shell = new CalculatorApplication();
		shell.open();
	}

}
