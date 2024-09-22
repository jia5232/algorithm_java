package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G7576 {
    static int n, m;
    static int[][] board, ch;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        m = Integer.parseInt(inputArr[0]);
        n = Integer.parseInt(inputArr[1]);
        board = new int[n][m];
        int tomatoes = 0;
        int leap = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(inputArr[j]);
                if(board[i][j]==0) tomatoes++;
                else if(board[i][j]==1){
                    queue.add(new int[]{i, j});
                }
            }
        }
        int time = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nr = now[0] + dr[j];
                    int nc = now[1] + dc[j];
                    if(nr>=0 && nr<n && nc>=0 && nc<m && board[nr][nc]==0){
                        board[nr][nc] = 1;
                        queue.add(new int[]{nr, nc});
                        leap++;
                    }
                }
            }
            time++;
        }
        if(tomatoes==leap) System.out.println(time-1);
        else System.out.println(-1);
    }
}
