package net.azib.java.students.t107678.homework;

import java.util.Date;

/** Initial logic for single Participant of Decathlon competition
 *
 */
public class Participant {

    private String name;
    private Date birthDate;
    private CountryCode country;

    /**
     *
      * @param name name of Participant
     * @param birthDate birth date of Participant
     * @param country country from where participant comes from or which it represents
     */
public Participant(String name, Date birthDate, CountryCode country) {
       this.name = name;
        this.birthDate = birthDate;
        this.country = country;
    }

    /**
     *
     * @return name of Participant
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return Participant birth date
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     *
     * @return country from where participant comes from or which it represents
     */
    public CountryCode getCountry() {
        return country;
    }
}
