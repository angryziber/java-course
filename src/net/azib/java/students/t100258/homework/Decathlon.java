package net.azib.java.students.t100258.homework;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Decathlon
 *
 * @author mihkel
 */
public class Decathlon {


	//Real 43 on exit k2sk, mis hoolitseb selle eest, et programm ei j6uaks reani 50 kui outMethod on v22rtustamata.
	//Oleks hea, kui SupressWarnings ei peaks kasutama(ulej22nud vead v6ivad m2rkamata j22da), kuid hetkel ma ei tea, kuidas koodi teistmoodi kirjutada.  
	public static void main(String[] args) throws IOException, SQLException{
		String outMethod=null;
		Integer outParamNr=null;
		ArrayList <Object> results;
		results= new ArrayList <Object>();
		if(args[0].equals("-csv")){
			System.out.println("Input from csv");
			outMethod=args[2];
			outParamNr=3;
			InCSV inputCSVObject = new InCSV();
			results=inputCSVObject.getResults(args[1]);}
		
		else if(args[0].equals("-console")){
			System.out.println("Input from console");
			outMethod=args[1];
			outParamNr=2;
			InConsole inputConsoleObject = new InConsole();
			results=inputConsoleObject.getResults();}
		
		else if(args[0].equals("-db")){
			System.out.println("Input from DB");
			outMethod=args[2];
			outParamNr=3;
			InMySQL inputMySQLObject = new InMySQL();
			results=inputMySQLObject.getResults(args[1]);}
		else{
			System.out.println("Invalid input");
			System.exit(0);
			
		}
		CalculateResults calculateObject = new CalculateResults();
		results=calculateObject.getCalculatedResults(results);
			
		
		if(outMethod.equals("-csv")){
			OutCSV outputCSVObject = new OutCSV();
			outputCSVObject.outputResults(results, args[outParamNr]);}
		else if(outMethod.equals("-console")){
			OutConsole outputConsoleObject = new OutConsole();
			outputConsoleObject.outputResults(results);}
		else if(outMethod.equals("-xml")){
			OutXML outputXMLObject = new OutXML();
			outputXMLObject.outputResults(results, args[outParamNr]);}
		else if(outMethod.equals("-html")){
			OutHTML outputHTMLObject = new OutHTML();
			outputHTMLObject.outputResults(results, args[outParamNr]);}
		else{
			System.out.println("Invalid output");
			System.exit(0);
			}
	}
	
}
