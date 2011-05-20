package net.azib.java.students.t104607.homework;

import org.apache.log4j.Logger;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * This class is for loading raw results of athletes from console
 *
 * @author 104607 IASM
 */
public class InputConsole {
	Logger LOG = Logger.getLogger(this.getClass());
	OutputStreamWriter out = new OutputStreamWriter(System.out);
	Scanner scanner = new Scanner(System.in);

	/**
     * Load raw results of athletes from console
     * <p>
     * @return list with athletes results
	 */
	public List<Athlete> load () {
		String[][] a = {
				{"Enter athlete name (ex. 'John Smith') : ","\\D+",null},
				{"Enter athlete birthday [DD.MM.YYYY] (ex. '31.12.2000') : ",
						"((0?[1-9])|([1-2][0-9])|(3[0-1]))[.]((0?[1-9])|(1[0-2]))[.][0-9]{4}",null},
				{"Enter athlete country (ex. 'UK') : ","[A-Z][A-Z]",null},
				{"Enter result of 100m sprint in seconds (ex. '10.22') : ","(\\d+)([.]((\\d)|(\\d{2})))?",null},
				{"Enter result of long jump in metres (ex. '8.22') : ","(\\d+)([.]((\\d)|(\\d{2})))?",null},
				{"Enter result of shot put in metres (ex. '19.17') : ","(\\d+)([.]((\\d)|(\\d{2})))?",null},
				{"Enter result of high jump in metres (ex. '2.27') : ","(\\d+)([.]((\\d)|(\\d{2})))?",null},
				{"Enter result of 400m sprint in seconds (ex. '45.68') : ","(\\d+)([.]((\\d)|(\\d{2})))?",null},
				{"Enter result of 110 hurdles in seconds (ex. '13.47') : ","(\\d+)([.]((\\d)|(\\d{2})))?",null},
				{"Enter result of discus throw in metres (ex. '55.87') : ","(\\d+)([.]((\\d)|(\\d{2})))?",null},
				{"Enter result of pole vault in metres (ex. '5.76') : ","(\\d+)([.]((\\d)|(\\d{2})))?",null},
				{"Enter result of javelin throw in metres (ex. '79.80') : ","(\\d+)([.]((\\d)|(\\d{2})))?",null},
				{"Enter result of 1500m race in seconds (ex. '238.70') : ","(\\d+)([.]((\\d)|(\\d{2})))?",null},
		};
		LOG.info("Using console input");

		List<Athlete> athletes = new ArrayList<Athlete>();
		scanner.useDelimiter("\n");

		try {
			do {
				for (int i=0 ; i<a.length ; i++) {
					out.write(a[i][0]);
					out.flush();
					try {
						String kp = scanner.next(a[i][1]);
						a[i][2] = kp;
					} catch (InputMismatchException e) {
						scanner.next();
						i--;
					}
				}
				try {
					Athlete athlete = new Athlete(a[0][2],a[1][2],a[2][2],a[3][2],
						a[4][2],a[5][2],a[6][2],a[7][2],a[8][2],a[9][2],a[10][2],a[11][2],a[12][2]);
					athletes.add(athlete);
				} catch (ParseException e) {
					LOG.error("Parsing console line",e);
				}
				out.write("Have you finished ? [y/n] : ");
				out.flush();
			} while (!scanner.next().equalsIgnoreCase("y"));
		} catch (IOException e) {
			LOG.error("Console input problem with output stream", e);
		}

		LOG.debug("Got " + athletes.size() + " record");
		return athletes;
	}
}
