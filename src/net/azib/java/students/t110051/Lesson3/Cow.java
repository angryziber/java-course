package net.azib.java.students.t110051.Lesson3;

public class Cow extends Animal{
	@Override
	String makeSound() {
		return "Moo moo";  //To change body of implemented methods use File | Settings | File Templates.
	}
	public Cow (){
		age = 3;
		sex = 'f';
		name = "Maasik";
	}
}
