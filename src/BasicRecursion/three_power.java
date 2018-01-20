package BasicRecursion;
//find the power by base and power
/**
 * 
 * @author sachinaraballi
 *
 */

public class three_power {
	public static void main(String[] args) {
		int res = solve(2, 10);
		System.out.println(res);
	}

	private static int solve(int base, int power) {
		if (power == 0) {
			return 1;
		}
		return base * solve(base, power - 1);
	}
}
