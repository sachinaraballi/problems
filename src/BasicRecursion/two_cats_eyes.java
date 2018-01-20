package BasicRecursion;
//Return the the number of eyes of the cats

/**
 * 
 * @author sachinaraballi
 *
 */
public class two_cats_eyes {

	public static void main(String[] args) {
		System.out.println(solve(10));
	}

	private static int solve(int cats) {
		if(cats  == 0){
			return 0;
		}else{
			return 2 + solve(cats - 1);
		}
	}
}
