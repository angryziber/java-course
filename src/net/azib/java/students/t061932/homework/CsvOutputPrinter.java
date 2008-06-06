package net.azib.java.students.t061932.homework;

import java.io.*;



class CsvOutputPrinter extends OutputPrinter
{
	private String destinationFile;
	
	public CsvOutputPrinter(String destinationFile)
	{
		this.destinationFile = destinationFile;
	}

	public void print() 
	{
		PrintWriter csvFileWriter;
		String beginingMessage = new String("You are now viewing the results of the competiion: \n");
		String table = buildCsvTable();
		try
		{
			csvFileWriter = new PrintWriter(new FileWriter(destinationFile), true);
			csvFileWriter.println(beginingMessage + table);
			csvFileWriter.close();
			
		}
		catch (IOException e)
		{
            System.err.println(e.getMessage());
        }
			 
	}
	private String buildCsvTable()
	{
		String table=new String();
		for(int i = 0; i < localContainer.size(); i++)
		{
			String athleteData = new String((new Integer(i+1)) + "," + localContainer.get(i).getPoints()+ ",\"" +localContainer.get(i).getName() + "\"," + localContainer.get(i).getBirthDate() + ", " + localContainer.get(i).getCountry());
			double[] resultArray = localContainer.get(i).getResults();
			String resultData = new String();
			for(int j = 0; j < resultArray.length; j++)
			{
				resultData += (new String(",")) + (new Double(resultArray[j])).toString();
			}
			resultData += (new String("\n"));
			String row = new String(athleteData + resultData);
			table += row;
		}
		return table;
	}
			
		
}
