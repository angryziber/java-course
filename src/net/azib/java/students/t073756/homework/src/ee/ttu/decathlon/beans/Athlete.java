package ee.ttu.decathlon.beans;

import java.util.Date;

public class Athlete implements Comparable<Athlete> {

    private String name;
    private Date dateOfBirth;
    private String country;
    private Result result;


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public int compareTo(Athlete o) {
        return result.getOverallResult() - o.getResult().getOverallResult();
    }

    @Override
    public String toString() {
        return result.getPlace() + "," + result.getOverallResult() + "," + CsvHolder.getCsvLine(this);
    }
}
