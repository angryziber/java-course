package net.azib.java.students.t092860.homework;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Logger;

/**
 * InputFromConsole
 *
 * @author scythe
 */
class InputFromConsole implements Input {

	private static Logger logger = Logger.getLogger("global");
	
	public InputFromConsole(InputStream in)
	{
		input = in;
	}
	
	public List<Data> get() throws Exception
	{
		List<Data> dataSet = new ArrayList<Data>();
		
		System.out.print("Insert decathlon results per athlete (press enter when done)\n");
		System.out.print("Example: \"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72\n");

		try		
		{	
			Scanner in = new Scanner(input);
			String strLine;
			
			try
			{
				while (!(strLine = in.nextLine()).isEmpty()) 
				{
					dataSet.add(parse(strLine));
				}
			}
			finally {
				in.close();
			}
	    } 
		catch (Exception e) { 
			throw new Exception("Incorrect input data. " + e.getMessage()); 
		}
		
		logger.info("data read from console");
		
		return dataSet;
	}
	
	private Data parse(String inputStr) throws Exception
	{
		Data athlete = new Data();
     
		//break comma separated line using ","				
		StringTokenizer st = new StringTokenizer(inputStr, ",");
		
		if(st.countTokens() != 13)
			throw new Exception("Too many or too few comma separated values. ");

		athlete.setName(st.nextToken());
		java.util.Date date = (new SimpleDateFormat("dd.MM.yyyy")).parse(st.nextToken());
		athlete.setDate(new Date(date.getTime()));	
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
	
	private InputStream input;
}
