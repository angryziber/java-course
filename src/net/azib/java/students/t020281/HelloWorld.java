package net.azib.java.students.t020281;


/**
 * HelloWorld
 *
 * @author t020281
 */
public class HelloWorld 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		System.out.println(Constants.GREETING_MESSAGE);
		System.out.println(Math.pow(2, 3));
		String s = "6";
		int i = 5;
		try{
			i = Integer.parseInt(s);
		}
		catch (NumberFormatException e){
			System.out.println("Exception!");
		}
		System.out.println(i);
		
		
		
	}
}
