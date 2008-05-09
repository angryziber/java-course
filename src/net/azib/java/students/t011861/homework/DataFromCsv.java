package net.azib.java.students.t011861.homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * DataFromCsv
 *
 * @author 011861
 */
public class DataFromCsv {
	List<String[]> athletesData = new ArrayList<String[]>();
	public List<String[]> getData() {
		return athletesData;
	}
	public DataFromCsv(File input) throws Exception{
		BufferedReader reader = null;
		String member = "";

		try {
			List<? super String> athleteData = null;
			athleteData = new ArrayList<String>();
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(input), "UTF-8"));
			while ((member = reader.readLine()) != null) 
			{
				String [] result = member.split(",");
				int test = result.length;
				
				for (int j = 0; j < test; j++)
				{
					athleteData.add(result[j]);
					System.out.println(athleteData.get(j).toString());
				}
				athletesData.add((String[]) athleteData.toArray(new String[athleteData.size()]));
				athleteData.clear();
			}
			reader.close();
		} 
		catch (FileNotFoundException e) 
			{
				System.out.println("File " + input + " not found! \n" + e);
			} 
		catch (IOException e) 
				{
					System.out.println("Problem with reading from " + input + "file!\\n" + e);
				}
	}
}
