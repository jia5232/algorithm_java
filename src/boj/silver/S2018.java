package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2018 { //수들의 합 5
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 1; // n 자기자신
        int start = 1, end = 1, tmp = 1;
        while (start <= n/2){
            if(tmp==n){
                answer++;
                end++;
                tmp += end;
            }
            else if(tmp>n){
                tmp -= start;
                start++;
            }
            else{
                end++;
                tmp += end;
            }
        }
        System.out.println(answer);
    }
}
