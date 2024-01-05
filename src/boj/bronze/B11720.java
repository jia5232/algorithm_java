package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11720 { //숫자의 합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split("");
        int answer = 0;
        for(String s : arr) answer+=Integer.parseInt(s);
        System.out.println(answer);
    }
}
