package net.azib.java.students.t104887.Lecture3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 21.02.11
 * Time: 23:04
 * To change this template use File | Settings | File Templates.
 */
public class World
{
	private String name;
	private List<Human> humans;
	private List<Animal> animals;

	public String getName()
	{
		return name;
	}

	public World(String name)
	{
		this.name = name;
		humans = new LinkedList();
		animals = new LinkedList();
		System.out.println("God created the World named "+ name);
	}

	public void addHuman(Human human)
	{
		humans.add(human);
	}

	public void addAnimal(Animal animal)
	{
		animals.add(animal);
	}

	public Human getHuman(String name)
	{
		Iterator it=humans.iterator();
		Human human;

		while (it.hasNext())
		{
			human = (Human)it.next();
			if (human.getName() == name)
				return human;
		}

		return null;
	}

	public Animal getAnimal(String name)
	{
		Iterator it=animals.iterator();
		Animal animal;

		while (it.hasNext())
		{
			animal = (Animal)it.next();
			if (animal.getName() == name)
				return animal;
		}

		return null;
	}

	public boolean kill (Object creature)
	{
		if (creature instanceof Animal)
		{
			return animals.remove(creature);
		}

		if (creature instanceof Human)
		{
			return humans.remove(creature);
		}

		return false;
	}
}
