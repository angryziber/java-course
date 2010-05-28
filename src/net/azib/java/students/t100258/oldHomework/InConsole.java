package net.azib.java.students.t100258.oldHomework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Console input class
 *
 * @author mihkel
 */
public class InConsole {
	/**
	 * Input from console
	 *
	 * 
	 */
	public InConsole() throws IOException {
		ArrayList <Object> results;
		results= new ArrayList <Object>();
		Scanner in = new Scanner(System.in);
		
String veel ="Y";
		while (veel.equals("Y"))
		{
			System.out.println ("Insert Name");
			String tempname = in.nextLine();
			System.out.println ("Insert date of birth in form: dd.mm.yyyy");
			String tempbirth =  in.nextLine();
			System.out.println ("Insert two letter ISO country code");
			String tempcountry = in.nextLine();
			System.out.println ("Insert result for 100m sprint");
			Float tempsprint_100 = Float.parseFloat( in.nextLine());
			System.out.println ("Insert result for Long jump");
			Float templong_jump = Float.parseFloat(in.nextLine());
			System.out.println ("Insert result for Short put");
			Float tempshort_put = Float.parseFloat(in.nextLine());
			System.out.println ("Insert result for High jump");
			Float temphigh_jump = Float.parseFloat(in.nextLine());
			System.out.println ("Insert result for 400m sprint");
			String tempsprint_400 = in.nextLine();
			System.out.println ("Insert result for 100m hurdles");
			Float temphurdles = Float.parseFloat(in.nextLine());
			System.out.println ("Insert result for Discus throw");
			Float tempdiscus_throw = Float.parseFloat(in.nextLine());
			System.out.println ("Insert result for Pole vault");
			Float temppole_vault = Float.parseFloat(in.nextLine());
			System.out.println ("Insert result for Jevelin throw");
			Float tempjevelin_throw = Float.parseFloat(in.nextLine());
			System.out.println ("Insert result for 1500m race");
			String temprace = in.nextLine();
			Integer tempsum = null;
			Result result1= new Result(tempname ,tempbirth ,tempcountry ,tempsprint_100 ,templong_jump ,tempshort_put ,temphigh_jump ,tempsprint_400 ,temphurdles ,tempdiscus_throw ,temppole_vault ,tempjevelin_throw ,temprace, tempsum, tempsum);
			results.add(result1);
			System.out.println ("Insert Y to inset more competitors, anything else to end inserting");
			veel = in.nextLine();

		}

		in.close();
		//System.out.println (((Result)results.get(0)).race); //test
		new CalculateResults(results);
		
		

	}

}
