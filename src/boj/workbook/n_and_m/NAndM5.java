package boj.workbook.n_and_m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NAndM5 {
    static int n, m;
    static int[] pm, intArr, ch;
    static StringBuilder sb;

    public static void DFS(int L){
        if(L==m){
            for(int i : pm){
                sb.append(intArr[i]).append(" ");
            }
            sb.append("\n");
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
        ch = new int[n+1];
        sb = new StringBuilder();
        DFS(0);
        System.out.println(sb);
    }
}
