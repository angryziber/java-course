package net.azib.java.students.t010687.homework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

/**
 * AthletsDataFrm
 *
 * @author Matu
 */
public class DecathlonDataFrm {
	private AthletesPersInfoModel athletesInfoMdl;
    private CompetResultsModel competResultsMdl;
    private CompetPointsModel competPointsMdl;
    
    private List <ResultsOfTheAthlet> results;
    public DecathlonDataFrm(List <ResultsOfTheAthlet> ListWithDecathlonData){
    	Collections.sort(ListWithDecathlonData);
    	results = ListWithDecathlonData;
    	JFrame frame = new JFrame("DECATHLON");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	JTabbedPane tab = new JTabbedPane();
    	/////////////////////////
    	frame.add(tab, BorderLayout.CENTER);
    	tab.add("AthletesCommonInfo", panelWithAthletesCommonInfo(ListWithDecathlonData));
    	/////////////////////////
    	competResultsMdl = new CompetResultsModel();//ListWithDecathlonData
    	TableRowSorter <CompetResultsModel> resultsSorter = new TableRowSorter<CompetResultsModel>(competResultsMdl);//<CompetResultsModel> 
    	resultsSorter.setSortsOnUpdates(true);
    	resultsSorter.toggleSortOrder(0);
    	JTable table = new JTable(competResultsMdl);
        table.setRowSorter(resultsSorter);
        //table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        //table.setFillsViewportHeight(true);
	    table.getTableHeader().setBackground(Color.yellow);
    	tab.add("CompetitionResults", new JScrollPane(table));
    	/////////////////////////
    	competPointsMdl = new CompetPointsModel();//ListWithDecathlonData
    	TableRowSorter <CompetPointsModel> pointsSorter = new TableRowSorter<CompetPointsModel>(competPointsMdl);//<CompetResultsModel> 
    	pointsSorter.setSortsOnUpdates(true);
    	table = new JTable(competPointsMdl);
        table.setRowSorter(pointsSorter);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
	    table.getTableHeader().setBackground(Color.yellow);
    	tab.add("CompetitionPointsAndRank", new JScrollPane(table));
    	/////////////////////////
    	tab.add("ExportData", panelExportData(ListWithDecathlonData));
    	/////////////////////////	
    	frame.setSize(1200,400);
    	frame.setVisible(true);
    }
    private Panel panelWithAthletesCommonInfo(List <ResultsOfTheAthlet>ListWithDecathlonData){
		Panel panel = new Panel();
		athletesInfoMdl = new AthletesPersInfoModel();
    	TableRowSorter <AthletesPersInfoModel> athletesInfoSorter = new TableRowSorter<AthletesPersInfoModel>(athletesInfoMdl);
    	athletesInfoSorter.setSortsOnUpdates(true);
    	athletesInfoSorter.toggleSortOrder(0);
    	JTable table =new JTable(athletesInfoMdl);
        table.setRowSorter(athletesInfoSorter);
        table.getTableHeader().setBackground(Color.yellow);
        //table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true); 

	    panel.add(new JScrollPane(table));
	    JButton btn_InsertRow = new JButton("Add Athlete");
	    btn_InsertRow.addActionListener(new AddRowForNewAthlete ());
	    panel.add(btn_InsertRow);
	    
	    return panel;	
    }
    private Panel panelExportData(List <ResultsOfTheAthlet>ListWithDecathlonData){
		Panel panel = new Panel();
	    JButton button = new JButton("ExportToXML");
	    button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				ExportData exporter = new ExportData(results);
				exporter.saveDataToXMLFormat();
			}});
	    panel.add(button);
	    button = new JButton("ExportToHTML");
	    button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				ExportData exporter = new ExportData(results);
				exporter.saveDataToHTMLFormat();
			}});
	    panel.add(button);
	    button = new JButton("ExportToCVS");
	    button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				ExportData exporter = new ExportData(results);
				exporter.saveDataToCSVFormat();
			}});;
	    panel.add(button);
	    return panel;	
    }
    class AddRowForNewAthlete implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {//\u0999 - for sorting. It adds new name to the end!
			ResultsOfTheAthlet	Results = new ResultsOfTheAthlet("\u0999XXXXNewAthleteXXXX", "01.01.1999", "--");
	    	Results.setSprint_100m(0);	//(sec)
	    	Results.setLongJump(0);		//(m)
	    	Results.setShotPut(0);		//(m)
	    	Results.setHighJump(0);		//(m)
	    	Results.setSprint_400m(0);	//(min:sec)
	    	Results.setHurdles_110m(0);	//(sec)
	    	Results.setDiscusThrow(0);	//(m)
	    	Results.setPoleVault(0);	//(m)
	    	Results.setJavelinThrow(0);	//(m)
	    	Results.setRace_1500m(0);	
	    	results.add(Results);
	    	int newRowIndex = results.size()-1;
	    	athletesInfoMdl.addRow(newRowIndex);
			competResultsMdl.addRow(newRowIndex);
			competPointsMdl.addRow(newRowIndex);
		}
    }
    class CompetResultsModel extends AbstractTableModel {
        /** serialVersionUID */
		private static final long serialVersionUID = 1L;
		public String[] columnNames = new String []{"AthletsName","Sprint100m(sec)","LongJump(m)",
            	"ShotPut(m)","HighJump(m)","Sprint400m(min:sec)","Hurdles110m(sec)",
            	"DiscusThrow(m)","PoleVault(m)","JavelinThrow(m)","Race1500m(min:sec)", "Points"};

        public int getColumnCount() {return columnNames.length;}
        public int getRowCount() {return results.size();}//return data == null ? 0 : data.length;}
        public String getColumnName(int col) {return columnNames[col];}
        public Object getValueAt(int row, int col) {
        	switch(col){
        	case 0:	return results.get(row).getName();
    		case 1:	return results.get(row).getSprint_100m();
    		case 2:	return results.get(row).getLongJump();
    		case 3:	return results.get(row).getShotPut();         		
    		case 4:	return results.get(row).getHighJump();         		
    		case 5:	return results.get(row).getSprint_400m();         	
    		case 6:	return results.get(row).getHurdles_110m();                 		
    		case 7:	return results.get(row).getDiscusThrow();       		
    		case 8:	return results.get(row).getPoleVault();   
    		case 9:	return results.get(row).getJavelinThrow();              		
    		case 10:return results.get(row).getRace_1500m();
    		case 11:return results.get(row).getPoints();
        	}
        	return 0;
        }

        public boolean isCellEditable(int row, int col) {
            //The data/cell address is constant,
            //no matter where the cell appears onscreen.
            if ((col < 1) || (col > 10)) {
                return false;
            } else {
                return true;
            }
        } 
        public  void addRow(int rowIndex){
        	fireTableRowsInserted(rowIndex,rowIndex);
        }
        public void setValueAt(Object value, int row, int col) {
        	switch(col){
        		case 1:
        			results.get(row).setSprint_100m((String)value);
        			competPointsMdl.fireTableRowsUpdated(row, row);
        			break;
        		case 2:
        			results.get(row).setLongJump((String)value);
        			competPointsMdl.fireTableRowsUpdated(row, row);
        			break;
        		case 3:
        			results.get(row).setShotPut((String)value);
        			competPointsMdl.fireTableRowsUpdated(row, row);
        			break;         		
        		case 4:
        			results.get(row).setHighJump((String)value);
        			competPointsMdl.fireTableRowsUpdated(row, row);
        			break;          		
        		case 5:
        			results.get(row).setSprint_400m((String)value);
        			competPointsMdl.fireTableRowsUpdated(row, row);
        			break;          	
        		case 6:
        			results.get(row).setHurdles_110m((String)value);
        			competPointsMdl.fireTableRowsUpdated(row, row);
        			break;                 		
        		case 7:
        			results.get(row).setDiscusThrow((String)value);
        			competPointsMdl.fireTableRowsUpdated(row, row);
        			break;          		
        		case 8:
        			results.get(row).setPoleVault((String)value);
        			competPointsMdl.fireTableRowsUpdated(row, row);
        			break;   
        		case 9:
        			results.get(row).setJavelinThrow((String)value);
        			competPointsMdl.fireTableRowsUpdated(row, row);
        			break;              		
        		case 10:
        			results.get(row).setRace_1500m((String)value);
        			competPointsMdl.fireTableRowsUpdated(row, row);
    				break;            		
        	}
        	competPointsMdl.refreshAthletesRanks();
        	fireTableCellUpdated(row, col);
            fireTableCellUpdated(row, 11);
        }
    }
    class CompetPointsModel extends AbstractTableModel {
        /** serialVersionUID */
		private static final long serialVersionUID = 1L;
		public String[] columnNames = new String []{"Rank", "AthletsName","Sprint100Points","LongJump(m)",
            	"ShotPut(m)","HighJump(m)","Sprint400m(min:sec)","Hurdles110m(sec)",
            	"DiscusThrow(m)","PoleVault(m)","JavelinThrow(m)","Race1500m(min:sec)", "Points"};
		String AthletesRanks[];
        public CompetPointsModel() {AthletesRanks = getAthletesRanks();}
        public String[] getAthletesRanks() {
        	Collections.sort(results);
        	int newRank = 0;
        	String Ranks[] = new String[results.size()];
        	for(int curRank= 0; curRank< results.size(); curRank++){
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
        	if (curRank < results.size() -1){//if next item exists
        		if (results.get(curRank).getPoints()> results.get(curRank +1).getPoints()){
        			return curRank;
        		}
        		else {return setRank(curRank + 1);}
        	}
        	else{return curRank;}
        }
        public int getColumnCount() {return columnNames.length;}
        public int getRowCount() {return results.size();}
        public String getColumnName(int col) {return columnNames[col];}
        public  void addRow(int rowIndex){
        	AthletesRanks = getAthletesRanks();
        	fireTableRowsInserted(rowIndex,rowIndex);
        }
        public Object getValueAt(int row, int col) {
            switch(col){
            case 0:	return AthletesRanks[row];
        	case 1:	return results.get(row).getName();
    		case 2:	return results.get(row).getSprint_100mPoints();
    		case 3:	return results.get(row).getLongJumpPoints();
    		case 4:	return results.get(row).getShotPutPoints();         		
    		case 5:	return results.get(row).getHighJumpPoints();         		
    		case 6:	return results.get(row).getSprint_400mPoints();         	
    		case 7:	return results.get(row).getHurdles_110mPoints();                 		
    		case 8:	return results.get(row).getDiscusThrowPoints();       		
    		case 9:	return results.get(row).getPoleVaultPoints();   
    		case 10:return results.get(row).getJavelinThrowPoints();              		
    		case 11:return results.get(row).getRace_1500mPoints();
    		case 12:return results.get(row).getPoints();
        	}
        	return 0;
        }
        
        public void refreshAthletesRanks(){
        	AthletesRanks = getAthletesRanks();
        	for(int i = 0;i<AthletesRanks.length;i++){
        		fireTableCellUpdated(i, 0);
        	}
        }       
        //Non editable
        public boolean isCellEditable(int row, int col) {return false;}

        public void setValueAt(Object value, int row, int col) {
            //fireTableCellUpdated(row, col);
        }
    }
    class AthletesPersInfoModel extends AbstractTableModel {
        /** serialVersionUID */
		private static final long serialVersionUID = 1L;
		public String[] columnNames = new String []{"AthletsName","DateOfBirth","Country"};

        public int getColumnCount() {return columnNames.length;}
        public int getRowCount() {return results.size();}//return data == null ? 0 : data.length;}
        public String getColumnName(int col) {return columnNames[col];}
        public Object getValueAt(int row, int col) {
            //return data[row][col];
        	switch(col){
        	case 0:	return results.get(row).getName();
    		case 1:	return results.get(row).getDateOfBirth();
    		case 2:	return results.get(row).getCountry();
        	}
        	return 0;
        }
        //public Class <Object> getColumnClass(int c) {
        //     return getValueAt(0, c).getClass();
        
        //All cells are editable!
        public boolean isCellEditable(int row, int col) {return true;} 
        public  void addRow(int rowIndex){fireTableRowsInserted(rowIndex,rowIndex);}
        public void setValueAt(Object value, int row, int col) {
        	switch(col){
        		case 0:
        			results.get(row).setName((String)value);
                	competResultsMdl.fireTableCellUpdated(row,0);
                	competPointsMdl.fireTableCellUpdated(row,1);
                	break;
        		case 1:
        			results.get(row).setDateOfBirth((String)value);
        			break;
        		case 2:
        			results.get(row).setCountry((String)value);
        			break;	
        	}
        	fireTableCellUpdated(row, col);
        }
    }
}
