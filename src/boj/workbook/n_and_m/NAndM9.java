package boj.workbook.n_and_m;

import java.util.*;

public class NAndM9 {
    static int n, m;
    static int[] arr;
    static int[] pm;
    static int[] ch;

    static List<String> list;

    public static void permutation(int L){
        if(L==m){
            String tmp = "";
            for (int i : pm) {
                tmp+=(i+" ");
            }
            list.add(tmp);
        }
        else{
            int t = -1;
            for (int i = 0; i < n; i++) {
                if(ch[i]==0 && t != arr[i]){
                    ch[i] = 1;
                    pm[L] = arr[i];
                    permutation(L+1);
                    ch[i] = 0;
                    t = arr[i];
                }
            }
        }
    }

    public static void main(String[] args) {
        list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];
        ch = new int[n];
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        permutation(0);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
