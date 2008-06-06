package net.azib.java.students.t061932.homework;

import java.util.*;
import java.io.*;

/**
 * ConsoleInputReader
 *
 * @author t061932
 */



class ConsoleInputReader implements InputReader {
	private ArrayList<Athlete> localContainer = new ArrayList<Athlete>();
	BufferedReader consoleReader;
	String inputData = new String();

	
	/**
	 * Calling this method leeds to all the data being gathered from console
	 * The method will endlessly prompt you to enter data about new athletes 
	 * untill you enter the 'stop' keyword. All the collected data will be stored in Athlete objects 
	 * being stored in a container.
	 * <p>
	 */
	public 	void getData() 
	{
		Athlete current;
		try
		{
			consoleReader = new BufferedReader(new InputStreamReader(System.in));
		}
		catch(Exception e)
		{
			System.out.println("I/O Exception:" + e.getMessage());
		}
		System.out.println("The application will now collect the data about the athlets. It will prompt you to enter information endlessly until you enter the 'stop' keyword");
		Integer athleteCount = new Integer(1);
		while(!inputData.equalsIgnoreCase("stop"))
		{
			System.out.println("Collecting data about athlete number " + athleteCount);
			if((current = getAthlete()) != null)
			{
				localContainer.add(current);
				System.out.println("Athlete number " + athleteCount + " was added to the competition");
				athleteCount++;
			}
		}
		System.out.println("The application has colected data about " + (new Integer(athleteCount -1)) + " athletes. Proceeding...");
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
	
	private Athlete getAthlete()
	{
		Athlete current = null;
		String athleteName = new String();
		String athleteCountry  = new String();
		int[] athleteBirthDate = new int[3];
		double[] athleteResults = new double[10];
		
		if(!(athleteName = getAthleteName()).equalsIgnoreCase("stop"))
		{
			if(!(athleteCountry = getAthleteCountry()).equalsIgnoreCase("stop"))
			{
				if((athleteBirthDate = getAthleteBirthDate()) != null )
				{
					if((athleteResults = getAthleteResults()) != null)
					{
						current = new Athlete(athleteName, athleteCountry, athleteBirthDate[2], athleteBirthDate[1], athleteBirthDate[0]);
						current.setResults(athleteResults);
						return current;
					}
				}
			}
		}
		return current;
	}
	
	
	private String getAthleteName()
	{
		   System.out.println("Please enter athletes name:");
		   try
		   {
			   inputData = consoleReader.readLine();
			   return (new String(inputData));
		   }
		   catch(IOException e)
		   {
			   System.out.println("Can't read from console");
			   return null;
		   }
		   
	}
	
	private int[] getAthleteBirthDate()
	{
		System.out.println("Please enter athletes birth date in format dd.mm.yyyy:");
		try
		{
			inputData = consoleReader.readLine();
			if(inputData.equalsIgnoreCase("stop"))
			{
				return null;
			}
			else
			{
				String[] birthDateStringValues = new String[3];
				try
				{
					birthDateStringValues = inputData.split("\\.");
				}
				catch(Exception e)
				{
					System.out.println("Error: Invalid date format, please re-enter information");
					return null;
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
						System.out.println("Error: Invalid date format, please re-enter information");
						return null;
					}
				}
				return birthDateIntegerValues;
			}
		}
		catch(Exception e)
		{
			return null;
		}

	}
	private String getAthleteCountry()
	{
		  System.out.println("Please enter athletes country:");
		   try
		   {
			   inputData = consoleReader.readLine();
			   return (new String(inputData));
		   }
		   catch(IOException e)
		   {
			   System.out.println("Error: Can't read from console");
			   return null;
		   }
	}
	private double[] getAthleteResults()
	{
		double[] results = new double[10];
		System.out.println("Enter athlete results sequentely, seperated by coma");
		try
		{
			inputData = consoleReader.readLine();
			if(inputData.equalsIgnoreCase("stop"))
			{
				return null;
			}
			else
			{
				Integer cursorPosition = new Integer(-1);
				for(int i=0; i<10; i++)
				{
					if(i == 9)
					{
						
						String result = inputData.substring(cursorPosition  + 1, inputData.length()).trim();
						String[] res = result.split(":");
						try
						{
							results[i] = (new Double(res[0]))*60 + (new Double(res[1]));
						}	
						catch(Exception e)
						{
							System.out.println("Error: Invalid data found, please re-enter");
							return null;
						}
					}
					else
					{
						int comaIndex = inputData.indexOf(",", cursorPosition  + 1);
						String result = inputData.substring(cursorPosition  + 1, comaIndex).trim();
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
								System.out.println("Error: Invalid data found, please re-enter");
								return null;
							}
						}
						cursorPosition  = new Integer(comaIndex);
					}
				}
				return results;
			}
		}	
		catch(Exception e)
		{
			System.out.println("Error: Can not read from console");
			return null;
		}
	}
}
