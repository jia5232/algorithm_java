package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class G1949 {
    static int n;
    static Town[] towns;
    static ArrayList<ArrayList<Town>> graph = new ArrayList<>();
    static int[][] dp;
    static int[] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        towns = new Town[n+1];
        dp = new int[n+1][2];
        ch = new int[n+1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        String[] inputArr = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            towns[i] = new Town(i, Integer.parseInt(inputArr[i-1]));
        }
        for (int i = 0; i < n-1; i++) {
            inputArr = br.readLine().split(" ");
            int a = Integer.parseInt(inputArr[0]);
            int b = Integer.parseInt(inputArr[1]);
            graph.get(a).add(towns[b]);
            graph.get(b).add(towns[a]);
        }
        DFS(1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    public static void DFS(int num){
        ch[num] = 1;
        dp[num][0] = 0;
        dp[num][1] = towns[num].peoples;

        for(Town t : graph.get(num)){
            if(ch[t.number]==0){
                DFS(t.number);
                dp[num][0] += Math.max(dp[t.number][0], dp[t.number][1]);
                dp[num][1] += dp[t.number][0];
            }
        }
    }

    static class Town{
        int number;
        int peoples;

        public Town(int number, int peoples){
            this.number = number;
            this.peoples = peoples;
        }
    }
}
