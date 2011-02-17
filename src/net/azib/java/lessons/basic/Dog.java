package net.azib.java.lessons.basic;

/**
 * This class represents any <b>dog</b> in the world.
 * See the {@link HelloWorld#main(String[])}
 *
 * @author Anton
 * @since version 123
 * @version 21213
 * @see StaticDemo
 */
public class Dog extends Animal {
    String name;

	/**
	 * Creates a dog with a name
	 * @param name specifies the new name
	 */
	public Dog(String name) {
		this.name = name;
	}

	public Dog rename(String newName) {
		return new Dog(newName);
	}

	public String toString() {
        return "Dog named " + name;
    }
}
