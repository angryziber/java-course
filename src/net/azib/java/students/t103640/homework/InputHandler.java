package net.azib.java.students.t103640.homework;

import java.util.ArrayList;

public class InputHandler extends IOController {


    public ArrayList<Athlete> readIn() {
     ArrayList<Athlete> athletes = null;

     if(getInputMethod().equals("-console")){
         ConsoleReader cr = new ConsoleReader();
         athletes = cr.getConsoleData();
     }

     if(getInputMethod().equals("-csv")){
         CSVReader csvReader = new CSVReader();
         athletes = csvReader.getCSVData(getInputParam());
     }

     if(getInputMethod().equals("-db")){
         DBReader dbR = new DBReader();
         athletes = dbR.getDBData(getInputParam());
     }

        return athletes;
    }
}
