package net.azib.java.students.t030629.homework.io;

import net.azib.java.students.t030629.homework.base.Athlete;
import net.azib.java.students.t030629.homework.base.utils.AthleteBuilder;
import net.azib.java.students.t030629.homework.base.DecathlonEvent;
import net.azib.java.students.t030629.homework.utils.LoggingException;

import java.util.List;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * Class loads athletes interactively from console,
 * using ConsoleCommunicator.
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 13.05.2008
 * <br>Time: 0:50:46
 */
public class ConsoleLoader implements AthleteLoader {
    private static final Logger LOG = Logger.getLogger(ConsoleLoader.class.getName());
    
    private final AthleteBuilder athleteBuilder;
    private final ConsoleCommunicator communicator;
    private List<Athlete> athletes;

    /**
     * Constructor
     */
    public ConsoleLoader() {
        athleteBuilder = new AthleteBuilder();
        communicator = new ConsoleCommunicator(System.in, System.out);
        athletes = new LinkedList<Athlete>();
    }

    /**
     * @see AthleteLoader#load()
     */
    public void load() {
        try {
            while (communicator.hasNewAthlete()) {
                athleteBuilder.newAthlete();
                athleteBuilder.addName(communicator.getName());
                athleteBuilder.addBirthday(StringParser.parseBirthday(communicator.getBirthDay()));
                athleteBuilder.addCountry(communicator.getCountry());
                DecathlonEvent event = DecathlonEvent.getFirstEvent();
                do {
                    athleteBuilder.addResult(event, StringParser.parseResult(event, communicator.getResult(event)));
                    event = event.next();
                } while (event != DecathlonEvent.getFirstEvent());

                athletes.add(athleteBuilder.getAthlete());
            }
        } catch (Exception e) {
            throw new LoggingException(ERROR_LOADING_MESSAGE + e.getMessage(), LOG);
        }

    }

    /**
     * @see AthleteLoader#getAthletes()
     */
    public List<Athlete> getAthletes() {
        return athletes;
    }
}
