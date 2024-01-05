package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G10986 { //나머지 합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] S = new long[n];
        long[] C = new long[m];

        long answer = 0;

        st = new StringTokenizer(br.readLine());
        S[0] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n; i++) {
            S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            long remainder = S[i] % m;
            if (remainder == 0) answer++;
            C[(int) remainder]++;
        }

        for (int i = 0; i < m; i++) {
            if (C[i] > 1) {
                answer += (C[i] * (C[i] - 1) / 2);
            }
        }

        System.out.println(answer);
    }
}
