package net.azib.java.students.t103640.homework;

import java.util.ArrayList;

public class OutputHandler extends IOController{

    public void writeOut(ArrayList<Athlete> athletes) {

        if(getOutputMethod().equals("-console")) {
            ConsoleWriter cw = new ConsoleWriter();
            cw.writeDataToConsole(athletes);
        }

        if(getOutputMethod().equals("-csv")){
          DataToCSVWriter writer = new DataToCSVWriter();
              writer.writeDataToCSV(athletes, getOutputParam());
        }

        if(getOutputMethod().equals("-xml")){
            DataToXMLWriter writer = new DataToXMLWriter();
                writer.writeDataToXml(athletes, getOutputParam());
        }

        if(getOutputMethod().equals("-html")){
            DataToHTMLWriter writer = new DataToHTMLWriter();
            writer.writeDataToHTML(athletes, getOutputParam());
        }
    }
}
