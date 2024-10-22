package boj.workbook.n_and_m;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NAndM7 {
    static int n, m;
    static int[] pm, intArr;
    static StringBuilder sb;

    public static void DFS(int L){
        if(L==m){
            for(int i : pm){
                sb.append(intArr[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 0; i < n; i++) {
                pm[L] = i;
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
        intArr = new int[n];
        inputArr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            intArr[i] = Integer.parseInt(inputArr[i]);
        }
        Arrays.sort(intArr);
        sb = new StringBuilder();
        DFS(0);
        System.out.println(sb);
    }
}
