package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int s = Integer.parseInt(inputArr[1]);
        inputArr = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputArr[i]);
        }
        int left = 0, right = 0, sum = 0;
        int min = Integer.MAX_VALUE;
        while (right<n){
            sum += arr[right];
            right++;

            while(sum>=s){
                min = Math.min(min, right-left);
                sum -= arr[left];
                left++;
            }
        }
        if(min==Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(min);
    }
}
