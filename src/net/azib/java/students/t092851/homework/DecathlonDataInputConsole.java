package net.azib.java.students.t092851.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * DecathlonDataInputConsole
 *
 * @author Lauri
 */
public class DecathlonDataInputConsole implements DecathlonDataInput {

	@Override
	public DecathlonData readData() {
		Scanner       scanner = new Scanner(System.in);
		Participant   athlete = new Participant();
		DecathlonData data    = new DecathlonData();
		
		while (true) {
			try {
				BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
				
				System.out.println("Starting to insert a new record.");
				System.out.println("Please enter following fields.");
				
				System.out.println("Athlete's name:");
				athlete.setName(input.readLine());
				
				System.out.println("Date of Birth (dd.MM.yyyy):");
				String     dateStr    = scanner.next("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}");
				DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
				athlete.setBirthDate(dateFormat.parse(dateStr));
				
				System.out.println("Country (two-letter ISO code):");
				String country = scanner.next("[A-Za-z]{2}");
				athlete.setCountry(country);
				
				for (DecathlonEvent event : DecathlonEvent.values()) {
					double result;
					
					System.out.println("Decathlon event " + event.getName() + " result (" + event.getUnits() + "):");
					result = scanner.nextDouble();
					athlete.setResult(event, result);
				}
				data.insert(athlete);
				System.out.println("Record is succesfully saved.");
			}
			catch (NoSuchElementException e) {
				System.out.println("Not supported format. Inserting a new record is interrupted.");
				scanner.next(); // Flush input
			}
			catch (ParseException e) {
				System.out.println("Invalid date format. Inserting a new record is interrupted.");
			}
			catch (IOException e) {
				System.out.println("Problems with console input, unable to receive data - exiting...");
				return null;
			}
			
			System.out.println("Would you like to enter a new record? (y/n)");
			String decision = scanner.next();
			if (decision.equals("y") || decision.equals("Y"))
				continue;
			else
				break;
			
		}
		System.out.println("Entering data finished.");
		return data;
	}

}
