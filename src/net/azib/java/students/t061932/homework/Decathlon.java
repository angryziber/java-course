package net.azib.java.students.t061932.homework;
import java.util.*;

/**
 * Decathlon
 *
 * @author t061932
 */
public class Decathlon {

	private static ArrayList<Athlete>  athleteContainer= new ArrayList<Athlete>();
	private static ConsoleInputReader consoleReader; 
	private static CsvInputReader csvReader; 
	private static ConsoleOutputPrinter consolePrinter;
	private static CsvOutputPrinter csvPrinter;
	
	public static void main(String[] args) {
		if(args.length < 2)
		{
			System.out.println("Error: not enough arguments provided");
		}
		else
		{
			for(int i = 0; i < args.length;)
			{
			
				if(args[i].equalsIgnoreCase("-csv") && i == 0)
				{
					if(args[i+1] != null)
					{
						csvReader = new CsvInputReader(args[1]);
						csvReader.getData();
						athleteContainer = csvReader.passData();
						i+=2;
					}
					else
					{
						System.out.println("Error: No file path provided");
						break;
					}
				}
				if(args[i].equalsIgnoreCase("-console") && i == 0)
				{
					consoleReader = new ConsoleInputReader();
					consoleReader.getData();
					if(consoleReader.passData() == null)
					{
						System.out.println("Error: can not pass data to athlete container");
						System.exit(0);
					}
					else
					{
						athleteContainer = consoleReader.passData();
						i++;
					}

				}
				if(args[i].equalsIgnoreCase("-csv") && i > 0)
				{
					if(args[i+1] != null)
					{
						csvPrinter = new CsvOutputPrinter(args[i+1]);
						csvPrinter.getData(athleteContainer);
						csvPrinter.print();
						break;
					}
					else
					{
						System.out.println("Error: No file path provided");
						break;
					}
				}
				if(args[i].equalsIgnoreCase("-console") && i > 0)
				{
					consolePrinter = new ConsoleOutputPrinter();
					consolePrinter.getData(athleteContainer);
					consolePrinter.print();
					break;

				}
				if( !args[i].equalsIgnoreCase("-console") && !args[i].equalsIgnoreCase("-csv"))
				{
					System.out.println("Error: " + args[i] + "is not a valid argument");
				}
			}
		}
	}
	
}
