package boj.silver;

import java.io.*;
public class S15990 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dt = new int[N];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; ++i) {
            dt[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, dt[i]);
        }

        long[][] dp = new long[max + 1][4]; // 1, 2, 3으로 끝나는 경우
        int MOD = 1_000_000_009;

        // 각 숫자를 1, 2, 3으로만 만들 수 있는 경우의 수
        if (max >= 1) dp[1][1] = 1;
        if (max >= 2) dp[2][1] = 0; dp[2][2] = 1;
        if (max >= 3) dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;

        for (int i = 4; i <= max; ++i) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            long result = (dp[dt[i]][1] + dp[dt[i]][2] + dp[dt[i]][3]) % MOD;
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
