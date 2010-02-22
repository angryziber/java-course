package net.azib.java.students.t050720;

/**
 * AnimalsDemo
 *
 * @author Marek
 */
public class AnimalsDemo {

	/**
	 * @param args
	 */
	
	void doStuff()
	{

		Dog pooch=new Dog();
		Hamster skippy=new Hamster();
		Wolf howler=new Wolf();
		Animal animals[]= {pooch, skippy, howler};
		
		for(Animal ca:animals)
		{
			System.out.println(ca.toString());
			ca.makeSound();
		}
		
	}
	
	public static void main(String[] args) {
		AnimalsDemo d= new AnimalsDemo();
		
		d.doStuff();
	}

}
