package net.azib.java.students.t104887.Lecture3;

/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 22.02.11
 * Time: 0:58
 * To change this template use File | Settings | File Templates.
 */
public class Cow extends Animal
{
	public Cow(String name)
	{
		this.name=name;
		System.out.println("Named: " + this.name);
	}

	public void sayHello()
	{
		System.out.println("Cow "+name+" said: Mooo!");
	}
}
