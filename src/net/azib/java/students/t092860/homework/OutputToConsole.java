package net.azib.java.students.t092860.homework;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/**
 * OutputToConsole
 *
 * @author scythe
 */
class OutputToConsole implements Output {
	
	private static Logger logger = Logger.getLogger("global");
	
	OutputToConsole(OutputStream out)
	{
		output = out;
	}
	
	public void set(List<Data> dataList) throws Exception
	{
		Iterator<Data> it = dataList.iterator(); 
		while(it.hasNext()) 
		{	
			String line = dataToString(it.next()) + System.getProperty("line.separator");
			output.write(line.getBytes("UTF-8"));
		} 
		logger.info("Output to console success");
	}
	
	private String dataToString(Data data)
	{
		String out = "";
		
		out += data.getPosition();
		out += "," + data.getScore();
		out += "," + Converter.athleteToString(data);
		
		return out;
	}
	
	private OutputStream output;
}
