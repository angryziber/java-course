package net.azib.java.students.t072054.hometask1;

import java.util.Scanner;
import java.io.*;

/**
 * BinaryParser
 *
 * @author r_vassiljev
 */
public class BinaryParser {
	private static void readStream() {
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
