package BasicRecursion;
//Print n to 1 s
/**
 * 
 * @author sachinaraballi
 *
 */

public class One_Print_n_to_one {
	
	public static void main(String[] args) {
		solve(10);
	}
	
	public static void solve(int n){
		//basecase
		if(n == 0){
			return;
		}
		//Print the number
		System.out.println(n);
		//recursion
		solve(n -1);
		
	}

}
