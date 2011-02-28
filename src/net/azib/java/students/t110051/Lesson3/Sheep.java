package net.azib.java.students.t110051.Lesson3;

/**
 * Created by IntelliJ IDEA.
 * User: Priit
 * Date: 28.02.11
 * Time: 16:35
 * To change this template use File | Settings | File Templates.
 */
public class Sheep extends Animal{
	@Override
	String makeSound() {
		return "baa baa";  //To change body of implemented methods use File | Settings | File Templates.
	}
	public Sheep(){
		age = super.age;
		name = super.name;
		sex = super.sex;
	}
}
