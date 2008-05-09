package net.azib.java.students.t011861.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
/**
 * OutDataToCsv
 *
 * @author 011861
 */
public class OutDataToCsv {
	public void showInCsvFile(File output, List<String[]> completeData) {
		BufferedWriter writer = null;
		try 
		{
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), "UTF-8"));
			for (String[] athleteData : completeData) 
			{
				for (int i = 0; i < athleteData.length; i++) 
				{
					writer.write(athleteData[i]);
					if (athleteData.length - i > 1) 
					{ 
						writer.write(",");
					}
				}
				writer.write(System.getProperty("line.separator"));
			}	
		} catch (IOException e) 
		  {
				System.out.println("Can not find the file " + output.toString());
		  }finally 
		  	{
			  try 
			  {
				  writer.close();
			  } catch (IOException e) 
			  	{
				  System.out.println("Problem with closing " + output + " file");
			  	}
		  	}
	}
}