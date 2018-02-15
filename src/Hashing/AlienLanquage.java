//https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/practice-problems/algorithm/alien-language/
package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author sachinaraballi
 *
 */

public class AlienLanquage {

    public static void main(String[] args) {
        Reader reader = new Reader();
        int T = reader.nextInt();
        for (int i = 0; i < T; i++) {
            String str = reader.next();
            String substr = reader.next();
            if (str.contains(substr)) {
                System.out.println("YES");
            } else {
                if (singleChar(str, substr))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }
//check for the statement If any sub-string of the word said by Jaadu is a sub-string of the word said by Little Jhool, the output should be "YES"
    public static boolean singleChar(String str, String substr) {
        for (int i = 0; i < substr.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (substr.charAt(i) == str.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
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
 SAMPLE INPUT 
3
hackerearth
hacker
hackerearth
wow
hackerearth
more


SAMPLE OUTPUT 
YES
NO
YES
*/
