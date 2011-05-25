package net.azib.java.students.t103640.homework;

import java.util.ArrayList;

public class ConsoleWriter {


    public void writeDataToConsole(ArrayList<Athlete> athletes) {
     ArrayList<String> athletesOut = new ArrayList<String>();

     athletesOut = new CoustomUtilities().fromAthleticToStringConsoleFormat(athletes);
        for (String s : athletesOut) {
            System.out.println(s);
        }
    }


}
