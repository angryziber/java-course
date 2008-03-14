package net.azib.java.students.t030633.lessons;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * DateReader
 * 
 * @author t030633
 */
public class DateReader {
	public static void main(String[] args) {

		System.out.print("Enter the number of dates: ");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		Locale locale = new Locale("et", "EE");
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, locale);
		List<Date> dates = new ArrayList<Date>();

		for (int i = 0; i < n; i++) {

			System.out.print(i + 1 + "? ");
			try {
				dates.add(df.parse(scanner.next()));
			}
			catch (ParseException e) {
				System.out.println("Date format is: " + ((SimpleDateFormat) df).toPattern());
				i--;
			}
		}

		for (Date date : dates) {
			System.out.println(df.format(date));
		}

	}
}
