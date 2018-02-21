package AdHocProblems.spoj;

import java.util.Scanner;
import java.util.Stack;

public class StreetParade {

    public static void main(String[] args) {
        Stack<Integer> lane = new Stack<Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n != 0){
            int need = 1;
            boolean state = true;
            
            int[] order = new int[n];
            for (int i = 0; i < n; i++) {
               order[i] = sc.nextInt();
            }
        for (int i = 0; i < n; i++) {
            while (!lane.isEmpty() && lane.peek() == need) {
                need++;
                lane.pop();
            }
            if (order[i] == need) {
                need++;
            } else if (!lane.isEmpty() && lane.peek() < order[i]) {
                state = false;
                break;
            } else {
                lane.push(order[i]);
            }
        }
        System.out.println(state ? "yes" : "no");
        }
    }
}

