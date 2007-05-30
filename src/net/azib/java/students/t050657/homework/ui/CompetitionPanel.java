package net.azib.java.students.t050657.homework.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * CompetitionPanel
 *
 * @author Boriss
 */
public class CompetitionPanel extends JPanel{

	/** serialVersionUID */
	private static final long serialVersionUID = -3425791510320419741L;
	
	JTextField title;
	JTextField date;
	JTextField country;
	JLabel warning;
	JButton button;
	
	private Dimension dim = new Dimension(150, 18);
	
	public CompetitionPanel() {
		createElements();
		showElements();
	}
	
	private void createElements() {
		title = new JTextField();
		date = new JTextField();
		country = new JTextField();
		warning = new JLabel();
		button = new JButton();
		
		title.setPreferredSize(dim);
		date.setPreferredSize(dim);
		country.setPreferredSize(dim);
		
		warning.setForeground(Color.red);
	}
	
	private void showElements() {
		GridLayout gl = new GridLayout(3, 3);
		gl.setHgap(4);
		gl.setVgap(4);
		this.setLayout(gl);
		
		this.add(new JLabel("Competition title"));
		this.add(new JLabel("Competition date (yyyy-mm-dd)"));
		this.add(new JLabel("Competition country (code)"));
		
		this.add(title);
		this.add(date);
		this.add(country);
		
		this.add(new JLabel());
		this.add(warning);
		this.add(button);
	}
	
	public boolean checkCompetitionInput() {
		Pattern datePattern = Pattern.compile("[1-9][0-9]{3}-[0-9]{1,2}-[0-9]{1,2}");
		
		if(this.country.getText().equals("")) {
			this.warning.setText("Please, enter competition country!");
			return false;
		}else if(this.title.getText().equals("")) {
			this.warning.setText("Please, enter competition title!");
			return false;
		}else if(this.date.getText().equals("")) {
			this.warning.setText("Please, enter competition date in appropriate format!");
			return false;
		}else if(!datePattern.matcher(this.date.getText()).matches()) {
			this.warning.setText("Date should be in appropriate format!");
			return false;
		}
		return true;
	}
}
