package net.azib.java.students.t103640.homework;

import java.util.ArrayList;

public class OutputHandler extends IOController{
	/**
	 * This method outputs the given data. It decides where to input by extending IOController.
	 *
	 * @param athletes - data to output
	 */
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
