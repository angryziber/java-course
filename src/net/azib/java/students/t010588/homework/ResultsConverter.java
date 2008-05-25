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
import net.azib.java.students.t010588.homework.importer.DatabaseImporter;
import net.azib.java.students.t010588.homework.importer.WrongFormatException;

import java.io.File;

/**
 * Tool to import decathlon results, scoring points and exporting results table
 *
 * @author Vjatseslav Rosin, 010588
 */
public class ResultsConverter {

	/**
	 * @param args
	 *            program arguments: -<input-method> [input-parameters] -<output-method>
	 *            [output-parameters]
	 */
	public static void main(String[] args) {
		String importerKey = null;
		String importerParam = null;

		String exporterKey = null;
		String exporterParam = null;

		switch (args.length) {
		case 0:
		case 1:
			help();
			System.exit(0);
			break;
		case 2:
			importerKey = args[0];
			exporterKey = args[1];
			break;
		case 3:
			importerKey = args[0];
			importerParam = args[1];
			exporterKey = args[2];
			break;
		default:
			importerKey = args[0];
			importerParam = args[1];

			exporterKey = args[2];
			exporterParam = args[3];
			break;
		}

		AthleteImporter importer = null;
		AthleteExporter exporter = null;

		try {
			if (importerKey.equals("-csv")) {
				importer = new CSVImporter(new File(importerParam));
			}
			else if (importerKey.equals("-console")) {
				importer = new ConsoleImporter();
			}
			else if (importerKey.equals("-db")) {
				importer = new DatabaseImporter(new File("db.properties"), importerParam);
			}

			if (exporterKey.equals("-csv")) {
				exporter = new CSVExporter(new File(exporterParam));
			}
			else if (exporterKey.equals("-xml")) {
				exporter = new XMLExporter(new File(exporterParam));
			}
			else if (exporterKey.equals("-console")) {
				exporter = new ConsoleExporter();
			}
			else if (exporterKey.equals("-html")) {
				exporter = new HTMLExporter(new File(exporterParam));
			}

			if (importer == null || exporter == null)
				throw new WrongFormatException("Unsupported format:" + importerKey + " => " + exporterKey);

			DecathlonScoreCounter counter = new DecathlonScoreCounter();
			counter.score(importer.getAthletes());

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
		System.out.println("Supported output format(s): csv");
		System.out.println("-console");
		System.out.println("-cvs [file]");
		System.out.println("-xml [file]");
		System.out.println("-html [file]");
	}
}
