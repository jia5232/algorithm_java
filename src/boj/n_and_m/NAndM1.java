package boj.n_and_m;

import java.util.Scanner;

public class NAndM1 {
    static int n, m;
    static int[] pm; //순열의 결과
    static int[] ch; //사용 여부
    static int[] arr; //들어온 자연수 배열

    public static void permutation(int L){
        if(L==m){
            for (int i : pm) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        else{
            for (int i = 0; i < n; i++) {
                if(ch[i]==0){
                    ch[i] = 1;
                    pm[L] = arr[i];
                    permutation(L+1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i+1;
        ch = new int[n];
        pm = new int[m];
        permutation(0);
    }
}
