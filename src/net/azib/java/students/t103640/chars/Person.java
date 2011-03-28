package net.azib.java.students.t103640.chars;

import java.util.Date;

public class Person {
    String name;
    Date birthday;
    String email;
    int phoneNumber;

    public String getName(){
        return name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public Date getBirthday(){
        return birthday;
    }

    public void setBirthday(Date newBirthday){
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
