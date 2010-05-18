package net.azib.java.students.t092860.homework;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils; 

/**
 * OutputToCSV
 *
 * @author scythe
 */
class OutputToCSV implements Output {
	
	private static Logger logger = Logger.getLogger("global");
	
	OutputToCSV(File filepath)
	{
		file = filepath;
	}
	
	public void set(List<Data> dataList) throws Exception
	{
		List<String> csvDataList = new ArrayList<String>();
		
		Iterator<Data> it = dataList.iterator(); 					
		while(it.hasNext())
		{
			csvDataList.add(dataToString(it.next()));
		}

		FileUtils.writeLines(file, "UTF8", csvDataList);
		
		logger.info("Output to CSV file success");
	}
	
	private String dataToString(Data data)
	{
		String out = "";
		
		out += data.getPosition();
		out += "," + data.getScore();
		out += "," + Converter.athleteToString(data);
		
		return out;
	}
	
	private File file;
}
