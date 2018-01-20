package BasicRecursion;
//find the factorial
public class four_factorial {
	
	public static void main(String[] args) {
		System.out.println(factorial(1));
	}

	private static int factorial(int n) {
		if(n == 0) return 1;
		return n * factorial(n - 1);
	}

}
