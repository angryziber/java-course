package net.azib.java.students.t092875.homework;

import net.azib.java.students.t092875.homework.athletes.Athlete;
import net.azib.java.students.t092875.homework.processors.AthleteProcessor;
import net.azib.java.students.t092875.homework.readers.DecathlonReader;
import net.azib.java.students.t092875.homework.writers.DecathlonWriter;
import java.util.List;

/**
 * HomeWork
 *
 * @author Mihhail
 */
public class Decathlon {
	public static void main(String[] args) throws Exception {
		if(args.length>1 && args.length<5){
			new Decathlon().run(args);
		}else if(args[0].equals("-help")){
			System.out.println("Useage:");
			System.out.println("Decathlon -<input-method> [input-parameters] -<output-method> [output-parameters]");
			System.out.println("input methods:");
			System.out.println("console: -console, does not take parameters");
			System.out.println("csv: -csv csv_file_name");
			System.out.println("database: -db competition_number");
			System.out.println("output methods:");
			System.out.println("console: -console, does not take parameters");
			System.out.println("csv: -csv csv_file_name");
			System.out.println("xml: -xml xml_file_name");
			System.out.println("html: -html html_file_name");
		}else{
			System.out.println("Useage:");
			System.out.println("Decathlon -<input-method> [input-parameters] -<output-method> [output-parameters]");
		}
	}
	
	public void run(String[] args){
		DecathlonReader reader;
		DecathlonWriter writer;
		DecathlonController controller = new DecathlonController();
		reader = controller.setReader(args);
		writer = controller.setWriter(args);
		List<Athlete> athletes = null; 
		try{
			athletes = reader.read();
			new AthleteProcessor().process(athletes);
			writer.write(athletes);
			System.out.println("DONE!");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
