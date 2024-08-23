package lecture.inflearn_basic.sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Kids {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputArr = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputArr[i]);
        }
        int[] copiedArr = arr.clone(); //깊은복사
        Arrays.sort(arr);
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(arr[i]!=copiedArr[i]) answer.add(i+1);
        }
        for(int i : answer){
            System.out.print(i+" ");
        }
    }
}