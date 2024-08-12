package lecture.inflearn_basic.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BiggerNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) arr[i] = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);
        for (int i = 1; i < num; i++) {
            if(arr[i-1]<arr[i]){
                sb.append(" ").append(arr[i]);
            }
        }
        System.out.println(sb);
    }
}