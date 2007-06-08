package net.azib.java.students.t050657.homework.ui;

import net.azib.java.students.t050657.homework.ctrl.dataOutput.CSVFileWriter;
import net.azib.java.students.t050657.homework.ctrl.dataOutput.XMLFileWriter;
import net.azib.java.students.t050657.homework.model.Competition;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;

/**
 * DecathlonGUI class for create application. 
 * @author Boriss
 */
public class DecathlonGUI {
	
	
	JFrame frame;
	OutputTable resultTable;
	ButtonGroup outputChoise;
	JRadioButton csv, xml, monitor;

	public void createAndShowGUI(DecathlonGUI gui) {
		gui.frame = new JFrame("Decathlon points calculator");
		gui.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gui.outputChoise = new ButtonGroup();
		gui.csv = new JRadioButton("to csv");
		gui.xml = new JRadioButton("to xml");
		gui.monitor = new JRadioButton("show in table");
		
		gui.outputChoise.add(gui.csv);
		gui.outputChoise.add(gui.xml);
		gui.outputChoise.add(gui.monitor);
		
		gui.monitor.setSelected(true);
		
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
	
	/**
	 * Method to output competition to choosen source.
	 * @param competition to print
	 */
	public void printCompetition(Competition competition) {
		if(this.csv.isSelected()) {
			try {
				new CSVFileWriter().writeCompetition(competition);
			}catch(IOException e) {
				System.out.println("Cannot write to CSV file!");
			}
		}
		else if(this.xml.isSelected()) {
			try {
				new XMLFileWriter().writeCompetition(competition);
			}
			catch (IOException e) {
				
				System.out.println("Cannot write to XML file!");
			}					
		}
		else if(this.monitor.isSelected()) {
			this.resultTable.updateTable(competition);
		}
		this.frame.pack();
	}

}
