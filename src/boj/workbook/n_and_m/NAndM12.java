package boj.workbook.n_and_m;

import java.util.Arrays;
import java.util.Scanner;

public class NAndM12 {
    static int n, m;
    static int[] arr;
    static int[] pm;
    static StringBuilder sb;

    public static void permutaion(int L, int index){
        if(L==m){
            for (int i : pm) {
                sb.append(i+" ");
            }
            sb.append("\n");
        }
        else{
            int t = -1;
            for (int i = index; i < n; i++) {
                if(t != arr[i]){
                    pm[L] = arr[i];
                    permutaion(L+1, i);
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
        permutaion(0, 0);
        System.out.println(sb);
    }
}
