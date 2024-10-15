package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S14940 {
    static int[][] board, ch, answer;
    static int[] start;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
        board = new int[n][m];
        answer = new int[n][m];
        start = new int[2];
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(inputArr[j]);
                if(board[i][j]==2){
                    start[0] = i;
                    start[1] = j;
                }
                if(board[i][j]==1){
                    answer[i][j] = -1;
                }
            }
        }
        BFS(start[0], start[1]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void BFS(int r, int c){
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        ch = new int[n][m];
        ch[r][c] = 1;
        answer[r][c] = 0;

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            int cr = now[0];
            int cc = now[1];
            for (int j = 0; j < 4; j++) {
                int nr = now[0] + dr[j];
                int nc = now[1] + dc[j];
                if(nr>=0 && nr<n && nc>=0 && nc<m && ch[nr][nc]==0 && board[nr][nc]==1){
                    ch[nr][nc] = 1;
                    answer[nr][nc] = answer[cr][cc]+1;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }
}
