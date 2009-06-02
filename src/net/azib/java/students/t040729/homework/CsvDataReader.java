package net.azib.java.students.t040729.homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * CSV (Comma Separated Values) file input implementation.
 * Reads given file and forms athletes from it.
 *
 * @author ValleTon
 */
public class CsvDataReader implements CompetitionDataIn {
	private List<Athlete> athletes = new ArrayList<Athlete>();
	private Properties properties;
	private String fileName;
	
	/**
	 * @param fileName File to be read data from.
	 */
	CsvDataReader(String fileName){
		this.fileName = fileName;
	}
	
	@Override
	public List<Athlete> getCompetitionData() throws Exception {
		BufferedReader input = null;
		try{
			input = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),properties.getProperty("encoding")));
			String lineRead=null;

			Athlete currentAthlete;
		
			while ((lineRead=input.readLine()) != null){
				currentAthlete = parseDataAndGetAthlete(lineRead);
				athletes.add(currentAthlete);
			}
		}catch(Exception e){
			throw e;
		}finally{
			try{
				if (input!=null){
					input.close();
				}
			}catch(Exception e1){
				throw e1;
			}
		}
		
		return athletes;
	}
	
	private Athlete parseDataAndGetAthlete(String lineRead) throws Exception {
		
		String[] line = lineRead.split(",");
		
		/* If athlete's name is surrounded by doublequotes (as it should), then
		 * remove them, else is fine too.
		 */
		String tmpAthleteName = (line[0].startsWith("\"") && line[0].endsWith("\""))?line[0].substring(1, line[0].length()-1):line[0];
		/* String Michael "Fast" Parker in CSV is "Michael ""Fast"" Parker",
		 * so we should remove some of those quotes.
		 */
		tmpAthleteName = tmpAthleteName.replaceAll("\"\"", "\"");
		Athlete athlete = new Athlete(new Name(tmpAthleteName),new BirthDate(line[1],properties.getProperty("dateformat_string")),new Country(line[2]));
		
		String tmpResult;
		String[] resultTime;
		
		for (Event event : Event.values()){
			tmpResult = line[event.ordinal()+3].trim();

			if (tmpResult.contains(":")){
				resultTime = tmpResult.split(":");
				try{
					athlete.insertEventResult((byte) event.ordinal(), Integer.parseInt(resultTime[0])*60 + Float.parseFloat(resultTime[1]));
				}catch (ArrayIndexOutOfBoundsException e){
					throw new Exception("Cannot parse time result: "+tmpResult);
				}catch (NumberFormatException e){
					throw new Exception("Cannot parse time result: "+tmpResult);
				}
			}else{
				athlete.insertEventResult((byte) event.ordinal(), Float.parseFloat(tmpResult));
			}
		}
		return athlete;
	}
	
	@Override
	public void setAppProperties(Properties properties) {
		this.properties = properties;		
	}
}
