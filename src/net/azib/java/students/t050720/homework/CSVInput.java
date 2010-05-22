package net.azib.java.students.t050720.homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * CSVInput
 *
 * @author Marek
 */
public class CSVInput implements Input {
	
	File f;

	public CSVInput(String fileName) throws FileNotFoundException
	{
			f = new File(fileName);
			if(!f.exists()) throw new FileNotFoundException();
	}

	@Override
	public void readInto(ArrayList<Record> records) throws IOException {
		FileReader freader=new FileReader(f);
		
		BufferedReader reader=new BufferedReader(freader);
		String tmp;
		tmp=reader.readLine();
		Integer suspect=new Integer(tmp.charAt(0));
		if(suspect.intValue()==0xFEFF) tmp=tmp.substring(1); //strip BOM if present
		while (tmp != null)
		{
			String[] items=tmp.split(",");
			
			Record record=new Record();
			record.setAthlete(items[0].replace("\"", ""));
			record.setBirthDate(items[1]);
			record.setCountry(items[2]);
			try {
				record.setRace_100m(new Float(items[3]));
			}catch(NumberFormatException e) {
				record.setRace_100m((float)0);
			}
			try {
				record.setLong_jump(new Float(items[4]));
			}catch(NumberFormatException e) {
				record.setLong_jump((float)0);
			}
			try {
				record.setShot_put(new Float(items[5]));
			}catch(NumberFormatException e) {
				record.setShot_put((float)0);
			}
			try {
				record.setHigh_jump(new Float(items[6]));
			}catch(NumberFormatException e) {
				record.setHigh_jump((float)0);
			}

			String[] race400=items[7].split(":",2);
			List<String> r400list=Arrays.asList(race400);
			try {
				if(r400list.size()==1) record.setRace_400m(new Float(r400list.get(0)));
				else record.setRace_400m( (float) ((new Float(race400[0]) * 60.0) + new Float(race400[1])) );
			}catch(NumberFormatException e) {
				record.setRace_400m((float)0);
			}
			try {
				record.setHurdles_110m(new Float(items[8]));
			}catch(NumberFormatException e) {
				record.setHurdles_110m((float)0);
			}
			try {
				record.setDiscus_throw(new Float(items[9]));
			}catch(NumberFormatException e) {
				record.setDiscus_throw((float)0);
			}
			try {
				record.setPole_vault(new Float(items[10]));
			}catch(NumberFormatException e) {
				record.setPole_vault((float)0);
			}
			try {
				record.setJavelin_throw(new Float(items[11]));
			}catch(NumberFormatException e) {
				record.setJavelin_throw((float)0);
			}
			String[] race1500=items[12].split(":",2);
			try {
				record.setRace_1500m((float) ((new Float(race1500[0]) * 60.0) + new Float(race1500[1])) );
			}catch(Exception e) {
				record.setRace_1500m((float)0);
			}
			records.add(record);
			
			tmp=reader.readLine();
		}
		
		reader.close();
		freader.close();
	}
}
