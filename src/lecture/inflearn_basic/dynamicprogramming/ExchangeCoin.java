package lecture.inflearn_basic.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ExchangeCoin {
    public static int n, m;
    public static int[] dy;

    public static int solution(int[] coins){
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j-coins[i]]+1);
            }
        }
        return dy[m];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        dy = new int[m+1];
        System.out.println(solution(arr));
    }
}
