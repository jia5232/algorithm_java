package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S10451 {
    static int n, answer;
    static int[] arr, ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            ch = new int[n+1];
            String[] inputArr = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(inputArr[i-1]);
            }
            answer = 0;
            for (int i = 1; i <= n; i++) {
                if(ch[i]==0){
                    DFS(i);
                }
            }
            System.out.println(answer);
        }
    }

    public static void DFS(int n){
        if(ch[n]==1){
            answer++;
            return;
        }

        ch[n] = 1;
        DFS(arr[n]);
    }
}
