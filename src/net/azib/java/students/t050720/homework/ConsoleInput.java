package net.azib.java.students.t050720.homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * ConsoleInput
 *
 * @author Marek
 */
public class ConsoleInput implements Input {

	BufferedReader rd;
	
	@Override
	public void readInto(ArrayList<Record> records) throws Exception {
		
		rd=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter data");
		String tmp;
		Float tmpF;
		while(true)
		{
			tmp=getString("Enter contestant name:");
			Record rec=new Record();
			rec.setAthlete(tmp);
			
			tmp=getString("Enter date of birth (day.month.year):");
			SimpleDateFormat df=new SimpleDateFormat("dd.MM.yyyy");
			try {
			df.parse(tmp);
			} catch(ParseException e) {
				tmp="01.01.1900";
			}
			rec.setBirthDate(tmp);
			
			tmp=getString("Enter nationality (2-letter code):");
			rec.setCountry(tmp);
			
			tmp=getString("Enter result of 100m (seconds):");
			try {
				tmpF=Float.valueOf(tmp);
			} catch(NumberFormatException e) {
				tmpF=(float) 0;
			}
			rec.setRace_100m(tmpF);
			
			tmp=getString("Enter result of long jump (meters):");
			try {
				tmpF=Float.valueOf(tmp);
			} catch(NumberFormatException e ) {
				tmpF=(float) 0;
			}
			rec.setLong_jump(tmpF);
			
			tmp=getString("Enter result of shot put (meters):");
			try {
				tmpF=Float.valueOf(tmp);
			} catch(NumberFormatException e) {
				tmpF=(float) 0;
			}
			rec.setShot_put(tmpF);
			
			tmp=getString("Enter result of high jump (meters):");
			try {
				tmpF=Float.valueOf(tmp);
			} catch (NumberFormatException e) {
				tmpF=(float) 0;
			}
			rec.setHigh_jump(tmpF);
			
			tmp=getString("Enter result of 400m (minutes:seconds):");
			if(tmp.contains(":"))
			{
				String[] r400=tmp.split(":");
				try {
					if(r400[0].contentEquals("0")) rec.setRace_400m(Float.valueOf(r400[0]));
					else rec.setRace_400m((float) (Float.valueOf(r400[0])*60.0 + Float.valueOf(r400[1])));
				} catch(NumberFormatException e) {
					rec.setRace_400m((float)0);
				}
			}
			else {
				try{
					rec.setRace_400m((float) Float.valueOf(tmp));
				} catch(NumberFormatException e) {
					rec.setRace_400m((float)0);
				}
			}	
			
			tmp=getString("Enter result of 110m hurdles (seconds):");
			try {
				tmpF=Float.valueOf(tmp);
			} catch (NumberFormatException e) {
				tmpF=(float) 0;
			}
			rec.setHurdles_110m(tmpF);
			
			tmp=getString("Enter result of discus (meters):");
			try {
				tmpF=Float.valueOf(tmp);
			} catch(NumberFormatException e) {
				tmpF=(float) 0;
			}
			rec.setDiscus_throw(tmpF);
			
			tmp=getString("Enter result of pole vault (meters):");
			try {
				tmpF=Float.valueOf(tmp);
			} catch (NumberFormatException e) {
				tmpF=(float) 0;
			}
			rec.setPole_vault(tmpF);
			
			tmp=getString("Enter result of javelin (meters):");
			try {
				tmpF=Float.valueOf(tmp);
			} catch (NumberFormatException e) {
				tmpF=(float) 0;
			}
			rec.setJavelin_throw(tmpF);
			
			tmp=getString("Enter result of 1500m (minutes:seconds)");
			if(tmp.contains(":"))
			{
				String[] r1500=tmp.split(":");
				try {
				rec.setRace_1500m((float) (Float.valueOf(r1500[0])*60.0 + Float.valueOf(r1500[1])));
				}catch (NumberFormatException e) {
					rec.setRace_1500m((float) 0);
				}
			}
			else rec.setRace_1500m((float)0);
			
			records.add(rec);
			
			tmp=getString("Enter more data? (y/n)");
			if(!tmp.toUpperCase().contentEquals("Y"))
			{
				break;
			}
		}
	}
	
	private String getString(String message) throws Exception
	{
		System.out.print(message);
		return rd.readLine();
	}

}
