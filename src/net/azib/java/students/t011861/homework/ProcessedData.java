package net.azib.java.students.t011861.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * ProcessedData
 *
 * @author 011861
 */

public class ProcessedData {
	List<String[]> completeData = new ArrayList<String[]>();
	public List<String[]> getFinalData(List<String[]> athletes,List<Double[]> points) throws Exception
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
					/**	
					int startLabelCount = 0;
					int t = 0;
					while (t<rows-1)
					{
						Integer vitt = Integer.
						Integer test1 = Integer.valueOf(newOnlyPoints.get(t).toString().trim());
						Integer test2 = Integer.valueOf(newOnlyPoints.get(t+1).toString().trim());
						if (test1 > test2)
						{
							System.out.println("test1: "+test1+" "+"test2: "+test2);
							//System.out.println(newOnlyPoints.get(t)+" "+newOnlyPoints.get(t+1));
							Integer tempLabel = t + 1;
							String place = String.valueOf(tempLabel);
							placeLabel.add(place);
							//System.out.println(place+" esimene");
							
						}
						
						else
						{	
							String kaks = "teine";
							System.out.println(kaks);
							/**
							int abi = t;
							while ((newOnlyPoints.get(abi) != newOnlyPoints.get(abi+1)) || (abi == rows-1))
							{
							startLabelCount++;
							abi++;
							System.out.println("teine");
							}
							t=abi;
							**/
							/**
							for (int u = t; u >= u + startLabelCount ;u++)
							{
								Integer tempStartLabel = u + 1;
								Integer tempStopLabel = u + startLabelCount;
								String place = String.valueOf(tempStartLabel)+" - "+String.valueOf(tempStopLabel);
								System.out.println(place);
								placeLabel.add(place);								
							}
							t = t + startLabelCount;
							startLabelCount = 0;
							
							//System.out.println(tempLabel);
							//System.out.println(tempLabel);
									
						}
						t++;
					}
					for (int z=0; z<rows; z++)
					{
						System.out.println(newOnlyPoints.get(z));
						//System.out.println(placeLabel.get(z));
					}
					
					**/
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
				//in right place in printData array
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
									//athleteData.add("Place: "+placeLabel.get(f).toString());
									athleteData.add("Place: ");
									orderIndex = f;
									//int place = orderIndex+1;
									
								}
						}
				completeData.set(orderIndex,(String[]) athleteData.toArray(new String[athleteData.size()]));
				athleteData.clear();
				helpIndex++;
				}
	return completeData;
	}
}
