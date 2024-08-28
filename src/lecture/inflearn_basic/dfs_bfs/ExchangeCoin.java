package lecture.inflearn_basic.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class ExchangeCoin {
    static int n, m;
    static Integer[] coins;

    static int answer = Integer.MAX_VALUE;

    public static void DFS(int sum, int L){
        if(L>answer) return;
        if(sum>m) return;

        if(sum==m){
            answer = Math.min(answer, L);
        }
        for(int i : coins){
            DFS(sum+i, L+1);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] inputArr = br.readLine().split(" ");
        coins = new Integer[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(inputArr[i]);
        }
        m = Integer.parseInt(br.readLine());
        Arrays.sort(coins, Collections.reverseOrder());
        DFS(0, 0);
        System.out.println(answer);
    }
}