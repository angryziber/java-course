package ee.ttu.decathlon.io;

import ee.ttu.decathlon.beans.Athlete;

import java.util.List;

public interface OutputProvider {
    void writeAthletes(List<Athlete> athletes);
}
