package net.azib.java.students.t960644.homework;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Pattern;


/**
 * CSVInput
 *
 * @author Lembit
 */
public class CSVInput {
	private InputStreamReader reader;
	/**
	 * Create a Competition object
	 * @return
	 */
	public Competition readCompetition(){
		Competition competition = new Competition();
		return competition;
	}
	public void initReader(String filename) {
		reader = new InputStreamReader(CSVInput.class.getResourceAsStream(filename));
	}
	
	public void readResults(Competition competition){
		Scanner sc = new Scanner(reader).useDelimiter(",");
		//Pattern pExit = Pattern.compile("\\z");
		//Pattern pString = Pattern.compile("");
		while (/*!sc.hasNext(pExit)&*/sc.hasNext()) {
			System.out.println(sc.next());
		}
	}
	
	public static void main(String[] args) {
		CSVInput csv = new CSVInput();
		csv.initReader("dec.csv");
		csv.readResults(new Competition());
	}

}
