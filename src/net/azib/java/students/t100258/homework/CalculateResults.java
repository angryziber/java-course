package net.azib.java.students.t100258.homework;

import java.util.ArrayList;

/**
 * CalculateResults
 *
 * @author mihkel
 */
public class CalculateResults implements CalculationsInterface {

	/**
	 * Decathlon points calculation
	 *
	 * @param results Arraylist of Results
	 * @throws IOExeption
	 * @return Sorted Arraylist of Results with total points and places
	 */
	public ArrayList<Object> getCalculatedResults(ArrayList<Object> results) {
		int tempsize = results.size();
		Integer i=tempsize-1;
		Result singleResult;
		System.out.println ("Number of competitors: "+tempsize); //test
		while (i  != -1)   {
			
			singleResult=((Result)results.get(i)); 
			Integer index = singleResult.sprint_400.indexOf(":");
			Float sprint400;
			if(index != -1) {
				 sprint400 = 60* Float.valueOf(singleResult.sprint_400.substring(0, index)).floatValue() + Float.valueOf(singleResult.sprint_400.substring(index+1, singleResult.sprint_400.length())).floatValue(); 
				 
			}
			else{
			sprint400 = Float.valueOf(singleResult.sprint_400).floatValue(); 	
			}
			
			index = singleResult.race.indexOf(":");
			Float race;
			if(index != -1) {
				 race = 60* Float.valueOf(singleResult.race.substring(0, index)).floatValue() + Float.valueOf(singleResult.race.substring(index+1, singleResult.race.length())).floatValue(); 
				 
			}
			else{
			race = Float.valueOf(singleResult.race).floatValue(); 	
			}
			
			Integer sum;
			sum=  (int)(25.4347* java.lang.Math.pow((double)18-singleResult.sprint_100, 1.81)); 
			sum= sum+ (int)(0.14354* java.lang.Math.pow((double)singleResult.long_jump-220, 1.4));
			sum= sum+ (int)(51.39* java.lang.Math.pow((double)singleResult.short_put-1.5, 1.05));
			sum= sum+ (int)(0.8465* java.lang.Math.pow((double)singleResult.high_jump-75, 1.42));
			sum= sum+ (int)(1.53775* java.lang.Math.pow((double)82- sprint400, 1.81)); 
			sum= sum+ (int)(5.74352* java.lang.Math.pow((double)28.5-singleResult.hurdles, 1.92));
			sum= sum+ (int)(12.91* java.lang.Math.pow((double)singleResult.discus_throw-4, 1.1));
			sum= sum+ (int)(0.2797* java.lang.Math.pow((double)singleResult.pole_vault-100, 1.35));
			sum= sum+ (int)(10.14* java.lang.Math.pow((double)singleResult.jevelin_throw-7, 1.08));
			sum= sum+ (int)(0.03768* java.lang.Math.pow((double)480- race, 1.85));
			singleResult.sum=sum;
			//results.remove(i);
			//results.add(i,tulemus);
			i--;
		    }
		//assign them places
		int done=0;
		int place=1;
		int samePlace=0;
		int current=0;
		int lastDone=100000;
		int pass=0;
		
		ArrayList <Object> resultsOut;
		resultsOut = new ArrayList <Object>();;//sorted, for output
		
		while (done==0){
			i=tempsize-1;
			if(pass==1){
				pass=2;
				}
			else{
				pass=1;
				}
			
			while (i  != -1)   {
				
				singleResult=((Result)results.get(i));
				if (pass==1){
					//pass1
					if((singleResult.sum > current) && (singleResult.sum < lastDone)){
						current=singleResult.sum; 
						}
			
				}
				//pass2
				else{
					if(singleResult.sum==lastDone){
						singleResult.place=place;
						samePlace=samePlace+1;
						resultsOut.add(singleResult);//arranged results
					}	
				}
				i--;
			}
			if(pass==1){
			lastDone=current;
			}
			current=0;
			place=place+samePlace;
			samePlace=0;
			//all done
			if (place-1==tempsize){
				done=1;
			}
		}	
		
		
		
		
		
		return resultsOut;
	}

}
