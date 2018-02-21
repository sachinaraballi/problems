package AdHocProblems;

import java.util.Scanner;

public class CubeSummation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int A[]= new int[1000000];
            for (int i = 0; i < M; i++) {
                String op = sc.next();
                if (op.equals("UPDATE")) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    int z = sc.nextInt();
                    int w = sc.nextInt();
                    A[x*y*z]= w;
                } else {
                    int x1 = sc.nextInt();
                    int y1 = sc.nextInt();
                    int z1 = sc.nextInt();
                    int x2 = sc.nextInt();
                    int y2 = sc.nextInt();
                    int z2 = sc.nextInt();
                    int sum = 0;
                    boolean flag = true;
                    for (int j = 0; j < A.length; j++) {
                        for (int j2 = 0; j2 < A.length; j2++) {
                            if (flag)
                                for (int k = 0; k < A.length; k++) {
                                    if (flag)
                                        if (j >= x1 && j2 >= y1 && k >= z1) {
                                            sum = sum + A[j*j2*k];
                                            if (j >= x2 && j2 >= y2 && k >= z2) {
                                                flag = false;
                                                break;
                                            }
                                        }
                                }
                        }
                    }
                    System.out.println(sum);
                }
            }
        }
    }

}
