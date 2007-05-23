package net.azib.java.students.t050657.homework.src.UI;

import net.azib.java.students.t050657.homework.src.controller.DataAccessor;
import net.azib.java.students.t050657.homework.src.model.Athlet;
import net.azib.java.students.t050657.homework.src.model.Competition;
import net.azib.java.students.t050657.homework.src.model.InsufficientResultsException;
import net.azib.java.students.t050657.homework.src.model.Result;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
		
		Calendar cal = getCalendarFromString(this.competitionPanel.date.getText());
		
		competition = new Competition();
		competition.setDescription(this.competitionPanel.title.getText());
		competition.setEventDate(cal);
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
		
		Calendar cal = getCalendarFromString(this.atletPanel.dateOfBirth.getText());
		
		Athlet athlet = new Athlet();
		athlet.setName(this.atletPanel.name.getText());
		athlet.setCountryCode(this.atletPanel.country.getText());
		athlet.setDateOfBirth(cal);

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
	
	private Calendar getCalendarFromString(String date) {
		String[] compDate = date.split("-");
		Calendar cal = new GregorianCalendar();
		cal.setLenient(true);
		cal.set(Integer.parseInt(compDate[0]),
				Integer.parseInt(compDate[1]) - 1, 
				Integer.parseInt(compDate[2]));
		return cal;
	}
	
	public void printCompetition() {
		if(this.gui.csv.isSelected()) {
			new DataAccessor().writeToFile(competition, 1);
		}else if(this.gui.xml.isSelected()){
			new DataAccessor().writeToFile(competition, 2);
		}
	}

}
