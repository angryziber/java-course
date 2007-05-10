package net.azib.java.students.t020556.homework;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DecathlonResultStreamWriter
 *
 * @author agu
 */
public class DecathlonResultStreamWriter implements IDecathlonResultWriter {
	
	private OutputStream out = null;

	//logger
	private Logger LOG = Logger.getLogger(this.getClass().getName());

	/* (non-Javadoc)
	 * @see net.azib.java.students.t020556.homework.IDecathlonResultWriter#
	 * 		writeResults(net.azib.java.students.t020556.homework.IDecathlonResultReader)
	 */
	public void writeResults(IDecathlonResultReader reader) {
		if(out == null){
			LOG.log(
				Level.SEVERE, "Stream has not been set internally!", new NullPointerException());
			return;
		}
		
		if(reader == null){
			LOG.log(Level.SEVERE, "Specified reader is null", new NullPointerException());
			return;
		}
		
		PriorityQueue<Competitor> compQ = reader.readResults();
		Competitor comp = null;
		try {
			PrintStream ps;
			ps = new PrintStream(out, true, "UTF8");
			int i = 1;
			while((comp = compQ.poll()) != null)
				ps.println((i++) + ") " +generateLine(comp));
		}
		catch (UnsupportedEncodingException e) {
			// shouldn't happen
		}

	}
	
	private String generateLine(Competitor comp){
		StringBuilder sb = new StringBuilder();
		
		//name
		sb.append(comp.getName()).append("\t");
		
		//score
		sb.append(Math.round(comp.getFinalResult())).append("\t");
		
		//results
		for(String result : comp.getResults()){
			sb.append(result).append("\t");
		}
		
		return sb.toString();
	}
	
	/**
	 * setStream method obtains the stream but does not handle it's state in any way
	 * so the stream has to be closed by the caller
	 * @author Agu Aarna
	 * 
	 * @param out
	 * 
	 * @version 1
	 */
	public void setStream(OutputStream out){
		if(out == null){
			LOG.log(
				Level.SEVERE, "Specified output stream is null!", new NullPointerException());
			return;
		}
		
		this.out = out;
	}
}
