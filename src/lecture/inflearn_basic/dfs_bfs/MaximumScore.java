package lecture.inflearn_basic.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumScore {
    static int[][] arr;
    static int n, m;
    static int max = 0;

    public static void DFS(int L, int sum, int time){
        if(L==n){
            if(time<=m){
                max = Math.max(max, sum);
            }
            return;
        }

        DFS(L+1, sum+arr[L][0], time+arr[L][1]);
        DFS(L+1, sum, time);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            int s = Integer.parseInt(inputArr[0]);
            int t = Integer.parseInt(inputArr[1]);
            arr[i][0] = s;
            arr[i][1] = t;
        }
        DFS(0, 0, 0);
        System.out.println(max);
    }
}