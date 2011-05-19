package net.azib.java.students.t107678.homework;

import java.io.Closeable;
import java.util.ArrayList;

/** Provides initial logic for all writers in project
 *
 */
public interface Writer {

    /** Logic for outputting single Participant final data
     *
     * @param  place Participant's final place in competition
     * @param record Participant's Record
     */
    public abstract void writeNext(Place place, Record record);

    /** Logic for outputting all Participants final data
     *
     * @param resultsComputation instance of ResultComputation with competition final results
     */
    public void writeOutput(ResultsComputation resultsComputation);
}
