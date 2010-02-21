package net.azib.java.students.t092859.hometask3;

/**
 * AnimalDemo
 *
 * @author Konstantin
 */
public class AnimalDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal[] zoo = new Animal[5];
		zoo[0] = new Dog (2, true, "Sharik", "Shepherd");
		zoo[1] = new Cat (3, true, "Barsik");
		zoo[2] = new Sheep (5, true);
		zoo[3] = new Cow (1, false);
		zoo[4] = new Dog (6, false, "Barbos", "Bloodhound");
		for(Animal a : zoo){
			System.out.println(a);
		}
	}
}
