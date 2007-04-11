package net.azib.java.students.t020556;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * InptScan
 *
 * @author Agu Aarna
 */
public class InptScan {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		InputStream inpt = System.in;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(inpt));
		System.out.print("Enter name: ");
		String line = reader.readLine();
		
		System.out.println();
		System.out.println("Hello, " + line + "");

	}

}
