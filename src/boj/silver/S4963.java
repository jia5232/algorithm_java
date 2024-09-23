package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S4963 {
    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int w, h;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String[] inputArr = br.readLine().split(" ");
            w = Integer.parseInt(inputArr[0]);
            h = Integer.parseInt(inputArr[1]);
            if(w==0 && h==0) break;
            board = new int[h][w];
            for (int i = 0; i < h; i++) {
                inputArr = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    board[i][j] = Integer.parseInt(inputArr[j]);
                }
            }
            int answer = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(board[i][j]==1){
                        answer++;
                        BFS(i, j);
                    }
                }
            }
            System.out.println(answer);
        }
    }

    public static void BFS(int r, int c){
        int[][] ch = new int[h][w];
        ch[r][c] = 1;
        board[r][c] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                for (int j = 0; j < 8; j++) {
                    int nr = now[0] + dr[j];
                    int nc = now[1] + dc[j];
                    if(nr>=0 && nr<h && nc>=0 && nc<w && ch[nr][nc]==0 && board[nr][nc]==1){
                        ch[nr][nc] = 1;
                        board[nr][nc] = 0;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
    }
}
