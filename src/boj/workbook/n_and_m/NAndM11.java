package boj.workbook.n_and_m;

import java.util.Arrays;
import java.util.Scanner;

public class NAndM11 {
    static int n, m;
    static int[] arr;
    static int[] pm;
    static StringBuilder sb;

    public static void permutation(int L){
        if(L==m){
            for (int i : pm) {
                sb.append(i+" ");
            }
            sb.append("\n");
        }
        else{
            int t = -1;
            for (int i = 0; i < n; i++) {
                if(t != arr[i]){
                    pm[L] = arr[i];
                    permutation(L+1);
                    t = arr[i];
                }
            }
        }
    }

    public static void main(String[] args) {
        sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        pm = new int[m];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        permutation(0);
        System.out.println(sb);
    }
}
