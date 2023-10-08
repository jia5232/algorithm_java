package lecture.inflearn_basic.dfs_bfs;

import java.util.Scanner;

public class DuplicatePermutation {
    static int[] pm;
    static int n, m;

    public static void DFS(int L){
        if(L==m){
            for (int i : pm) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        else{
            for (int i = 1; i <= n; i++) {
                pm[L] = i;
                DFS(L+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];
        DFS(0);
    }
}
