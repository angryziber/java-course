package net.azib.java.students.t073639.homework;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * Instance of StringConverter class represents list of strings, which contain
 * data of single athlete.
 * 
 * @author t073639
 */
public class StringConverter {
	private List<String> list = new ArrayList<String>();

	/**
	 * <p>
	 * Create a new empty list. <br>
	 * Add all data from parameter.
	 * 
	 * @param s - string, which contains name, birthday, country and ten
	 *            results of decathlon separated by comma.
	 */
	public StringConverter(String s) {
		this.addSingleAthleteFromString(s);
	}

	/**
	 * <p>Get single athlete list.
	 * 
	 * @return Single athlete list.
	 */
	public List<String> getList() {
		return list;
	}

	/**
	 * @return Formated string, which contains name, birthday, country and ten
	 *         results of decathlon separated by comma.
	 */
	@Override
	public String toString() {
		return list.get(0) + "," + list.get(1) + "," + list.get(2) + "," + list.get(3) + "," + list.get(4) + "," + list.get(5)
				+ "," + list.get(6) + "," + list.get(7) + "," + list.get(8) + "," + list.get(9) + "," + list.get(10) + ","
				+ list.get(11) + "," + list.get(12);
	}

	private void addSingleAthleteFromString(String source) {
		Scanner scanner = new Scanner(source).useDelimiter(",");
		int i = 0;
		while (scanner.hasNext()) {
			String scan = scanner.next();
			Pattern pMinutes = Pattern.compile("[0-9]+\\:[0-9]{2}\\.[0-9]{1,2}");
			Matcher minutes = pMinutes.matcher(scan);
			Pattern pMetres = Pattern.compile("[0-9]{1,2}\\.[0-9]{1,2}");
			Matcher metres = pMetres.matcher(scan);
			Pattern pUnitMetres = Pattern.compile("[0-9]{1}");
			Matcher unitMetres = pUnitMetres.matcher(scan);
			if (minutes.find())
				this.list.add(StringConverter.formatTimeMinToSec(scan.replaceAll("\\s", "")));
			else if ((i == 4 || i == 6 || i == 10) && (metres.find() || (scan.length() == 1 && unitMetres.find()))) {
				BigDecimal bd = new BigDecimal(Double.parseDouble(scan));
				bd = bd.multiply(new BigDecimal(100));
				bd = bd.setScale(0, BigDecimal.ROUND_HALF_UP);
				this.list.add(String.valueOf(bd.toString()));
			}
			else
				this.list.add(scan);
			i++;
		}
	}

	/**
	 * <p> Method converts from minutes consisted results to seconds.
	 * <br>Example: was "5:10.25", return "310.25"
	 * @param string - Time, which contain minutes, seconds and milliseconds.
	 * @return Formated time, which contain seconds and milliseconds.
	 */
	public static String formatTimeMinToSec(String string) {
		Pattern p1 = Pattern.compile(":");
		Pattern p2 = Pattern.compile("\\.");
		Matcher m1 = p1.matcher(string);
		Matcher m2 = p2.matcher(string);
		int intSeconds = 0;
		int index = 0;
		if (m1.find() && m2.find()) {
			intSeconds = 60 * Integer.parseInt(string.substring(index, m1.end() - 1));
			index = m1.end();
			intSeconds = intSeconds + Integer.parseInt(string.substring(index, m2.end() - 1));
			index = m2.end();
			return (int) intSeconds + "." + string.substring(index, string.length());
		}
		else
			return "Error";
	}
}
