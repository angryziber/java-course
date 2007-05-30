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
    
    public DecathlonDataFrm(List <ResultsOfTheAthlet> ListWithDecathlonData){
    	JFrame frame = new JFrame("DECATHLON");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	JTabbedPane tab = new JTabbedPane();
		Panel panel = new Panel();
		String colHeaders[] = {"AthletsName","DateOfBirth","Country"};
		String data[][] = new String[ListWithDecathlonData.size()][3];
		//for(ResultsOfTheAthlet Results : ListWithDecathlonData){
		//we need counter for data[][]. There is no pint for For..each loop
		for(int j = 0; j<ListWithDecathlonData.size(); j++){
			data[j][0] = ListWithDecathlonData.get(j).getName();
			data[j][1] = ListWithDecathlonData.get(j).getDateOfBirth();
			data[j][2] = ListWithDecathlonData.get(j).getCountry();
		}

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
    	colHeaders = new String []{"AthletsName","Sprint100m(sec)","LongJump(m)",
    	"ShotPut(m)","HighJump(m)","Sprint400m(min:sec)","Hurdles110m(sec)",
    	"DiscusThrow(m)","PoleVault(m)","JavelinThrow(m)","Race1500m(min:sec)"};
    	
    	data = new String[ListWithDecathlonData.size()][11];
    	for(int j = 0; j<ListWithDecathlonData.size(); j++){
			data[j][0] = ListWithDecathlonData.get(j).getName();
			data[j][1] = ListWithDecathlonData.get(j).getSprint_100m();
			data[j][2] = ListWithDecathlonData.get(j).getLongJump();
			data[j][3] = ListWithDecathlonData.get(j).getShotPut();
			data[j][4] = ListWithDecathlonData.get(j).getHighJump();
			data[j][5] = ListWithDecathlonData.get(j).getSprint_400m();
			data[j][6] = ListWithDecathlonData.get(j).getHurdles_110m();
			data[j][7] = ListWithDecathlonData.get(j).getDiscusThrow();
			data[j][8] = ListWithDecathlonData.get(j).getPoleVault();
			data[j][9] = ListWithDecathlonData.get(j).getJavelinThrow();
			data[j][10] = ListWithDecathlonData.get(j).getRace_1500m();
		}
    	table = new JTable(new DefaultTableModel(data,colHeaders));
    	table.setSize(1600, 1600);
	    header = table.getTableHeader();
	    header.setBackground(Color.yellow);

    	tab.add("CompetitionResults", new JScrollPane(table));
    	frame.setSize(800,400);
    	frame.setVisible(true);
    }
    

    }
