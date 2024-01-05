package boj.workbook.n_and_m;

import java.util.Scanner;

public class NAndM4 {
    static int n, m;
    static int[] pm;
    static int[] arr;
    static StringBuilder sb;

    public static void permutation(int L, int index){
        if(L==m){
            for (int i : pm) {
                sb.append(i+" ");
            }
            sb.append("\n");
        }
        else{
            for (int i = index; i < n; i++) {
                pm[L] = arr[i];
                permutation(L+1, i);
            }
        }
    }

    public static void main(String[] args) {
        sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i+1;
        permutation(0, 0);
        System.out.println(sb);
    }
}
