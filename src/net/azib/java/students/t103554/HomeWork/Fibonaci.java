package net.azib.java.students.t103554.HomeWork;

/**
 * Created by IntelliJ IDEA.
 * User: Koliyanov Vyacheslav
 * Date: 17.02.11
 */
public class Fibonaci {

    static int FiBO(int f)
   {
       return (f<=2 ? 1 : FiBO(f-1) + FiBO(f-2));
   }
   public static void main(String[] args)
   {
       for (int f=1; f<=100; f++)
           System.out.print(FiBO(f)+", ");
   }

}


