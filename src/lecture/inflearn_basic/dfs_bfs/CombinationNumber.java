package lecture.inflearn_basic.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CombinationNumber {
    static int[][] dy = new int[35][35];

    public static int DFS(int n, int r){
        if(dy[n][r]>0) return dy[n][r]; //이미 구한값이면 구하지 않음

        if(n==r || r==0) return 1;
        else return DFS(n-1, r-1) + DFS(n-1, r);
        //DFS(n-1, r-1) -> n이 참여 하는경우
        //DFS(n-1, r) -> n이 참여하지 않는 경우
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        System.out.println(DFS(n, r));
    }
}