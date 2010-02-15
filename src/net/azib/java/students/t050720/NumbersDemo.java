package net.azib.java.students.t050720;

/**
 * NumbersDemo
 *
 * @author Marek
 */
public class NumbersDemo {
	private Fibonacci fib;
	private Factorial fact;
	
	private void stupidJava() throws Exception
	{
		fib=new Fibonacci();
		fact=new Factorial();
		
		//some colour-speak there :)
		System.out.print("Tha 100th Fib numbah iz...");
		System.out.print(fib.getNumber(100).toString());
		System.out.print("\nTha factorial of 100 is...");
		System.out.print(fact.retFact(100).toString());
	}
	
	public static void main(String[] args)
	{
		NumbersDemo d=new NumbersDemo();
		
		System.out.println("Hi! Me's gonna display You's some funny stuff!\n\nLike...the 100th fibonacci number and factorial of 100!!1!\n");
		try {
			//again, a fluffy work-around for some stupid java quirk
			d.stupidJava();
		}
		//i kinda added the exception just for fun. oh, well, let it be then...
		catch (Exception e) { 
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("");
		
	}

}
