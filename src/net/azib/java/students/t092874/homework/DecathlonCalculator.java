package net.azib.java.students.t092874.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * HomeWork
 * 
 * @author Aleksandr Gladki
 */
public class DecathlonCalculator {
	private static List<Result> _listResults = new ArrayList<Result>();

	/**
	 * 
	 * @param source
	 *            parametrs from console. What does.
	 */
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals(Constants.CONSOLE)) {
				if (i == 0)
					_listResults = new ShowingInConsole().read();
				else
					new ShowingInConsole().write(_listResults);
			}
			else if (args[i].equals(Constants.CSV)) {
				if (i == 0)
					_listResults = new ShowingInCSV(args[++i]).read();
				else
					new ShowingInCSV(args[++i]).write(_listResults);
			}
			else if (args[i].equals(Constants.DB)) {
				_listResults = new ShowingInDB(args[++i]).read();
			}
			else if (args[i].equals(Constants.XML)) {
				new ShowingInXML(args[++i]).createXml(_listResults);
			}
			else if (args[i].equals(Constants.HTML)) {
				new ShowingInHTML(args[++i]).createHTML(_listResults);
			}
			else {
				throw new IllegalArgumentException("Invalid input parameter " + args[i]);
			}
		}
	}
}
