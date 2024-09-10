package boj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class G4811 {
    // 메모이제이션 배열로 (whole pills, half pills) 상태에 대한 결과를 저장합니다.
    static long[][] dp = new long[31][31];

    // 유효한 문자열의 수를 계산하는 함수
    static long countSequences(int whole, int half) {
        // 기저 사례: 알약이 더 이상 없을 때, 유효한 문자열은 하나 (아무 것도 하지 않음)
        if (whole == 0 && half == 0) {
            return 1;
        }

        // 이전에 이 상태를 계산했으면, 그 결과를 반환합니다.
        if (dp[whole][half] != 0) {
            return dp[whole][half];
        }

        long result = 0;

        // 남은 알약이 있으면, 하나를 반으로 쪼갭니다.
        if (whole > 0) {
            result += countSequences(whole - 1, half + 1);
        }

        // 반쪽 알약이 있으면, 하나를 섭취합니다.
        if (half > 0) {
            result += countSequences(whole, half - 1);
        }

        // 결과를 메모이제이션 배열에 저장합니다.
        dp[whole][half] = result;

        return result;
    }

    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            // 한 줄의 입력을 받아서 정수로 변환
            int N = Integer.parseInt(br.readLine());

            // 입력이 0이면 종료
            if (N == 0) break;

            // 메모이제이션 배열을 0으로 초기화
            dp = new long[31][31];

            // N개의 전체 알약과 0개의 반쪽 알약으로 시작하는 유효한 문자열의 수 계산
            long result = countSequences(N, 0);

            // 결과 출력
            System.out.println(result);
        }

        br.close();
    }
}
