package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S1743 {
    static int n, m, k;
    static int[][] board, ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
        k = Integer.parseInt(inputArr[2]);
        board = new int[n][m];
        ch = new int[n][m];
        for (int i = 0; i < k; i++) {
            inputArr = br.readLine().split(" ");
            int r = Integer.parseInt(inputArr[0])-1;
            int c = Integer.parseInt(inputArr[1])-1;
            board[r][c] = 1;
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j]==1){
                    int size = BFS(i, j);
                    answer = Math.max(answer, size);
                }
            }
        }
        System.out.println(answer);
    }

    public static int BFS(int r, int c){
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        ch[r][c] = 1;
        int size = 0;
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            size++;
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && ch[nr][nc]==0 && board[nr][nc]==1){
                    ch[nr][nc] = 1;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        return size;
    }
}
