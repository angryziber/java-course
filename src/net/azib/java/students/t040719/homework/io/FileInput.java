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
 * FileInput - a class for obtaining decathlon results from a CVS file
 *
 * @version 0.0
 * @author Romi Agar
 */
public class FileInput implements DataInput {
	private static final Logger LOG = Logger.getLogger(DataInput.class.getSimpleName());			

	static final String ERROR_NO_FILE_TEXT = " cannot be found.";
	static final String INVALID_DATA_TEXT = " contains data in invalid format.";
	static final String INVALID_FILENAME_TEXT = " is not valid file name.";
	static final int ERROR_CODE_NO_ARGS = 1;
	static final int ERROR_CODE_NO_FILE = 2;
	static final int ERROR_CODE_ENCODING = 3;
	static final int ERROR_CODE_READ_FILE = 4;
	static final int ERROR_CODE_CLOSING = 5;
	private File dataSource = null;

	boolean initiateFile(String fileName){
		dataSource = new File(fileName);
		if (!dataSource.exists()){
			LOG.severe("'" + dataSource + "'" + ERROR_NO_FILE_TEXT);
			dataSource = null;
			return false;
		}
		return true;
	}
	
	void exit(int errorCode) {
		   System.exit(errorCode);
	}
	
	public List<Athlete> getResults(String... parameter) {
		if (parameter.length == 0){
			LOG.severe("No input file name given.");			
			exit(ERROR_CODE_NO_ARGS);
		}else if (!initiateFile(parameter[0]))
			exit(ERROR_CODE_NO_FILE);
		if (dataSource != null){
			List<Athlete> athletes = new ArrayList<Athlete>();
			
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
				LOG.log(Level.SEVERE, "Encoding problem with file: " + dataSource, e);
				exit(ERROR_CODE_ENCODING);
			}
			catch (FileNotFoundException e) {
				LOG.log(Level.SEVERE, "'" + dataSource + "'" + ERROR_NO_FILE_TEXT, e);
				exit(ERROR_CODE_NO_FILE);
			}
			catch (IOException e) {
				LOG.log(Level.SEVERE, "Could not read from file: " + dataSource, e);
				exit(ERROR_CODE_READ_FILE);
			}
			finally{
				if (br != null){					
					try {
						br.close();
					}
					catch (IOException e) {
						LOG.log(Level.SEVERE, "Could not close file: " + dataSource, e);
						exit(ERROR_CODE_CLOSING);
					}
				}
			}
			
			return athletes;
		} else
			return null;
	}
	
}
