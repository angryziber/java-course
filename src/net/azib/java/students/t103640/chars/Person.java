package net.azib.java.students.t103640.chars;

public class Person {
    String name;
    String birthday;
    String email;
    int phoneNumber;

    public String getName(){
        return name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public String getBirthday(){
        return birthday;
    }

    public void setBirthday(String newBirthday){
        this.birthday = newBirthday;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String newEmail){
    this.email = newEmail;
    }

    public int getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(int newNumber){
      this.phoneNumber = newNumber;
    }
}
