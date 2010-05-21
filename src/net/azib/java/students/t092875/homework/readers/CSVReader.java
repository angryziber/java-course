package net.azib.java.students.t092875.homework.readers;

import net.azib.java.students.t092875.homework.athletes.Athlete;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * CSVReader
 *
 * @author Mihhail
 */
public class CSVReader implements DecathlonReader {

	String csvFile;
	/**
	 * 
	 * @param fileName - csv file where the data is located
	 */
	public CSVReader(String fileName){
		csvFile = fileName;
	}
	/**
	 * Read the file and output a list of athletes
	 * @output List of athletes
	 */
	@Override
	public List<Athlete> read() {
		List<Athlete> result = new ArrayList<Athlete>();
		LineNumberReader lnr = null; 
		try {
			File source = new File(csvFile);
			lnr = new LineNumberReader(new FileReader(source));
			String line;
			while((line = lnr.readLine()) != null){
				String[] data = line.split(",");
				String[] results = new String[10];
				for(int i=0; i<results.length; i++){
					results[i] = data[i+3];
				}
				Date date;
				DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
				date = (Date) df.parse(data[1]);
				result.add(new Athlete(data[0],date,data[2], results));
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			try {
				lnr.close();
			}
			catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	} 

}
