package net.azib.java.students.t103640.homework;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class ConsoleReader {

   private CoustomUtilities validator = new CoustomUtilities();

    public ArrayList<Athlete> getConsoleData(){
        ArrayList<Athlete> athletes = new ArrayList<Athlete>();
        Scanner input = new Scanner(System.in);

        boolean insertAnother = true;

        while(insertAnother){
            Athlete athlete = new Athlete();

            System.out.println("Please insert the name of the athlete!");
            athlete.setName(input.nextLine().trim());

            System.out.println("Please enter the birthday of " + athlete.getName() + "!");
            athlete.setBirthday(addDate(input));

            System.out.println("Please enter the origin country of " + athlete.getName() + "!");
            athlete.setCountry(addCountry(input));

            System.out.println("Please enter " + athlete.getName() + "`s 100m sprint result!");
            athlete.setHundredMSprint(setStringToDouble(input));

            System.out.println("Please enter " + athlete.getName() + "`s long jump result!");
            athlete.setLongJump(setStringToDouble(input));

            System.out.println("Please enter " + athlete.getName() + "`s shot put result!");
            athlete.setShotPut(setStringToDouble(input));

            System.out.println("Please enter " + athlete.getName() + "`s 400m sprint result");
            athlete.setFourHundredMSprint(setStringToDoubleInMinutes(input));

            System.out.println("Please enter " + athlete.getName() + "`s high jump result!");
            athlete.setHighJump(setStringToDouble(input));

            System.out.println("Please enter " + athlete.getName() + "`s 110m hurdles result!");
            athlete.setHundredAndTenHurdles(setStringToDouble(input));

            System.out.println("Please enter " + athlete.getName() + "`s discus throw result!");
            athlete.setDiscusThrow(setStringToDouble(input));

            System.out.println("Please enter "+ athlete.getName() + "`s pole vault result!");
            athlete.setPoleVault(setStringToDouble(input));

            System.out.println("Please enter "+ athlete.getName() + "`s javelin throw result!");
            athlete.setJavelinThrow(setStringToDouble(input));

            System.out.println("Please enter "+athlete.getName()+ "`s 1500m race result!");
            athlete.setKilometerAndHalfRace(setStringToDoubleInMinutes(input));

            athletes.add(athlete);
            athlete = null;

            System.out.println("Would you like to enter another athlete? (y/n?)");
            insertAnother = isInsertAnother(input);
        }

        return athletes;
    }

    private String addCountry(Scanner input) {
        while(true){
        try{
            return validator.checkISOCountry(input.nextLine().trim());
        }
        catch (Exception e){
            System.out.println("Enter ISO standard country please ( Must be in upper case). i.e EE");
            }

        }
    }

    private boolean isInsertAnother(Scanner input) {
        String s;

        while(true){

            s = input.nextLine();

            if(s.equals("y")){
                return true;
            }

            if(s.equals("n")){
                return false;
            }

            if(!s.equals("y") || !s.equals("n")){

                System.out.println("Please enter correct input!");
            }

        }

    }





    public double setStringToDoubleInMinutes(Scanner input) {


        while(true){
          try{
            return validator.setStringToDoubleInMinutes(input.nextLine().trim());

          } catch (Exception e){
              System.out.println("Insert correct result! I.e min:sec");
          }

      }

    }

    private double setStringToDouble(Scanner input) {
        while(true){
            try{
                return Double.parseDouble(input.nextLine().trim());
            }catch(NumberFormatException e){
                System.out.println("Please insert correct result!");
            }
        }
    }

    private Date addDate(Scanner input){

        while(true){
            try {
              return validator.checkDate(input.nextLine());
            } catch (ParseException e) {
                System.out.println("Please enter correct date! i.e dd.mm.yyyy");
            }
        }
    }
}
