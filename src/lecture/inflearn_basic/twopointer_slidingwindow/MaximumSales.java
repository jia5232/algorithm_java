package lecture.inflearn_basic.twopointer_slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumSales {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        int answer = Integer.MIN_VALUE, tmp = 0;
        for (int i = 0; i < k; i++) {
            tmp += arr[i];
        }
        answer = Math.max(answer, tmp);
        for (int i = k; i < n; i++) {
            tmp -= arr[i-k];
            tmp += arr[i];
            answer = Math.max(answer, tmp);
        }
        System.out.println(answer);
    }
}