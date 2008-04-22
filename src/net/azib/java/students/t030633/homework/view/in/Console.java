package net.azib.java.students.t030633.homework.view.in;

import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.AthleteBuilder;
import net.azib.java.students.t030633.homework.model.Event;
import net.azib.java.students.t030633.homework.view.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * Reads athletes from a scanner.
 * 
 * @author t030633
 */
public class Console implements Input {

	private static final String BEGIN_MSG = "-=[Athlete input]=-";
	private static final String LN = System.getProperty("line.separator");
	private static final String QUESTION = "Do you wish to enter another athlete? y/n" + LN + ">";
	private static final String WRONG_FORMAT = "Result must be a number!" + LN;
	private AthleteBuilder builder;
	private final BufferedReader in;
	private final PrintStream out;

	/**
	 * Console: input stream defaults to System.in, output stream defaults to
	 * System.out
	 */
	public Console() {
		this(System.in, System.out);
	}

	/**
	 * @param in -
	 *            InputStream to read input from
	 * @param out -
	 *            PrintStream for outgoing messages
	 */
	public Console(InputStream in, PrintStream out) {
		this.in = new BufferedReader(new InputStreamReader(in));
		this.out = out;
	}

	public Input builder(AthleteBuilder builder) {
		this.builder = builder;
		return this;
	}

	public List<Athlete> read() throws IOException {

		List<Athlete> list = new LinkedList<Athlete>();
		out.println(BEGIN_MSG);

		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, new Locale(System.getProperty("user.country")));

		do {
			builder.reset();
			out.print("Name: ");
			builder = builder.name(in.readLine());
			out.print("Country: ");
			builder = builder.country(in.readLine());
			out.print("Birth date: ");

			try {
				builder = builder.date(df.parse(in.readLine()));
			}
			catch (ParseException e) {
				builder = builder.date(new Date(0L));
			}

			out.println("Results: ");

			for (Event e : Event.values()) {
				out.print("\t" + e.getName() + ": ");
				String result = in.readLine();
				try {
					builder = builder.addResult(e, Double.parseDouble(result));
				}
				catch (NumberFormatException ex) {
					out.print(WRONG_FORMAT);
				}
			}

			list.add(builder.build());
			out.print(QUESTION);
		}
		while (in.readLine().equals("y"));

		return list;

	}

	public void close() throws IOException {
		this.in.close();
		this.out.close();
	}

}
