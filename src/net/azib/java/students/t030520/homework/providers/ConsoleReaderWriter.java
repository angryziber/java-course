package net.azib.java.students.t030520.homework.providers;

import net.azib.java.students.t030520.homework.event.FieldEvent;
import net.azib.java.students.t030520.homework.event.TrackEvent;
import net.azib.java.students.t030520.homework.sportsman.EventResult;
import net.azib.java.students.t030520.homework.sportsman.SportsmanWithResults;
import net.azib.java.students.t030520.homework.util.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides reading and writing functionality into the console.
 *
 * @author t030520
 */
public class ConsoleReaderWriter {

	/**
	 * @return the list of sportsman's results.
	 * @throws IOException
	 */
	public List<SportsmanWithResults> readSportsmanResultsFromConsole() throws IOException {
		List<SportsmanWithResults> sportsmanWithResults = new ArrayList<SportsmanWithResults>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		System.out.println("Enter spotsman data.");

		do {
			SportsmanWithResults sportsmenResult = new SportsmanWithResults();
			
			// Enter name
			System.out.println("Name: ");
			str = br.readLine();
			while(Utils.isEmpty(str)) {
				System.out.println("Should not be empty. Retype, please.");
				str = br.readLine();
			}
			sportsmenResult.setName(str);
			
			// Enter date
			System.out.println("Date of birth(dd.mm.yyyy): ");
			str = br.readLine();
			while(Utils.isEmpty(str) || !Utils.isValidDate(str)) {
				System.out.println("Wrong date. Retype, please.");
				str = br.readLine();
			}
			sportsmenResult.setBirthDate(Utils.convertToDate(str));

			// Enter country code
			System.out.println("Country code: ");
			str = br.readLine();
			while (Utils.isEmpty(str) || str.length() != 2) {
				System.out.println("Wrong country code. Retype, please.");
				str = br.readLine();
			}
			sportsmenResult.setCountryCode(str);

			// Enter sprint100 results
			System.out.println("100 m sprint(sec): ");
			sportsmenResult.getResults().add(new EventResult(getFloatInput(br), TrackEvent.SPRINT100));

			// Enter longJump results
			System.out.println("Long jump (m): ");
			sportsmenResult.getResults().add(new EventResult(getFloatInput(br), FieldEvent.LONGJUMP));

			// Enter shotPut results
			System.out.println("Shot put (m): ");
			sportsmenResult.getResults().add(new EventResult(getFloatInput(br), FieldEvent.SHOTPUT));

			// Enter highJump results
			System.out.println("High jump (m): ");
			sportsmenResult.getResults().add(new EventResult(getFloatInput(br), FieldEvent.HIGHJUMP));

			// Enter sprint400 results
			System.out.println("400 m sprint (min:sec): ");
			sportsmenResult.getResults().add(new EventResult(getFloatInput(br), TrackEvent.SPRINT400));

			// Enter hurdles110 results
			System.out.println("110 m hurdles (sec): ");
			sportsmenResult.getResults().add(new EventResult(getFloatInput(br), TrackEvent.HURDLES110));

			// Enter discusThrow results
			System.out.println("Discus throw (m): ");
			sportsmenResult.getResults().add(new EventResult(getFloatInput(br), FieldEvent.DISCUSTHROW));

			// Enter poleVault results
			System.out.println("Pole vault (m): ");
			sportsmenResult.getResults().add(new EventResult(getFloatInput(br), FieldEvent.POLEVAULT));

			// Enter javelinThrow results
			System.out.println("Javelin throw (m): ");
			sportsmenResult.getResults().add(new EventResult(getFloatInput(br), FieldEvent.JAVELINTHROW));

			// Enter race1500 results
			System.out.println("1500 m race (min:sec): ");
			sportsmenResult.getResults().add(new EventResult(getFloatInput(br), TrackEvent.RACE1500));

			sportsmanWithResults.add(sportsmenResult);
			System.out.println("Do you want to proceed? yes/no");
			str = br.readLine();
		} while(!str.toLowerCase().equals("no"));

		return sportsmanWithResults;
	}

	/**
	 * Writes the result into console.
	 * @param results the list of sportsman's results.
	 */
	public void writeSportsmanResultsToConsole(List<SportsmanWithResults> sportsmanWithResults) {
		for (SportsmanWithResults res : sportsmanWithResults) {
			System.out.print(res.getPlace() + ", " + res.getPoints() + ", " + res.getName() + ", "
					+ res.getBirthDate() + ", " + res.getCountryCode() + ", ");
			int i = 1;
			for (EventResult ev : res.getResults()) {
				System.out.print(ev.getResult());
				if (i != res.getResults().size()) {
					System.out.print(", ");
				}
				i++;
			}
			System.out.println();
		}
	}

	private float getFloatInput(BufferedReader br) throws IOException {
		String str = br.readLine();
		while (Utils.isEmpty(str) || !Utils.isValidFloat(str)) {
			System.out.println("Wrong number format. Retype, please.");
			str = br.readLine();
		}
		return Utils.convertToFloat(str);
	}
}
