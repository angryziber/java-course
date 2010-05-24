package net.azib.java.students.t092875.homework;

import net.azib.java.students.t092875.homework.readers.CSVReader;
import net.azib.java.students.t092875.homework.readers.ConsoleReader;
import net.azib.java.students.t092875.homework.readers.DatabaseReader;
import net.azib.java.students.t092875.homework.readers.DecathlonReader;
import net.azib.java.students.t092875.homework.writers.CSVWriter;
import net.azib.java.students.t092875.homework.writers.ConsoleWriter;
import net.azib.java.students.t092875.homework.writers.DecathlonWriter;
import net.azib.java.students.t092875.homework.writers.HTMLWriter;
import net.azib.java.students.t092875.homework.writers.XMLWriter;

import java.util.regex.Pattern;

/**
 * DecathlonController
 *
 * @author Mihhail
 */
public class DecathlonController {
	/**
	 * Returns a reader depending on the arguments passed.
	 * Readers:
	 * -Console reader (-console)
	 * -Database reader (-db [event_number])
	 * -CSV reader (-csv [file])
	 * 
	 * @param args the arguments passed with the start of the program
	 * @return a reader to be used to read the data about the athletes in the competition
	 */
	public DecathlonReader setReader(String[] args){
		if(args[0].equals("-csv") && Pattern.matches(".{1,}\\.csv$", args[1])){
			return new CSVReader(args[1]);
		}else if(args[0].equals("-db") && Pattern.matches("\\d{1,}", args[1])){
			return new DatabaseReader(new Integer(args[1]));
		}else if(args[0].equals("-console")){
			return new ConsoleReader();
		}else{
			return null;
		}
	}
	
	/**
	 * Returns a writer depending on the arguments passed
	 * Writers:
	 * -Console writer (-console)
	 * -CSV writer (-csv [file])
	 * -XML writer (-xml [file])
	 * -HTML writer (-html [file])
	 * 
	 * @param args the arguments passed with the start of the program
	 * @return a writer to be used to read the data about the athletes in the competition
	 */
	public DecathlonWriter setWriter(String[] args){
		int offset = args[0].equals("-console")?1:2;
		if(args.length==offset){
			return null;
		}
		if(args[offset].equals("-csv") && args.length==(offset+2) && Pattern.matches(".{1,}\\.csv$", args[offset+1])){
			return new CSVWriter(args[++offset]);
		}else if(args[offset].equals("-console")){
			return new ConsoleWriter();
		}else if(args[offset].equals("-xml") && args.length==(offset+2) && Pattern.matches(".{1,}\\.xml$", args[offset+1])){
			return new XMLWriter(args[++offset]);
		}else if(args[offset].equals("-html") && args.length==(offset+2) && Pattern.matches(".{1,}\\.html$", args[offset+1])){
			return new HTMLWriter(args[++offset]);
		}else{
			return null;
		}
	}
}
