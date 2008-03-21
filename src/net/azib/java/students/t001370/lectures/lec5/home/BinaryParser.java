package net.azib.java.students.t001370.lectures.lec5.home;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * BinaryParser
 *
 * @author maksim
 */
public class BinaryParser {
	public final String WELCOME_MSG = "Welcome! Enter binary ('x' for exit)";
	public final String EXIT_MSG = "Exit! You have pressed 'x' for exit!";
	public final String ERROR_MSG = "Error! Entered pattern does not match :: ";
	
	private final PrintStream output;
	private final Scanner input;
	
	BinaryParser(){
		this.output = System.out;
		this.input 	= new Scanner(System.in);
	}
	BinaryParser(PrintStream out, Scanner in){
		this.output	= out;
		this.input 	= in;
	}
	
	public void parseBinary(){
		output.println(WELCOME_MSG);
		do{
			if (input.hasNext("[0-1]+")) {
				try{
					int number = binToDec(input.next());
					output.println("Binary in Dec: " + number + " and in Hex: 0x" + Integer.toHexString(number).toUpperCase());
				}
				catch (Exception e){
					output.println("Entered numer is to big! " + e.getMessage());
				}
			}
			else if (input.hasNext("x")) {
				output.println(EXIT_MSG);
				break;
			}
			else
				output.println(ERROR_MSG + input.next());
		}while (true);
	}
	
	public int binToDec(String binStr){
		return Integer.parseInt(binStr, 2);
	}

	public static BigInteger binToInt(String bin){
		BigInteger i = new BigInteger(bin, 2);
		return i;
	}
	

	public static void main(String[] args) {
		new BinaryParser().parseBinary();
		
		//System.out.println(BinaryParser.binToInt("1111").toString());
	}

}
