package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S2468 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int[][] board = new int[n][n];
        int maxHeight = 0;
        String[] inputArr;
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(inputArr[j]);
                maxHeight = Math.max(maxHeight, board[i][j]);
            }
        }
        int max = 1;
        for (int h = 0; h <= maxHeight; h++) {
            int[][] ch = new int[n][n];
            Queue<int[]> queue = new LinkedList<>();
            int safeArea = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(board[i][j]>h && ch[i][j]==0){
                        safeArea++;
                        queue.add(new int[]{i, j});
                        ch[i][j] = 1;
                        while (!queue.isEmpty()){
                            int[] now = queue.poll();
                            for (int k = 0; k < 4; k++) {
                                int nr = now[0] + dr[k];
                                int nc = now[1] + dc[k];
                                if(nr>=0 && nr<n && nc>=0 && nc<n && board[nr][nc]>h && ch[nr][nc]==0){
                                    ch[nr][nc] = 1;
                                    queue.add(new int[]{nr, nc});
                                }
                            }
                        }
                    }
                }
            }
            max = Math.max(max, safeArea);
        }
        System.out.println(max);
    }
}
