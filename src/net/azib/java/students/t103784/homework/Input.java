package net.azib.java.students.t103784.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Input {

	List<Athlete> contestants = new ArrayList<Athlete>();
	SimpleDateFormat format = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT);
	int tokenNumber = 0;


	public List<Athlete> readAthleteFromCSV(BufferedReader reader) {
		
		
		try	{
			String line;
			StringTokenizer tokenizer;

			while((line = reader.readLine()) != null) {
				Athlete athlete = new Athlete();
				tokenizer = new StringTokenizer(line.trim(), ",");
				while(tokenizer.hasMoreTokens()) {
					athlete.setName(checkName(tokenizer.nextToken()));
					tokenNumber++;
					athlete.setBirthDate(checkDate(tokenizer.nextToken()));
					tokenNumber++;
					athlete.setCountry(checkCountry(tokenizer.nextToken()));
					tokenNumber++;
					for (int c = 0; c < 10; c++) {
						if (c == 4 || c == 9) {
							athlete.setPerformance(c, checkMinSec(tokenizer.nextToken()));
							//athlete.performance[c] = checkMinSec(tokenizer.nextToken());
							tokenNumber++;
						}
						else {
							athlete.setPerformance(c, checkIsNumber(String.valueOf(Double.parseDouble(tokenizer.nextToken()))));
							//athlete.performance[c] = Double.parseDouble(tokenizer.nextToken());
							tokenNumber++;
						}
					}
					tokenNumber = 0;
					ScoreCalculator.calculate(athlete);
					contestants.add(athlete);
				}
			}
		}
		catch(Exception e) {
			System.out.println("Exception while reading csv file: " + e);
		}
		return contestants;
	}

	public List<Athlete> readAthleteFromConsole() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
		
		int i = 0;
		boolean inputtingAthletes = true;		
		
		while (inputtingAthletes) {
			Athlete athlete = new Athlete();
			
			

			while (athlete.getName() == null) {
	            System.out.print("Full name (First name/Last name): ");
	            athlete.setName(checkName(reader.readLine()));
	        }
	
	        while (athlete.getBirthDate() == null) {
	            System.out.print("Date of Birth " + "(" + format.toPattern() + "): ");
	            String checkDateResult = checkDate(reader.readLine());
	            if (checkDateResult == null)
	            	System.out.println("Error in input for date of birth. Try again.");
	            else
	            	athlete.setBirthDate(checkDateResult);
			    
			    
	        }
	
	        while (athlete.getCountry() == null) {
	            System.out.print("Country (2-digits, eg. EE): ");
	            athlete.setCountry(checkCountry(reader.readLine()));
	        }
	
			while (athlete.getHundredMeters() == null) {
	            System.out.print("100m (seconds.milliseconds): ");
	            try {
		            athlete.setPerformance(i, checkIsNumber(reader.readLine()));
					athlete.setHundredMeters(athlete.getPerformance(i));
		            i++;
				} catch (NumberFormatException e) {
					System.out.println("Wrong input for 100m time. Try again.");
				}
			}
	
			while (athlete.getLongJump() == null) {
	            System.out.print("Long jump (meters.centimeters): ");
	            try {
		            athlete.setPerformance(i, checkIsNumber(reader.readLine()));
					athlete.setLongJump(athlete.getPerformance(i));
		            i++;
				} catch (NumberFormatException e) {
					athlete.setLongJump(null);
				}
	        }
	
			while (athlete.getShotPut() == null) {
	            System.out.print("Shot put (meters.centimeters): ");
	            try {
		            athlete.setPerformance(i, checkIsNumber(reader.readLine()));
					athlete.setShotPut(athlete.getPerformance(i));
		            i++;
				} catch (NumberFormatException e) {
					athlete.setShotPut(null);
				}
	        }
	
			while (athlete.getHighJump() == null) {
	            System.out.print("High Jump (meters.centimeters): ");
	            try {
		            athlete.setPerformance(i, checkIsNumber(reader.readLine()));
					athlete.setHighJump(athlete.getPerformance(i));
		            i++;
				} catch (NumberFormatException e) {
					athlete.setHighJump(null);
				}
	        }
	
			while (athlete.getFourHundredMeters() == null) {
	            System.out.print("400m (seconds.milliseconds): ");
	            try {
		            athlete.setPerformance(i, checkMinSec(reader.readLine()));
					athlete.setFourHundredMeters(athlete.getPerformance(i));
		            i++;
				} catch (NumberFormatException e) {
					athlete.setFourHundredMeters(null);
				}
	        }
	
			while (athlete.getHurdles() == null) {
	            System.out.print("110m hurdles (seconds.milliseconds): ");
	            try {
		            athlete.setPerformance(i, checkIsNumber(reader.readLine()));
					athlete.setHurdles(athlete.getPerformance(i));
		            i++;
				} catch (NumberFormatException e) {
					athlete.setHurdles(null);
				}
	        }
	
			while (athlete.getDiscus() == null) {
	            System.out.print("Discus throw (meters.centimeters): ");
	            try {
		            athlete.setPerformance(i, checkIsNumber(reader.readLine()));
					athlete.setDiscus(athlete.getPerformance(i));
		            i++;
				} catch (NumberFormatException e) {
					athlete.setDiscus(null);
				}
	        }
	
			while (athlete.getPoleVault() == null) {
	            System.out.print("Pole vault (meters.centimeters): ");
	            try {
		            athlete.setPerformance(i, checkIsNumber(reader.readLine()));
					athlete.setPoleVault(athlete.getPerformance(i));
		            i++;
				} catch (NumberFormatException e) {
					athlete.setPoleVault(null);
				}
	        }
	
			while (athlete.getJavelin() == null) {
	            System.out.print("Javelin throw (meters.centimeters): ");
	            try {
		            athlete.setPerformance(i, checkIsNumber(reader.readLine()));
					athlete.setJavelin(athlete.getPerformance(i));
		            i++;
				} catch (NumberFormatException e) {
					athlete.setJavelin(null);
				}
	        }
	
			while (athlete.getRace() == null) {
	            System.out.print("1500m race (seconds.milliseconds): ");
	            try {
		            athlete.setPerformance(i, checkMinSec(reader.readLine()));
					athlete.setRace(athlete.getPerformance(i));
		            i++;
				} catch (NumberFormatException e) {
					athlete.setRace(null);
				}
			}
			
			i = 0;
			ScoreCalculator.calculate(athlete);
			contestants.add(athlete);
			System.out.print("Add more athletes (y/n)? ");
			inputtingAthletes = reader.readLine().toLowerCase().startsWith("y");			
        }		
		return contestants;
	}

	public String checkName(String name) {
		if (name.contains("\"")) {
			String[] nameSplit = name.split("\"");
			if (nameSplit[1].matches("(\\p{L}(\\p{L}+\\s?)){2,3}")) {
				return nameSplit[1];
			}
			else {
				return null;
			}

		}
		else {
			if (name.matches("(\\p{L}(\\p{L}+\\s?)){2,3}")) {
				return name;
			}
			else {
				return null;
			}
		}
	}

	public String checkDate(String birthDate) {
		if (birthDate.matches("^([1-9]|0[1-9]|[12][0-9]|3[01])[.]?([1-9]|[0][1-9]|[1][0-2])[. ]?(18|19|20)\\d{2}$"))
			return birthDate;
		else
			return null;
	}

	public String checkCountry(String country) {
		if (country.matches("[A-Z]{2,2}"))
			return country;
		else
			return null;
	}

	public Double checkIsNumber(String stringInput) {
		if (stringInput == null || Double.valueOf(stringInput) == null)
			return null;
		else
			return Double.valueOf(stringInput);
	}

    public Double checkMinSec(String time) {
	    String[] timeSplit;

	    if (time.matches("^([0-9]?[0-9])[:]?([0-5][0-9])[. ]?([0-9][0-9])")) {
            timeSplit = time.split(":");
       		return (double)Integer.parseInt(timeSplit[0])*60 + Double.parseDouble(timeSplit[1]);

        }
        else if (time.matches("([0-5][0-9])[.]([0-9][0-9])")){
            return Double.valueOf(time);
        }
		else {
		    throw new NumberFormatException();
        }
	}
}
