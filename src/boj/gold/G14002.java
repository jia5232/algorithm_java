package boj.gold;

import java.io.*;
import java.util.*;

public class G14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] dp = new int[N];
        int[] prev = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 1); // 자기 자신만 포함하는 경우 LIS 길이는 1
        Arrays.fill(prev, -1); // 경로 추적을 위한 배열을 -1로 초기화

        int maxLength = 1;
        int lastIndex = 0;

        // LIS 구하는 DP 과정
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j; // 경로 추적을 위해 이전 인덱스 저장
                }
            }
            // 가장 긴 부분 수열의 길이와 마지막 원소 인덱스 갱신
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                lastIndex = i;
            }
        }

        // 결과 출력
        System.out.println(maxLength); // 가장 긴 증가하는 부분 수열의 길이 출력

        // 경로 추적하여 LIS 수열 출력
        List<Integer> lis = new ArrayList<>();
        while (lastIndex != -1) {
            lis.add(A[lastIndex]);
            lastIndex = prev[lastIndex];
        }
        Collections.reverse(lis); // 수열을 역순으로 추적했으므로, 다시 뒤집어야 함

        for (int num : lis) {
            System.out.print(num + " ");
        }
    }
}