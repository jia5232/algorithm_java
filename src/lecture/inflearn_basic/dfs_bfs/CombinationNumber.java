package lecture.inflearn_basic.dfs_bfs;

import java.util.Scanner;

public class CombinationNumber {
    static int[][] dy = new int[35][35];

    public static int DFS(int n, int r){
        if(dy[n][r]>0) return dy[n][r]; //이미 구한값이면 구하지 않음

        if(n==r || r==0) return 1;
        else return dy[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
        //DFS(n-1, r-1) -> n이 참여 하는경우
        //DFS(n-1, r) -> n이 참여하지 않는 경우
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(DFS(n, r));
    }
}
