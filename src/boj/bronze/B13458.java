package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] inputArr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputArr[i]);
        }
        inputArr = br.readLine().split(" ");
        int b = Integer.parseInt(inputArr[0]);
        int c = Integer.parseInt(inputArr[1]);
        long answer = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i]>0){
                answer++;
                arr[i] -= b;
            }
            if(arr[i]>0){
                if(arr[i]%c==0){
                    answer += arr[i]/c;
                }else{
                    answer += (arr[i]/c + 1);
                }
            }
        }
        System.out.println(answer);
    }
}
