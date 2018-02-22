package BFS;

//https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/till-the-end-of-the-time-d73ba7d1/

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

/**
 * 
 * @author sachinaraballi
 *
 */

public class TravelDairies {
    static int N; // row
    static int M; // col
    static int A[][]; // matrix
    static int V[][]; // visited matrix
    static int directions[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    static int maxCount = -1;
    static int onescount = 0;

    static int queue[][];
    static int front;
    static int rear;

    static int length() {
        return rear - front;
    }

    static void enqueue(int i, int j, int count) {
        rear++;
        queue[rear][0] = i;
        queue[rear][1] = j;
        queue[rear][2] = count;
    }

    static void dequeue() {
        front++;
    }

    public static void main(String[] args) throws IOException {
        Scan s = new Scan();
        Print p = new Print();
        
        front = rear = -1;
        queue = new int[1000000][3];
        N = s.scanInt();
        M = s.scanInt();
        A = new int[N][M];
        V = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                A[i][j] = s.scanInt();
                if (A[i][j] == 1) {
                    onescount++;
                }
            }
        }
        bfs();
        if (onescount != 0) {
            p.printLine(Integer.toString(-1));
        } else
            p.printLine(Integer.toString(maxCount));
 
        p.printLine("");
        p.close();
    }

    private static void bfs() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 2) {
                    enqueue(i, j, 0);
                    V[i][j] = 1;
                }
            }
        }
        while (length() > 0) {
            dequeue();
            int i = queue[front][0];
            int j = queue[front][1];
            int count = queue[front][2];
            maxCount = Math.max(count, maxCount);
            for (int k = 0; k < 4; k++) {
                int m = i + directions[k][0];
                int n = j + directions[k][1];
                if (isValidState(m, n) && V[m][n] != 1 && A[m][n] == 1) {
                    V[m][n] = 1;
                    A[m][n] = 2;
                    onescount--;
                    enqueue(m, n, count + 1);
                }
            }
        }
    }

    private static boolean isValidState(int i, int j) {
        return (i < N && j < M && i >= 0 && j >= 0);
    }

}

class Scan {
    private byte[] buf = new byte[1024];
    private int index;
    private InputStream in;
    private int total;
 
    public Scan() {
        in = System.in;
    }
 
    public int scan() throws IOException {
        if (total < 0)
            throw new InputMismatchException();
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0)
                return -1;
        }
        return buf[index++];
    }
 
    public int scanInt() throws IOException {
        int integer = 0;
        int n = scan();
        while (isWhiteSpace(n))
            n = scan();
        int neg = 1;
        if (n == '-') {
            neg = -1;
            n = scan();
        }
        while (!isWhiteSpace(n)) {
            if (n >= '0' && n <= '9') {
                integer *= 10;
                integer += n - '0';
                n = scan();
            } else
                throw new InputMismatchException();
        }
        return neg * integer;
    }
 
    public double scanDouble() throws IOException {
        double doub = 0;
        int n = scan();
        while (isWhiteSpace(n))
            n = scan();
        int neg = 1;
        if (n == '-') {
            neg = -1;
            n = scan();
        }
        while (!isWhiteSpace(n) && n != '.') {
            if (n >= '0' && n <= '9') {
                doub *= 10;
                doub += n - '0';
                n = scan();
            } else
                throw new InputMismatchException();
        }
        if (n == '.') {
            n = scan();
            double temp = 1;
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    temp /= 10;
                    doub += (n - '0') * temp;
                    n = scan();
                } else
                    throw new InputMismatchException();
            }
        }
        return doub * neg;
    }
 
    public String scanString() throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = scan();
        while (isWhiteSpace(n))
            n = scan();
        while (!isWhiteSpace(n)) {
            sb.append((char) n);
            n = scan();
        }
        return sb.toString();
    }
 
    private boolean isWhiteSpace(int n) {
        if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
            return true;
        return false;
    }
}
 
class Print {
    private final BufferedWriter bw;
 
    public Print() {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
 
    public void print(String str) throws IOException {
        bw.append(str);
    }
 
    public void printLine(String str) throws IOException {
        print(str);
        bw.append("\n");
    }
 
    public void close() throws IOException {
        bw.close();
    }
}
