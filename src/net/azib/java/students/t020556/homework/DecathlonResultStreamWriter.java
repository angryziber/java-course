package net.azib.java.students.t020556.homework;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
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
	private boolean isCSVFormat = true;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

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
			String separator = isCSVFormat ? "," : " ";
			while((comp = compQ.poll()) != null)
				ps.println((i++) + separator + generateLine(comp));
		}
		catch (UnsupportedEncodingException e) {
			// shouldn't happen
		}

	}
	
	private String generateLine(Competitor comp){
		StringBuilder sb = new StringBuilder();
		char separator = isCSVFormat ? ',' : '\t';
		
		//name
		sb.append(comp.getName()).append(separator);
		
		//date of birth
		sb.append(formatter.format(comp.getDateOfBirth())).append(separator);
		
		//locale
		sb.append(comp.getLocale().getISO3Country());
		
		//score
		sb.append(Math.round(comp.getFinalResult()));
		
		//results
		for(String result : comp.getResults()){
			sb.append(separator).append(result);
		}
		
		return sb.toString();
	}
	
	/**
	 * setStream method obtains the stream but does not handle it's state in any way
	 * so the stream has to be closed by the caller
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
	 * @param CSVFormat - <b>false</b> will print human readable format; <b>true</b> 
	 * will print CSV format
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
	 * @return <b>false</b> will print human readable format; <b>true</b> 
	 * will print CSV format
	 * 
	 * @version 1
	 */
	public boolean getFormat(){
		return isCSVFormat;
	}
}
