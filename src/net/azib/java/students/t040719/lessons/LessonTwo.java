package net.azib.java.students.t040719.lessons;

/**
 * LessonTwo
 *
 * @author Romi
 */
public class LessonTwo {
	public static void main(String[] args) {
		Animal[] animals = new Animal[7];
		animals[0] = new Cow("Vissi","Holstein",(byte)2);		
		animals[1] = new Dog("Figaro","Cocker Spaniel",(byte)1);		
		animals[2] = new Cock("Rooster","White Leghorn",(byte)2);		
		animals[3] = new Cat("Cora","Persian",(byte)2);		
		animals[4] = new Cow("Pille","Jersey",(byte)4,25);		
		animals[5] = new Cat("Harissa","Ragdoll",(byte)5,4);		
		animals[6] = new Dog("Muki","Mutt",(byte)5,49);	

		int count = (int)(Math.random()*10);
		for (int i = 0; i<count; i++)
			animals[2].makeSound();
		
		for (Animal smth : animals){
			System.out.println(smth);
			smth.makeSound();
			System.out.println("");
		}
	}
}
