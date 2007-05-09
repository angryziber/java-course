package net.azib.java.students.t020632.homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

/**
 * CSVInput
 *
 * @author Marek Soobik t020632
 */
public class CSVInput implements Input {

	private String path;
	
	public CSVInput(String path){
		this.path = path;
	}
	
	
	@Override
	public List<AthleteResults> read() {
		File file = new File(path);
		String s;
		
		try{
			FileReader stream = new FileReader(file);
			BufferedReader in = new BufferedReader(stream);
			
			while((s = in.readLine()) != null){
				parseLine(s);
			}
		}
		catch(Exception e){
			System.out.println("File not found!\n Make sure you have entered correct path");
		}
		
		return null;
	}
	
	public void parseLine(String s){
		AthleteResults result;
		String name;
		String date;
		String country;
		String [] values;
		
		values = s.split(",");
		
		for(String str : values){
			System.out.println(str);
		}
		
	}

}
