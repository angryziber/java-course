package net.azib.java.students.t103784.homework;

import com.sun.mail.imap.Rights;
import net.azib.java.lessons.db.PersonException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Input {

	String parameter = Main.inputParameter;
	List<Athlete> contestants = new ArrayList<Athlete>();
	SimpleDateFormat format = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT);
	int tokenNumber = 0;

	public List<Athlete> readAthleteFromDB() throws SQLException, PersonException, ParseException {
		int i = 0;
		Connection conn = DriverManager.getConnection("jdbc:mysql://java.azib.net:3306/decathlon", "java", "java");
		conn.setAutoCommit(false);
		try {
			Statement statement = conn.createStatement();
			ResultSet rs;
			if (parameter.matches("\\d+")) {
				rs = statement.executeQuery(
					"SELECT a. * , r. * \n" +
					"FROM athletes a, results r\n" +
					"WHERE a.id = r.athlete_id\n" +
					"AND r.competition_id =" + parameter + "\n" +
					"ORDER BY a.id ASC"
					);
			}
			else {
				rs = statement.executeQuery(
					"SELECT a. * , r. * , c. *\n" +
					"FROM competitions c, athletes a, results r\n" +
					"WHERE a.id = r.athlete_id\n" +
					"AND c.name =" + "'"+parameter+"'" + "\n" +
					"AND c.id = r.competition_id\n" +
					"ORDER BY a.id ASC"
					);
			}

			while(!rs.isLast()) {
				if (!rs.next()) {
					return null;
				}
				Athlete athlete = new Athlete();
				athlete.setName(rs.getString("name"));
				athlete.setBirthDate(rs.getString("dob"));
				athlete.setCountry(rs.getString("country_code"));
				athlete.setPerformance(i, rs.getDouble("race_100m"));
				i++;
				athlete.setPerformance(i, rs.getDouble("long_jump"));
				i++;
				athlete.setPerformance(i, rs.getDouble("shot_put"));
				i++;
				athlete.setPerformance(i, rs.getDouble("high_jump"));
				i++;
				athlete.setPerformance(i, rs.getDouble("race_400m"));
				i++;
				athlete.setPerformance(i, rs.getDouble("hurdles_110m"));
				i++;
				athlete.setPerformance(i, rs.getDouble("discus_throw"));
				i++;
				athlete.setPerformance(i, rs.getDouble("pole_vault"));
				i++;
				athlete.setPerformance(i, rs.getDouble("javelin_throw"));
				i++;
				athlete.setPerformance(i, rs.getDouble("race_1500m"));
				i = 0;
				ScoreCalculator.calculate(athlete);
				contestants.add(athlete);
			}
		}
		catch (SQLException e) {
			conn.rollback();
			System.out.println(("Failed to load athletes"));
		}
		finally {
			conn.close();
		}

		return contestants;
	}

	public List<Athlete> readAthleteFromCSV(BufferedReader reader) {
		try	{
			String line;
			StringTokenizer tokenizer;

			while((line = reader.readLine()) != null) {
				Athlete athlete = new Athlete();
				tokenizer = new StringTokenizer(line.trim(), ",");
				while(tokenizer.hasMoreTokens()) {
					athlete.setName(checkName(tokenizer.nextToken().trim()));
					tokenNumber++;
					athlete.setBirthDate(checkDate(tokenizer.nextToken().trim()));
					tokenNumber++;
					athlete.setCountry(checkCountry(tokenizer.nextToken().trim()));
					tokenNumber++;
					for (int c = 0; c < 10; c++) {
						if (c == 4 || c == 9) {
							athlete.setPerformance(c, checkMinSec(tokenizer.nextToken().trim()));
							tokenNumber++;
						}
						else {
							athlete.setPerformance(c, checkIsNumber(String.valueOf(Double.parseDouble(tokenizer.nextToken().trim()))));
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

	public List<Athlete> readAthleteFromConsole() throws IOException, ParseException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));

		int i = 0;
		boolean inputtingAthletes = true;

		while (inputtingAthletes) {
			Athlete athlete = new Athlete();



			while (athlete.getName() == null) {
	            System.out.print("Full name (Name Surname): ");
	            athlete.setName(checkName(reader.readLine()));
	        }

	        while (athlete.getBirthDate() == null) {
	            System.out.print("Date of Birth " + "(" + format.toPattern() + "): ");
	            String checkDateResult = checkDate(reader.readLine());
	            if (checkDateResult == null) {
	            	System.out.println("Error in input. Try again.");
	            }
	            else {
	            	athlete.setBirthDate(checkDateResult);
	            }
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
					System.out.println("Error in input. Try again.");
				}
			}

			while (athlete.getLongJump() == null) {
	            System.out.print("Long jump (meters.centimeters): ");
	            try {
		            athlete.setPerformance(i, checkIsNumber(reader.readLine()));
					athlete.setLongJump(athlete.getPerformance(i));
		            i++;
				} catch (NumberFormatException e) {
					System.out.println("Error in input. Try again.");
				}
	        }

			while (athlete.getShotPut() == null) {
	            System.out.print("Shot put (meters.centimeters): ");
	            try {
		            athlete.setPerformance(i, checkIsNumber(reader.readLine()));
					athlete.setShotPut(athlete.getPerformance(i));
		            i++;
				} catch (NumberFormatException e) {
					System.out.println("Error in input. Try again.");
				}
	        }

			while (athlete.getHighJump() == null) {
	            System.out.print("High jump (meters.centimeters): ");
	            try {
		            athlete.setPerformance(i, checkIsNumber(reader.readLine()));
					athlete.setHighJump(athlete.getPerformance(i));
		            i++;
				} catch (NumberFormatException e) {
					System.out.println("Error in input. Try again.");
				}
	        }

			while (athlete.getFourHundredMeters() == null) {
	            System.out.print("400m (minutes:seconds.milliseconds): ");
	            try {
		            athlete.setPerformance(i, checkMinSec(reader.readLine()));
					athlete.setFourHundredMeters(athlete.getPerformance(i));
		            i++;
				} catch (NumberFormatException e) {
					System.out.println("Error in input. Try again.");
				}
	        }

			while (athlete.getHurdles() == null) {
	            System.out.print("110m hurdles (seconds.milliseconds): ");
	            try {
		            athlete.setPerformance(i, checkIsNumber(reader.readLine()));
					athlete.setHurdles(athlete.getPerformance(i));
		            i++;
				} catch (NumberFormatException e) {
					System.out.println("Error in input. Try again.");
				}
	        }

			while (athlete.getDiscus() == null) {
	            System.out.print("Discus throw (meters.centimeters): ");
	            try {
		            athlete.setPerformance(i, checkIsNumber(reader.readLine()));
					athlete.setDiscus(athlete.getPerformance(i));
		            i++;
				} catch (NumberFormatException e) {
					System.out.println("Error in input. Try again.");
				}
	        }

			while (athlete.getPoleVault() == null) {
	            System.out.print("Pole vault (meters.centimeters): ");
	            try {
		            athlete.setPerformance(i, checkIsNumber(reader.readLine()));
					athlete.setPoleVault(athlete.getPerformance(i));
		            i++;
				} catch (NumberFormatException e) {
					System.out.println("Error in input. Try again.");
				}
	        }

			while (athlete.getJavelin() == null) {
	            System.out.print("Javelin throw (meters.centimeters): ");
	            try {
		            athlete.setPerformance(i, checkIsNumber(reader.readLine()));
					athlete.setJavelin(athlete.getPerformance(i));
		            i++;
				} catch (NumberFormatException e) {
					System.out.println("Error in input. Try again.");
				}
	        }

			while (athlete.getRace() == null) {
	            System.out.print("1500m race (minutes:seconds.milliseconds): ");
	            try {
		            athlete.setPerformance(i, checkMinSec(reader.readLine()));
					athlete.setRace(athlete.getPerformance(i));
		            i++;
				} catch (NumberFormatException e) {
					System.out.println("Error in input. Try again.");
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

	private String checkName(String name) throws UnsupportedEncodingException {
		byte[] nameUTF = name.getBytes("UTF-8");
		name = new String (nameUTF, "UTF-8");
		return name;
		//since limiting names is a bad idea I'll just convert them to UTF-8 instead.
		/*if (name.contains("\"")) {
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
		}*/
	}

	private String checkDate(String birthDate) throws ParseException {
        format.setLenient(false);
		try {
			format.parse(birthDate);
			return birthDate;
		}
        catch (ParseException e) {
            return null;
        }
        catch (IllegalArgumentException e) {
            return null;
        }

    }

	private String checkCountry(String country) {
		String[] countries = Locale.getISOCountries();
			for (int i = 0; i < Locale.getISOCountries().length; i++) {
				if (countries[i].contains(country))
				return country;
			}
		return null;
	}

	private Double checkIsNumber(String stringInput) {
		if (stringInput == null || Double.valueOf(stringInput) == null) {
			System.out.println("Error in input. Try again.");
			return null;
		}
		else {
			return Double.valueOf(stringInput);
		}
	}

    private Double checkMinSec(String time) {
	    String[] timeSplit;
	    if (time.matches("^([0-9][1-9]|[0-9])[:]([0-5][0-9]|[0-9])[. ]([0-9][0-9][0-9]|[0-9][0-9]|[0-9])")){
		    timeSplit = time.split(":");
       		return (double)Integer.parseInt(timeSplit[0])*60 + Double.parseDouble(timeSplit[1]);
	    }
	    else if (time == null || Double.valueOf(time) == null) {
		    System.out.println("Error in input. Try again.");
			throw new NumberFormatException();
		}
		else {
			return Double.valueOf(time);
		}
	}
}