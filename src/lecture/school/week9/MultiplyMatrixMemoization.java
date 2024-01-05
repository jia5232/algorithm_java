package lecture.school.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MultiplyMatrixMemoization {
    static int[][] dy;
    static int recursion(int p[], int i, int j) {
        if (i == j) return 0;
        else if(dy[i][j] > 0) return dy[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int count = recursion(p, i, k) + recursion(p, k + 1, j) + p[i - 1] * p[k] * p[j];
            if (count < min) min = count;
        }
        return dy[i][j] = min;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N + 1];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            dy = new int[arr.length][arr.length];
            System.out.println(recursion(arr, 1, arr.length - 1));
        }
    }
}
