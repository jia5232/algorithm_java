package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class G2533 {
    static int n;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1][2];
        ch = new int[n+1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        String[] inputArr;
        for (int i = 0; i < n-1; i++) {
            inputArr = br.readLine().split(" ");
            int start = Integer.parseInt(inputArr[0]);
            int end = Integer.parseInt(inputArr[1]);
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        DFS(1); //트리 구조이기 때문에 1부터 시작
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    public static void DFS(int num){
        ch[num] = 1;
        dp[num][0] = 0;
        dp[num][1] = 1;

        for(int child : graph.get(num)){
            if(ch[child]==0){
                DFS(child);
                dp[num][0] += dp[child][1];
                dp[num][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }
}
