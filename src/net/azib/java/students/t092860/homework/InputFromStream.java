package net.azib.java.students.t092860.homework;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Logger;

/**
 * Class to read data from the stream specified.
 */
public class InputFromStream implements Input {

	private static Logger logger = Logger.getLogger("global");
	
	/**
	 * Constructor
	 * 
	 * @param in a stream to read data from
	 */
	public InputFromStream(InputStream in) {
		input = in;
	}
	
	/**
	 * Gets data from the stream provided by constructor
	 * 
	 * @return list of athletes data
	 * @throws Exception if incorrect data is received.
	 */
	public List<Data> get() throws Exception {
		List<Data> dataSet = new ArrayList<Data>();

		try {
			Scanner scanner = new Scanner(input, "UTF-8");

			try {
				String input = "";
				while (scanner.hasNextLine() && !(input = scanner.nextLine()).isEmpty()) {
					dataSet.add(parse(input));
				}
			}
			finally {
				scanner.close();
			}
		}
		catch (Exception e) {
			throw new Exception("Incorrect input data. " + e.getMessage());
		}

		logger.info("data read from console");

		return dataSet;
	}
	
	private Data parse(String inputStr) throws Exception {
		logger.info("input parsing started");

		Data athlete = new Data();

		// break comma separated line using ","
		StringTokenizer st = new StringTokenizer(inputStr, ",");

		if (st.countTokens() != 13)
			throw new Exception("Too many or too few comma separated values. ");

		athlete.setName(st.nextToken());
		athlete.setDate((new SimpleDateFormat("dd.MM.yyyy")).parse(st.nextToken()));
		athlete.setCountry(st.nextToken());
		for(Events e: Events.values()){
			if(e.getUnits() == Events.Units.METERS)
				athlete.addEvent(e, Double.parseDouble(st.nextToken()));
			else
				athlete.addEvent(e, Converter.stringToTime(st.nextToken()));
		}

		return athlete;
	}
	
	private InputStream input;
}
