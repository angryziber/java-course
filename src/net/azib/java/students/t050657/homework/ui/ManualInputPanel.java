package net.azib.java.students.t050657.homework.ui;

import net.azib.java.students.t050657.homework.model.Athlet;
import net.azib.java.students.t050657.homework.model.Competition;
import net.azib.java.students.t050657.homework.model.InsufficientResultsException;
import net.azib.java.students.t050657.homework.model.Result;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * ManualInputPanel for input athlet and results for it.
 * @author Boriss
 */
public class ManualInputPanel extends JPanel{
	
	/** serialVersionUID */
	private static final long serialVersionUID = -6005197285227296187L;
	
	DecathlonGUI gui;
	AthletPanel atletPanel;
	private Competition competition = new Competition();
	
	public ManualInputPanel(DecathlonGUI gui) {
		this.gui = gui;
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
				
		atletPanel = new AthletPanel();
		atletPanel.button.setText("Add athlet and result");
		atletPanel.button.addActionListener(EventHandler.create(ActionListener.class,
				this, "addAthlet"));
		
		panel.add(atletPanel, BorderLayout.CENTER);
		
		JButton outputComp = new JButton("Write competition to file");
		outputComp.addActionListener(EventHandler.create(
				ActionListener.class, this, "printCompetition"));
		
		panel.add(outputComp, BorderLayout.SOUTH);
		
		this.add(panel);
	}
	
	/**
	 * Method add athlet to competition.
	 */
	public void addAthlet() {
		if(competition == null) {
			this.atletPanel.warning.setText("Insert competition first");
			return;
		}else if(!this.atletPanel.checkAthletInput()) {
			return;
		}else if(!this.atletPanel.resultPanel.checkResultInput()) {
			this.atletPanel.warning.setText("Not all results were " +
					"inserted or unappropriate format");
			return;
		}
		
		Athlet athlet = new Athlet();
		athlet.setName(this.atletPanel.name.getText());
		athlet.setCountryCode(this.atletPanel.country.getText());
		athlet.setDateOfBirth(Date.valueOf(this.atletPanel.dateOfBirth.getText()));

		Result result = new Result(competition.getResults().size() + 1);
		
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
		
		result.setAthlet(athlet);
		
		try {
			result.calculateFinalScore();
			competition.addResult(result);
			competition.calculateAndSetPlaces();
		}
		catch (InsufficientResultsException e) {
			e.printStackTrace();
		}
		
		gui.resultTable.updateTable(competition);
		gui.frame.pack();
	}
	
	/**
	 * Prints competition to source.
	 */
	public void printCompetition() {
		gui.printCompetition(competition);
	}
}
