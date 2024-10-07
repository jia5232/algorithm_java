package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S11370 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m, n;
        while (true){
            String[] inputArr = br.readLine().split(" ");
            m = Integer.parseInt(inputArr[0]);
            n = Integer.parseInt(inputArr[1]);
            if(n==0 && m==0) break;
            char[][] board = new char[n][m];
            int[][] ch = new int[n][m];
            for (int i = 0; i < n; i++) {
                inputArr = br.readLine().split("");
                for (int j = 0; j < m; j++) {
                    board[i][j] = inputArr[j].charAt(0);
                }
            }
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(board[i][j]=='S'){
                        queue.add(new int[]{i, j});
                        ch[i][j] = 1;
                    }
                }
            }
            while (!queue.isEmpty()){
                int[] now = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = now[0] + dr[i];
                    int nc = now[1] + dc[i];
                    if(nr>=0 && nr<n && nc>=0 && nc<m && ch[nr][nc]==0 && board[nr][nc]=='T'){
                        ch[nr][nc] = 1;
                        queue.add(new int[]{nr, nc});
                        board[nr][nc] = 'S';
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }
    }
}
