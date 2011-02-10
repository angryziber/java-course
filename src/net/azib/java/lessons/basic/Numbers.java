package net.azib.java.lessons.basic;

import java.math.BigDecimal;

public class Numbers {
    public static final double PI = 3.14159;

    public static void main(String[] args) {
        System.out.println(Numbers.PI);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Double.MIN_VALUE);

        String s = "123";
        int n = Integer.parseInt(s) + 1;
        System.out.println(n);

        char c = 0;
        c = '\u00A0';
        c = 'A';
        c++;
        System.out.println(c);

        n = 255;
        long l = 2147483648L;
        byte b = (byte)255;
        b = (byte)n;
        System.out.println(n);

        double d = 0;
        float f = 3.14f;

        BigDecimal big = new BigDecimal("172631263716236163761263612731623182376817236126381237");
        big = big.add(BigDecimal.ONE);
        big = big.divide(BigDecimal.TEN);
        System.out.println(big);

        System.out.println(StaticFailure.n);

        System.out.println("Finished");
    }
}
