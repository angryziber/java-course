package net.azib.java.students.t050657.homework.src.UI;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * DecathlonGUI
 *
 * @author Boriss
 */
public class DecathlonGUI {
	
	JFrame frame;
	OutputTable resultTable;
	ButtonGroup outputChoise;
	JRadioButton csv, xml, monitor;

	private static void createAndShowGUI(DecathlonGUI gui) {
		gui.frame = new JFrame("Decathlon points calculator");
		gui.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gui.outputChoise = new ButtonGroup();
		gui.csv = new JRadioButton("to csv");
		gui.xml = new JRadioButton("to xml");
		gui.monitor = new JRadioButton("show in table");
		
		gui.outputChoise.add(gui.csv);
		gui.outputChoise.add(gui.xml);
		gui.outputChoise.add(gui.monitor);
		
		JPanel p = new JPanel();
		p.add(gui.csv);
		p.add(gui.xml);
		p.add(gui.monitor);

		JTabbedPane dataAccessTabbedPane = new JTabbedPane();
		gui.resultTable = new OutputTable(); 
		
		gui.frame.setLayout(new BorderLayout());
		gui.frame.add(dataAccessTabbedPane, BorderLayout.SOUTH);
		gui.frame.add(p, BorderLayout.CENTER);
		gui.frame.add(gui.resultTable, BorderLayout.NORTH);
		
		FileAccessPanel fileAccessPanel = new FileAccessPanel(gui);
		DBAccessPanel dbAccessPanel = new DBAccessPanel(gui);
		ManualInputPanel manualPanel = new ManualInputPanel(gui);
	
		dataAccessTabbedPane.add("File access", fileAccessPanel);
		dataAccessTabbedPane.add("DB access", dbAccessPanel);
		dataAccessTabbedPane.add("Manual input", manualPanel);

		gui.frame.pack();
		gui.frame.setVisible(true);
	}
	
	public static void main(String[] args) throws IllegalArgumentException, 
						ClassNotFoundException, InstantiationException,
						IllegalAccessException, UnsupportedLookAndFeelException{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
           public void run() {
        	  DecathlonGUI gui = new DecathlonGUI(); 
              createAndShowGUI(gui);
           }
        });
	}

}
