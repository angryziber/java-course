package net.azib.java.students.t030629.homework.io;

import net.azib.java.students.t030629.homework.base.DecathlonEvent;

import java.io.PrintStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Class performs communication with a user while entering the Decathlon competition
 * data manually from the console. It asks the user questions and obtains the answers.
 * <p>
 * Class intrinsically defines the communication protocol.
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 13.05.2008
 * <br>Time: 1:14:58
 */
public class ConsoleCommunicator {
    private static final String ASK_NEW_INPUT = "Hit <ENTER> to input another Athlete or <ANY-KEY> to quit...";
    private static final String NAME_QUESTION = "Enter name: ";
    private static final String BIRTHDAY_QUESTION = "Enter date of birth (dd.MM.yyyy): ";
    private static final String COUNTRY_QUESTION = "Enter country as ISO 2-letter code: ";
    private static final String RESULT_QUESTION = "Enter result for ";
    static final int ENTER_CHAR = 10;
    private static final String LN = System.getProperty("line.separator");

    private final Scanner in;
    private final PrintStream out;
    private final InputStream userInput;

    /**
     * Contructor with its IntpuStream and PrintStream
     * @param userInput stream the user enters data into
     * @param communicatorOutput stream the {@link net.azib.java.students.t030629.homework.io.ConsoleCommunicator}
     *                  enters question into
     */
    public ConsoleCommunicator(InputStream userInput, PrintStream communicatorOutput) {
        this.in = new Scanner(userInput);
        this.in.useDelimiter(LN);
        this.out = communicatorOutput;
        this.userInput = userInput;
    }

    /**
     * Asks the user to input another athlete data and returns the user's agreement
     * @return <code>true</code> if the user agreed to enter new athlete data. <code>false</code> otherwise.
     * @throws IOException if an I/O error occurs
     */
    public boolean hasNewAthlete() throws IOException {
        out.print(ASK_NEW_INPUT);
        out.flush();
        int answer = userInput.read();
        return answer == ENTER_CHAR;
    }

    /**
     * Asks the user to input the name of the athlete under construction and returns the user's input
     * @return the athlete's name (String) entered by the user
     */
    public String getName() {
        return getAnswerFor(NAME_QUESTION);
    }

    /**
     * Asks the user to input the date of birth of the athlete under construction and returns the user's input
     * @return the athlete's date of birth (String) entered by the user
     */
    public String getBirthDay() {
        return getAnswerFor(BIRTHDAY_QUESTION);
    }

    /**
     * Asks the user to input the country of the athlete under construction and returns the user's input
     * @return the athlete's country (String) entered by the user
     */
    public String getCountry() {
        return getAnswerFor(COUNTRY_QUESTION);
    }

    /**
     * Asks the user to input the result of the athlete under construction
     * for the specified event and returns the user's input
     * @param event event to enter the result for
     * @return the athlete's result (String) entered by the user for the specified event.
     *          <p><b>NB!</b> The specified result is assumed to be normalized, since the
     *          question for entering the result asks for the result in normal units.
     *          Otherwise exception will be thrown when creating the result, or
     *          alternatively the result may become incorrect despite being valid.
     */
    public String getResult(DecathlonEvent event) {
        return getAnswerFor(askResultFor(event));
    }

    private String getAnswerFor(String question) {
        out.print(question);
        out.flush();
        return in.next();
    }

    private String askResultFor(DecathlonEvent event) {
        return RESULT_QUESTION + event + " (" + event.getUnit() + "): ";
    }
}
