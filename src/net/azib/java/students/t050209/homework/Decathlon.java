package net.azib.java.students.t050209.homework;

/**
 * Decathlon
 *
 * @author Kaupo Laan
 */
public class Decathlon {

	public static double handleUserInteraction() throws Exception{
		HandleDecathlonIO value = new HandleDecathlonIO();		
		double userValue = value.getUserInsertedValue();
		return userValue;
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
		
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
							
		switch(selectDataInputType()) {
		case 1:
			insertValuesManually();
			break;
		
		case 2:
			//insertDataPath
			break;
			
		case 3:
			//initiateServerConnection
			break;
			
		default:
			break;
		}
		//compute
		//storeValuesIntoArray
		//selectOutput
		//initSysAgain
	}

}
