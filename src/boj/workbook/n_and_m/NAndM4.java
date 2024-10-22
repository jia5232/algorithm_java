package boj.workbook.n_and_m;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NAndM4 {
    static int n, m;
    static int[] pm;
    static StringBuilder sb;

    public static void DFS(int L, int s){
        if(L==m){
            for(int i : pm){
                sb.append(i).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = s; i <= n; i++) {
                pm[L] = i;
                DFS(L+1, i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
        pm = new int[m];
        sb = new StringBuilder();
        DFS(0, 1);
        System.out.println(sb);
    }
}
