package net.azib.java.students.t040750.homework.lesson2;

/**
 * Farm
 *
 * @author karpo
 */
public class Farm {
	public static void main(String[] args) throws CloneNotSupportedException{
		Animal[] animals = new Animal[3];
		
		animals[0] = new Dog("Pluto",Byte.valueOf("4"),"brown");
		animals[1] = new Cow("Maasi",Byte.valueOf("2"),"black-white");
		animals[2] = new Chicken("Chick",Byte.valueOf("1"),"white");
		
		for (Animal animal:animals) {	
			System.out.println(animal);
		}
		
		Dog d = (Dog)animals[0];
		
		/*
		 * Kui nii kirjutada, siis, kuigi kompilaator ei kobise,
		 * saame runtime errori, kuna animals[1] on hoopis Cow tüüpi.
		 * 
		 * 
				Dog d = (Dog)animals[1];
		*/
		System.out.println(d);
		
		System.out.println(animals[0].equals(animals[1]));
		
		System.out.println(animals[2].getClass());
		/*
		 * Kui try-catch blokk ära jätta, siis võib lahendada ka kasutades
		 * throws keywordi meetodi deklaratsioonis
		 * 
		try{
			Animal c = (Animal) animals[1].clone();
			System.out.println(c);
			System.out.println(c.equals(animals[1]));
		}
		
		**Mitu catch blokki tähendab seda, et erinevate exceptionite
		* puhul käitutakse erinevalt

		catch (CloneNotSupportedException e) {
			System.out.println("Can't clone...");
		}
		catch (NullPointerException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Please call customer support...");
		}
		finally {
			System.out.println("Finally");
		}
		
		**Pannes lõppu üldistava Exception catchi tagame selle, et kõik
		* meie poolt mitte-handle'itud exceptionid saavad ikkagi püütud
		*/
		
		Animal c = (Animal) animals[1].clone();
		System.out.println(c);
		System.out.println(c.equals(animals[1]));
	}

}
