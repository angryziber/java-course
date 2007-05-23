package net.azib.java.students.t050657.homework.src.UI;

import net.azib.java.students.t050657.homework.src.controller.DataAccessor;
import net.azib.java.students.t050657.homework.src.model.Competition;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * FileAccessPanel
 *
 * @author Boriss
 */
public class FileAccessPanel extends JPanel{

	/** serialVersionUID */
	private static final long serialVersionUID = -2673328986837450631L;
	
	DecathlonGUI gui;
	
	JButton buttonParse;
	JButton buttonBrowse;
	JTextField textField;
	
	CompetitionPanel competitionPanel;
	
	public FileAccessPanel(DecathlonGUI gui) {
		this.gui = gui;
		
		BorderLayout bl = new BorderLayout();
		bl.setHgap(4);
		bl.setVgap(4);
		this.setLayout(bl);
		Dimension dim = new Dimension(100, 18);
		
		competitionPanel = new CompetitionPanel();
		competitionPanel.button.setText("Set competition");
		
		textField = new JTextField();
		buttonBrowse = new JButton("Browse");
		buttonParse = new JButton("Calculate results");

		buttonParse.setSize(dim);
		buttonBrowse.setSize(dim);
		
		buttonParse.addActionListener(EventHandler.create(
				ActionListener.class, this, "output"));
		buttonBrowse.addActionListener(EventHandler.create(
				ActionListener.class, this, "buttonBrowse"));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(buttonParse);
		
		JPanel pathPanel = new JPanel();
		pathPanel.setLayout(new BorderLayout());
		pathPanel.add(new JLabel("File path:"), BorderLayout.NORTH);
		pathPanel.add(textField, BorderLayout.CENTER);
		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(pathPanel, BorderLayout.NORTH);
		p.add(buttonPanel, BorderLayout.CENTER);

		this.add(competitionPanel, BorderLayout.NORTH);
		this.add(p, BorderLayout.CENTER);
	}
	
	public void output() {

		if(!this.competitionPanel.checkCompetitionInput()) {
			return;
		}else if(this.textField.getText().equals("")) {
			competitionPanel.warning.setText("File path should be inserted");
			return;
		}else {
			competitionPanel.warning.setText("");
		}
		
		Competition competition = DataAccessor.getCompetitionInfo(
								competitionPanel.date.getText(),
								competitionPanel.country.getText(), 
								competitionPanel.title.getText(), 
								textField.getText());
		
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
