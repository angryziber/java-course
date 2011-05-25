package net.azib.java.students.t103640.homework;

import java.util.ArrayList;

public class DecathlonCalculator {
    /*  PLEASE don´t grade this project yet, as it is not complete, I only need to update it, to be sure, that it will
        be safe for the time I format C my computer. If everything goes as planned, then you will not even see this
        message, as I plan to commit my final version this evening.

        Thank You
     */
    public static void main(String[] args) {

        argumentHandler(args);
        ArrayList<Athlete> inputData = new InputHandler().readIn();

        ScoreCalc scoreCalc = new ScoreCalc();
        scoreCalc.calculateScore(inputData);

        OutputHandler oh = new OutputHandler();
        oh.writeOut(scoreCalc.calculateScore(inputData));





    }


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
