package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G2589 {
    static int m, n;
    static char[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static int BFS(int r, int c){
        int[][] distance = new int[m][n];
        int[][] ch = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        ch[r][c] = 1;
        int maxDist = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                int cr = now[0];
                int cc = now[1];
                for (int j = 0; j < 4; j++) {
                    int nr = cr + dr[j];
                    int nc = cc + dc[j];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && board[nr][nc]=='L' && ch[nr][nc] ==0){
                        ch[nr][nc] = 1;
                        queue.add(new int[]{nr, nc});
                        distance[nr][nc] = distance[cr][cc] + 1;
                        maxDist = Math.max(maxDist, distance[nr][nc]);
                    }
                }
            }
        }
        return maxDist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        m = Integer.parseInt(inputArr[0]);
        n = Integer.parseInt(inputArr[1]);
        board = new char[m][n];
        for (int i = 0; i < m; i++) {
            inputArr = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                board[i][j] = inputArr[j].charAt(0);
            }
        }
        int maxLength = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]=='L'){
                    int level = BFS(i, j);
                    maxLength = Math.max(maxLength, level);
                }
            }
        }
        System.out.println(maxLength);
    }
}
