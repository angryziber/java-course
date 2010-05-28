package net.azib.java.students.t100258.oldHomework;


import java.io.IOException;
import java.sql.SQLException;





/**
 *
 * @author mihkel
 */
public class Decathlon {
	static String out_method;
	static String out_arg;
	/**
	 * Chooses input method based on console arguments. Stores output arguments and method
	 * @param args -(input-method) [input-parameters] -(output-method) [output-parameters]

	 * @throws IOException  
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws IOException, SQLException  {
		
		if(args[0].equals("-csv")){
		System.out.println("Input from csv");
		
		out_method=args[2];
		if(!(args[2].equals("-console"))){
			out_arg=args[3];
			}
		new InCSV(args[1]);}
		
		else if(args[0].equals("-console")){
			System.out.println("Input from console");
			out_method=args[1];
			if(!(args[1].equals("-console"))){
			out_arg=args[2];
			}
			new InConsole();
		}
		else if(args[0].equals("-db")){
			System.out.println("Input from DB");
			out_method=args[2];
			if(!(args[2].equals("-console"))){
				out_arg=args[3];
				}
			new InMySQL(args[1]);
		}
		else{
			System.out.println("Invalid input");
		}
		
	}

}
