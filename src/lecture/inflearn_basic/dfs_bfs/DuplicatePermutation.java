package lecture.inflearn_basic.dfs_bfs;

//import java.util.Scanner;
//
//public class DuplicatePermutation {
//    static int[] pm;
//    static int n, m;
//
//    public static void DFS(int L){
//        if(L==m){
//            for (int i : pm) {
//                System.out.print(i+" ");
//            }
//            System.out.println();
//        }
//        else{
//            for (int i = 1; i <= n; i++) {
//                pm[L] = i;
//                DFS(L+1);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        m = sc.nextInt();
//        pm = new int[m];
//        DFS(0);
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DuplicatePermutation {
    static int n, m;
    static int[] pm;

    public static void DFS(int L){
        if(L==m){
            StringBuilder sb = new StringBuilder();
            for (int i : pm) {
                sb.append(i+" ");
            }
            System.out.println(sb);
        }
        else{
            for (int i = 1; i <= n; i++) {
                pm[L] = i;
                DFS(L+1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pm = new int[m];
        DFS(0);
    }
}