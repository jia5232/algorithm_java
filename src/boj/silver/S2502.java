package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int d = Integer.parseInt(inputArr[0]);
        int k = Integer.parseInt(inputArr[1]);
        int[] dp = new int[d+1];
        for (int i = 1; i <= k/2; i++) { //첫째날 먹은 떡의 개수
            for (int j = 1; j <= k; j++) { //둘째날 먹은 떡의 개수
                dp[1] = i;
                dp[2] = j;
                for (int l = 3; l <= d; l++) {
                    dp[l] = dp[l-1] + dp[l-2];
                }
                if(dp[d] == k){
                    System.out.println(dp[1]);
                    System.out.println(dp[2]);
                    return;
                }
            }
        }
    }
}
