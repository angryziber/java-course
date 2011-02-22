package net.azib.java.students.t104887.Lecture3;

/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 21.02.11
 * Time: 23:16
 * To change this template use File | Settings | File Templates.
 */
public class Dog extends Pet
{
	public Dog(String name)
	{
		this.name=name;
		System.out.println("Named: " + this.name);
	}

	public void sayHello()
	{
		System.out.println("Dog "+name+" said: Wow-wow!");
	}
}
