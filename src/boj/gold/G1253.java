package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G1253 { //좋은 수 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int find = arr[i];
            int start = 0, end = n-1;
            while(start<end){
                if(arr[start]+arr[end]==find){
                    if(start!=i && end!=i){
                        answer++;
                        break;
                    }
                    else if(start==i) start++;
                    else if(end==i) end--;
                }
                else if(arr[start]+arr[end] < find) start++;
                else end--;
            }
        }
        System.out.println(answer);
        br.close();
    }
}