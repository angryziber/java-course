package net.azib.java.students.t104971.homework.athletics.components;

/**
 * @author Jaroslav Judin
 */
public class Result {

    private ResultType type;
    private int score;
    private double result;

    public Result(ResultType type, double result) {
        this.type = type;
        this.result = result;
        score = type.countScore(result);
    }

    public ResultType getType() {
        return type;
    }

    public int getScore() {
        return score;
    }

    public double getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "type=" + type +
                ", result=" + result +
                ", score=" + score +
                '}';
    }
}
