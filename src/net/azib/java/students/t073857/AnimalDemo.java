package net.azib.java.students.t073857;

import java.io.IOException;
import java.util.ArrayList;

/**
 * AnimalDemo
 *
 * @author Joonas Vali
 */
public class AnimalDemo {
	public static void main(String[] args) throws IOException {
		
		String fileSeparator = System.getProperty("file.separator");		
		
		String path1 = "./src/net/azib/java/students/t073857/elven.txt";
		String path2 = "./src/net/azib/java/students/t073857/roman.txt";
		
		path1 = path1.replace("/", fileSeparator);
		path2 = path2.replace("/", fileSeparator);		
		
		NameGenerator elven = new NameGenerator(path1);
		NameGenerator roman = new NameGenerator(path2);
		
		ArrayList<Animal> animals = new ArrayList<Animal>();
		
		animals.add( new Dog(elven.compose(3), 10, 3, 10, Gender.FEMALE) );		
		animals.add( new Cat(roman.compose(2), 10, 3, 10, Gender.MALE) );
		animals.add( new Chicken(elven.compose(2), 3, 1, 4, Gender.MALE) );
		animals.add( new Wolf( 30, 5, 10, Gender.MALE) );
		animals.add( new Dog(elven.compose(3), 10, 3, 10, Gender.MALE) );		
		animals.add( new Cat(roman.compose(2), 10, 3, 10, Gender.FEMALE) );
		animals.add( new Chicken(elven.compose(2), 3, 1, 4, Gender.MALE) );
		animals.add( new Dog(roman.compose(3), 10, 3, 10, Gender.MALE) );		
		animals.add( new Cat(elven.compose(2), 10, 3, 10, Gender.FEMALE) );
		animals.add( new Wolf( 30, 5, 10, Gender.FEMALE) );
		animals.add( new Chicken(elven.compose(2), 3, 1, 4, Gender.FEMALE) );
		animals.add( new Dog(elven.compose(3), 10, 3, 10, Gender.FEMALE) );		
		animals.add( new Cat(elven.compose(2), 10, 3, 10, Gender.FEMALE) );
		animals.add( new Chicken(roman.compose(2), 3, 1, 4, Gender.FEMALE) );
		animals.add( new Dog(roman.compose(3), 10, 3, 10, Gender.MALE) );
		animals.add( new Wolf( 30, 5, 10, Gender.FEMALE) );
		animals.add( new Cat(elven.compose(2), 10, 3, 10, Gender.MALE) );
		animals.add( new Chicken(elven.compose(2), 3, 1, 4, Gender.MALE) );
		
		for(Animal a: animals){
			a.description();
			a.makeSound();
			a.move();			
			if(a instanceof Pet){				
				Pet b = (Pet)a;
				System.out.println("You figured out, that "+b.getName()+" is a Pet, so you can stroke it.");
				b.stroke();				
				if(a instanceof Chicken){
					Chicken c = (Chicken)b;
					System.out.println("You realized, that "+c.getName()+" is a bird, so you'd better squeeze it for an egg!");
					c.layEgg();
				}
			}
			else if(a instanceof WildAnimal){
				WildAnimal w = (WildAnimal)a;
				System.out.println("You discovered, that "+w.toString()+" is a WildAnimal. You'd better run!");
				w.runFromIt();
			}
			System.out.println();
		}
		
		
	}
}
