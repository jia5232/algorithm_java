package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int k = Integer.parseInt(inputArr[1]);
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int[] dy = new int[k+1];
        dy[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= k; j++) {
                dy[j] += dy[j-coins[i]];
            }
        }
        System.out.println(dy[k]);
    }
}
