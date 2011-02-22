package net.azib.java.students.t104887.Lecture3;

/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 21.02.11
 * Time: 23:09
 * To change this template use File | Settings | File Templates.
 */
abstract class Animal
{
	protected int age;
	protected String name;

	abstract void sayHello();

	public int getAge()
	{
		return age;
	}

	public String getName()
	{
		return name;
	}

	public void becomeOlder()
	{
		age++;
	}

	public Animal()
	{
		System.out.println("Animal created");
	}
}
