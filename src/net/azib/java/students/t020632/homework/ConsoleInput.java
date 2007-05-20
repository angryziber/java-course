package net.azib.java.students.t020632.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * ConsoleInput reads input data from console
 *
 * @author Marek Soobik t020632
 */
public class ConsoleInput implements Input{

	/**
	 * Reads input data from input stream.
	 */
	public List<AthleteResults> read() {
		List<AthleteResults> results = new ArrayList<AthleteResults>();
		String s;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    
		try {
			System.out.println("Type one athlete with results and then press enter. For example:");
			System.out.println("\t Trond Høiby,29.02.1982,ZA,  11.62,  6.88,  14.53, 1.97, 50.93, 15.42,  44.39, 4.62, 64.67, 4:27.66");
			while((s = in.readLine()) != null){
				if(s.equals(""))
					break;
				parseLine(s, results);
				System.out.println("Type another line or press enter to finish");
			}
			System.out.println("Calculating points");
			return results;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Parses the input line which is written by user. Checks whether the input
	 * is correct and adds data into AthleteResults list.
	 * 
	 * @param s			input string
	 * @param results	AthleteResults list
	 * @return			boolean value indicating wheter the input line was valid
	 */
	public boolean parseLine(String s, List<AthleteResults> results){
		UnitsConverter converter;
		AthleteResults result;
		Event event;
		String name;
		String date;
		String country;
		String [] values;
		int i = 0;
		
		values = s.split(",");
		
		while(i < values.length){
			values[i].trim();
			i++;
		}
		
		if(values.length == 13){
			name = values[0];
			date = values[1];
			country = values[2];
			
			result = new AthleteResults(name, date, country);
			
			i = 3;
			float fResult = 0.0F;
			converter = UnitsConverter.getUnitsConverter();
			
			for(EventInfo eventInfo : EventInfo.values()){
				event = result.createEvent(eventInfo);
				fResult = converter.convert(eventInfo, values[i]);
				event.setResult(fResult);
				event.setResult(values[i]);
				result.addEvent(event);
				i++;
			}
			
			results.add(result);
		}
		else{
			System.out.println("Input line is not in correct format!");
			if(values.length > 13){
				System.out.println("You have entered too much information");
			}
			else{
				System.out.println("You have not entered all required information");
			}
			
			return false;
		}
		
		return true;
	}

}
