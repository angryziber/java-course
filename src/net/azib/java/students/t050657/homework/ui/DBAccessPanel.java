package net.azib.java.students.t050657.homework.ui;

import net.azib.java.students.t050657.homework.ctrl.dataAccess.DBAccessor;
import net.azib.java.students.t050657.homework.model.Competition;
import net.azib.java.students.t050657.homework.model.InsufficientResultsException;

import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 * DBAccessPanel for access data from DB source
 * @author Boriss
 */
public class DBAccessPanel extends JPanel{
	
	/** serialVersionUID */
	private static final long serialVersionUID = -818604148395622646L;
	
	DecathlonGUI gui;
	
	JComboBox competitions;
	JButton calculate;

	public DBAccessPanel(DecathlonGUI gui) {
		this.gui = gui;
		competitions = new JComboBox();
		List<Competition> competitionList = new DBAccessor().getCompetition();
		
		calculate = new JButton("Calculate results");
		calculate.addActionListener(EventHandler.create(
				ActionListener.class, this, "analizeCompetition"));
		
		for(Competition competition : competitionList) {
			competitions.addItem(competition);
		}
		this.add(competitions);
		this.add(calculate);
	}
	
	public void analizeCompetition() {
		Competition competition = (Competition)competitions.getSelectedItem();

		competition = new DBAccessor().getResultsForCompetition(competition);
		
		try {
			competition.calculateAndSetPlaces();
		}
		catch (InsufficientResultsException e1) {
			System.out.println("Not all results were added to competition");
			e1.printStackTrace();
		}
		
		gui.printCompetition(competition);
		gui.frame.pack();
	}

}
