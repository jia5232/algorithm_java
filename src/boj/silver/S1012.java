package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1012 {
    static int n, m, k, answer;
    static int[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            String[] inputArr = br.readLine().split(" ");
            m = Integer.parseInt(inputArr[0]);
            n = Integer.parseInt(inputArr[1]);
            k = Integer.parseInt(inputArr[2]);
            board = new int[n][m];
            for (int i = 0; i < k; i++) {
                inputArr = br.readLine().split(" ");
                int x = Integer.parseInt(inputArr[0]);
                int y = Integer.parseInt(inputArr[1]);
                board[y][x] = 1;
            }
            answer = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(board[i][j]==1){
                        answer++;
                        DFS(i, j);
                    }
                }
            }
            System.out.println(answer);
        }
    }

    public static void DFS(int r, int c){
        board[r][c] = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && board[nr][nc]==1){
                DFS(nr, nc);
            }
        }
    }
}
