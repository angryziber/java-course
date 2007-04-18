package net.azib.java.students.t050209.homework;


import java.lang.*;
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
		System.out.println("-1 Insert values manually");
		System.out.println("-2 Insert values from file");
		System.out.println("-3 Get values from Database");
		
		result = (byte)handleUserInteraction();
		
		return result;
	}
	
	public static void insertValuesManually() throws Exception{
		HandleDecathlonIO result = new HandleDecathlonIO();
		System.out.println(result.manualInsertionSequence());
	}
	
	public static void fileSequence() {
		HandleDecathlonIO result = new HandleDecathlonIO();
		result.readFromFileSequence();
	}
		
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
							
		switch(selectDataInputType()) {
		case 1:
			insertValuesManually();
			break;
		
		case 2:
			fileSequence();
			break;
			
		case 3:
			//initiateServerConnection
			break;
			
		default:
			//ignore?
			break;
		}
		//compute
		//storeValuesIntoArray
		//selectOutput
		//initSysAgain
	}

}
