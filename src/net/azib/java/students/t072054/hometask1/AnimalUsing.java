package net.azib.java.students.t072054.hometask1;

/**
 * AnimalUsing
 * 
 * @author Roman
 */
public class AnimalUsing {
	public static void main(String[] args) {
		Animal shavka[] = new Animal[4];

		shavka[0] = new Dog();
		shavka[0].SetName("Sharik");
		shavka[1] = new Dog();
		shavka[1].SetName("Zhuchka");
		shavka[2] = new Dog();
		shavka[2].SetName("Bobik");
		shavka[3] = new Dog();
		shavka[3].SetName("Tjafka");
		
		for (int i : new int[] {0,1,2,3})
		{
			System.out.println(shavka[i].getName());
		}
	}
}
