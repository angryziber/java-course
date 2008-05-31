package net.azib.java.students.t010588.homework.importer;

import net.azib.java.students.t010588.homework.Athlete;
import net.azib.java.students.t010588.homework.DecathlonConstants;
import net.azib.java.students.t010588.homework.EventType;
import net.azib.java.students.t010588.homework.FieldEventResult;
import net.azib.java.students.t010588.homework.Result;
import net.azib.java.students.t010588.homework.RunningEventResult;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Imports athletes from console
 *
 * @author Vjatseslav Rosin, 010588
 */
public class ConsoleImporter implements AthleteImporter {

	private List<Athlete> athletes;

	/**
	 * Constructor uses default system input stream as importer input stream
	 *
	 * @throws WrongFormatException
	 *             in a case of invalid user input
	 */
	public ConsoleImporter() throws WrongFormatException {
		this(System.in);
	}

	/**
	 * @param inputStream
	 *            to read data from
	 * @throws WrongFormatException
	 *             in a case of invalid user input
	 */
	public ConsoleImporter(InputStream inputStream) throws WrongFormatException {
		athletes = new ArrayList<Athlete>();

		InputStreamReader isr = new InputStreamReader(inputStream);

		BufferedReader stdin = new BufferedReader(isr);

		try {
			int i = 1;
			while (true) {
				Athlete athlete = new Athlete();
				System.out.println("Athlete " + i + ", name:");
				String name = stdin.readLine();
				athlete.setName(name);

				System.out.println("Athlete " + i + ", birthday:");
				String birthday = stdin.readLine();
				athlete.setBirhday(DATE_FORMAT.parse(birthday));

				System.out.println("Athlete " + i + ", country:");
				String country = stdin.readLine();
				athlete.setCountry(country.toCharArray());

				int eventsCount = DecathlonConstants.EVENTS.length;

				Result[] results = new Result[eventsCount];
				for (int j = 0; j < eventsCount; j++) {
					System.out.println("Athlete " + i + ", result " + (j + 1) + ":");
					String result = stdin.readLine();
					if (DecathlonConstants.EVENTS[j] == EventType.RUNNING)
						results[j] = new RunningEventResult(j, result);
					else
						results[j] = new FieldEventResult(j, Float.parseFloat(result));
				}

				athlete.setResults(results);

				athletes.add(athlete);

				System.out.println("More?");
				String more = stdin.readLine();
				if (!more.equals("y") && !more.equals("Y"))
					break;
				i++;
			}

			stdin.close();
		}
		catch (Exception e) {
			e.printStackTrace(System.err);
			throw new WrongFormatException("Wrong format!");
		}
	}

	public List<Athlete> getAthletes() {
		return athletes;
	}
}
