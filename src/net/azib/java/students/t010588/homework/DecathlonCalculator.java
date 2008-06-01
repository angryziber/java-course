package net.azib.java.students.t010588.homework;

import net.azib.java.students.t010588.homework.exporter.AthleteExporter;
import net.azib.java.students.t010588.homework.exporter.CSVExporter;
import net.azib.java.students.t010588.homework.exporter.ConsoleExporter;
import net.azib.java.students.t010588.homework.exporter.HTMLExporter;
import net.azib.java.students.t010588.homework.exporter.InternalException;
import net.azib.java.students.t010588.homework.exporter.XMLExporter;
import net.azib.java.students.t010588.homework.importer.AthleteImporter;
import net.azib.java.students.t010588.homework.importer.CSVImporter;
import net.azib.java.students.t010588.homework.importer.ConsoleImporter;
import net.azib.java.students.t010588.homework.importer.DBConstants;
import net.azib.java.students.t010588.homework.importer.DatabaseImporter;
import net.azib.java.students.t010588.homework.importer.WrongFormatException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Tool to import decathlon results, scoring points and exporting results table
 *
 * @author Vjatseslav Rosin, 010588
 */
public class DecathlonCalculator {

	/**
	 * @param args
	 *            program arguments: -<input-method> [input-parameters] -<output-method>
	 *            [output-parameters]
	 */
	public static void main(String[] args) {
		if (args.length < 2) {
			help();
			System.exit(0);
		}

		int argIndex = 0;

		AthleteImporter importer = null;
		AthleteExporter exporter = null;

		try {
			if (args[argIndex].equals("-csv")) {
				importer = new CSVImporter(new FileInputStream(args[++argIndex]));
			}
			else if (args[argIndex].equals("-console")) {
				importer = new ConsoleImporter();
			}
			else if (args[argIndex].equals("-db")) {
				importer = new DatabaseImporter(
						DecathlonCalculator.class.getResourceAsStream(DBConstants.DEFAULT_DB_PROP_FILE_NAME), args[++argIndex]);
			}

			argIndex++;

			if (args[argIndex].equals("-csv")) {
				File exportFile = new File(args[++argIndex]);
				exporter = new CSVExporter(exportFile);
			}
			else if (args[argIndex].equals("-xml")) {
				File exportFile = new File(args[++argIndex]);
				exporter = new XMLExporter(exportFile);
			}
			else if (args[argIndex].equals("-console")) {
				exporter = new ConsoleExporter();
			}
			else if (args[argIndex].equals("-html")) {
				File exportFile = new File(args[++argIndex]);
				exporter = new HTMLExporter(exportFile, DecathlonCalculator.class
						.getResourceAsStream(HTMLExporter.DEFAULT_STYLE_FILE_NAME));
			}

			if (importer == null || exporter == null)
				throw new WrongFormatException("Unsupported format:" + args[argIndex++] + " => " + args[argIndex++]);

			new DecathlonSummarizer().summarize(importer.getAthletes());

			exporter.exportAthletes(importer.getAthletes());
		}
		catch (WrongFormatException e) {
			System.out.println("Error!");
			System.out.println("Wrong Format: " + e.getMessage());
			help();
		}
		catch (InternalException e) {
			System.out.println("Internal error!");
			System.out.println(e.getMessage());
			help();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.exit(0);
	}

	/**
	 * Prints help message
	 */
	private static void help() {
		System.out.println("Usage: <program> -<input-method> [input-parameters] -<output-method> [output-parameters]");
		System.out.println("Supported input format(s):");
		System.out.println("-console");
		System.out.println("-cvs [file]");
		System.out.println("-db [competition id or name]");
		System.out.println("Supported output format(s):");
		System.out.println("-console");
		System.out.println("-cvs [file]");
		System.out.println("-xml [file]");
		System.out.println("-html [file]");
	}
}
