package lecture.inflearn_basic.twopointer_slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfNaturalNumber {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n/2+1];
        for (int i = 0; i < n / 2 + 1; i++) {
            arr[i] = i+1;
        }
        int lt = 0, rt = 0, answer = 0;
        while (rt<arr.length){
            int tmp = 0;
            for (int i = lt; i <= rt; i++) {
                tmp += arr[i];
            }
            if(tmp==n){
                answer++;
                lt++;
            }else if(tmp<n){
                rt++;
            }else{
                lt++;
            }
        }
        System.out.println(answer);
    }
}