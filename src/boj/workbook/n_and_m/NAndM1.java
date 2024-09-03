package boj.workbook.n_and_m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NAndM1 {
    static int n, m;
    static int[] pm, ch;

    public static void DFS(int L){
        if(L==m){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < pm.length; i++) {
                sb.append(pm[i]).append(" ");
            }
            System.out.println(sb);
        } else {
            for (int i = 1; i <= n; i++) {
                if(ch[i]==0){
                    ch[i] = 1;
                    pm[L] = i;
                    DFS(L+1);
                    ch[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
        ch = new int[n+1];
        pm = new int[m];
        DFS(0);
    }
}
