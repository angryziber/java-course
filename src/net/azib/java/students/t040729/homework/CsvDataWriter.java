package net.azib.java.students.t040729.homework;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Properties;

/**
 * CSV (Comma Separated Values) file generator.
 * From given list of athletes the specified CSV file ise created.
 *
 * @author ValleTon
 */
public class CsvDataWriter implements CompetitionDataOut {
	private Properties properties;
	private String fileName;
	
	/**
	 * @param fileName Filename to output data
	 */
	public CsvDataWriter(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void putCompetitionData(List<Athlete> athlete) throws Exception {
		BufferedWriter output = null;
		StringBuilder outputString;
		char comma = ',';
		char quotes = '"';
		
		try {
			output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName),properties.getProperty("encoding")));
			
			for (Athlete curAthlete : athlete){
				outputString = new StringBuilder().append(quotes).append(curAthlete.getPlace()).append(quotes).append(comma).append(curAthlete.getTotalPoints()).append(comma).append(quotes).append(curAthlete.getName().replace("\"", "\"\"")).append(quotes).append(comma).append(curAthlete.getBirthDate()).append(comma).append(curAthlete.getCountryCode());
				
				for (Event e : Event.values()){
					outputString.append(comma).append(curAthlete.getFormattedResult((byte) e.ordinal()));
				}
				outputString.append(System.getProperty("line.separator"));
				output.write(outputString.toString());
			}
		}
		catch (Exception e) {
			throw e;
		}finally{
			try{
				if (output!=null){
					output.close();
				}
			}catch(Exception e1){
				throw e1;
			}
		}
	}
	
	@Override
	public void setAppProperties(Properties properties) {
		this.properties = properties;
	}
}
