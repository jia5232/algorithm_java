package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S21736 {
    static int n, m;
    static char[][] board;
    static int[][] ch;
    static int answer;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void DFS(int r, int c){
        if(board[r][c]=='P'){
            answer++;
        }

        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];
            if(nextR>=0 && nextR<n && nextC>=0 && nextC<m && ch[nextR][nextC]==0 && board[nextR][nextC]!='X'){
                ch[nextR][nextC] = 1;
                DFS(nextR, nextC);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
        board = new char[n][m];
        ch = new int[n][m];
        answer = 0;
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = inputArr[j].charAt(0);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j]=='I'){
                    ch[i][j] = 1;
                    DFS(i, j);
                }
            }
        }
        if(answer==0) System.out.println("TT");
        else System.out.println(answer);
    }
}
