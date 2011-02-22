package net.azib.java.students.t104887.Lecture3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 21.02.11
 * Time: 23:32
 * To change this template use File | Settings | File Templates.
 */
abstract class Human
{
	private int age;
	protected String name;
	protected List animals;

	abstract void sayHello();

	public int getAge()
	{
		return age;
	}

	public String getName()
	{
		return this.name;
	}

	public Human()
	{
		animals = new LinkedList();
		System.out.println("Human is born!");
	}

	public void addAnimal(Animal animal)
	{
		animals.add(animal);
		System.out.println("Human "+name+" got new animal named "+animal.getName());
	}

	public void getAnimals()
	{
		Iterator it=animals.iterator();
		String animalList = new String();

		while (it.hasNext())
		{
			animalList+=((Animal)it.next()).getName() +", ";
		}
		System.out.println("human "+name+" has next animals: "+animalList);
	}

}
