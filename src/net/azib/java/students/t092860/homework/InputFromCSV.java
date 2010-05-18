package net.azib.java.students.t092860.homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;

/**
 * InputFromCSV
 *
 * @author scythe
 */
class InputFromCSV implements Input {

	private static Logger logger = Logger.getLogger("global");
	
	public InputFromCSV(File filepath)
	{
		file = filepath;
	}
	
	public List<Data> get() throws Exception
	{
		List<Data> dataSet = new ArrayList<Data>();

		try		
		{								
			BufferedReader in = new BufferedReader( new InputStreamReader( new FileInputStream(file), "UTF8"));			
			String strLine;				
			
			try
			{
				//read comma separated file line by line			
				while( (strLine = in.readLine()) != null)			
				{								
					dataSet.add(parse(strLine));				
				}	
			}
			finally {
				in.close();
			}
	    } 
		catch (Exception e)
		{
			throw new Exception("Incorrect input data. " + e.getMessage());
		}
		
		logger.info("data read from csv file");
		
		return dataSet;
	}
	
	private Data parse(String input) throws Exception
	{
		Data athlete = new Data();
     
		//break comma separated line using ","				
		StringTokenizer st = new StringTokenizer(input, ",");
		
		if(st.countTokens() != 13)
			throw new Exception("Too many or too few comma separated values. ");
						

		athlete.setName(st.nextToken());
		java.util.Date date = (new SimpleDateFormat("dd.MM.yyyy")).parse(st.nextToken());
		athlete.setDate(new java.sql.Date(date.getTime()));	
		athlete.setCountry(st.nextToken());
		athlete.addEvent(Events.RACE_100M, Converter.stringToTime(st.nextToken()));
		athlete.addEvent(Events.LONG_JUMP, Double.parseDouble(st.nextToken()));
		athlete.addEvent(Events.SHOT_PUT, Double.parseDouble(st.nextToken()));
		athlete.addEvent(Events.HIGH_JUMP, Double.parseDouble(st.nextToken()));
		athlete.addEvent(Events.RACE_400M, Converter.stringToTime(st.nextToken()));
		athlete.addEvent(Events.HURDLES_110M, Converter.stringToTime(st.nextToken()));
		athlete.addEvent(Events.DISCUS_THROW, Double.parseDouble(st.nextToken()));
		athlete.addEvent(Events.POLE_VAULT, Double.parseDouble(st.nextToken()));
		athlete.addEvent(Events.JAVELIN_THROW, Double.parseDouble(st.nextToken()));
		athlete.addEvent(Events.RACE_1500M, Converter.stringToTime(st.nextToken()));
		
		return athlete;
	}
	
	private File file;
}
