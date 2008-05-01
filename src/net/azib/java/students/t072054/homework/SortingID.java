package net.azib.java.students.t072054.homework;

import java.sql.SQLException;

/**
 * SortingID
 * 
 * @author r_vassiljev
 */
public class SortingID {
	
	//public static /*int[]*/ void SortByID(){
	public static void main(String[] args){
		int[] return_value = new int[10000];
		double[] buf = new double[14];
		
		LoadNewResults lnr = new LoadNewResults();
		
		lnr.LoadResults();
		try{
			
			int count = 1; // counter
			double max_num; // maximal value of result
			
			// Start to count decathlon points
			for (int i = 4; i < 14; i++) {
				//System.out.println(lnr.rs3.getDouble(i));
				buf[i] = lnr.rs3.getDouble(i);
			}
			double result = CountAthletResult.CountResult(buf[4], buf[5], buf[6], 
					buf[7], buf[8], buf[9], buf[10], buf[11], buf[12], buf[13]);
			// END of decathlon count //
			max_num = result;
			
			double max_index = 1; // index of maximal number

			while(lnr.rs3.next())
			{
				// Start to count decathlon points
				for (int i = 4; i < 14; i++) {
					//System.out.println(lnr.rs3.getDouble(i));
					buf[i] = lnr.rs3.getDouble(i);
				}
				result = CountAthletResult.CountResult(buf[4], buf[5], buf[6], 
						buf[7], buf[8], buf[9], buf[10], buf[11], buf[12], buf[13]);
				// END of decathlon count //
				
				System.out.println("result = " + result);
				
				// New max value if result > max_num
				if (result > max_num){
					max_num = result;
					max_index = count;
				}
				
				count++;
			}
			
			System.out.println("max_num = " + max_num);
			System.out.println("max_index = " + max_index);
		}
		catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		
		lnr.ConnClose();
	}
}
