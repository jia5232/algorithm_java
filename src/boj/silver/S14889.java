package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S14889 {
    static int n, answer = Integer.MAX_VALUE;
    static int[][] board;
    static int[] ch;

    public static void DFS(int L, int s){
        if(L==n/2){
            int start = 0;
            int link = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    if(ch[i]==1 && ch[j]==1){
                        start += board[i][j];
                        start += board[j][i];
                    }
                    else if(ch[i]==0 && ch[j]==0){
                        link += board[i][j];
                        link += board[j][i];
                    }
                }
            }
            answer = Math.min(answer, Math.abs(start-link));
            return;
        }else{
            for (int i = s; i < n; i++) {
                if(ch[i]==0){
                    ch[i] = 1;
                    DFS(L+1, i+1);
                    ch[i] = 0;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        ch = new int[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0, 0);
        System.out.println(answer);
    }
}