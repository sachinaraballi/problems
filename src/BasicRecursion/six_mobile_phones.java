package BasicRecursion;

public class six_mobile_phones {

	public static void main(String[] args) {
		int res = solve(4);
		System.out.println(res);
	}

	private static int solve(int n) {
		if(n == 0){
			return 0;
		}
		
		//int a = 0, b = 0;
		if (n % 2 == 0) {
			return solve(n - 1) + 2;
		} else {
			return solve(n - 1) + 1;
		}

		//return a + b;
	}

}
