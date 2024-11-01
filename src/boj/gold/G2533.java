package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class G2533 {
    static int n;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] ch;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ch = new int[n+1];
        dp = new int[n+1][2];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        String[] inputArr;
        for (int i = 0; i < n - 1; i++) {
            inputArr = br.readLine().split(" ");
            int a = Integer.parseInt(inputArr[0]);
            int b = Integer.parseInt(inputArr[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        DFS(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    public static void DFS(int num){
        ch[num] = 1;
        dp[num][0] = 0;
        dp[num][1] = 1;

        for(int next : graph.get(num)){
            if(ch[next]==0){
                DFS(next);
                dp[num][0] += dp[next][1];
                dp[num][1] += Math.min(dp[next][0], dp[next][1]);
            }
        }
    }
}