package net.azib.java.students.t050657.homework.src.UI;

import net.azib.java.students.t050657.homework.src.controller.DataAccessor;
import net.azib.java.students.t050657.homework.src.model.Competition;

import java.awt.event.ActionListener;
import java.beans.EventHandler;

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
		
		Competition competition = DataAccessor.getCompetitionInfo(
								dbCompetitionPanel.date.getText(),
								dbCompetitionPanel.country.getText(), 
								dbCompetitionPanel.title.getText(), 
								"jdbc:mysql://srv.azib.net/decathlon", 
								"java", 
								"java");
		
		competition.calculateAndSetPlaces();
		
		if(gui.csv.isSelected()) {
			new DataAccessor().writeToFile(competition, 1);
		}
		else if(gui.xml.isSelected()) {
			new DataAccessor().writeToFile(competition, 2);		
		}
		else if(gui.monitor.isSelected()) {
			gui.resultTable.updateTable(competition);
		}
		gui.frame.pack();
	}

}
