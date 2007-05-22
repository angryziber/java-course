package net.azib.java.students.t030647.homework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * InteractiveFrame
 * A frame that allows user to insert competition's data interactively
 * @author Igor
 */
public class InteractiveFrame extends JFrame implements ActionListener {
	
	/** serialVersionUID */
	private static final long serialVersionUID = -2367532426981825160L;
	JTextArea text;
	
	public InteractiveFrame() {
		super("Insert data");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		text = new JTextArea(7, 50);
		JButton btn = new JButton("ok");
		btn.addActionListener(this);
		mainPanel.add(text);
		mainPanel.add(btn);
		
		getContentPane().add(mainPanel);
		setSize(560,200);
		//setResizable(false);
		setVisible(true);
		
	}
	
	/**
	 * ActionListener
	 */
	public void actionPerformed(ActionEvent arg0) {
		ApplicationFrame.data = text.getText();
		this.dispose();
	}
	
}
