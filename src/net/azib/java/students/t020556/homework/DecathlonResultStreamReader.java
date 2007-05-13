package net.azib.java.students.t020556.homework;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DecathlonResultStreamReader
 *
 * @author Agu Aarna
 */
public class DecathlonResultStreamReader 
	implements IDecathlonResultReader {

	//logger
	private Logger LOG = Logger.getLogger(this.getClass().getName());
	private String encoding = "UTF8";

	//stream
	private InputStream input;
		
	/** 
	 * readResults method reads the results from the given stream. The stream is not closed 
	 * or handled in any way, so the caller must do these operations itself
	 * 
	 * @author Agu Aarna
	 * 
	 * @see net.azib.java.students.t020556.homework.IDecathlonResultReader#readResults()
	 * 
	 * @version 1
	 */
	public PriorityQueue<Competitor> readResults() {
		if(input == null){
			LOG.severe("Input stream not set, unable to read results");
			return null;
		}
		
		BufferedReader reader = null;
		PriorityQueue<Competitor> compQ = new PriorityQueue<Competitor>();
		try {
			reader = new 
				BufferedReader(new InputStreamReader(new BufferedInputStream(input), encoding));
			String line;
			while((line = reader.readLine()) != null){
				compQ.add(createCompetitor(line));
			}
			return compQ;
		}
		catch (UnsupportedEncodingException e) {
			LOG.warning("Unsupported encoding " + encoding);
		}
		catch (IOException e) {
			LOG.log(Level.WARNING, "Reading interrupted", e);
		}

		return null;
	}
	
	private Competitor createCompetitor(String args){
		String[] results = args.split(",");
		
		Competitor comp = new Competitor();
		comp.setName(results[0].trim());
		comp.setDateOfBirth(results[1]);
		comp.setLocale(results[2]);
		
		ArrayList<String> resList = new ArrayList<String>(Arrays.asList(results));
		for(int i = 0; i < 3; i++)
			resList.remove(0);
		resList.toArray(results);
		comp.setResults(Arrays.copyOf(results, 10));
		
		return comp;
	}

	/**
	 * setStream sets the input stream internally
	 *
	 * @author Agu Aarna
	 * 
	 * @version 1
	 */
	public void setStream(InputStream in) {
		if(in != null)
			this.input = in;			
		else
			LOG.severe("Passed stream is not suitable for file reading");
	}

}
