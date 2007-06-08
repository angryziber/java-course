package net.azib.java.students.t050657.homework.ui;

import net.azib.java.students.t050657.homework.model.Competition;
import net.azib.java.students.t050657.homework.model.DecathlonCoeficient;
import net.azib.java.students.t050657.homework.model.InsufficientResultsException;
import net.azib.java.students.t050657.homework.model.Result;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * OutputTable represents table to show results.
 * @author Boriss
 */
public class OutputTable extends JPanel{
	
	/** serialVersionUID */
	private static final long serialVersionUID = -4724179500529182463L;
	
	JLabel title;
	JTable table;
	JScrollPane scrollPane;
	
	private Font font = new Font("Arial Bold", 5, 24);
	private String[] columnNames = {"Name", "Place", "Final score",
							"100 m sprint", "Long jump", "Shot put",
							"High jump", "400 m sprint", "110 m hurdles",
							"Discus throw", "Pole vault", "Javelin throw",
							"1500 m race"};
	
	public OutputTable() {
		scrollPane = new JScrollPane(new JScrollBar(JScrollBar.VERTICAL));
		
		table = new JTable();
		table.setEnabled(false);
		
		title = new JLabel();
		title.setFont(font);
		
		this.setLayout(new BorderLayout());
		
		this.add(table, BorderLayout.SOUTH);
		this.add(title, BorderLayout.NORTH);
	}
	
	/**
	 * Method to update table when needed.
	 * @param competition to set into table
	 */
	public void updateTable(Competition competition) {
		this.remove(scrollPane);
		title.setText(competition.toString());
		
		String[][] athlets = new String[competition.getResults().size()][13];
	 	List<Result> resultList = new ArrayList<Result>();
	 	resultList.addAll(competition.getResults());
	 	
 		for(int i=0; i<competition.getResults().size(); i++) {
 			try {
				resultList.get(i).calculateFinalScore();
			}
			catch (InsufficientResultsException e) {
				e.printStackTrace();
			}
			athlets[i][0] = resultList.get(i).getAthlet().getName();
			athlets[i][1] = resultList.get(i).getPlace();
			athlets[i][2] = Double.toString(resultList.get(i).getFinalScore()); 
			
			int j = 1;
			for(DecathlonCoeficient decCoef : DecathlonCoeficient.values()) {
				try {
					athlets[i][j+2] = Double.toString(
							resultList.get(i).getResult(decCoef));
				}
				catch (InsufficientResultsException e) {
					e.printStackTrace();
				}
				j++;
			}
		}
 		
        final JTable table = new JTable(athlets, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        table.setEnabled(false);
        //table.setFillsViewportHeight(true);
        
        scrollPane = new JScrollPane(table);
 		this.add(scrollPane);
	}

}
