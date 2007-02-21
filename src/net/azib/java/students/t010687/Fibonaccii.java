package net.azib.java.students.t010687;

import java.math.BigInteger;

/**
 * Fibonaccii
 *
 * @author t010687
 */
public class Fibonaccii {
	
	public static void numbersToHundred(){
		BigInteger FiboNr[] = new BigInteger[103];

		
		FiboNr[0] = BigInteger.ZERO;
		FiboNr[1] = BigInteger.ONE;
		
		for (int i=0; i<100;i++){
			FiboNr[i+2]= FiboNr[i].add(FiboNr[i+1]);
			//System.out.println("Numb" +FiboNr[i].toString() );                             
		}
		
		//new style 
		for (BigInteger i:FiboNr){
			System.out.println("Numb" + i.toString());
		}
		
	}

}
