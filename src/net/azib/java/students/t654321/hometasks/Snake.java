package net.azib.java.students.t654321.hometasks;

/**
 * Snake
 *
 * @author karl
 */
public class Snake extends Animal{
	
//	private String venom;
	
	/**
	 * @param name
	 * @param color
	 * @param age
	 */
	public Snake(String name, String color, int age) {
		super(name, color, age);
		// TODO Auto-generated constructor stub
	}

	@Override
	void fly() {
		// TODO Auto-generated method stub
		System.out.println("Sorry, no can do");
	}

	@Override
	void jump() {
		// TODO Auto-generated method stub
		System.out.println("Sorr,y no can do");
	}

	@Override
	void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("Ssssssssss...");
	}
	
	void crawl(){
		System.out.println("Crawling to my nest");
	}
	
	public String toString(){
		return "I'm a snake. My name is " + getName() + " and age is  " + getAge() + " years. I'm " + getColor();
	}
}
