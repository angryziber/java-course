package net.azib.java.students.t104887.Lecture3;

/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 21.02.11
 * Time: 23:32
 * To change this template use File | Settings | File Templates.
 */
public class Man extends Human
{
	public Man(String name)
	{
		this.name = name;
		System.out.println("Named: " + this.name);
	}

	public void sayHello()
	{
		System.out.println("Man "+name+" said: Hello World!");
	}
}
