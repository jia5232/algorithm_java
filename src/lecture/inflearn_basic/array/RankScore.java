package lecture.inflearn_basic.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RankScore {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[num];
        Integer[] sortedArr = new Integer[num];
        String[] inputArr = br.readLine().split(" ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(inputArr[i]);
            sortedArr[i] = Integer.parseInt(inputArr[i]);
        }
        Arrays.sort(sortedArr, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            for (int j = 0; j < num; j++) {
                if(i==sortedArr[j]){
                    sb.append(j+1).append(" ");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}