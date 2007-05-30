package net.azib.java.students.t050657.homework.ui;

import net.azib.java.students.t050657.homework.ctrl.dataAccess.DBAccessor;
import net.azib.java.students.t050657.homework.ctrl.dataOutput.CSVFileWriter;
import net.azib.java.students.t050657.homework.ctrl.dataOutput.XMLFileWriter;
import net.azib.java.students.t050657.homework.model.Competition;

import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.io.IOException;
import java.sql.Date;

import javax.swing.JPanel;

/**
 * DBAccessPanel
 *
 * @author Boriss
 */
public class DBAccessPanel extends JPanel{
	
	/** serialVersionUID */
	private static final long serialVersionUID = -818604148395622646L;
	
	DecathlonGUI gui;
	
	CompetitionPanel dbCompetitionPanel;

	public DBAccessPanel(DecathlonGUI gui) {
		this.gui = gui;
		
		dbCompetitionPanel = new CompetitionPanel();
		dbCompetitionPanel.button.setText("Calculate results");
		dbCompetitionPanel.button.addActionListener(EventHandler.create(ActionListener.class,
								this, "analizeCompetition"));
		this.add(dbCompetitionPanel);
	}
	
	public void analizeCompetition() {
		
		if(!this.dbCompetitionPanel.checkCompetitionInput()) {
			return;
		}
		
		
		
		Competition competition = new DBAccessor().getCompetition(
								dbCompetitionPanel.country.getText(),
								Date.valueOf(dbCompetitionPanel.date.getText()),
								dbCompetitionPanel.title.getText());
		
		competition.calculateAndSetPlaces();
		
		if(gui.csv.isSelected()) {
			try {
				new CSVFileWriter().writeCompetition(competition);
			}catch(IOException e) {
				System.out.println("Cannot write to CSV file!");
			}
		}
		else if(gui.xml.isSelected()) {
			try {
				new XMLFileWriter().writeCompetition(competition);
			}
			catch (IOException e) {
				System.out.println("Cannot write to XML file!");
			}					
		}
		else if(gui.monitor.isSelected()) {
			gui.resultTable.updateTable(competition);
		}
		gui.frame.pack();
	}

}
