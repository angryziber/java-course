package net.azib.java.students.t061932.homework;

/**
 * CsvInputReader
 *
 * @author t061932
 */
import java.util.*;
import java.io.*;


class CsvInputReader implements InputReader {

	private File csvFile;
	private BufferedReader fileReader;
	private ArrayList<Athlete> localContainer = new ArrayList<Athlete>();
	private String fileContent = new String("");
	private Integer cursorPositionFileContent = new Integer(-1);
	private Integer cursorPositionAthleteContent = new Integer(-1);
	
	/**
	 * This constructor creates an CsvInputReader that is
	 * going to read data from the file pointed by the fileName argument
	 * <p>
	 * @param 		fileName the path to the csv file
	 */
	public CsvInputReader(String fileName)
	{
		csvFile = new File(fileName);
		if(!csvFile.exists())
		{
			System.out.println("The fileName you have provided is invalid. The file does not exist. Exiting");
			System.exit(0);
		}
	}
	
	
	/**
	 * Calling this method leeds to all the data being read from the csv file and properly proccesed.
	 * After that new Athlete objects based on the information from the csv file are created 
	 * and stored in the local container.  
	 * <p>
	 */
	public void getData() {
		String row;
		String athleteCsvInfo;
		try 
		{
			fileReader= new BufferedReader(new FileReader(csvFile));
			while((row = fileReader.readLine()) != null)
			{
				fileContent += row;
			}
			
			while((athleteCsvInfo = getAthleteCsvInfo(fileContent)) != null ) 
			{
				Athlete current = getAthlete(athleteCsvInfo);
				localContainer.add(current); 
			}
		}
		catch(IOException e)
		{
			System.out.println("exception :" + e.getMessage());
		}

	}

	/**
	 * This method returns a copy of the local athletre container 
	 * which was filled by the getData() method. This method
	 * should only be called after  the getData() method was called.
	 * <p>
	 * @return      ArrayList object containing all Athlete objects stored 
	 * @see         getData()
	 */
	public ArrayList<Athlete> passData() 
	{
		if(!localContainer.isEmpty())
		{
			return (ArrayList<Athlete>)localContainer.clone();
			
		}
		else
		{
			System.out.println("No data to be passed");
			return null;
		}
	
	}
	
	private Athlete getAthlete(String athleteCsvInfo)
	{
		String athleteName = getAthleteName(athleteCsvInfo);
		int[] athleteBirthDate = getAthleteBirthDate(athleteCsvInfo); 
		String athleteCountry = getAthleteCountry(athleteCsvInfo); 
		double[] athleteResults = getAthleteResults(athleteCsvInfo);
		Athlete current = new Athlete(athleteName, athleteCountry, athleteBirthDate[2], athleteBirthDate[1], athleteBirthDate[0]);
		current.setResults(athleteResults);
		return current;
	}
	
	
	private String getAthleteName(String athleteCsvInfo)
	{
		   cursorPositionAthleteContent  = new Integer(-1);
		   int quoteIndex = athleteCsvInfo.indexOf("\"", cursorPositionAthleteContent  + 1);
		   cursorPositionAthleteContent  = new Integer(quoteIndex);
		   quoteIndex = athleteCsvInfo.indexOf("\"", cursorPositionAthleteContent  + 1);
		   return athleteCsvInfo.substring(cursorPositionAthleteContent  + 1, quoteIndex).trim();
	}
	
	private int[] getAthleteBirthDate(String athleteCsvInfo)
	{
	   int comaIndex = athleteCsvInfo.indexOf(",", cursorPositionAthleteContent  + 1);
	   cursorPositionAthleteContent  = new Integer(comaIndex);
	   comaIndex = athleteCsvInfo.indexOf(",", cursorPositionAthleteContent  + 1);
	   String birthDate = athleteCsvInfo.substring(cursorPositionAthleteContent  + 1, comaIndex).trim();
	   String[] birthDateStringValues = new String[3];
	   try
	   {
		   birthDateStringValues = birthDate.split("\\.");
	   }
	   catch(Exception e)
	   {
		   System.out.println("pattern exception: " + e.getMessage());
	   }
	   int[] birthDateIntegerValues = new int[3];
	   for(int i=0; i < 3; i++)
	   {
		   try
		   {
			   birthDateIntegerValues[i] = Integer.parseInt(birthDateStringValues[i]);
		   }
		   catch(Exception e)
		   {
			   System.out.println("exception " + e.getMessage());
		   }
	   }
	   return birthDateIntegerValues;
	}
	private String getAthleteCountry(String athleteCsvInfo)
	{
		int comaIndex = athleteCsvInfo.indexOf(",", cursorPositionAthleteContent  + 1);
		cursorPositionAthleteContent  = new Integer(comaIndex);
		comaIndex = athleteCsvInfo.indexOf(",", cursorPositionAthleteContent  + 1);
		String country = athleteCsvInfo.substring(cursorPositionAthleteContent  + 1, comaIndex).trim();
		return country;
	}
	private double[] getAthleteResults(String athleteCsvInfo)
	{
		double[] results = new double[10];
		for(int i=0; i<10; i++)
		{
			if(i == 9)
			{
				int comaIndex = athleteCsvInfo.indexOf(",", cursorPositionAthleteContent  + 1);
				cursorPositionAthleteContent  = new Integer(comaIndex);
				String result = athleteCsvInfo.substring(cursorPositionAthleteContent  + 1, athleteCsvInfo.length()).trim();
				String[] res = result.split(":");
				try
				{
					results[i] = (new Double(res[0]))*60 + (new Double(res[1]));
				}	
				catch(Exception e)
				{
					System.out.println("Invalid data found");
				}
				
			}
			else
			{
				int comaIndex = athleteCsvInfo.indexOf(",", cursorPositionAthleteContent  + 1);
				cursorPositionAthleteContent  = new Integer(comaIndex);
				comaIndex = athleteCsvInfo.indexOf(",", cursorPositionAthleteContent  + 1);
				String result = athleteCsvInfo.substring(cursorPositionAthleteContent  + 1, comaIndex).trim();
				if(result.indexOf(":") == -1)
				{			
					results[i] = Double.parseDouble(result);
				}
				else
				{
					String[] res = result.split(":");
					try
					{
						results[i] = (new Double(res[0]))*60 + (new Double(res[1]));
					}	
					catch(Exception e)
					{
						System.out.println("Invalid data found");
					}
				}
			}
		}
		return results;
	}

	private String getAthleteCsvInfo(String fileContent)
	{
		int beginingIndex = 0;
		int endIndex = 0;
		int quoteIndex = cursorPositionFileContent ;
		for(int i = 0; i <3; i++)
		{
			quoteIndex = fileContent.indexOf("\"", quoteIndex + 1);
			if(cursorPositionFileContent  == fileContent.length()) // in case we have read all the information about all athletes
			{
				return null;
			}
			
			if(quoteIndex == -1 && i == 2) // in case we reached the last Athlete in the file
			{
				cursorPositionFileContent  = new Integer(fileContent.length());
				return fileContent.substring(beginingIndex, fileContent.length());
			}
			
			if(i==0)
			{
				beginingIndex = quoteIndex;
			}
			else if(i==2)
			{
				endIndex = quoteIndex;
			}
			
		}
		cursorPositionFileContent  = new Integer(endIndex - 1);
		return fileContent.substring(beginingIndex, endIndex);
	}
	

}