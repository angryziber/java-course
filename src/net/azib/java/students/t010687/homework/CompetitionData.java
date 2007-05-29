package net.azib.java.students.t010687.homework;
import javax.swing.*;
import javax.swing.table.*;
/**
 * CompetitionData
 *
 * @author Ylo
 */
public class CompetitionData {
	
	 public CompetitionData(){
		 InsertRows();
	 }
	 
	 public void InsertRows(){
		    JFrame frame = new JFrame("Inserting rows in the table!");
		    JPanel panel = new JPanel();
		    //* Name
		    //* Date of birth
		    //* Country (ISO 2-letter code)
		    //* Raw results (measurements) for each of 10 decathlon events
		    String data[][] = {{"Siim Susi","01.01.1976","EE"},{"Beata Kana","29.02.1982","ZA"},{"Szőrös Szűk","03.04.1972","HU"}};
		    String col[] = {"First And Last Name","Date of birth","Country"};
		    DefaultTableModel model = new DefaultTableModel(data,col);
		    //DefaultTableColumnModel model = new DefaultTableColumnModel(data,col);
		    
		    JTable table = new JTable(model);
		    //table.
		    //Insert first position
		    model.insertRow(0,new Object[]{"Ranjan","50"});
		    //Insert 4 position
		    model.insertRow(3,new Object[]{"Amar","600"});
		    //Insert last position
		    model.insertRow(table.getRowCount(),new Object[]{"Sushil","600"});
		    panel.add(table);
		    frame.add(panel);
		    frame.setSize(300,300);
		    frame.setVisible(true);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  }
}
