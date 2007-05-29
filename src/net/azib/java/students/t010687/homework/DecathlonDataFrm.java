package net.azib.java.students.t010687.homework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 * AthletsDataFrm
 *
 * @author Matu
 */
public class DecathlonDataFrm {
    //JFrame frame = new JFrame("Managing Athlets Pers Info");
    //JPanel panel = new JPanel();
    //String col[] = {"First And Last Name","Date of birth","Country"};
    
    public DecathlonDataFrm(List <ResultsOfTheAthlet> ListWithDecathlonData){
    	JFrame frame = new JFrame("DECATHLON");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	JTabbedPane tab = new JTabbedPane();
		Panel panel = new Panel();
		String colHeaders[] = {"AthletsName","DateOfBirth","Country"};
		//String data[ListWithDecathlonData.size()][3] = new 
		System.out.println(ListWithDecathlonData.size());
		String data[][] = new String[ListWithDecathlonData.size()][3];
		//for(ResultsOfTheAthlet Results : ListWithDecathlonData){
		//we need counter for data[][]. There is no pint for For..each loop
		for(int j = 0; j<ListWithDecathlonData.size(); j++){
			data[j][0] = ListWithDecathlonData.get(j).getName();
			data[j][1] = ListWithDecathlonData.get(j).getDateOfBirth();
			data[j][2] = ListWithDecathlonData.get(j).getCountry();
		}
		//= new Array<String>(data[ListWithDecathlonData.size()][3])
		//String data[][] = new[ListWithDecathlonData.size()][3] String();
		
		
	    /*String data[][] = {{"100","Vinod","programmer","5000"},
                {"101","Deepak","Content Writer","20000"},
                {"102","Noor","Techniqual Writer","30000"},
                {"104","Rinku","PHP programar","25000"}};
	    */
	    DefaultTableModel model = new DefaultTableModel(data,colHeaders);
	    JTable table = new JTable(model);
	    JTableHeader header = table.getTableHeader();
	    header.setBackground(Color.yellow);
	    JScrollPane pane = new JScrollPane(table);
	    panel.add(pane);
		//panel.add(new JButton("btn_AthletesCommonInfo"));
		frame.add(tab, BorderLayout.CENTER);

    	tab.add("AthletesCommonInfo", panel);
    	panel = new Panel();
    	panel.add(new JButton("btn_CompetitionResults"));
    	tab.add("CompetitionResults", panel);
    	frame.setSize(800,400);
    	frame.setVisible(true);
    }
}
