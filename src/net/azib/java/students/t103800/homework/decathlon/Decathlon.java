package net.azib.java.students.t103800.homework.decathlon;

import net.azib.java.students.t103800.homework.decathlon.argument.Argument;
import net.azib.java.students.t103800.homework.decathlon.argument.ArgumentException;
import net.azib.java.students.t103800.homework.decathlon.argument.ArgumentHandler;

/**
 * This is the main class of the decathlon project.
 *
 * @author Jaan Aigro
 * @version 1.0
 * @since 27/05/2011
 */
public class Decathlon {

	/**
	 * Main method that runs the program.
	 * @param arguments input arguments. @see Argument
	 */
	public static void main(String[] arguments) {
		System.setProperty("console.encoding", "UTF-8");
		new Decathlon(arguments);
	}

	/**
	 * Main constructor of the program. Executes arguments.
	 * @param arguments arguments to execute.
	 */
	public Decathlon(String[] arguments) {
		try {
			ArgumentHandler handler = new ArgumentHandler(arguments);
			Argument inputArg = handler.getNextArgument();
			Argument outputArg = handler.getNextArgument();

			Exporter exporter = Exporter.getExporter();
			Importer importer = Importer.getImporter();
			Athlete[] athletes = importer.importAthletes(inputArg);
			exporter.exportAthletes(athletes, outputArg);

			System.out.println("Done.");
		} catch (ArgumentException e) {
			System.err.println("Argument exception: " + e.getMessage());
		} catch (ImporterException e) {
			System.err.println("Importer exception: " + e.getMessage());
		} catch (ExporterException e) {
			System.err.println("Exporter exception: " + e.getMessage());
		}
	}
}