package net.azib.java.students.t030657.homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Input data contains any number of athletes. 
The following information is available about each of them:

    * Name
    * Date of birth
    * Country (ISO 2-letter code)
    * Raw results (measurements) for each of 10 decathlon events 

Input data can come from various sources:

    * Interactively entered using the keyboard
    * CSV (comma-separated) file in UTF-8 encoding. Decimal separator is period ('.').
    * MySQL database (connection options are below) 

The program must process only a single decathlon competition at a time.

Input data should be validated for logical correctness.

Example of CSV file content:

"Siim Susi",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72 
"Beata Kana",29.02.1982,ZA,13.04,4.53,7.79,1.55,1:04.72,18.74,24.20,2.40,28.20,6:50.76 

Above, events are in the following order and units:

    * 100 m sprint (sec)
    * Long jump (m)
    * Shot put (m)
    * High jump (m)
    * 400 m sprint (min:sec)
    * 110 m hurdles (sec)
    * Discus throw (m)
    * Pole vault (m)
    * Javelin throw (m)
    * 1500 m race (min:sec) 
 */

/**
 * @author Karina
 * public class CsvReader
 * In this class reading athlete is implemented, exceptions are thrown if something is wrong
 * Used IO source - CSV
 * 
 */

public class CsvReader implements Reader {
	public static final int MIN_FIELDS = 3;
	public static final String SEPARATOR = ",";
	public static final String TIME_SEPARATOR = ":";
	
	File file;

	CsvReader(File file) {
		this.file = file;
	}

	public List<Results> readAll() {
		ArrayList<Results> results = new ArrayList<Results>();
		BufferedReader input = null;
		try {
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader in = new InputStreamReader(fis, "UTF-8");
			input = new BufferedReader(in);
			String line = null;

			while ((line = input.readLine()) != null) {
				String[] fields = line.split(SEPARATOR);
				int i=0;
				if (fields.length<MIN_FIELDS)
					throw new IllegalArgumentException("Not enough fields");
				Results r = new Results( new Athlete(
						fields[i++].replace("\"", ""),
						fields[i++],
						fields[i++]
				));
				results.add(r);
				for (Event ev: Event.values()) {
					double result = 0.0;
					if (i>=fields.length)
						break;
					String field = fields[i++];
					if (ev==Event.race400m || ev==Event.race1500m) {
						String[] parts = field.split(TIME_SEPARATOR);
						if (parts.length>1) {
							field = parts[1];
							result+=Double.parseDouble(parts[0])*60.0;
						}
					}
					result += Double.parseDouble(field);
					r.setResult(ev, result);
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (input != null) {
					input.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return results;
	}
}
