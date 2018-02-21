package BFS;

import java.util.Scanner;

//https://www.hackerrank.com/contests/world-codesprint-12/challenges/red-knights-shortest-path/problem
public class RedKnightsShortestPath {
    static int A[][]; // main matrix
    static int V[][]; //visited matrix
    static int N; //size of the matrix

    //array to track the parent to find the path
    static int parent[][][];

    // Queue implementation
    static int front;
    static int rear;
    static int queue[][];

    //Order is important 
    static int directions[][] = new int[][] { { -2, -1 }, { -2, 1 }, { 0, 2 }, { 2, 1 }, { 2, -1 }, { 0, -2 } };
    static String strdirections[] = { "UL", "UR", "R", "LR", "LL", "L" };

    //to check the queue size
    static int length() {
        return rear - front;
    }

    //count is track the distance
    static void enqueue(int i, int j, int count) {
        rear++;
        queue[rear][0] = i;
        queue[rear][1] = j;
        queue[rear][2] = count;
    }

    static void dequeue() {
        front++;
    }

    public static void main(String[] args) {
        front = rear = -1;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N][N];
        V = new int[N][N];
        parent = new int[N][N][3];
        queue = new int[1000000][3];
        int is = sc.nextInt();
        int js = sc.nextInt();
        int ie = sc.nextInt();
        int je = sc.nextInt();
        solve(is, js, ie, je);
    }

    private static void solve(int is, int js, int ie, int je) {
        boolean flag = true;
       //get the start point enqueue it
        enqueue(is, js , 0);
        //mark it visited
        V[is][js] = 1;
        //if queue is not empty
        while(length() > 0){
            //dequeue all neighbors elements
            dequeue();
            int i = queue[front][0];
            int j = queue[front][1];
            int count = queue[front][2];
            if(i == ie && j == je){
                //if end point found
                System.out.println(count);
                String ans = "";
                while(!(i == is && j == js)){
                    int l = parent[i][j][0];
                    int o = parent[i][j][1];
                    ans = strdirections[parent[i][j][2]] + " " + ans; //print in reverse order
                    i = l;
                    j = o;
                }
                System.out.println(ans);
                flag = false;
                break;
            }
            for (int k = 0; k < directions.length; k++) {
                int m = i + directions[k][0];
                int n = j + directions[k][1];
                //valid state and not already visited
                if(isValidState(m,n) && V[m][n] != 1){
                  //set the parent 
                    parent[m][n][0] = i;
                    parent[m][n][1] = j;
                    parent[m][n][2] = k;
                    //mark as visited
                    V[m][n] = 1;
                    //enqueue all the neighbors
                    enqueue(m, n, count + 1);
                }
            }
            
        }
        if(flag){
            System.out.println("Impossible");
        }
        
    }

    private static boolean isValidState(int i, int j) {
        // check boundary conditions
        return (i >= 0 && j >= 0 && i < N && j < N);
    }
}
