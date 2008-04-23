package net.azib.java.students.t072054.hometask1;

import java.util.Scanner;

/**
 * BinaryParser
 * 
 * @author r_vassiljev
 */
public class BinaryParser {

	private Scanner scanner;
	private String scan_buffer;

	BinaryParser() {
		scanner = new Scanner(System.in);
		return;
	}

	public void readStream() {
		try {
			System.out.println("Enter some text...");

			// while (scanner.hasNext()) {
			scan_buffer = scanner.next();
			// }
			scanner.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("The decimal value is: " + convertDecimal(scan_buffer));
	}

	public static double convertDecimal(String str_buf) {
		/* This is str_buf in decimal format */
		double num_buf = 0;
		char temp_char;
		/* The value to be returned by the function */
		// String str_result;
		for (int i = str_buf.length() - 1; i >= 0; i--) {
			if (str_buf.charAt(i) == '0' || str_buf.charAt(i) == '1') {

				temp_char = str_buf.charAt(i);
				num_buf = num_buf + (temp_char-48) * Math.pow(2, i);
			}
			else
				return -1;
		}

		return num_buf;
	}

	public static void main(String[] args) {
		BinaryParser bs;

		bs = new BinaryParser();

		bs.readStream();

	}

}
