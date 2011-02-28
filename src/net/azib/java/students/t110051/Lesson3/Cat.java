package net.azib.java.students.t110051.Lesson3;

public class Cat extends Pet{
	   String catName = "Garfield";
	@Override
	String makeSound() {
		return "meow meow";  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	String name( String name) {
		return name;  //To change body of implemented methods use File | Settings | File Templates.
	}

	public Cat(){
		name = this.name("Garfield");
		age = 8;
		sex = super.sex;
	}


}
