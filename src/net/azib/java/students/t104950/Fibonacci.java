package net.azib.java.students.t104950;

/**
 * Created by IntelliJ IDEA.
 * User: Priit
 * Date: 17.02.11
 * Time: 15:45
 * To change this template use File | Settings | File Templates.
 */
public class Fibonacci {

   //public long a;
   //public long b;
  // public long count;
    //int index;

    public long Calculate(int index) {
//mitmeni teha -> index
        long result,a,b;
        int count;
        for (a = 0, b = 1, count = 0, result = 0; count < index-1; count++) {
            result = a + b;
            a = b;
            b=result;
        }
        return result;
    }


}

