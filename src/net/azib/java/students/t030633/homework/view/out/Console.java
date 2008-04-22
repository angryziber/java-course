package net.azib.java.students.t030633.homework.view.out;

import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.Event;
import net.azib.java.students.t030633.homework.view.Output;

import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Prints athletes to PrintStream.
 * 
 * @author t030633
 */
public class Console implements Output {

	static final String LN = System.getProperty("line.separator");
	static final String BEGIN_MSG = "-=[Athletes]=- " + LN;
	private final PrintStream out;

	private static final Locale locale = new Locale(System.getProperty("user.country"));
	private static final DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, locale);

	/**
	 * Output stream defaults to System.out
	 */
	public Console() {
		this(System.out);
	}

	/**
	 * @param out -
	 *            PrintStream, where to print output
	 */
	public Console(PrintStream stream) {
		this.out = stream;
	}

	public void write(List<Athlete> list) throws IOException {
		out.println(BEGIN_MSG);
		if (!(list == null)) {
			for (Athlete a : list) {
				out.println("Name: " + a.getName());
				out.println("Birth date: " + df.format(a.getBirthDate()));
				out.println("Country: " + a.getCountry());
				out.println("Total score: " + a.getScore());
				out.println("Results: ");
				Map<Event, Double> results = a.getResults();
				if (!(results == null)) {
					for (Event e : results.keySet()) {
						out.println("\t" + e.getName() + " - " + results.get(e));
					}
				}
				out.println();
			}
		}
	}

	public void close() throws IOException {
		this.out.close();
	}

}
