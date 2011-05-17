package net.azib.java.students.t104607.homework;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 104607 IASM
 */
public class InputCsv {
	Logger LOG = Logger.getLogger(this.getClass());

	public String[] parseCSV(String csvLine) {
		ArrayList<String> allMatches = new ArrayList<String>();
		String match;
		Pattern csvPattern = Pattern.compile("\"([^\"]*)\"|(?<=,|^)([^,]*)(?:,|$)");
	    Matcher matcher = csvPattern.matcher(csvLine);

	    while (matcher.find()) {
	            match = matcher.group(1);
	            if (match!=null) {
	                    allMatches.add(match);
	            }
	            else {
	                    allMatches.add(matcher.group(2));
	            }
	    }

	    int size = allMatches.size();
	    if (size > 0) {
	            return allMatches.toArray(new String[size]);
	    } else {
	            return new String[0];
	    }
	}

	public List<Athlete> load(InputStream inputStream) throws IOException, ParseException {
		List<Athlete> athletes = new ArrayList<Athlete>();
		String line;
		String[] split;

		LOG.info("Using CSV input");
		BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
		while ((line = in.readLine()) != null) {
			if (!line.startsWith("#")) {
				split = parseCSV(line);
				Athlete athlete = new Athlete(split[0],split[1],split[2],split[3],split[4],
						split[5],split[6],split[7],split[8],split[9],split[10],split[11],split[12]);
				athletes.add(athlete);
			}
		}
		in.close();

		return athletes;
	}
}
