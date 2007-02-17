import java.math.BigInteger;

/**
 * Factorial
 * @author t050657
 *
 */
public class Factorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(factorial(3));
		System.out.println(factorial(5));
		System.out.println(factorial(100));
	}
	
	public static BigInteger factorial(int n) {
		BigInteger ans = BigInteger.ONE;
		for( ; n>0; n--) {
			String a = n + ""; 
			ans = ans.multiply(new BigInteger(a)); 
		}
		return ans;
	}
}
