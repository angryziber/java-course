package net.azib.java.students.t011861.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * ProcessedData
 *
 * @author 011861
 * @param Input parameter for completeData: 1. List<String[]> It consists of data which comes from input 
 * modules (DataFromConsole, DataFromCsv and DataFromMySQL)! Input data has the same 
 * format and structure in every circumstances! It doesn't depend on input module! 
 * 2. List<Double[]> It consists of data which comes from module of CalculatePoints!
 * @return Only one public function "completeData" returns List<String[]> which consists of 
 * all original data, points and place label!
 */

public class ProcessedData {
	List<String[]> completeData = new ArrayList<String[]>();
	public List<String[]> getFinalData(List<String[]> athletes,List<Double[]> points) throws Exception
	{
		try
		{
		int rows = points.size(); //Find the sum of all rows (results and athletes are the same!)	
		List<? super Double> onlyPoints = null;
		onlyPoints = new ArrayList<Double>();
			
		List<? super Integer> pointOrder = null;
		pointOrder = new ArrayList<Integer>();
		
		List<? super Double> newOnlyPoints = null;
		newOnlyPoints = new ArrayList<Double>();
		
		List<? super String> placeLabel = null;
		placeLabel = new ArrayList<String>();
		    //Creates array (newPoints) which consists of only total points
			for (Double[] newPoints : points)
			{
				onlyPoints.add(newPoints[10]);
			}
			//If there are more than 1 athlete's data, then program start next cycle 
			if (rows != 1)
			{
		        //Creates sorted new arrays (pointOrder & newOnlypoints) to find final list of athletes results!
				Double helpPoint = -1.0; //
				int pointIndex = 0;
		
					for (int j = 0; j < rows; j++)
					{
						for (int i = 0; i < rows; i++)
						{
							if (i == 0)
								{
									helpPoint = Double.valueOf(onlyPoints.get(i).toString()); //First member of the points array
									pointIndex = i;
								}
							else 
								{ 
									Double newHelpPoint = Double.valueOf(onlyPoints.get(i).toString());
										if (helpPoint<newHelpPoint)
											{
												helpPoint = newHelpPoint;
												pointIndex = i;
											}
								}
			
						}
							//After inner  "for" cycle max value will be set in newOnlyPoints array 
							//and the same value in onlyPoint array will be set "-1.0".
							//pointIndex will be set in pointIndex array!
							pointOrder.add(pointIndex);
							onlyPoints.set(pointIndex, -1.0);
							newOnlyPoints.add(helpPoint);
					}
					//Create ordered place labels
					int startLabelCount = 0;
					int t = 0;
					while (t<rows-1)
					{
						String test1 = String.valueOf(newOnlyPoints.get(t).toString().trim());
						String test2 = String.valueOf(newOnlyPoints.get(t+1).toString().trim());
						if (!test1.equals(test2))
						{
							Integer tempLabel = t + 1;
							String place = String.valueOf(tempLabel);
							placeLabel.add(place);
							t++;
						}
						
						else
						{
							int abi = t;
							while ((test1.equals(test2)) && (abi < rows-2))
							{
							startLabelCount++;
							abi++;
							test1 = String.valueOf(newOnlyPoints.get(abi).toString().trim());
							test2 = String.valueOf(newOnlyPoints.get(abi+1).toString().trim());	
							}
							if ((test1.equals(String.valueOf(newOnlyPoints.get(rows-1).toString().trim()))) && (String.valueOf(newOnlyPoints.get(rows-2).toString().trim()).equals(String.valueOf(newOnlyPoints.get(rows-1).toString().trim()))))
							{
								startLabelCount++;
							}
							for (int u = t; u < t + startLabelCount+1 ;u++)
							{
								Integer tempStartLabel = t + 1;
								Integer tempStopLabel = t + startLabelCount + 1;
								String place = String.valueOf(tempStartLabel)+" - "+String.valueOf(tempStopLabel);
								placeLabel.add(place);
																
							}
							t = t + startLabelCount + 1;
							startLabelCount = 0;	
						}
					}
					String test1 = String.valueOf(newOnlyPoints.get(rows-1).toString().trim());
					String test2 = String.valueOf(newOnlyPoints.get(rows-2).toString().trim());
					if (!test1.equals(test2))
					{
						String place = String.valueOf(rows);
						placeLabel.add(place);
					}		
		}
		//If there is only one row of athletes data, then program doesn't need to create different help arrays and so on!
		//Then we know that place label will be "1", pointOrder index is 0!
		else 
		
		{
			placeLabel.add("1");
			pointOrder.add(0);
			for (Double[] newPoints : points)
			{
				newOnlyPoints.add(newPoints[10]);
			}
			
		}
			int orderNumber = 0;
			int orderIndex = 0;
			//Creates new ArrayList which consists of athletes data, points and places (join newOnlyPoints and athletes)! 
				List<? super String> athleteData = null;
				athleteData = new ArrayList<String>();
				//Creates new empty list!
				for (int f = 0; f < rows; f++) 
				{
					completeData.add((String[]) athleteData.toArray(new String[athleteData.size()]));
				}
				//Creates new row with complete information for every athletes and replaces it 
				//in right place in completeData array
				int helpIndex = 0;
				for (String[] newAthletes : athletes)
				{	
					for (int k = 0; k<13; k++) 
					{	
						athleteData.add(String.valueOf(newAthletes[k]));
					}
						for (int f = 0; f < rows; f++)
						{	
							orderNumber = Integer.valueOf(pointOrder.get(f).toString());
							if (orderNumber == helpIndex)
								{
									athleteData.add(String.valueOf(newOnlyPoints.get(f).toString()));
									if (rows == 1)
									{
										athleteData.add("Place: 1");	
									}
									else
									{
									athleteData.add("Place: "+placeLabel.get(f).toString());
									}
									orderIndex = f;
									
								}
						}
				completeData.set(orderIndex,(String[]) athleteData.toArray(new String[athleteData.size()]));
				athleteData.clear();
				helpIndex++;
				}
		}
		catch (Exception e)
		{
			System.out.println("There wasn't any input data!!");
			e.printStackTrace();
		}
		return completeData;
		}		
}
