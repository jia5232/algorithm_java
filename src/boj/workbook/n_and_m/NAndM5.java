package boj.workbook.n_and_m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NAndM5 {
    static int n, m;
    static int[] pm, ch, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
        inputArr = br.readLine().split(" ");
        pm = new int[m];
        ch = new int[n];
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputArr[i]);
        }
        Arrays.sort(arr);
        DFS(0);
    }
    
    public static void DFS(int L){
        if(L==m){
            StringBuilder sb = new StringBuilder();
            for(int i : pm){
                sb.append(arr[i]).append(" ");
            }
            System.out.println(sb);
        } else {
            for (int i = 0; i < n; i++) {
                if(ch[i]==0){
                    ch[i] = 1;
                    pm[L] = i;
                    DFS(L+1);
                    ch[i] = 0;
                }
            }
        }
    }
}