package net.azib.java.students.t107678.hw2;

public abstract class Pet extends Animal {

    public String name;

    public String getName() {
        return name;
    }

    private boolean haveCollar = false;

    public boolean isHaveCollar() {
        return haveCollar;
    }

    public void setHaveCollar(boolean haveCollar) {
        this.haveCollar = haveCollar;
    }


}
