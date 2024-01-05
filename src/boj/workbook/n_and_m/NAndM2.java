package boj.workbook.n_and_m;

import java.util.Scanner;

public class NAndM2 {
    static int n, m;
    static int[] pm;
    static int[] ch;
    static int[] arr;
    public static void permutation(int L, int index){
        if(L==m){
            for (int i : pm) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        else{
            for (int i = index; i < n; i++) {
                if(ch[i] == 0){
                    ch[i] = 1;
                    pm[L] = arr[i];
                    permutation(L+1, i+1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];
        ch = new int[n];
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i+1;
        permutation(0, 0);
    }
}
