package net.azib.java.students.t107678.homework;

import java.util.Set;

public class Record {


    Participant participant;
    Set<Event> events;

    public Record(Participant participant, Set<Event> events) {

        this.participant=participant;
        this.events = events;

        assert participant!=null : "Participant must not be null";
        assert events!=null : "Events must not be null";
        //TODO events size more than 10,;

    }


    public int getPoints(){
        int sum=0;

        for(Event e : events){
                 sum+=e.getPoints();
        }
        return sum;
    }


}
