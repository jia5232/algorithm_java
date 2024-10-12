package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S18422 {
    static int n, m;
    static char[][] board;
    static int[][] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
        board = new char[n][m];
        ch = new int[n][m];
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = inputArr[j].charAt(0);
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j]=='*' && ch[i][j]==0){
                    answer++;
                    BFS(i, j);
                }
            }
        }
        System.out.println(answer);
    }

    public static void BFS(int r, int c){
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        ch[r][c] = 1;
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && board[nr][nc]=='*' && ch[nr][nc]==0){
                    ch[nr][nc] = 1;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }
}
