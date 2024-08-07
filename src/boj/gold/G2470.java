package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputArr = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(inputArr[i]);

        int[] answer = new int[2];
        int minDiff = Integer.MAX_VALUE;
        int left = 0;
        int right = n-1;

        Arrays.sort(arr);

        while (left<right){
            int sum = arr[left] + arr[right];

            if(Math.abs(sum)<minDiff){
                minDiff = Math.abs(sum);
                answer[0] = arr[left];
                answer[1] = arr[right];
            }

            if(sum<0){
                left++;
            } else{
                right--;
            }
        }
        System.out.print(answer[0]+" "+answer[1]);
    }
}
