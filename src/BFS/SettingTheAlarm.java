package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class SettingTheAlarm {

    static final int HH = 13; //max value of hour 12
    static final int MM = 62; //max value of minute 60
    static final int FF = 3; //max value of flag 2

    static int visited[][][];
    static int queue[][];
    static int rear;
    static int front;

    static int length() {
        return rear - front;
    }

    static void enqueue(int hh, int mm, int f) {
        rear++;
        queue[rear][0] = hh;
        queue[rear][1] = mm;
        queue[rear][2] = f;
    }

    static void dequeue() {
        front++;
    }

    static void hPlus(int hh, int mm, int f) {
        hh++;

        if (hh == 12) // if hour is 12 then change the flag 
            f ^= 1;
        if (hh > 12) //if it is greater than 12 make it to 1
            hh = 1;

        if (visited[hh][mm][f] == 0) // if it is not visited enqueue the next time 
            enqueue(hh, mm, f);
    }

    static void hMinus(int hh, int mm, int f) {
        hh--;

        if (hh == 11) //if hour reduced to 11 then change the flag 
            f ^= 1;
        if (hh < 1) //if hour is less than 1 then make it to 12
            hh = 12;

        if (visited[hh][mm][f] == 0) // if not visited enqueue
            enqueue(hh, mm, f);
    }

    static void mPlus(int hh, int mm, int f) {
        mm++;

        if (mm <= 59) { // if minute is less than and equql to 59 just enqueue 
            if (visited[hh][mm][f] == 0)
                enqueue(hh, mm, f);
        } else { // else make minute zero and increment hour
            mm = 0;
            hPlus(hh, mm, f);
        }
    }

    static void mMinus(int hh, int mm, int f) {
        mm--;

        if (mm >= 0) { //if minute is greater than or equal to zero then just enqueue
            if (visited[hh][mm][f] == 0)
                enqueue(hh, mm, f);
        } else { // else reduce hour
            mm = 59;
            hMinus(hh, mm, f);
        }
    }

    static void hashx(int hh, int mm, int f) {
        f ^= 1; // just toggle and enqueue

        if (visited[hh][mm][f] == 0)
            enqueue(hh, mm, f);
    }

    private static void solve(int hh1, int mm1, int f1, int hh2, int mm2, int f2) {
        visited = new int[HH][MM][FF];
        rear = -1;
        front = -1;
        queue = new int[100000][3];
        enqueue(hh1, mm1, f1);
        int step = 0;
        while (length() > 0) {

            int k = length();
            for (int i = 1; i <= k; i++) {
                dequeue();
                int hh = queue[front][0];
                int mm = queue[front][1];
                int ff = queue[front][2];
                if (visited[hh][mm][ff] != 0) {
                    continue;
                }
                visited[hh][mm][ff] = step;
                hPlus(hh, mm, ff);
                hMinus(hh, mm, ff);
                mPlus(hh, mm, ff);
                mMinus(hh, mm, ff);
                hashx(hh, mm, ff);
            }
            step++;

        }
    }

    public static void main(String[] args) {
       // Scanner sc = new Scanner(System.in);
        Reader1 r = new Reader1();
        int T = r.nextInt();
        while (T-- != 0) {

            String str1 = r.next();
            String first[] = str1.split(":");
            int hh1 = Integer.parseInt(first[0]);
            int mm1 = Integer.parseInt(first[1]);
            String str2 = r.next();
            int f1 = 0;
            if (str2.equals("pm")) {
                f1 = 1;
            }

            str1 = r.next();
            first = str1.split(":");
            int hh2 = Integer.parseInt(first[0]);
            int mm2 = Integer.parseInt(first[1]);
            str2 = r.next();
            int f2 = 0;
            if (str2.equals("pm")) {
                f2 = 1;
            }
            solve(hh1, mm1, f1, hh2, mm2, f2);
            System.out.println(visited[hh2][mm2][f2]);
        }
    }

}
class Reader1 {

    BufferedReader br;
    StringTokenizer st;

    public Reader1() {
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