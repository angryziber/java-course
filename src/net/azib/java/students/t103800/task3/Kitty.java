package net.azib.java.students.t103800.task3;

/**
 * User: Jaan Aigro 103800
 * Date: 19.02.11
 * Time: 23:16
 */
public class Kitty extends Pet {

    private String nick;

    public Kitty() {
        super("Nameless", 0, "mr Greatheart");
        nick = "Nicknameless";
    }

    /**
     * Kitty cat.
     * @param name Name of the cat.
     * @param nickName Nick of the cat.
     * @param owner Owner of the cat.
     * @param ageInYears Age of the cat.
     */
    public Kitty(String name, String nickName, String owner, int ageInYears) {
        super(name, ageInYears, owner);
        nick = nickName;
    }

    public void setNickName(String newNickName) {
        nick = newNickName;
    }

    public String getNickName() {
        return nick;
    }

    public void makeSound() {
        System.out.println("Meow!");
    }

    public String toString() {
        return "[Type: Kitty(Animal, Pet)][Age: " + super.getAgeInYears() + " years]" +
                "[Name: " + super.getName() + "][Owner: " + super.getOwnerName() + "]" +
                "[Nick: " + nick + "]";
    }

}