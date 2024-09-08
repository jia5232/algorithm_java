package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S11055 {
    static int n;
    static int[] arr, dy;

    public static int solution(){
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if(arr[j]<arr[i] && dy[j]+arr[i]>dy[i]){
                    dy[i] = Math.max(dy[i], dy[j]+arr[i]);
                }
            }
        }
        return Arrays.stream(dy).max().getAsInt();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dy = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            dy[i] = arr[i];
        }
        System.out.println(solution());
    }
}
