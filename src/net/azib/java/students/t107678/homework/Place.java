package net.azib.java.students.t107678.homework;

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
