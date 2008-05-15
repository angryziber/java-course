package net.azib.java.students.t040719.homework.io;

import net.azib.java.students.t040719.homework.Athlete;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FileInput - a class for obtaining decathlon results from a CSV file
 *
 * @version 1.0
 * @author Romi Agar
 */
public class FileInput implements DataInput {
	private static final Logger LOG = Logger.getLogger(FileInput.class.getSimpleName());			

	static final String ERROR_NO_FILE_TEXT = " cannot be found.";
	static final String INVALID_DATA_TEXT = " contains data in invalid format.";
	static final String INVALID_FILENAME_TEXT = " is not valid file name.";
	static final int ERROR_CODE_NO_ARGS = 6;
	static final int ERROR_CODE_NO_FILE = 7;
	private File dataSource = null;

	/**
	 * @param fileName
	 * @return returns true if file exists, false otherwise
	 */
	boolean initiateFile(String fileName){
		dataSource = new File(fileName);
		if (!dataSource.exists()){
			LOG.severe("'" + dataSource + "'" + ERROR_NO_FILE_TEXT);
			dataSource = null;
			return false;
		}
		return true;
	}

	/**
	 * Exiting from program with given error code
	 * @param errorCode error code (int) for exiting
	 */
	void exit(int errorCode) {
		   System.exit(errorCode);
	}
	
	/**
	 * @param parameters contains csv input file name
	 * @return returns a list of athletes
	 */
	public List<Athlete> getResults(String... parameters) {
		List<Athlete> athletes = new ArrayList<Athlete>();
		if (parameters.length == 0){
			LOG.severe("No input file name given.");			
			exit(ERROR_CODE_NO_ARGS);
		}else if (!initiateFile(parameters[0]))
			exit(ERROR_CODE_NO_FILE);
		if (dataSource != null){			
			String line = "";
			String name = "";
			String countryCode = "";
			Date birthday = null;
			String[] elements = null;
			String[] sResults = new String[10];
			float[] results = null;
			BufferedReader br = null;
			try {
				
				br = new BufferedReader(new InputStreamReader(new FileInputStream(dataSource), "UTF-8"));
				while ((line = br.readLine()) != null) {
					elements = line.split(",");
					if (elements.length == 13){
						name = InputParser.removeQuotes(elements[0]);
						birthday = InputParser.parseDateString(elements[1]);
						countryCode = InputParser.parseCountryCode(elements[2]);
						System.arraycopy(elements, 3, sResults, 0, 10);
						results = InputParser.parseEventResults(sResults);
						if (results == null){
							LOG.warning("Error parsing event results for athlete '" + name + "'. Skipping.");
							continue;
						}
						Athlete athlete = new Athlete(name,birthday,countryCode, results);
						athletes.add(athlete);
					}else
						LOG.warning("Wrong number of elements on line. Skipping this.");
				}
			}
			catch (UnsupportedEncodingException e) {
				if (System.getProperty("program.debug") != null)
					LOG.log(Level.SEVERE, "Encoding problem with file: " + dataSource, e);
				else
					LOG.log(Level.SEVERE, "Encoding problem with file: " + dataSource);
			}
			catch (FileNotFoundException e) {
				if (System.getProperty("program.debug") != null)
					LOG.log(Level.SEVERE, "'" + dataSource + "'" + ERROR_NO_FILE_TEXT, e);
				else
					LOG.log(Level.SEVERE, "'" + dataSource + "'" + ERROR_NO_FILE_TEXT);
			}
			catch (IOException e) {
				if (System.getProperty("program.debug") != null)
					LOG.log(Level.SEVERE, "Could not read from file: " + dataSource, e);
				else
					LOG.log(Level.SEVERE, "Could not read from file: " + dataSource);
			}
			finally{
				if (br != null){					
					try {
						br.close();
					}
					catch (IOException e) {
						if (System.getProperty("program.debug") != null)
							LOG.log(Level.SEVERE, "Could not close file: " + dataSource, e);
						else
							LOG.log(Level.SEVERE, "Could not close file: " + dataSource);
					}
				}
			}
		}
		return athletes;
	}
	
}
