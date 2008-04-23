package net.azib.java.students.t072054.hometask1;

import java.util.Scanner;

/**
 * BinaryParser
 *
 * @author r_vassiljev
 */
public class BinaryParser {
	public static void readStream() {
	       try {
	         Scanner scanner = new Scanner(System.in);
	         while (scanner.hasNext()) {
	           System.out.println(scanner.next());
	         }
	         scanner.close();
	       } catch (Exception e) {
	         e.printStackTrace();
	       }
	     }

}
