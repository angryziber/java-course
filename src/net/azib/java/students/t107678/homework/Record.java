package net.azib.java.students.t107678.homework;

import java.util.Collection;
import java.util.Set;

/** represents record for one participant, his personal data and his performance from 10 events
 *
 */
public class Record {


    final private Participant participant;
    final private Collection<Event> events;

    /** Method allows us to extract wanted personal data about Participant
     *
     * @return All personal Participant data
     */
    public Participant getParticipant() {
        return participant;
    }

    /**
     *
     * @return Collection of Event types of data bundled with single particular Participant
     */
    public Collection<Event> getEvents() {
        return events;
    }

    /**
     *
     * @param participant instance of Participant
     * @param events represents 10 event data of Decathlon for particular Participant
     */
    public Record(Participant participant, Collection<Event> events) {

        this.participant=participant;
        this.events = events;

        assert participant!=null : "Participant must not be null";
        assert events!=null : "Events must not be null";

    }

    /** This method allows us to get final Participant score in competition
     *
     * @return total computed point in competition for single Participant
     */
    public int getTotalPoints(){
        int sum=0;

        for(Event e : events){
                 sum+=e.getPoints();
        }
        return sum;
    }

}
