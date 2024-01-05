package lecture.inflearn_basic.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumScore {
    static int n, limit;
    static int answer = Integer.MIN_VALUE;
    public static void DFS(int sum, int time, int L, int[][] arr){
        if(time>limit) return;

        if(L==n){
            if(sum>answer) answer = sum;
        }
        else{
            DFS(sum+arr[L][0], time+arr[L][1], L+1, arr);
            DFS(sum, time, L+1, arr);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        limit = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); //점수
            arr[i][1] = Integer.parseInt(st.nextToken()); //걸리는 시간
        }
        DFS(0, 0, 0, arr);
        System.out.println(answer);
    }
}