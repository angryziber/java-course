package net.azib.java.students.t092875.homework.writers;

import net.azib.java.students.t092875.homework.athletes.Athlete;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * CSVWriter
 *
 * @author Mihhail
 */
public class CSVWriter implements DecathlonWriter{
	String filename;
	public CSVWriter(String filename){
		this.filename = filename;
	}
	/**
	 * writes the results of the decathlon to a csv file
	 * @param athletes - List of athletes who participated in the competition
	 */
	@Override
	public void write(List<Athlete> athletes) {
		File distination = new File(filename);
		OutputStreamWriter writer = null;
		try {
			if(!distination.exists()){
				distination.createNewFile();
			}
			writer = new OutputStreamWriter(new FileOutputStream(distination), "UTF-8");
			for(Athlete athlete : athletes) {
				writer.write(athlete.getName());
				SimpleDateFormat format = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT);
				writer.write(","+format.format(athlete.getDateOfBirth()));
				writer.write(","+athlete.getOrigin());
				for(int i=0; i<10; i++){
					writer.write(","+athlete.getEventResult(i));
				}
				writer.write(","+athlete.getResult());
				writer.write(","+athlete.getPlace());
				writer.write('\n');
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				System.out.println("DONE!");
				writer.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
