package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S17391 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int m = Integer.parseInt(inputArr[1]);
        int[][] board = new int[n][m];
        int[][] ch = new int[n][m];
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(inputArr[j]);
            }
        }
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, board[0][0]});
        ch[0][0] = 1;
        int[] dr = { 1, 0};
        int[] dc = { 0, 1};
        boolean isFound = false;
        while (!queue.isEmpty()){
            if(isFound) break;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                int cr = now[0];
                int cc = now[1];
                int cItem = now[2];
                if(cr==n-1 && cc==m-1){
                    isFound = true;
                    break;
                }
                for (int j = 0; j < 2; j++) {
                    for (int k = 1; k <= cItem; k++) {
                        int nr = cr + dr[j]*k;
                        int nc = cc + dc[j]*k;
                        if(nr>=0 && nr<n && nc>=0 && nc<m && ch[nr][nc]==0){
                            ch[nr][nc] = 1;
                            queue.add(new int[]{nr, nc, board[nr][nc]});
                        }
                    }
                }
            }
            if(!isFound) answer++;
        }
        System.out.println(answer);
    }
}
