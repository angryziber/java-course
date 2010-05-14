package net.azib.java.students.t100258.Homework;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;


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
		Result tulemus;
		System.out.println ("Number of competitors: "+tempsize); //test
		while (i  != -1)   {
			
			tulemus=((Result)results.get(i)); 
			Integer index = tulemus.sprint_400.indexOf(":");
			Float sprint400;
			if(index != -1) {
				 sprint400 = 60* Float.valueOf(tulemus.sprint_400.substring(0, index)).floatValue() + Float.valueOf(tulemus.sprint_400.substring(index+1, tulemus.sprint_400.length())).floatValue(); 
				 
			}
			else{
			sprint400 = Float.valueOf(tulemus.sprint_400).floatValue(); 	
			}
			
			index = tulemus.race.indexOf(":");
			Float race;
			if(index != -1) {
				 race = 60* Float.valueOf(tulemus.race.substring(0, index)).floatValue() + Float.valueOf(tulemus.race.substring(index+1, tulemus.race.length())).floatValue(); 
				 
			}
			else{
			race = Float.valueOf(tulemus.race).floatValue(); 	
			}
			
			
			Integer sum;
			sum=  (int)(25.4347* java.lang.Math.pow((double)18-tulemus.sprint_100, 1.81)); 
			sum= sum+ (int)(0.14354* java.lang.Math.pow((double)tulemus.long_jump-220, 1.4));
			sum= sum+ (int)(51.39* java.lang.Math.pow((double)tulemus.short_put-1.5, 1.05));
			sum= sum+ (int)(0.8465* java.lang.Math.pow((double)tulemus.high_jump-75, 1.42));
			sum= sum+ (int)(1.53775* java.lang.Math.pow((double)82- sprint400, 1.81)); 
			sum= sum+ (int)(5.74352* java.lang.Math.pow((double)28.5-tulemus.hurdles, 1.92));
			sum= sum+ (int)(12.91* java.lang.Math.pow((double)tulemus.discus_throw-4, 1.1));
			sum= sum+ (int)(0.2797* java.lang.Math.pow((double)tulemus.pole_vault-100, 1.35));
			sum= sum+ (int)(10.14* java.lang.Math.pow((double)tulemus.jevelin_throw-7, 1.08));
			sum= sum+ (int)(0.03768* java.lang.Math.pow((double)480- race, 1.85));
			tulemus.sum=sum;
			//results.remove(i);
			//results.add(i,tulemus);
			i--;
		    }
		if(Decathlon.out_method.equals("-console")){
		new OutConsole(results);
		}
		else if(Decathlon.out_method.equals("-csv")){
		new OutCsv(results);
		}
		else if(Decathlon.out_method.equals("-xml") ||Decathlon.out_method.equals("-html")){
		new OutXml(results);
		}
		
	}
	
	
	public class CalculateResultsTest {
//		 this is a simple test case
		@Test 
		public void testResults() throws IOException {
			ArrayList <Object> results = new ArrayList <Object>();
			Result result= new Result("Nimi" ,"0000-00-00" ,"EE" ,new Float(14.15) ,new Float(3.98) ,new Float(10.0) ,new Float(1.45) ,"70.12" ,new Float(18.65) ,new Float(29.15) ,new Float(2.15) ,new Float(32.67) ,"466.6", 0);
			results.add(result);
			CalculateResults c = new CalculateResults(results);
		//assertEquals("Calculated result wrong!", new Double(2165),new Double(((Result)c.results.get(0)).sum));
		}
	}
}


