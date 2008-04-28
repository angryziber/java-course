package net.azib.java.students.t030633.homework.view.in;

import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.AthleteBuilder;
import net.azib.java.students.t030633.homework.model.Event;
import net.azib.java.students.t030633.homework.view.Files;
import net.azib.java.students.t030633.homework.view.Input;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Reads decathlon input athletes and their results from a comma separated file.
 * 
 * @author t030633
 */
public class CSV implements Input {

	private AthleteBuilder athleteBuilder;

	private InputStream in;

	public CSV() throws FileNotFoundException {
		this.in = new FileInputStream(new Files().getInputFile("csv"));
	}

	public CSV(InputStream in) {
		this.in = in;
	}

	public Input builder(AthleteBuilder athleteBuilder) {
		this.athleteBuilder = athleteBuilder;
		return this;
	}

	public List<Athlete> read() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
		List<Athlete> list = new LinkedList<Athlete>();
		while (reader.ready()) {
			list.add(parseAthlete(athleteBuilder, reader.readLine()));
		}
		return list;
	}

	private Athlete parseAthlete(AthleteBuilder athleteBuilder, String line) {
		athleteBuilder.reset();
		String[] fields = line.split(",");
		String[] stringResults = new String[Event.values().length];
		System.arraycopy(fields, 3, stringResults, 0, Event.values().length);
		Parser parser = new Parser();
		double[] doubleResults = parser.parseResults(stringResults);
		int i = 0;
		for (Event e : Event.values()) {
			athleteBuilder.addResult(e, doubleResults[i++]);
		}
		return athleteBuilder.name(parser.parseName(fields[0])).date(parser.parseDate(fields[1])).country(fields[2]).build();
	}

	public void close() throws IOException {
		in.close();
	}

}
