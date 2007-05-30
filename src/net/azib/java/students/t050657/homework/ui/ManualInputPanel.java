package net.azib.java.students.t050657.homework.ui;

import net.azib.java.students.t050657.homework.ctrl.dataOutput.CSVFileWriter;
import net.azib.java.students.t050657.homework.ctrl.dataOutput.XMLFileWriter;
import net.azib.java.students.t050657.homework.model.Athlet;
import net.azib.java.students.t050657.homework.model.Competition;
import net.azib.java.students.t050657.homework.model.InsufficientResultsException;
import net.azib.java.students.t050657.homework.model.Result;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * ManualInputPanel
 *
 * @author Boriss
 */
public class ManualInputPanel extends JPanel{
	
	/** serialVersionUID */
	private static final long serialVersionUID = -6005197285227296187L;
	
	DecathlonGUI gui;
	
	CompetitionPanel competitionPanel;
	AthletPanel atletPanel;
	
	private Competition competition;
	
	public ManualInputPanel(DecathlonGUI gui) {
		this.gui = gui;
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
				
		competitionPanel = new CompetitionPanel();
		competitionPanel.button.setText("Add competition");
		competitionPanel.button.addActionListener(EventHandler.create(ActionListener.class,
				this, "addCompetition"));
		
		atletPanel = new AthletPanel();
		atletPanel.button.setText("Add athlet and result");
		atletPanel.button.addActionListener(EventHandler.create(ActionListener.class,
				this, "addAthlet"));
		
		panel.add(competitionPanel, BorderLayout.NORTH);
		panel.add(atletPanel, BorderLayout.CENTER);
		
		JButton outputComp = new JButton("Print competition");
		outputComp.addActionListener(EventHandler.create(
				ActionListener.class, this, "printCompetition"));
		
		panel.add(outputComp, BorderLayout.SOUTH);
		
		this.add(panel);
	}
	
	public void addCompetition() {
		if(!this.competitionPanel.checkCompetitionInput()) {
			return;
		}
		
		competition = new Competition();
		competition.setDescription(this.competitionPanel.title.getText());
		competition.setEventDate(Date.valueOf(this.competitionPanel.date.getText()));
		competition.setCountryCode(this.competitionPanel.country.getText());
		
		gui.resultTable.title.setText(competition.toString());
		
		gui.frame.pack();
	}
	
	public void addAthlet() {
		if(competition == null) {
			this.atletPanel.warning.setText("Insert competition first");
			return;
		}else if(!this.atletPanel.checkAthletInput()) {
			return;
		}else if(!this.atletPanel.resultPanel.checkResultInput()) {
			this.competitionPanel.warning.setText("Not all results were " +
					"inserted or unappropriate format");
			return;
		}
		
		Athlet athlet = new Athlet();
		athlet.setName(this.atletPanel.name.getText());
		athlet.setCountryCode(this.atletPanel.country.getText());
		athlet.setDateOfBirth(Date.valueOf(this.atletPanel.dateOfBirth.getText()));

		Result result = new Result();
		
		List<Double> resultList = new ArrayList<Double>();
		
		resultList.add(Double.parseDouble(this.atletPanel.resultPanel.m100.getText().trim()));
		resultList.add(Double.parseDouble(this.atletPanel.resultPanel.longJump.getText().trim()));
		resultList.add(Double.parseDouble(this.atletPanel.resultPanel.shortPut.getText().trim()));
		resultList.add(Double.parseDouble(this.atletPanel.resultPanel.highJump.getText().trim()));
		resultList.add(Double.parseDouble(this.atletPanel.resultPanel.m400.getText().trim()));
		resultList.add(Double.parseDouble(this.atletPanel.resultPanel.m110Hurdles.getText().trim()));
		resultList.add(Double.parseDouble(this.atletPanel.resultPanel.discusThrow.getText().trim()));
		resultList.add(Double.parseDouble(this.atletPanel.resultPanel.poleVault.getText().trim()));
		resultList.add(Double.parseDouble(this.atletPanel.resultPanel.javelinThrow.getText().trim()));
		resultList.add(Double.parseDouble(this.atletPanel.resultPanel.m1500.getText().trim()));
		
		try {
			result.setResults(resultList);
		}
		catch (InsufficientResultsException e) {
			System.out.println("Not all result were added!");
		}
			
		athlet.setResult(result);
		athlet.calculateAndSetFinalScore();
		competition.addAthlet(athlet);
		competition.calculateAndSetPlaces();
		
		gui.resultTable.updateTable(competition);
		gui.frame.pack();
		
		System.out.println(competition.getAthlets());
	}
	
	public void printCompetition() {
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
