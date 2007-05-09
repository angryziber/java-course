package net.azib.java.students.t020632.homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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
		String s;
		
		try{
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
			
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
		//AthleteResults result;
		//String name;
		//String date;
		//String country;
		String [] values;
		
		values = s.split(",");
		
		for(String str : values){
			System.out.println(str);
		}
		
	}

}
