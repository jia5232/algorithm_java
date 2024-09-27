package boj.silver;

import java.io.*;
import java.util.*;

public class S13565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int m = Integer.parseInt(inputArr[1]);
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int[][] board = new int[n][m];
        int[][] ch = new int[n][m];
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(inputArr[j]);
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean isFound = false;
        for (int i = 0; i < m; i++) {
            if(board[0][i]==0) queue.add(new int[]{0, i});
            ch[0][i] = 1;
        }
        while (!queue.isEmpty()){
            if(isFound) break;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                if(now[0]==n-1){
                    isFound = true;
                    break;
                }
                for (int j = 0; j < 4; j++) {
                    int nr = now[0] + dr[j];
                    int nc = now[1] + dc[j];
                    if(nr>=0 && nr<n && nc>=0 && nc<m && ch[nr][nc]==0 && board[nr][nc]==0){
                        ch[nr][nc] = 1;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
        if(isFound) System.out.println("YES");
        else System.out.println("NO");
    }
}
