package net.azib.java.students.t104887.Lecture3;

import java.util.jar.Manifest;

/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 21.02.11
 * Time: 23:03
 * To change this template use File | Settings | File Templates.
 */
public class main
{
	public static void main(String[] args)
	{
		World earth = new World("Earth");

		earth.addAnimal(new Dog("Snoopy"));
		earth.addAnimal(new Dog("Laika"));
		earth.addAnimal(new Cat("Murka"));
		earth.addAnimal(new Cow("Burenka"));
		earth.addAnimal(new Sheep("Fara"));
		earth.addAnimal(new Sheep("Justyne"));
		earth.addAnimal(new Sheep("Yasmeen"));
		earth.addAnimal(new Sheep("Carlene"));
		earth.addAnimal(new Sheep("Bernardyn"));
		earth.addAnimal(new Sheep("Sheena"));
		earth.addAnimal(new Wolf("Adolph"));

		earth.addHuman(new Man("Juri Bogdanov"));
		earth.addHuman(new Man("Anton Keks"));
		earth.addHuman(new Man("Vladimir Glushakov"));
		earth.addHuman(new Woman("Olga Blinova"));
		earth.addHuman(new Man("Oleg East"));

		earth.getAnimal("Snoopy").sayHello();
		earth.getAnimal("Murka").sayHello();
		earth.getAnimal("Burenka").sayHello();
		earth.getAnimal("Fara").sayHello();
		earth.getAnimal("Adolph").sayHello();

		earth.getHuman("Anton Keks").sayHello();
		earth.getHuman("Vladimir Glushakov").sayHello();
		earth.getHuman("Olga Blinova").sayHello();
		earth.getHuman("Oleg East").sayHello();

		earth.getHuman("Anton Keks").addAnimal(earth.getAnimal("Snoopy"));
		earth.getHuman("Anton Keks").addAnimal(earth.getAnimal("Laika"));
        earth.getHuman("Anton Keks").getAnimals();

		earth.getHuman("Vladimir Glushakov").addAnimal(earth.getAnimal("Adolph"));
		earth.getHuman("Vladimir Glushakov").getAnimals();

		earth.getHuman("Olga Blinova").addAnimal(earth.getAnimal("Murka"));
		earth.getHuman("Olga Blinova").addAnimal(earth.getAnimal("Burenka"));
        earth.getHuman("Olga Blinova").getAnimals();

		earth.getHuman("Oleg East").addAnimal(earth.getAnimal("Fara"));
		earth.getHuman("Oleg East").addAnimal(earth.getAnimal("Justyne"));
		earth.getHuman("Oleg East").addAnimal(earth.getAnimal("Yasmeen"));
		earth.getHuman("Oleg East").addAnimal(earth.getAnimal("Carlene"));
		earth.getHuman("Oleg East").addAnimal(earth.getAnimal("Bernardyn"));
		earth.getHuman("Oleg East").addAnimal(earth.getAnimal("Sheena"));
        earth.getHuman("Oleg East").getAnimals();

		((Wolf)earth.getAnimal("Adolph")).eat(earth.getAnimal("Fara"), earth, earth.getHuman("Oleg East"));
		((Wolf)earth.getAnimal("Adolph")).eat(earth.getAnimal("Justyne"), earth, earth.getHuman("Oleg East"));
		((Wolf)earth.getAnimal("Adolph")).eat(earth.getAnimal("Yasmeen"), earth, earth.getHuman("Oleg East"));
		((Wolf)earth.getAnimal("Adolph")).eat(earth.getAnimal("Carlene"), earth, earth.getHuman("Oleg East"));
		((Wolf)earth.getAnimal("Adolph")).eat(earth.getAnimal("Bernardyn"), earth, earth.getHuman("Oleg East"));

		 earth.getHuman("Oleg East").getAnimals();
	}
}
