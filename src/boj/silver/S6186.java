package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S6186 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int m = Integer.parseInt(inputArr[1]);
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        char[][] board = new char[n][m];
        int[][] ch = new int[n][m];
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = inputArr[j].charAt(0);
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j]=='#' && ch[i][j]==0){
                    answer++;
                    Queue<int[]> queue = new LinkedList<>();
                    ch[i][j] = 1;
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()){
                        int[] now = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nr = now[0] + dr[k];
                            int nc = now[1] + dc[k];
                            if(nr>=0 && nr<n && nc>=0 && nc<m && board[nr][nc]=='#' && ch[nr][nc]==0){
                                ch[nr][nc] = 1;
                                queue.add(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
