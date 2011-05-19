package net.azib.java.lessons.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author anton
 */
public class UserInput {
	Reader reader = new InputStreamReader(System.in);

	public String askForName() throws IOException {
		System.out.print("Please enter your name: ");
		BufferedReader reader = new BufferedReader(this.reader);
		return reader.readLine();
	}
}
