package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G1937 {
    static int n, max = 0;
    static int[][] board, dp;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        dp = new int[n][n];
        String[] inputArr;
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(inputArr[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int pathLength = DFS(i, j); //각 좌표에서 시작하는 최대 경로
                max = Math.max(max, pathLength);
            }
        }
        System.out.println(max);
    }

    public static int DFS(int r, int c){
        if(dp[r][c] != 0){
            return dp[r][c];
        }

        dp[r][c] = 1;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<n && board[r][c]<board[nr][nc]){
                dp[r][c] = Math.max(dp[r][c], DFS(nr, nc)+1);
            }
        }

        return dp[r][c];
    }
}
