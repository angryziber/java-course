package net.azib.java.students.t104950;

/**
 * Created by IntelliJ IDEA.
 * User: Priit
 * Date: 17.02.11
 * Time: 17:00
 * To change this template use File | Settings | File Templates.
 */
public class Factorial {

   public long Calculate(int n) {

        long result,a;
        int count;
        for (a = 1,  count = 0, result=0 ; count < n; count++) {
            a=a*(a+1);
            //result = (a+1) * a;
           // a=result;
        }
        return result;
    }
}
