package net.azib.java.students.t050209.homework;


import java.io.IOException;
/**
 * Decathlon
 *
 * @author Kaupo Laan
 */
public class Decathlon {

	public static double handleUserInteraction() throws Exception{
		HandleDecathlonIO value = new HandleDecathlonIO();		
		return value.getUserInsertedValue();
	}
	
	public static byte selectDataInputType() throws Exception{
		byte result;
		System.out.println("What do you want to do?");
		System.out.println("- 1 Insert values manually");
		System.out.println("- 2 Insert values from file");
		System.out.println("- 3 Get values from Database");
		
		result = (byte)handleUserInteraction();
		
		return result;
	}
	
	public static void insertValuesManually() throws Exception{
		HandleDecathlonIO sequence = new HandleDecathlonIO();
		sequence.nameInsertion();
		sequence.dateOfBirthInsertion();
		sequence.countryCodeInsertion();
		sequence.dataInsertion();
		//TODO - separate function for show result
	}
	
	public static void fileSequence() throws IOException {
		HandleDecathlonIO sequence = new HandleDecathlonIO();
		sequence.readFromFileSequence();
//		TODO - separate function for show result
	}
		
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub		
		
		switch(selectDataInputType()) {
		case 1:
			insertValuesManually();
			//TODO - output path
			break;
		
		case 2:
			fileSequence();
//			TODO - output path
			break;
			
		case 3:
			//initiateServerConnection
//			TODO - output path
			break;
			
		default:
			//ignore?
			break;
		}
		HandleDecathlonIO.showResultOnScreen();
		//compute
		//storeValuesIntoArray
		//selectOutput
		//initSysAgain
	}

}
