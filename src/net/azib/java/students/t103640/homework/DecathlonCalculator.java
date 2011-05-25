package net.azib.java.students.t103640.homework;

import java.util.ArrayList;

public class DecathlonCalculator {
	 /**This program is designed to read in given decathlon data from console, database or cvs format.
	  * This program calculates the score and place of athletes and returns them in descending order
	  * @param args: inputMethod, inputParam, outputMethod, outputParam
	  *     These are the given parameters that control the input-output of the program
	  * @author Taavi Sonets
	  */
    public static void main(String[] args) {

        argumentHandler(args);
        ArrayList<Athlete> inputData = new InputHandler().readIn();

        ScoreCalc scoreCalc = new ScoreCalc();
        scoreCalc.calculateScore(inputData);

        OutputHandler oh = new OutputHandler();
        oh.writeOut(scoreCalc.calculateScore(inputData));
    }

	/**
	 * This method is for handling given arguments correctly. If the input method is chosen to be "console" then
	 * program will decide, that the next given argument will be output method.
	 * @param args: inputMethod, inputParam, outputMethod, outputParam
	 */
    private static void argumentHandler(String[] args) {
        IOController.setInputMethod(args[0]);

        if(args[0].equals("-console")){
           IOController.setInputParam("");
           }

        if(!args[0].equals("-console")){
           IOController.setInputParam(args[1]);
        }

        handleOutput(args);
       }

    private static void handleOutput(String[] args) {


        if(args[args.length-1].equals("-console")){
            IOController.setOutuputMethod(args[args.length-1]);
            IOController.setOutputParam("");
        }
        if(!args[args.length - 1].equals("-console") && !args[args.length-2].equals("-console")){
            IOController.setOutputParam(args[args.length - 1]);
            IOController.setOutuputMethod(args[args.length-2]);
        }
    }

}
