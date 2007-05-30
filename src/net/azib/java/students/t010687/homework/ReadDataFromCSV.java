package net.azib.java.students.t010687.homework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



/**
 * ReadDataFromCVS
 * Hints: http://www.exampledepot.com/egs/javax.swing.filechooser/CreateDlg.html
 *
 * @author Matu
 */
public class ReadDataFromCSV implements ActionListener{
    private JFrame ParentFrm;
    public ReadDataFromCSV(JFrame Related_frame){
    	ParentFrm = Related_frame;
    }
    public void actionPerformed(ActionEvent e){
        JFileChooser fc = new JFileChooser(new File(File.separator+"CSV"));
        // Show dialog; this method doesn't return until dialog is closed
        fc.showOpenDialog(ParentFrm);
        // Get the selected file
        File file = fc.getSelectedFile();
        if (file != null){
        	List <ResultsOfTheAthlet> ListWithDechatlonInfo = parseCSVFile(file);
        	if (ListWithDechatlonInfo.isEmpty()){
        		JOptionPane.showMessageDialog(ParentFrm,"Please select correct CSV File!");
        		return;
        	}       	
        	ParentFrm.dispose();
        	new DecathlonDataFrm(ListWithDechatlonInfo);
        }
    }
    public List <ResultsOfTheAthlet> parseCSVFile(File csvFile){ //String csvFileName
		List<ResultsOfTheAthlet> ListWithDechatlonInfo = new ArrayList<ResultsOfTheAthlet>();//Arrays.asList(new String[] {"a", "b", "z", "x", "z"})
		
		try{// Read comma seperated file
			BufferedReader csvReader;
			//new BufferedInputStream(
			csvReader = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile), "UTF-8"));
			String SpitedRowData[];
			ResultsOfTheAthlet Results;

			String curLine = csvReader.readLine();
			// Now we know the columns, now read data row lines
			while(curLine != null){
				SpitedRowData = curLine.split(",");
				//stringTokenizer = new StringTokenizer(curLine, ",");
				//if(stringTokenizer.countTokens() == 0xD){	
				if(SpitedRowData.length == 0xD){	
					Results = new ResultsOfTheAthlet(removeQuotes(SpitedRowData[0]),SpitedRowData[1],SpitedRowData[2]);
					Results.setSprint_100m(SpitedRowData[3]);	//(sec)
					Results.setLongJump(SpitedRowData[4]);		//(m)
					Results.setShotPut(SpitedRowData[5]);		//(m)
					Results.setHighJump(SpitedRowData[6]);		//(m)
					Results.setSprint_400m(SpitedRowData[7]);	//(min:sec)
					Results.setHurdles_110m(SpitedRowData[8]);	//(sec)
					Results.setDiscusThrow(SpitedRowData[9]);	//(m)
					Results.setPoleVault(SpitedRowData[10]);	//(m)
					Results.setJavelinThrow(SpitedRowData[11]);	//(m)
					Results.setRace_1500m(SpitedRowData[12]);	//(min:sec)
					ListWithDechatlonInfo.add(Results);
				}
				curLine = csvReader.readLine();
			}
			csvReader.close();
		}
		catch(IOException exp){
			System.err.println(exp.toString());
		}
		catch(Exception exp){
			System.err.println(exp.toString());
		}
		return ListWithDechatlonInfo;
	}
    private String removeQuotes(String AthletsNameData){
    	String DataParts[] = AthletsNameData.split("\"");	
    	return DataParts[1];
    }
}
/*
 Here's some code that demonstrates the use of the actions:

    JFrame frame = new JFrame();
    
    // Create a file chooser
    String filename = File.separator+"tmp";
    JFileChooser fc = new JFileChooser(new File(filename));
    
    // Create the actions
    Action openAction = new OpenFileAction(frame, fc);
    Action saveAction = new SaveFileAction(frame, fc);
    
    // Create buttons for the actions
    JButton openButton = new JButton(openAction);
    JButton saveButton = new JButton(saveAction);
    
    // Add the buttons to the frame and show the frame
    frame.getContentPane().add(openButton, BorderLayout.NORTH);
    frame.getContentPane().add(saveButton, BorderLayout.SOUTH);
    frame.pack();
    frame.setVisible(true);
*/
/*
String filename = File.separator+"cvs";
JFileChooser fc = new JFileChooser(new File(filename));

// Show open dialog; this method does not return until the dialog is closed
fc.showOpenDialog(frame);
File selFile = fc.getSelectedFile();
//plugins.file.writeTXTFile(tempFile,csv);
System.out.println("CVS");
*/