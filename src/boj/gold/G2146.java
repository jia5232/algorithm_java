package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class G2146 {
    static int n;
    static int[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        String[] inputArr;
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(inputArr[j]);
            }
        }
        int cnt = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]==1){
                    makeBoardAnotherNum(i, j, cnt);
                    cnt++;
                }
            }
        }
        ArrayList<int[]> startPoints = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]>0){
                    boolean isAvailable = false;
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if(nr>=0 && nr<n && nc>=0 && nc<n && board[nr][nc]==0){
                            isAvailable = true;
                        }
                    }
                    if(isAvailable){
                        startPoints.add(new int[]{i, j});
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int[] start : startPoints){
            int startSpace = board[start[0]][start[1]];
            int length = BFS(startSpace, start[0], start[1]);
            if(length>0){
                min = Math.min(min, length);
            }
        }
        System.out.println(min-1);
    }

    public static int BFS(int start, int r, int c){
        int[][] ch = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();
        ch[r][c] = 1;
        queue.add(new int[]{r, c});
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                int cr = now[0];
                int cc = now[1];
                if(board[cr][cc]>0 && board[cr][cc]!=start){
                    return level;
                }
                for (int j = 0; j < 4; j++) {
                    int nr = now[0] + dr[j];
                    int nc = now[1] + dc[j];
                    if(nr>=0 && nr<n && nc>=0 && nc<n && ch[nr][nc]==0 && board[nr][nc]!=start){
                        ch[nr][nc] = 1;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void makeBoardAnotherNum(int r, int c, int num){
        int[][] ch = new int[n][n];
        ch[r][c] = 1;
        board[r][c] = num;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<n && board[nr][nc]==1){
                    board[nr][nc] = num;
                    ch[nr][nc] = 1;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }
}
