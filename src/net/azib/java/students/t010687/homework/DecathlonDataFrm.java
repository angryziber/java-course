package net.azib.java.students.t010687.homework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

/**
 * AthletsDataFrm
 *
 * @author Matu
 */
public class DecathlonDataFrm {
    private CompetResultsModel competResultsMdl;
    public DecathlonDataFrm(List <ResultsOfTheAthlet> ListWithDecathlonData){
    	Collections.sort(ListWithDecathlonData);
    	JFrame frame = new JFrame("DECATHLON");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	JTabbedPane tab = new JTabbedPane();
		
    	frame.add(tab, BorderLayout.CENTER);
    	tab.add("AthletesCommonInfo", panelWithAthletesCommonInfo(ListWithDecathlonData));
    	
    	/////////////////////////
    	competResultsMdl = new CompetResultsModel(ListWithDecathlonData);
    	TableRowSorter <CompetResultsModel> resultsSorter = new TableRowSorter<CompetResultsModel>(competResultsMdl);//<CompetResultsModel> 
    	resultsSorter.setSortsOnUpdates(true);
    	resultsSorter.toggleSortOrder(0);
    	JTable table = new JTable(competResultsMdl);
        table.setRowSorter(resultsSorter);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
	    table.getTableHeader().setBackground(Color.yellow);
    	tab.add("CompetitionResults", new JScrollPane(table));
    	/////////////////////////
    	CompetPointsModel competPointsMdl = new CompetPointsModel(ListWithDecathlonData);
    	TableRowSorter <CompetPointsModel> pointsSorter = new TableRowSorter<CompetPointsModel>(competPointsMdl);//<CompetResultsModel> 
    	pointsSorter.setSortsOnUpdates(true);
    	pointsSorter.toggleSortOrder(11);
    	pointsSorter.toggleSortOrder(11);
    	table = new JTable(competPointsMdl);
        table.setRowSorter(pointsSorter);
        
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
	    table.getTableHeader().setBackground(Color.yellow);
    	tab.add("CompetitionPointsAndRank", new JScrollPane(table));
    	/////////////////////////
    	frame.setSize(1200,400);
    	frame.setVisible(true);
    	
    	//model.insertRow(table.getRowCount(),new String[]{"AthletsName","Sprint100m(sec)","LongJump(m)",
        //	"ShotPut(m)","HighJump(m)","Sprint400m(min:sec)","Hurdles110m(sec)",
        //	"DiscusThrow(m)","PoleVault(m)","JavelinThrow(m)","Race1500m(min:sec)"});
    }
    private Panel panelWithAthletesCommonInfo(List <ResultsOfTheAthlet>ListWithDecathlonData){
		Panel panel = new Panel();
		String colHeaders[] = {"AthletsName","DateOfBirth","Country"};
		String data[][] = new String[ListWithDecathlonData.size()][3];
		//for(ResultsOfTheAthlet Results : ListWithDecathlonData){
		//we need counter for data[][]. There is no pint for For..each loop
		for(int j = 0; j<ListWithDecathlonData.size(); j++){
			data[j] = new String []{ListWithDecathlonData.get(j).getName(),
			ListWithDecathlonData.get(j).getDateOfBirth(),
			ListWithDecathlonData.get(j).getCountry()};
		}

	    DefaultTableModel model = new DefaultTableModel(data,colHeaders);
	    JTable table = new JTable(model);
	    table.getTableHeader().setBackground(Color.yellow);
	    JScrollPane pane = new JScrollPane(table);
	    panel.add(pane);
		return panel;	
    }
    class CompetResultsModel extends AbstractTableModel {
        /** serialVersionUID */
		private static final long serialVersionUID = 1L;
		public String[] columnNames = new String []{"AthletsName","Sprint100m(sec)","LongJump(m)",
            	"ShotPut(m)","HighJump(m)","Sprint400m(min:sec)","Hurdles110m(sec)",
            	"DiscusThrow(m)","PoleVault(m)","JavelinThrow(m)","Race1500m(min:sec)", "Points"};
        public Object[][] data;

        public CompetResultsModel(List <ResultsOfTheAthlet> Results) {
        	data = new Object[Results.size()][0xD];
         	for(int j = 0; j<Results.size(); j++){
         		data[j]= new Object []{Results.get(j).getName(),
     			Results.get(j).getSprint_100m(), Results.get(j).getLongJump(),
     			Results.get(j).getShotPut(), Results.get(j).getHighJump(),
     			Results.get(j).getSprint_400m(), Results.get(j).getHurdles_110m(),
     			Results.get(j).getDiscusThrow(), Results.get(j).getPoleVault(),
     			Results.get(j).getJavelinThrow(), Results.get(j).getRace_1500m(),
     			Results.get(j).getPoints(), Results.get(j)};
     		}
        }
        public int getColumnCount() {return columnNames.length;}
        public int getRowCount() {return data.length;}
        public String getColumnName(int col) {return columnNames[col];}
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }
        //public Class <Object> getColumnClass(int c) {
        //     return getValueAt(0, c).getClass();
        //}
        public boolean isCellEditable(int row, int col) {
            //The data/cell address is constant,
            //no matter where the cell appears onscreen.
            if ((col < 1) || (col > 10)) {
                return false;
            } else {
                return true;
            }
        }

