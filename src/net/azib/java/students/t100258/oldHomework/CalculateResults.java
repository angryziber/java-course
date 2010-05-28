package net.azib.java.students.t100258.oldHomework;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Class for points calculation
 *
 * @author mihkel
 */
public class CalculateResults {

	/**
	 * Decathlon points calculation
	 *
	 * @param results Arraylist of Results
	 * @throws IOExeption
	 */
	
	public CalculateResults(ArrayList <Object> results) throws IOException{
		
		
		int tempsize = results.size();
		Integer i=tempsize-1;
		Result single_result;
		System.out.println ("Number of competitors: "+tempsize); //test
		while (i  != -1)   {
			
			single_result=((Result)results.get(i)); 
			Integer index = single_result.sprint_400.indexOf(":");
			Float sprint400;
			if(index != -1) {
				 sprint400 = 60* Float.valueOf(single_result.sprint_400.substring(0, index)).floatValue() + Float.valueOf(single_result.sprint_400.substring(index+1, single_result.sprint_400.length())).floatValue(); 
				 
			}
			else{
			sprint400 = Float.valueOf(single_result.sprint_400).floatValue(); 	
			}
			
			index = single_result.race.indexOf(":");
			Float race;
			if(index != -1) {
				 race = 60* Float.valueOf(single_result.race.substring(0, index)).floatValue() + Float.valueOf(single_result.race.substring(index+1, single_result.race.length())).floatValue(); 
				 
			}
			else{
			race = Float.valueOf(single_result.race).floatValue(); 	
			}
			
			Integer sum;
			sum=  (int)(25.4347* java.lang.Math.pow((double)18-single_result.sprint_100, 1.81)); 
			sum= sum+ (int)(0.14354* java.lang.Math.pow((double)single_result.long_jump-220, 1.4));
			sum= sum+ (int)(51.39* java.lang.Math.pow((double)single_result.short_put-1.5, 1.05));
			sum= sum+ (int)(0.8465* java.lang.Math.pow((double)single_result.high_jump-75, 1.42));
			sum= sum+ (int)(1.53775* java.lang.Math.pow((double)82- sprint400, 1.81)); 
			sum= sum+ (int)(5.74352* java.lang.Math.pow((double)28.5-single_result.hurdles, 1.92));
			sum= sum+ (int)(12.91* java.lang.Math.pow((double)single_result.discus_throw-4, 1.1));
			sum= sum+ (int)(0.2797* java.lang.Math.pow((double)single_result.pole_vault-100, 1.35));
			sum= sum+ (int)(10.14* java.lang.Math.pow((double)single_result.jevelin_throw-7, 1.08));
			sum= sum+ (int)(0.03768* java.lang.Math.pow((double)480- race, 1.85));
			single_result.sum=sum;
			//results.remove(i);
			//results.add(i,tulemus);
			i--;
		    }
		//assign them places
		int done=0;
		int place=1;
		int sameplace=0;
		int current=0;
		int last_done=100000;
		int pass=0;
		
		ArrayList <Object> resultsout;
		resultsout = new ArrayList <Object>();;//sorted, for output
		
		while (done==0){
			i=tempsize-1;
			if(pass==1){
				pass=2;
				}
			else{
				pass=1;
				}
			
			while (i  != -1)   {
				
				single_result=((Result)results.get(i));
				if (pass==1){
					//pass1
					if((single_result.sum > current) && (single_result.sum < last_done)){
						current=single_result.sum; 
						}
			
				}
				//pass2
				else{
					if(single_result.sum==last_done){
						single_result.place=place;
						sameplace=sameplace+1;
						resultsout.add(single_result);//arranged results
					}	
				}
				i--;
			}
			if(pass==1){
			last_done=current;
			}
			current=0;
			place=place+sameplace;
			sameplace=0;
			//all done
			if (place-1==tempsize){
				done=1;
			}
		}	
		
		
		
		
		
		//where to output
		if(Decathlon.out_method.equals("-console")){
		new OutConsole(resultsout);
		}
		else if(Decathlon.out_method.equals("-csv")){
		new OutCsv(resultsout);
		}
		else if(Decathlon.out_method.equals("-xml") ||Decathlon.out_method.equals("-html")){
		new OutXml(resultsout);
		}
		
	}	
}