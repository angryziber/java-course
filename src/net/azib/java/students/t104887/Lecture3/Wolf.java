package net.azib.java.students.t104887.Lecture3;

/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 22.02.11
 * Time: 1:18
 * To change this template use File | Settings | File Templates.
 */
public class Wolf extends Animal
{
	public Wolf(String name)
	{
		this.name=name;
		System.out.println("Named: " + this.name);
	}

	public void sayHello()
	{
		System.out.println("Wolf "+name+" said: Woooooo!");
	}

	public void eat(Animal animal, World world, Human owner)
	{
		world.kill(animal);
		owner.animals.remove(animal);
		System.out.println("Wolf "+name+" ate "+animal.getName());
	}
}
