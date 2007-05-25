package net.azib.java.students.t020543;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SwingGUI {
	
	private static void createAndShowGUI() {
		final JFrame frame = new JFrame("Decathlon Point Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Choose your destiny!");
		frame.add(label);
		
		JButton button = new JButton("Enter");
		frame.add(button);
		
		frame.setLayout(new GridLayout());
		
		button.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent e) 
				{
				JOptionPane.showMessageDialog(frame, "Let's do it!");
				}
		});
		
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, 
			IllegalAccessException, UnsupportedLookAndFeelException {
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        	{
        		public void run() 
        		{
        			createAndShowGUI();
        		}
        	});
    }
}
