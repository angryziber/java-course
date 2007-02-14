package net.azib.java.students.t960644;

/**
 * LoopTst
 *
 * @author t960644
 */
public class LoopTst {
	/**
	 * 
	 * @param cnt numbreid milleni välja trükib
	 */
	public static void displayNum(int cnt){
		int i1=1;
		do{
			System.out.println(i1);
			i1++;
		}while(i1<=cnt);
			
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		displayNum(10);
	}

}
