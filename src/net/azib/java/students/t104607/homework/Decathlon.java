package net.azib.java.students.t104607.homework;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author 104607 IASM
 */
public class Decathlon {
	static boolean CommandLine (String[] args) throws IOException, SQLException {
		int i = 0;

		try {
			if (args[i].compareToIgnoreCase("-console") == 0) {
				new InputConsole();
			} else if (args[i].compareToIgnoreCase("-csv") == 0) {
				i++;
				new InputCsv(args[i]);
			} else if (args[i].compareToIgnoreCase("-db") == 0) {
				i++;
				new InputDb (args[1]);
			} else {
				return false;
			}
			i++;
			if (args[i].compareToIgnoreCase("-console") == 0) {
				new OutputConsole();
			} else if (args[i].compareToIgnoreCase("-csv") == 0) {
				i++;
				new OutputCsv(args[i]);
			} else if (args[i].compareToIgnoreCase("-xml") == 0) {
				i++;
				new OutputXml(args[i]);
			} else if (args[i].compareToIgnoreCase("-html") == 0) {
				i++;
				new OutputHtml(args[i]);
			} else {
				return false;
			}
			return true;
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}

	public static void main(String[] args) throws IOException, SQLException {
		System.out.println("HomeWork from 104607 IASM !");
		if (CommandLine(args) == false) {
			System.out.println("Use program:\n\tDecathlon -<input-method> [input-parameters] -<output-method> [output-parameters]");
		}
	}
}
