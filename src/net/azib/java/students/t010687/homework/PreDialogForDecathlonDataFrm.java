package net.azib.java.students.t010687.homework;


import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
/**
 * PreDialogAthletsDataFrm
 *
 * @author Matu
 */
public class PreDialogForDecathlonDataFrm extends JDialog{
	/** serialVersionUID */
	private static final long serialVersionUID = -3383891752642184013L;

	public PreDialogForDecathlonDataFrm(JFrame MyFrame) {
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
		JButton btn_NewDataSheet = new JButton("<html>" + "New competition" + "<br>" + "(New Data Sheet)" + "</html>");
		btn_NewDataSheet.addActionListener(new GenerateEmptyDataList(MyFrame));
		
		Panel panel = new Panel();
		panel.add(btn_DataFromCVS);
		panel.add(btn_DataFromSQL);
		panel.add(btn_NewDataSheet);
	
		this.add(panel, BorderLayout.CENTER);
		this.setSize(400, 200);
		this.setVisible(true);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	private class GenerateEmptyDataList implements ActionListener{
		private JFrame ParentFrm;
		private GenerateEmptyDataList(JFrame Related_frame){
	    	ParentFrm = Related_frame;
	    }
		public void actionPerformed(ActionEvent arg0) {
			List<ResultsOfTheAthlet> EmptyDechatlonList = new ArrayList<ResultsOfTheAthlet>();
			ResultsOfTheAthlet EmptyResult = new ResultsOfTheAthlet("XXXXNewAthleteXXXX", "01.01.1999", "--");
			EmptyResult.setSprint_100m(0);	//(sec)
			EmptyResult.setLongJump(0);		//(m)
			EmptyResult.setShotPut(0);		//(m)
			EmptyResult.setHighJump(0);		//(m)
			EmptyResult.setSprint_400m(0);	//(min:sec)
			EmptyResult.setHurdles_110m(0);	//(sec)
			EmptyResult.setDiscusThrow(0);	//(m)
			EmptyResult.setPoleVault(0);	//(m)
			EmptyResult.setJavelinThrow(0);	//(m)
			EmptyResult.setRace_1500m(0);	//(min:sec)
			EmptyDechatlonList.add(EmptyResult);
        	ParentFrm.dispose();
        	new DecathlonDataFrm(EmptyDechatlonList);
		}
	}
}
