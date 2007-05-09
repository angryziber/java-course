package net.azib.java.students.t020556.homework;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DecathlonResultFileReader
 *
 * @author Agu Aarna
 */
public class DecathlonResultFileReader 
	implements IDechatlonResultReader {

	//logger
	private Logger LOG = Logger.getLogger(this.getClass().getName());
	private String encoding = "UTF8";

	//stream
	private FileInputStream input;
	
	/** 
	 * @author Agu Aarna
	 * 
	 * @see net.azib.java.students.t020556.homework.IDechatlonResultReader#readResults()
	 * 
	 * @version 1
	 */
	public PriorityQueue<Competitor> readResults() {
		BufferedReader reader = null;
		PriorityQueue<Competitor> compQ = new PriorityQueue<Competitor>();
		try {
			reader = new 
				BufferedReader(new InputStreamReader(new BufferedInputStream(input), encoding));
			String line;
			while((line = reader.readLine()) != null){
				compQ.add(createCompetitor(line));
			}
			
		}
		catch (UnsupportedEncodingException e) {
			LOG.warning("Unsupported encoding " + encoding);
		}
		catch (IOException e) {
			LOG.log(Level.WARNING, "Reading interrupted", e);
		}
		finally{
			try {
				reader.close();
				return compQ;
			}
			catch (IOException e) {
				// should not happen
			}
		}
		return null;
	}
	
	private Competitor createCompetitor(String args){
		String[] results = args.split(",");
		
		Competitor comp = new Competitor();
		comp.setName(results[0]);
		comp.setDateOfBirth(results[1]);
		comp.setLocale(results[2]);
		
		int i = 3;
		for(DecathlonEvent event : DecathlonEvent.values()){
			comp.put(event, event.calculatePoints(results[i++]));
		}
		
		return comp;
	}

	/**
	 * @author Agu Aarna
	 * 
	 * @see net.azib.java.students.t020556.homework.IDechatlonResultReader#
	 * 		setStream(java.io.InputStream)
	 * 
	 * @version 1
	 */
	public void setStream(InputStream in) {
		if (in instanceof FileInputStream)
			this.input = (FileInputStream) in;			
		else
			LOG.log(
				Level.SEVERE, 
				"Passed stream is not suitable for file reading", 
				new ClassCastException());
	}

}
