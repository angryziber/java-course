package net.azib.java.students.t061932.homework;

import java.util.*;


abstract class OutputPrinter {
	
	protected ArrayList<Athlete> localContainer;
	public void getData(ArrayList<Athlete> athleteContainer) 
	{
		if(!athleteContainer.isEmpty())
		{
			localContainer = (ArrayList<Athlete>)athleteContainer.clone();
			sortAthlets(localContainer);
			
		}
		else
		{
			System.out.println("Error: Container is empty");
		}
	}
	
	private void sortAthlets(ArrayList<Athlete> athleteContainer)
	{
		int containerSize = athleteContainer.size();
		for(int i = 0; i < containerSize - 1 ; i++)
		{
			for(int j = i+1; j < athleteContainer.size(); j++ )
			{
				if(athleteContainer.get(i).getPoints() < athleteContainer.get(j).getPoints())
				{
					Collections.swap(athleteContainer, i, j);
				}
			}
		}
	}
	
	protected String buildTable()
	{
		String table=new String();
		for(int i = 0; i < localContainer.size(); i++)
		{
			String athleteData = new String((new Integer(i+1)) + "." +localContainer.get(i).getName() + "(" + localContainer.get(i).getBirthDate() + ", " + localContainer.get(i).getCountry() +") " );
			String resultData = new String("scored " + (new Double(localContainer.get(i).getPoints())).toString() + " points. His(her) results are: \n");
			double[] resultArray = localContainer.get(i).getResults();
			for(int j = 0; j < resultArray.length; j++)
			{
				resultData += (new Double(resultArray[j])).toString() + (new String(" "));
			}
			resultData += (new String("\n\n"));
			String row = new String(athleteData + resultData);
			table += row;
		}
		return table;
	}
}