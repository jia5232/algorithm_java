package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S17086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int m = Integer.parseInt(inputArr[1]);
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(inputArr[j]);
            }
        }
        int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
        int max = 0;
        Queue<int[]> queue;
        int[][] ch;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j]==0){
                    queue = new LinkedList<>();
                    ch = new int[n][m];
                    queue.add(new int[]{i, j});
                    ch[i][j] = 1;
                    int level = 0;
                    boolean isFound = false;
                    while (!queue.isEmpty()){
                        if(isFound) break;
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int[] now = queue.poll();
                            if(board[now[0]][now[1]]==1){
                                isFound = true;
                                break;
                            }
                            for (int l = 0; l < 8; l++) {
                                int nr = now[0] + dr[l];
                                int nc = now[1] + dc[l];
                                if(nr>=0 && nr<n && nc>=0 && nc<m && ch[nr][nc]==0){
                                    ch[nr][nc] = 1;
                                    queue.add(new int[]{nr, nc});
                                }
                            }
                        }
                        if(!isFound) level++;
                    }
                    max = Math.max(max, level);
                }
            }
        }
        System.out.println(max);
    }
}
