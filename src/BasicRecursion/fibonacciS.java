package BasicRecursion;

public class fibonacciS {

	public static void main(String[] args) {
		int n = fibonacci(4);
		System.out.println(n);
	}

	public static int fibonacci(int num) {
		if (num == 0) {
			return 0;
		}
		if (num == 1) {
			return 1;
		}
		int a = fibonacci(num - 1);
		int b = fibonacci(num - 2);
		return a + b;
		//fibonacci(num-1) + fibonacci(num-2)
	}

}


/*

             4
           /   \
          3  +  2
         / \   / \
        2 + 1 1 + 0
       / \
      1 + 0
      
      

*/