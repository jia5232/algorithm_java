package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1920 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int[] targets = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) targets[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        for (int target : targets) {
            System.out.println(exist(target));
        }
    }

    public static int exist(int n){
        int lt = 0, rt = arr.length-1;
        while (lt<=rt){
            int mid = (lt+rt) / 2;
            if(arr[mid]==n) return 1;
            else if(arr[mid]<n) lt = mid+1;
            else rt = mid-1;
        }
        return 0;
    }
}
