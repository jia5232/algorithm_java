package boj.workbook.n_and_m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NAndM6 {
    static int n, m;
    static int[] pm, intArr;
    static StringBuilder sb;

    public static void DFS(int L, int s){
        if(L==m){
            for(int i : pm){
                sb.append(intArr[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for(int i=s; i<n; i++){
                pm[L] = i;
                DFS(L+1, i+1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
        inputArr = br.readLine().split(" ");
        intArr = new int[n];
        for (int i = 0; i < n; i++) {
            intArr[i] = Integer.parseInt(inputArr[i]);
        }
        Arrays.sort(intArr);
        pm = new int[m];
        sb = new StringBuilder();
        DFS(0, 0);
        System.out.println(sb);
    }
}
