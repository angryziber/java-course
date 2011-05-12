package net.azib.java.students.t107678.homework;

import java.util.Collection;
import java.util.Set;

public class Record {


    final private Participant participant;
    final private Collection<Event> events;

    public Participant getParticipant() {
        return participant;
    }

    public Collection<Event> getEvents() {
        return events;
    }

    public Record(Participant participant, Collection<Event> events) {

        this.participant=participant;
        this.events = events;

        assert participant!=null : "Participant must not be null";
        assert events!=null : "Events must not be null";
        //TODO events size not more than 10,;

    }


    public int getPoints(){
        int sum=0;

        for(Event e : events){
                 sum+=e.getPoints();
        }
        return sum;
    }


}
