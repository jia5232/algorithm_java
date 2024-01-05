package lecture.school.week9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class MultiplyMatrixDP {
    static int[][] dp;
    static int[][] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] d = new int[n + 1];

            dp = new int[n + 1][n + 1];
            p = new int[n + 1][n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j <= n; j++) {
                d[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= n; j++) {
                dp[j][j] = 0;
                p[j][j] = 0;
            }

            int answer = cmm(d, n);

            System.out.println();
            System.out.println(answer);
        }
    }

    static int cmm(int[] d, int n) {
        for (int diagonal = 1; diagonal <= n - 1; diagonal++) {
            for (int i = 1; i <= n - diagonal; i++) {
                int j = i + diagonal;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int temp = dp[i][k] + dp[k + 1][j] + d[i - 1] * d[k] * d[j];
                    if (temp < dp[i][j]) {
                        dp[i][j] = temp;
                        p[i][j] = k;
                    }
                }
            }
        }
        order(1, n);
        return dp[1][n];
    }

    static void order(int i, int j) {
        int k = p[i][j];
        if (i == j) {
            System.out.print("M" + i);
        } else {
            System.out.print("(");
            order(i, k);
            order(k + 1, j);
            System.out.print(")");
        }
    }
}


