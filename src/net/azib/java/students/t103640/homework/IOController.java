package net.azib.java.students.t103640.homework;

public class IOController {
	/**
	 * This is a class for input output methods and parameters storage, with
	 * according getters and setters
	 */
	private static String inputMethod;
    private static String inputParam;
    private static String outputTo;
    private static String outputParam;

    public static void setInputMethod(String input){
        inputMethod = input;
    }

    public String getInputMethod(){
        return inputMethod;
    }

    public static void setInputParam(String param) {
        inputParam = param;
    }

    public static void setOutuputMethod(String outputMethod) {
        outputTo = outputMethod;
    }

    public static void setOutputParam(String param) {
        outputParam = param;
    }

    public String getInputParam() {
        return inputParam;
    }

    public String getOutputMethod() {
        return outputTo;
    }

    public String getOutputParam() {
        return outputParam;
    }
}
