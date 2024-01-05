package lecture.inflearn_basic.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MazeShortestPath {
    static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1, 0, 1, 0}; //행
    static int[] dy = {0, 1, 0, -1}; //열
    static int[][] board, dis;

    public static void BFS(int x, int y){
        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(x, y));
        board[x][y] = 1;
        while (!Q.isEmpty()){
            Point tmp = Q.poll();
            if(tmp.x==7 && tmp.y==7) break;

            for (int i = 0; i < 4; i++) {
                int nextX = tmp.x + dx[i];
                int nextY = tmp.y + dy[i];
                if(nextX>=1 && nextX<=7 && nextY>=1 && nextY<=7 && board[nextX][nextY]==0){
                    board[nextX][nextY] = 1;
                    Q.add(new Point(nextX, nextY));
                    dis[nextX][nextY] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        dis = new int[8][8];
        board = new int[8][8];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 1; i <= 7; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 7; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        BFS(1, 1);
        if(dis[7][7]==0) System.out.println(-1);
        else System.out.println(dis[7][7]);
    }
}