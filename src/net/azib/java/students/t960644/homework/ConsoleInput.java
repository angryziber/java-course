package net.azib.java.students.t960644.homework;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * ConsoleInput
 * 
 * @author Lembit
 */
public class ConsoleInput {
	
	public void readResults(Readable in, PrintStream out, Competition competition) {
		boolean notFinished = true;
		//PrintStream printOut = new PrintStream(out);
		while (notFinished) {
			Athlete athlete = new Athlete();
			Result result = new Result();
			notFinished = readAthlete(in, out, athlete);
			if (notFinished) {
				notFinished = readResult(in, out, result);
			}
			if (notFinished) {
				result.setAthlete(athlete);
				competition.addAthlete(athlete);
				competition.addResult(result);
				out.println("Added "+athlete.getName()+". Score = "+Integer.toString(result.calcResult()));
			}
		}
	}

	protected boolean readAthlete(Readable in, PrintStream out, Athlete athlete) {
		try {
			String tempVal;
			tempVal = readValue(in, out, "Enter athlete's name: ");
			if (tempVal.equals("")) {return false;}
			athlete.setName(tempVal);
			athlete.setBirthDate(readValue(in, out, "Enter athlete's date of birth: "));
			tempVal = readValue(in, out, "Enter athlete's country code: ");
			if (tempVal.equals("")) {return false;}
			athlete.setCountryCode(tempVal);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}

	protected boolean readResult(Readable in, PrintStream out, Result result) {
		try {
			result.setRace100(readValue(in, out, "Enter race 100m result: "));
			result.setLongJump(readValue(in, out, "Enter long jump result: "));
			result.setShotPut(readValue(in, out, "Enter shot put result: "));
			result.setHighJump(readValue(in, out, "Enter high jump result: "));
			result.setRace400(readValue(in, out, "Enter race 400m result: "));
			result.setHurdles110(readValue(in, out, "Enter hurdles 110m result: "));
			result.setDiscusThrow(readValue(in, out, "Enter discus throw result: "));
			result.setPoleVault(readValue(in, out, "Enter pole vault result: "));
			result.setJavelinThrow(readValue(in, out, "Enter javelin throw result: "));
			result.setRace1500(readValue(in, out, "Enter race 1500m result: "));
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}

	/*public String readValue(InputStream in, OutputStream out, String msg) {
		PrintStream printOut = new PrintStream(out);
		printOut.println(msg);
		Pattern pLF = Pattern.compile("$", Pattern.MULTILINE);
		Scanner sc = new Scanner(in).useDelimiter(pLF);
		return sc.next().replaceAll("\\n", "").replaceAll("\\r", "");
	}*/

	public String readValue(Readable in, PrintStream out, String msg) {
		//PrintStream printOut = new PrintStream(out);
		out.println(msg);
		Pattern pLF = Pattern.compile("$", Pattern.MULTILINE);
		Scanner sc = new Scanner(in).useDelimiter(pLF);
		return sc.next().replaceAll("\\n", "").replaceAll("\\r", "");
	}
	
	
	public Integer readOption(Readable in, PrintStream out, List<String> options, String msg) {
		//PrintStream printOut = new PrintStream(out);
		for (int i=0;i<options.size();i++){
			out.println(i+": "+options.get(i));
		}
		String retStringValue; 
		Integer retValue = null;
		boolean isCorrect = false;
		while(!isCorrect){
			retStringValue = readValue(in,out,msg);
			try {
				retValue = Integer.parseInt(retStringValue);
				isCorrect = retValue>=0&&retValue<options.size();
				if(!isCorrect) {
					System.out.println("Out of range! Valid values are 0.."+(options.size()-1));
				}
			} catch (NumberFormatException e) {
				out.println("Faulty value!");
				return null;
			}
		}
		return retValue;
	}
}
