package lecture.inflearn_basic.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Badoogi {
    static int n, max;
    static int answer = 0;

    public static void DFS(int L, int sum, int[] arr){
        if(sum>max) return;

        if(L==n){
            if(sum>answer) answer = sum;
        }
        else{
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        max = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
        DFS(0, 0, arr);
        System.out.println(answer);
    }
}