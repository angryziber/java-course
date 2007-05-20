package net.azib.java.students.t030632.homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;


/**
 * FileProcessor
 *
 * @author Toni
 */
public class FileProcessor {
	private List<Competitor> competitorsList;
	public FileProcessor(File file){
		competitorsList  = new LinkedList<Competitor>();  
		FileInputStream inStream;
		InputStreamReader inStreamReader;
		BufferedReader inBufReader;
		try {
			inStream = new FileInputStream(file);
			inStreamReader = new InputStreamReader(inStream, "UTF8");
	        inBufReader = new BufferedReader(inStreamReader);
	        String competitorData;
	        while((competitorData = inBufReader.readLine())!=null ){
	        	competitorsList.add(new Competitor(competitorData));
	        }
		}
		catch (FileNotFoundException e) {
			System.out.println("File not Found!..");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("Error while reading file specified!..");
			e.printStackTrace();
		}
        
	}
	/**
	 * 
	 * @return list of competitor(s) that were read from file
	 */
	public List<Competitor> getCompetitors(){
		return competitorsList;
	}
}
