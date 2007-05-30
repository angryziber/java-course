package net.azib.java.students.t050657.homework.ui;

import net.azib.java.students.t050657.homework.model.DecathlonCoeficient;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * ResultsPanel
 *
 * @author Boriss
 */
public class ResultsPanel extends JPanel{
	
	/** serialVersionUID */
	private static final long serialVersionUID = -8359647816604784184L;
	
	JTextField m100;
	JTextField longJump;
	JTextField shortPut;
	JTextField highJump;
	JTextField m400;
	JTextField m110Hurdles;
	JTextField discusThrow;
	JTextField poleVault;
	JTextField javelinThrow;
	JTextField m1500;
	
	private Dimension dim = new Dimension(30, 18);
	
	public ResultsPanel() {
		createGUI();
		showGUI();
	}
	
	private void createGUI() {
		m100 = new JTextField();
		longJump= new JTextField();
		shortPut = new JTextField();
		highJump = new JTextField();
		m400 = new JTextField();
		m110Hurdles = new JTextField();
		discusThrow = new JTextField();
		poleVault = new JTextField();
		javelinThrow = new JTextField();
		m1500 = new JTextField();
		
		m100.setPreferredSize(dim);
		longJump.setPreferredSize(dim);
		shortPut.setPreferredSize(dim);
		highJump.setPreferredSize(dim);
		m400.setPreferredSize(dim);
		m110Hurdles.setPreferredSize(dim);
		discusThrow.setPreferredSize(dim);
		poleVault.setPreferredSize(dim);
		javelinThrow.setPreferredSize(dim);
		m1500.setPreferredSize(dim);
	}
	
	private void showGUI() {
		GridLayout gl = new GridLayout(5,2);
		gl.setHgap(4);
		gl.setVgap(4);
		
		this.setLayout(gl);
		
		this.add(new JLabel(DecathlonCoeficient.M_100.getTitle() + " (sec)"));
		this.add(m100);
		
		this.add(new JLabel(DecathlonCoeficient.LONG_JUMP.getTitle() + " (cm)"));
		this.add(longJump);
		
		this.add(new JLabel(DecathlonCoeficient.SHOT_PUT.getTitle() + " (m)"));
		this.add(shortPut);
		
		this.add(new JLabel(DecathlonCoeficient.HIGH_JUMP.getTitle() + " (cm)"  ));
		this.add(highJump);
		
		this.add(new JLabel(DecathlonCoeficient.M_400.getTitle() + " (sec)"));
		this.add(m400);
		
		this.add(new JLabel(DecathlonCoeficient.M_110_HURDLES.getTitle() + " (sec)"));
		this.add(m110Hurdles);
		
		this.add(new JLabel(DecathlonCoeficient.DISCUS_THROW.getTitle() + " (m)"));
		this.add(discusThrow);
		
		this.add(new JLabel(DecathlonCoeficient.POLE_VAULT.getTitle() + " (cm)"));
		this.add(poleVault);
		
		this.add(new JLabel(DecathlonCoeficient.JAVELIN_THROW.getTitle() + " (m)"));
		this.add(javelinThrow);
		
		this.add(new JLabel(DecathlonCoeficient.M_1500.getTitle() + " (sec)"));
		this.add(m1500);
	}
	
	public boolean checkResultInput() {
		Pattern format = Pattern.compile("[1-9][0-9]*\\.?[0-9]{0,2}");
		if(format.matcher(this.discusThrow.getText()).matches()
				&& format.matcher(this.highJump.getText()).matches()
				&& format.matcher(this.javelinThrow.getText()).matches()
				&& format.matcher(this.longJump.getText()).matches()
				&& format.matcher(this.m100.getText()).matches()
				&& format.matcher(this.m110Hurdles.getText()).matches()
				&& format.matcher(this.shortPut.getText()).matches()
				&& format.matcher(this.poleVault.getText()).matches()
				&& format.matcher(this.m400.getText()).matches()
				&& format.matcher(this.m1500.getText()).matches()) {
			return true;
		}
		return false;
	}

}
