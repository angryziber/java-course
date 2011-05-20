package net.azib.java.students.t107678.homework;

/**
 *     Represents logic for final place (position in Competition) that participant took
 */
public class Place {

    private static final String DASH = "-";
    private int possiblePlace;
    private int sharesWithHowMany;

    public int getPossiblePlace() {
        return possiblePlace;
    }

    public void setPossiblePlace(int possiblePlace) {
        this.possiblePlace = possiblePlace;
    }

    public int getSharesWithHowMany() {
        return sharesWithHowMany;
    }

    public void setSharesWithHowMany(int sharesWithHowMany) {
        this.sharesWithHowMany = sharesWithHowMany;
    }

    public Place(int possiblePlace, int sharesWithHowMany) {
        this.possiblePlace = possiblePlace;
        this.sharesWithHowMany = sharesWithHowMany;
    }

    /**   Logic is that if Participant is not sharing place, that only int is displayed,
     *      if he does share that place range is displayed
     *
     * @return final place in competition according to sharing requirement
     */
    public String getFinalPlace() {

        String finalPlace = "";

        if (sharesWithHowMany == 0) {
            finalPlace = finalPlace + Integer.toString(possiblePlace);
            return finalPlace;
        } else {
            finalPlace = finalPlace + Integer.toString(possiblePlace) + DASH + Integer.toString(possiblePlace + sharesWithHowMany);
            return finalPlace;
        }

    }

}
