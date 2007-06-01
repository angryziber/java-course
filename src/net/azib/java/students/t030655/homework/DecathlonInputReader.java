package net.azib.java.students.t030655.homework;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.PriorityQueue;

/**
 * DecathlonInputReader has methods to read from file or from console
 *
 * @author Triin Nestor
 */
public class DecathlonInputReader {
		
	public PriorityQueue<Competitor> readInputStream (InputStream input){
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader
				(new InputStreamReader(new BufferedInputStream(input), "UTF-8"));
		}
		catch (UnsupportedEncodingException e) {
			System.out.println("Unsupported encoding!");
			e.printStackTrace();
		}
	
		PriorityQueue<Competitor> pqCompetitor = new PriorityQueue<Competitor>();
		String line;
		Competitor comp = null;
		try {
			while(((line = reader.readLine()) != null) && (!line.equalsIgnoreCase(""))){
				comp = new Competitor();
				comp.setCompetitor(line);
				pqCompetitor.add(comp);
			}
				
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pqCompetitor;
		
	}



}
