package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S1926 {
    static int n, m;
    static int[][] board, ch;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
        board = new int[n][m];
        ch = new int[n][m];
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(inputArr[j]);
            }
        }
        int number = 0;
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(ch[i][j]==0 && board[i][j]==1){
                    number++;
                    int size = BFS(i, j);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        System.out.println(number);
        System.out.println(maxSize);
    }

    public static int BFS(int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        ch[r][c] = 1;
        int answer = 0;
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            answer++;
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && board[nr][nc]==1 && ch[nr][nc]==0){
                    ch[nr][nc] = 1;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        return answer;
    }
}
