package net.azib.java.students.t020632.homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * CSVInput reads input data from csv file
 *
 * @author Marek Soobik t020632
 */
public class CSVInput implements Input {

	// Path to the file
	private String path;
	
	public CSVInput(String path){
		this.path = path;
	}
	
	/**
	 * Reads input data from csv file
	 */
	public List<AthleteResults> read() {
		List<AthleteResults> results = new ArrayList<AthleteResults>();
		String s = "";
		
		try{
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF8"));
			
			while((s = in.readLine()) != null){
				parseLine(s, results);
			}
		}
		catch(Exception e){
			System.out.println("File " + path + " not found!\n Make sure you have entered correct path");
			return null;
		}
		
		return results;
	}
	
	/**
	 * Parses line from csv file. Results are added to AthleteResults list
	 * 
	 * @param s			parsed string
	 * @param results	AthleteResults list
	 */
	public void parseLine(String s, List<AthleteResults>results){
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
			
			//result.printResults();
			results.add(result);
		}
		else{
			System.out.println("Input line is not in correct format!");
		}
	}

}
