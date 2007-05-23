package net.azib.java.students.t050657.homework.src.UI;

import net.azib.java.students.t050657.homework.src.model.Competition;
import net.azib.java.students.t050657.homework.src.model.DecathlonCoeficient;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * OutputTable
 *
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
	
	public void updateTable(Competition competition) {
		this.remove(scrollPane);
		title.setText(competition.toString());
		
		String[][] athlets = new String[competition.getAthlets().size()][13];
	 	
 		for(int i=0; i<competition.getAthlets().size(); i++) {
			athlets[i][0] = competition.getAthlets().get(i).getName();
			athlets[i][1] = competition.getAthlets().get(i).getPlace();
			athlets[i][2] = Double.toString(competition.getAthlets().get(i).getFinalScore()); 
			
			int j = 1;
			for(DecathlonCoeficient decCoef : DecathlonCoeficient.values()) {
				athlets[i][j+2] = Double.toString(competition.getAthlets().
						get(i).getResult().getConvertedResult(decCoef));
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
