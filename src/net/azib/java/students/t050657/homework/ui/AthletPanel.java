package net.azib.java.students.t050657.homework.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * AthletPanel to set concrete athlet
 * @author Boriss
 */
public class AthletPanel extends JPanel{

	/** serialVersionUID */
	private static final long serialVersionUID = 1493845494701822060L;
	
	JTextField name;
	JTextField dateOfBirth;
	JTextField country;
	JLabel warning;
	ResultsPanel resultPanel;
	JButton button;
	
	private Dimension dim = new Dimension(100, 18);

	public AthletPanel() {
		createGUI();
		showGUI();
	}
	
	private void createGUI() {
		name = new JTextField();
		dateOfBirth = new JTextField();
		country = new JTextField();
		warning = new JLabel();
		resultPanel = new ResultsPanel();
		button = new JButton();
		
		name.setPreferredSize(dim);
		dateOfBirth.setPreferredSize(dim);
		country.setPreferredSize(dim);
		
		warning.setForeground(Color.red);
	}
	
	private void showGUI() {
		JPanel panel = new JPanel();
		
		GridLayout gl = new GridLayout(3, 3);
		gl.setHgap(4);
		gl.setVgap(4);
		panel.setLayout(gl);
		
		panel.add(new JLabel("Athlet name"));
		panel.add(new JLabel("Athlet date of birth"));
		panel.add(new JLabel("Athlet country"));
		
		panel.add(name);
		panel.add(dateOfBirth);
		panel.add(country);
		
		panel.add(new JLabel());
		panel.add(warning);
		panel.add(button);
		
		GridLayout grl = new GridLayout(2,1);
		this.setLayout(grl);
		this.add(panel, BorderLayout.NORTH);
		this.add(resultPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Method checks all athlet parameters are setted.
	 * @return true, if setted, false otherwise.
	 */
	public boolean checkAthletInput() {
		Pattern datePattern = Pattern.compile("[1-9][0-9]{3}-[0-9]{1,2}-[0-9]{1,2}");
		
		if(this.country.getText().equals("")) {
			this.warning.setText("Please, enter athlet country!");
			return false;
		}else if(this.name.getText().equals("")) {
			this.warning.setText("Please, enter athlet title!");
			return false;
		}else if(this.dateOfBirth.getText().equals("")) {
			this.warning.setText("Please, enter athlet's date in appropriate format!");
			return false;
		}else if(!datePattern.matcher(this.dateOfBirth.getText()).matches()) {
			this.warning.setText("Date should be in appropriate format!");
			return false;
		}
		return true;
	}
}
