package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1940 { //주몽
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int answer = 0, start = 0, end = arr.length-1;
        while (start<end){
            if(arr[start]+arr[end]==m){
                answer++;
                start++;
                end--;
            }
            else if(arr[start]+arr[end] < m){
                start++;
            }
            else{
                end--;
            }
        }
        System.out.println(answer);
    }
}
