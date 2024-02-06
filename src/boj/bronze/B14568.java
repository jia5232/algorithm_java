package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 2; i <= n; i+=2) {
            for (int j = 1; j <= n-i; j++) {
                int k = n-i-j;
                if(k >= j+2) answer++;
            }
        }
        System.out.println(answer);
    }
}
