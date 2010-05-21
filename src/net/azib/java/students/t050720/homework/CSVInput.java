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
		// TODO Auto-generated method stub
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
			record.setRace_100m(new Float(items[3]));
			record.setLong_jump(new Float(items[4]));
			record.setShot_put(new Float(items[5]));
			record.setHigh_jump(new Float(items[6]));
			
			String[] race400=items[7].split(":",2);
			List<String> r400list=Arrays.asList(race400);
			if(r400list.size()==1) record.setRace_400m(new Float(r400list.get(0)));
			else record.setRace_400m( (float) ((new Float(race400[0]) * 60.0) + new Float(race400[1])) );
			record.setHurdles_110m(new Float(items[8]));
			record.setDiscus_throw(new Float(items[9]));
			record.setPole_vault(new Float(items[10]));
			record.setJavelin_throw(new Float(items[11]));
			
			String[] race1500=items[12].split(":",2);
			record.setRace_1500m((float) ((new Float(race1500[0]) * 60.0) + new Float(race1500[1])) );
			records.add(record);
			
			tmp=reader.readLine();
		}
		
		reader.close();
		freader.close();
	}
}
