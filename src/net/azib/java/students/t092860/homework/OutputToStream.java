package net.azib.java.students.t092860.homework;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/**
 * Class to write data to the stream specified.
 */
public class OutputToStream implements Output {
	
	private static Logger logger = Logger.getLogger("global");
	
	/**
	 * Constructor
	 * 
	 * @param out a stream to write data to
	 */
	OutputToStream(OutputStream out) {
		output = out;
	}
	
	/**
	 * Writes list of athletes (with results) to the stream given by the constructor
	 * 
	 * @param dataList list of athletes data (with results)
	 * @throws Exception if data cannot be written.
	 */
	public void set(List<Data> dataList) throws Exception {
		Iterator<Data> it = dataList.iterator();
		while (it.hasNext()) {
			String line = dataToString(it.next()) + System.getProperty("line.separator");
			output.write(line.getBytes("UTF-8"));
		}
		logger.info("Output to console success");
	}
	
	private String dataToString(Data data) throws Exception {
		String out = "";

		out += data.getPosition();
		out += "," + data.getScore();
		out += "," + Converter.athleteToString(data);

		return out;
	}
	
	private OutputStream output;
}
