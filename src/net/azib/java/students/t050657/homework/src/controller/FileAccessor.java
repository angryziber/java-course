package net.azib.java.students.t050657.homework.src.controller;

import net.azib.java.students.t050657.homework.src.model.Athlet;
import net.azib.java.students.t050657.homework.src.model.Competition;
import net.azib.java.students.t050657.homework.src.model.DecathlonCoeficient;
import net.azib.java.students.t050657.homework.src.model.InsufficientResultsException;
import net.azib.java.students.t050657.homework.src.model.Result;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * FileAccessor
 *
 * @author Boriss
 */
public class FileAccessor {
	
	private static List<String> formatsInFile = Arrays.asList(
								new String[] {"sec", "m", "m", "m", "min:sec",
							  		  		  "sec", "m", "m", "m", "min:sec"});
	
	protected Competition getCompetitionInfo(String date, 
		     						     String countryCode,
		     						     String description,
		     						     String path) {
		Competition competition = new Competition();
		
		String[] compDate = date.split("-");
		
		Calendar cal = new GregorianCalendar();
		cal.setLenient(true);
		cal.set(Integer.parseInt(compDate[0]),
				Integer.parseInt(compDate[1]) - 1, 
				Integer.parseInt(compDate[2]));
		
		cal.getTime();
		
		competition.setEventDate(cal);
		competition.setCountryCode(countryCode);
		competition.setDescription(description);
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(
										new FileInputStream(path), "UTF8"));
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		catch (UnsupportedEncodingException e) {
			System.out.println("Encoding UTF8 not supported!");
		}

		try {
			while (reader.ready()) {
				String line = reader.readLine();
				line.trim();
				
				Athlet athlet = parseAthlet(line);
				athlet.setResult(parseResult(line));	
				
				competition.addAthlet(athlet);
			}
		}
		catch (IOException e) {
			System.out.println("IOException ???");
		}
		
		return competition;
	}
	
	private static Athlet parseAthlet(String line) {
		Athlet athlet = new Athlet();
		
		String[] parts = line.split(",");

		String[] data = parts[1].split("\\.");

		Calendar cal = new GregorianCalendar();
		cal.setTime(Date.valueOf(data[2] + "-" + data[1] + "-" + data[0]));
		athlet.setName(parts[0].substring(parts[0].indexOf("\"")+1, parts[0].length()-1));
		athlet.setDateOfBirth(cal);
		athlet.setCountryCode(parts[2]);
		
		return athlet;
	}
	
	private static Result parseResult(String line){
		Result result = new Result();
		
		List<Double> results = new ArrayList<Double>();
		List<String> resList = Arrays.asList(line.split(","));

		int i = 0;
		for(DecathlonCoeficient decCoef : DecathlonCoeficient.values()) {
			Double res = decCoef.reduceToFormat(resList.get(i+3), formatsInFile.get(i));
			results.add(res);
			i++;
		}
		
		try {
			result.setResults(results);
		}catch(InsufficientResultsException e) {
			
		}

		return result;
	}

}