        public void setValueAt(Object value, int row, int col) {
        	ResultsOfTheAthlet Result = (ResultsOfTheAthlet)data[row][columnNames.length];
        	switch(col){
        		case 1:
        			Result.setSprint_100m((String)value);
        			data[row][col] = Result.getSprint_100m();
        			break;
        		case 2:
        			Result.setLongJump((String)value);
        			data[row][col] = Result.getLongJump();
        			break;
        		case 3:
        			Result.setShotPut((String)value);
        			data[row][col] = Result.getShotPut();
        			break;         		
        		case 4:
        			Result.setHighJump((String)value);
        			data[row][col] = Result.getHighJump();
        			break;          		
        		case 5:
        			Result.setSprint_400m((String)value);
        			data[row][col] = Result.getSprint_400m();
        			break;          	
        		case 6:
        			Result.setHurdles_110m((String)value);
        			data[row][col] = Result.getHurdles_110m();
        			break;                 		
        		case 7:
        			Result.setDiscusThrow((String)value);
        			data[row][col] = Result.getDiscusThrow();
        			break;          		
        		case 8:
        			Result.setPoleVault((String)value);
        			data[row][col] = Result.getPoleVault();
        			break;   
        		case 9:
        			Result.setJavelinThrow((String)value);
        			data[row][col] = Result.getJavelinThrow();
        			break;              		
        		case 10:
    				Result.setRace_1500m((String)value);
    				data[row][col] = Result.getJavelinThrow();
    				break;            		
        	}
            fireTableCellUpdated(row, col);
        }
    }
    class CompetPointsModel extends AbstractTableModel {
        /** serialVersionUID */
		private static final long serialVersionUID = 1L;
		public String[] columnNames = new String []{"Rank", "AthletsName","Sprint100Points","LongJump(m)",
            	"ShotPut(m)","HighJump(m)","Sprint400m(min:sec)","Hurdles110m(sec)",
            	"DiscusThrow(m)","PoleVault(m)","JavelinThrow(m)","Race1500m(min:sec)", "Points"};
        public Object[][] data;
        private List <ResultsOfTheAthlet> Results;
        public CompetPointsModel(List <ResultsOfTheAthlet> Results) {
        	data = new Object[Results.size()][0xE];
        	this.Results = Results;
        	String AthletesRanks[] = getAthletesRanks();
         	for(int j = 0; j<Results.size(); j++){
         		data[j]= new Object []{AthletesRanks[j], Results.get(j).getName(),
     			Results.get(j).getSprint_100mPoints(), Results.get(j).getLongJumpPoints(),
     			Results.get(j).getShotPutPoints(), Results.get(j).getHighJumpPoints(),
     			Results.get(j).getSprint_400mPoints(), Results.get(j).getHurdles_110mPoints(),
     			Results.get(j).getDiscusThrowPoints(), Results.get(j).getPoleVaultPoints(),
     			Results.get(j).getJavelinThrowPoints(), Results.get(j).getRace_1500mPoints(),
     			Results.get(j).getPoints(), Results.get(j)};
     		}
        }
        public String[] getAthletesRanks() {
        	int newRank = 0;
        	String Ranks[] = new String[Results.size()];
        	for(int curRank= 0; curRank< Results.size(); curRank++){
        		newRank = setRank(curRank);
        		if (curRank==newRank){
        			Ranks[curRank] = ((Integer)(curRank+1)).toString();}
        		else{
        			for(int i = curRank; i<= newRank; i++){
        				Ranks[i] = (curRank+1) + " - " + (newRank+1);
        			}
        			curRank = newRank;
        		}
        	}	
        	return Ranks; 
        }
        private int setRank(int curRank){
        	if (curRank < Results.size() -1){
        		System.out.println(curRank);
        		if (Results.get(curRank).getPoints()> Results.get(curRank +1).getPoints()){
        			return curRank;
        		}
        		else {
        			return setRank(curRank + 1);
        		}
        	}
        	else{return curRank;}
        }
        public int getColumnCount() {return columnNames.length;}
        public int getRowCount() {return data.length;}
        public String getColumnName(int col) {return columnNames[col];}
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }
        //public Class <Object> getColumnClass(int c) {
        //     return getValueAt(0, c).getClass();
        //}
        public boolean isCellEditable(int row, int col) {
        	//Non editable
        	return false;
        }

        public void setValueAt(Object value, int row, int col) {
        	ResultsOfTheAthlet Result = (ResultsOfTheAthlet)data[row][columnNames.length];
        			Result.setSprint_100m((String)value);
        			data[row][col] = Result.getSprint_100m();
            fireTableCellUpdated(row, col);
        }
    }
}
