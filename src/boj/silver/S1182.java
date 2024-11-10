package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1182 {
    static int answer = 0;
    static int[] arr;
    static int N, S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        N = Integer.parseInt(inputArr[0]);
        S = Integer.parseInt(inputArr[1]);
        arr = new int[N];
        inputArr = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputArr[i]);
        }
        DFS(0, 0);
        if(S==0) answer--;
        System.out.println(answer);
    }

    public static void DFS(int depth, int sum){
        if(depth==N){
            if(sum==S) answer++;
            return;
        }

        DFS(depth+1, sum+arr[depth]);
        DFS(depth+1, sum);
    }
}
