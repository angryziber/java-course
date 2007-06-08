package net.azib.java.students.t050657.homework.ui;

import net.azib.java.students.t050657.homework.ctrl.dataAccess.CSVFileAccessor;
import net.azib.java.students.t050657.homework.model.Competition;
import net.azib.java.students.t050657.homework.model.InsufficientResultsException;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.util.List;

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
	JTextField textField;

	public FileAccessPanel(DecathlonGUI gui) {
		this.gui = gui;
		
		BorderLayout bl = new BorderLayout();
		bl.setHgap(4);
		bl.setVgap(4);
		this.setLayout(bl);
		Dimension dim = new Dimension(100, 18);

		
		textField = new JTextField();
		buttonParse = new JButton("Calculate results");

		buttonParse.setSize(dim);
		
		buttonParse.addActionListener(EventHandler.create(
				ActionListener.class, this, "output"));
		
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

		this.add(p, BorderLayout.CENTER);
	}
	
	public void output() {
		String filepath = textField.getText();
		
		Competition competition = null;
		List<Competition> compsList = new CSVFileAccessor().setFilepath(filepath).getCompetition();
		
		if(!compsList.isEmpty()) {
			competition = compsList.get(0);
			try {
				competition.calculateAndSetPlaces();
			}
			catch (InsufficientResultsException e1) {
				e1.printStackTrace();
			}
			
			gui.printCompetition(competition);
		}
		
		gui.frame.pack();
	}

}
