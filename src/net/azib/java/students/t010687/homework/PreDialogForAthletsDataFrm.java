package net.azib.java.students.t010687.homework;

//import javax.swing.text.html.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * PreDialogAthletsDataFrm
 *
 * @author Matu
 */
public class PreDialogForAthletsDataFrm extends JDialog{
	/** serialVersionUID */
	private static final long serialVersionUID = -3383891752642184013L;

	public PreDialogForAthletsDataFrm(JFrame MyFrame) {
		super(MyFrame,"DECATHLON: Please select the Data source:");
	    addWindowListener(new WindowAdapter(){
	            public void windowClosing(WindowEvent evt){
	        System.exit(0);
	            }
	        });
	    this.setResizable(false);

		JLabel lbl_Request = new JLabel("<html><br><head><h2>" + "Please select the Data source:" + "</h2></head></html>");
		lbl_Request.setHorizontalAlignment(JLabel.CENTER);
		this.add(lbl_Request, BorderLayout.NORTH);//,
		
		JButton btn_DataFromCVS = new JButton("<html>" + "The data situates" + "<br>" + "in local machine" + "</html>");
		btn_DataFromCVS.addActionListener(new ReadDataFromCSV(MyFrame));
		JButton btn_DataFromSQL = new JButton("<html>" + "The data situates" + "<br>" + "on the SQL server" + "</html>");
		btn_DataFromSQL.addActionListener(new ReadDataFromSQL(MyFrame));
		//JButton btn_Exit = new JButton("<html>" + "My mistake!" + "<br>" + "Please exit!" + "</html>");
		//btn_Exit.addActionListener(new ReadDataFromSQL());
		
		Panel panel = new Panel();
		panel.add(btn_DataFromCVS);
		panel.add(btn_DataFromSQL);
		//panel.add(btn_Exit);
	
		this.add(panel, BorderLayout.CENTER);
		this.setSize(400, 200);
		this.setVisible(true);

		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
}
