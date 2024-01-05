package boj.n_and_m;

import java.util.Arrays;
import java.util.Scanner;

public class NAndM6 {
    static int n, m;
    static int[] arr;
    static int[] ch;
    static int[] pm;
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
                if(ch[i]==0){
                    ch[i] = 1;
                    pm[L] = arr[i];
                    permutation(L+1, i+1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];
        ch = new int[n];
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        permutation(0, 0);
        System.out.println(sb);
    }
}
