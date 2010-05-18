package net.azib.java.students.t092860.homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Calculator
 *
 * @author scythe
 */
class Calculator implements Comparator<Output.Data> {

	private static Logger logger = Logger.getLogger("global");
	
    public List<Output.Data> calcResults(List<Input.Data> inputSet)
	{
    	List<Output.Data> outputList = new ArrayList<Output.Data>();

		Iterator<Input.Data> inputIt = inputSet.iterator(); 
		while(inputIt.hasNext()) 
		{
			Output.Data output = new Output.Data(inputIt.next());
			int score = 0;
			
			Collection<Events> events = output.getEvents();
			Iterator<Events> setIt = events.iterator();
			while(setIt.hasNext()) 
			{
				Events event = setIt.next();
				Values val = formulaValues.get(event);
				double P = output.getEventResult(event);

				switch(event)
				{
					//JUMPS
					case LONG_JUMP:      
					case HIGH_JUMP:
					case POLE_VAULT: 
						//INT(A*(P-B)**C) - P = Distance in centimeters
						score += val.A * Math.pow(P*100 - val.B, val.C);
						break;
						
					//THROWS
					case SHOT_PUT: 
					case DISCUS_THROW:  
					case JAVELIN_THROW:
						//INT(A*(P-B)**C) - P = Distance in meters
						score += val.A * Math.pow(P - val.B, val.C);
						break;
					
					//TRACK
					case RACE_100M:
					case RACE_400M:  
					case HURDLES_110M:     	
					case RACE_1500M:
						//INT(A*(B-P)**C) - P = Time in seconds
						score += val.A * Math.pow(val.B - P, val.C);
						break;
				}
			}
			
			output.setScore(score);
			outputList.add(output);
		} 
		logger.info("athletes scores calculated");
		
		//calculate position
		Collections.sort(outputList, this);
		logger.info("athletes sorted by score");
		
		for (int i = 0; i < outputList.size(); i++)
		{
			int count = i;
			while((++count != outputList.size()) && 
				  (outputList.get(i).getScore() == outputList.get(count).getScore()));
			
			for (int j = i; j < count; j++)
			{
				String pos;
				pos = String.valueOf(i+1);
				if (i+1 != count)
					pos +=  "-" +  String.valueOf(count);
				
				outputList.get(j).setPosition(pos);
			}
			i=count-1;
		}
		logger.info("athletes positioned by score");
		
		return outputList;
	}
	
	public static class Values
	{
		Values(double a, double b, double c){ 
			A = a;
			B = b;
			C = c;
		}
		public double A;
		public double B;
		public double C;
	}
	
	private static final Map<Events, Values> formulaValues =  
	    Collections.unmodifiableMap(new HashMap<Events, Values>() {{  
	        put(Events.RACE_100M,     new Values( 25.4347 ,18   ,1.81 )); 
	        put(Events.LONG_JUMP,     new Values( 0.14354 ,220  ,1.4  ));
	        put(Events.SHOT_PUT,      new Values( 51.39   ,1.5  ,1.05 ));
	        put(Events.HIGH_JUMP,     new Values( 0.8465  ,75   ,1.42 ));
	        put(Events.RACE_400M,     new Values( 1.53775 ,82   ,1.81 ));
	        put(Events.HURDLES_110M,  new Values( 5.74352 ,28.5 ,1.92 ));
	        put(Events.DISCUS_THROW,  new Values( 12.91   ,4    ,1.1  ));
	        put(Events.POLE_VAULT,    new Values( 0.2797  ,100  ,1.35 ));
	        put(Events.JAVELIN_THROW, new Values( 10.14   ,7    ,1.08 ));
	        put(Events.RACE_1500M,    new Values( 0.03768 ,480  ,1.85 ));
	    }});

	public int compare(Output.Data d1, Output.Data d2)
	{
		if(d1.getScore() < d2.getScore())
			return 1;
		else if(d1.getScore() > d2.getScore())
			return -1;
		else
			return 0;
	}
}
