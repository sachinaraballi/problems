//https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/exists/description/

package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KKandCrush {

    public static int[] hash;

    public static void main(String[] args) {
        Reader in = new Reader(); //faster compared to scanner
        int T = in.nextInt();
        for (int tc = 1; tc <= T; tc++) { //for loop is faster than while
            int N = in.nextInt();
            StringBuilder s = new StringBuilder();
            hash = new int[2 * 100000 + 10]; //input might contain 10^5 values
            for (int i = 0; i < N; i++) {
                int input = in.nextInt();
                if (input >= 0)
                    hash[input] = 1;
                else
                    hash[100000 - input] = 1; //for negative value
            }
            int Q = in.nextInt();
            for (int i = 0; i < Q; i++) {
                int input = in.nextInt();
                if (input >= 0) {
                    if (hash[input] == 1) {
                        s.append("Yes");
                    } else {
                        s.append("No");
                    }
                } else {
                    if (hash[100000 - input] == 1) {
                        s.append("Yes");
                    } else {
                        s.append("No");
                    }
                }
                s.append("\n");
            }
            System.out.println(s);
        }

    }

}

class Reader {

    BufferedReader br;
    StringTokenizer st;

    public Reader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}


/*
 2
5
12 13 -4 3 2
6
15
11
13
2
3
12
6
12 3 -67 67 34 2
4
4
5
67
7
NO
NO
YES
YES
YES
YES
NO
NO
YES
NO
*/
