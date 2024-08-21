package lecture.inflearn_basic.hashmap_treeset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KNum {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int k = Integer.parseInt(inputArr[1]);
        int[] arr = new int[n];
        inputArr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputArr[i]);
        }
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int l = j+1; l < n; l++) {
                    int num = arr[i]+arr[j]+arr[l];
                    set.add(num);
                }
            }
        }

        int answer = -1;
        int cnt = 0;
        for (int i : set) {
            cnt++;
            if(cnt == k){
                answer = i;
            }
        }
        System.out.println(answer);
    }
}
