package boj.workbook.n_and_m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NAndM3 {
    static int n, m;
    static int[] pm, arr;
    static StringBuilder sb;

    public static void DFS(int L){
        if(L==m){
            for(int i : pm){
                sb.append(i+" ");
            }
            sb.append('\n');
        } else {
            for (int i = 0; i < n; i++) {
                pm[L] = arr[i];
                DFS(L+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
        pm = new int[m];
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        sb = new StringBuilder();
        DFS(0);
        System.out.println(sb.toString());
    }
}
