package net.azib.java.students.t030633.homework.view.in;

import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.AthleteBuilder;
import net.azib.java.students.t030633.homework.model.DecathlonAthleteBuilder;
import net.azib.java.students.t030633.homework.model.Event;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

/**
 * Reads athletes from a scanner.
 * 
 * @author t030633
 */
public class Console implements Input {

	static final String BEGIN_MSG = "-=[Athlete input]=-";
	static final String LN = System.getProperty("line.separator");
	static final String QUESTION = "Do you wish to enter an athlete? y/n" + LN + ">";
	static final String WRONG_RESULT_FORMAT = "Result must be a number!" + LN;
	static final String WRONG_DATE_FORMAT = "Bad date format.";

	// Using system date format, which the user probably assumes
	static final DateFormat DF = DateFormat.getDateInstance();

	private PrintStream out;
	private BufferedReader reader;
	private AthleteBuilder builder = new DecathlonAthleteBuilder();
	
	public Console() {
		this(System.out, new BufferedReader(new InputStreamReader(System.in)));
	}

	/**
	 * @param out -
	 *            PrintStream for outgoing messages to console
	 * @param in -
	 *            InputStream to read console input from
	 */
	public Console(PrintStream out, BufferedReader in) {
		this.out = out;
		this.reader = in;
	}

	public List<Athlete> read(String... param) throws IOException {

		List<Athlete> list = new LinkedList<Athlete>();

		out.println(BEGIN_MSG);
		out.print(QUESTION);
		while (reader.readLine().equals("y")) {
			out.print("Name: ");
			builder = builder.name(reader.readLine());
			out.print("Country: ");
			builder = builder.country(reader.readLine());
			out.print("Birth date: ");

			try {
				builder = builder.date(DF.parse(reader.readLine()));
			}
			catch (ParseException e) {
				out.print(WRONG_DATE_FORMAT);
			}

			out.println("Results: ");

			for (Event e : Event.values()) {
				out.print("\t" + e.getName() + ": ");
				String result = reader.readLine();
				try {
					result = result.replaceAll(",", "."); // To allow both comma and dot separators
					if (result.contains(":")) {
						String[] minutes = result.split(":");
						builder = builder.addResult(e, Integer.parseInt(minutes[0]) * 60 + Double.parseDouble(minutes[1]));
					}
					else {
						builder = builder.addResult(e, Double.parseDouble(result));
					}
				}
				catch (NumberFormatException ex) {
					out.print(WRONG_RESULT_FORMAT);
				}
			}

			list.add(builder.build());
			out.print(QUESTION);
		}
		return list;

	}

}
