package net.azib.java.students.t020556.homework;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DecathlonResultStreamWriter class provides functionality for writing decathlon results to a stream
 *
 * @author Agu Aarna
 * 
 * @version 1
 */
public class DecathlonResultStreamWriter implements IDecathlonResultWriter {
	
	private OutputStream out = null;

	//logger
	private Logger LOG = Logger.getLogger(this.getClass().getName());

	private boolean isCSVFormat = true;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

	/**
	 * writeResults method writes the results to the given stream. The stream is not closed 
	 * or handled in any way, so the caller must do these operations itself
	 * 
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
		
		writeResults(reader.readResults());
	}
	
	private String generateLine(Competitor comp){
		StringBuilder sb = new StringBuilder();
		char separator = isCSVFormat ? ',' : '\t';
		
		//score
		sb.append(Math.round(comp.getFinalResult())).append(separator);
		
		//name
		sb.append(comp.getName()).append(separator);
		
		//date of birth
		sb.append(formatter.format(comp.getDateOfBirth())).append(separator);
		
		//locale
		sb.append(comp.getLocale().toString().toUpperCase());
		
		//results
		for(String result : comp.getResults()){
			sb.append(separator).append(result);
		}
		
		return sb.toString();
	}
	
	/**
	 * setStream method obtains the stream but does not handle it's state in any way
	 * so the stream has to be closed by the caller
	 * 
	 * @author Agu Aarna
	 * 
	 * @param out - output stream to write data to
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

	/**
	 * setFormat method specifies in which way data is printed to the stream; Default is CSV 
	 * 
	 * @author Agu Aarna
	 * 
	 * @param CSVFormat -  
	 * 		<ul>
	 * 			<li><b>true</b> - will print human readable format</li>
	 * 			<li><b>false</b> - will print CSV format</li>
	 * 		</ul>
	 * 
	 * @version 1
	 */
	public void setFormat(boolean CSVFormat){
		isCSVFormat = CSVFormat;
	}

	/**
	 * getFormat method specifies in which way data is printed to the stream
	 * 
	 * @author Agu Aarna
	 * 
	 * @return 
	 * 		<ul>
	 * 			<li><b>true</b> - will print human readable format</li>
	 * 			<li><b>false</b> - will print CSV format</li>
	 * 		</ul>
	 * 
	 * @version 1
	 */
	public boolean getFormat(){
		return isCSVFormat;
	}

	/**
	 * @see net.azib.java.students.t020556.homework.IDecathlonResultWriter#
	 * 		writeResults(java.util.PriorityQueue)
	 */
	public void writeResults(PriorityQueue<Competitor> compQ) {
		if(compQ == null){
			LOG.severe("Unable to read results from reader!");
			return;
		}
		
		PriorityQueue<Competitor> compQLocal = new PriorityQueue<Competitor>(compQ);
		Competitor comp = null;
		try {
			PrintStream ps;
			ps = new PrintStream(out, true, "UTF8");
			int i = 1;
			String separator = isCSVFormat ? "," : " ";
			while((comp = compQLocal.poll()) != null)
				ps.println((i++) + separator + generateLine(comp));
		}
		catch (UnsupportedEncodingException e) {
			// shouldn't happen
		}
	}
}
