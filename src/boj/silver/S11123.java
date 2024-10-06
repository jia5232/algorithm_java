package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S11123 {
    static int n, m;
    static char[][] board;
    static int[][] ch;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            String[] inputArr = br.readLine().split(" ");
            n = Integer.parseInt(inputArr[0]);
            m = Integer.parseInt(inputArr[1]);
            board = new char[n][m];
            for (int i = 0; i < n; i++) {
                inputArr = br.readLine().split("");
                for (int j = 0; j < m; j++) {
                    board[i][j] = inputArr[j].charAt(0);
                }
            }
            ch = new int[n][m];
            int answer = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(board[i][j]=='#' && ch[i][j]==0){
                        answer++;
                        DFS(i, j);
                    }
                }
            }
            System.out.println(answer);
        }
    }

    public static void DFS(int r, int c){
        ch[r][c] = 1;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && board[nr][nc]=='#' && ch[nr][nc]==0){
                DFS(nr, nc);
            }
        }
    }
}
