package lecture.inflearn_basic.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Badoogi {
    static int c, n;
    static int[] arr;
    static int max = Integer.MIN_VALUE;

    public static void DFS(int L, int sum){
        if(L==n){
            if(sum<=c) max = Math.max(max, sum);
            return;
        }

        DFS(L+1, sum+arr[L]);
        DFS(L+1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        c = Integer.parseInt(inputArr[0]);
        n = Integer.parseInt(inputArr[1]);
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        DFS(0, 0);
        System.out.println(max);
    }
}