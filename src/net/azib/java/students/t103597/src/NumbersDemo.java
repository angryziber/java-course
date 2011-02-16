package net.azib.java.students.t103597.src;

public class NumbersDemo {
    public static void main(String[] args){

        //BigInteger fibnr, factnr;

        // USER CAN CHOOSE THE INDEX FOR THE NUMBERS
        //System.out.println("Enter the index of the Fibonacci & Factorial numbers you wish to see: ");
        //Scanner index = new Scanner(System.in);
        //System.out.println("You chose nr: "+ index.nextLine());

        // CREATES OBJECTS OF THE CLASSES USED
        Factorial factObject = new Factorial();
        Fibonacci fibObject = new Fibonacci();

        // USES SPECIFIED OBJECTS FROM CHOSEN CLASSES
        fibObject.fib();
        factObject.fact();

        //System.out.println(factnr);
        //System.out.println(x);

        // BRING VALUES AND OUTPUT RESULTS


        }
}

