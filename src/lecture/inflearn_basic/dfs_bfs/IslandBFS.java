package lecture.inflearn_basic.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class IslandBFS {
    static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n;
    static int answer = 0;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static Queue<Point> Q = new LinkedList<>();

    public static void BFS(int x, int y, int[][] board){
        Q.add(new Point(x, y));
        while (!Q.isEmpty()){
            Point tmp = Q.poll();
            for (int i = 0; i < 8; i++) {
                int nextX = tmp.x + dx[i];
                int nextY = tmp.y + dy[i];
                if(nextX>=0 && nextX<n && nextY>=0 && nextY<n && board[nextX][nextY]==1){
                    //보드 범위안에 들어오고, 디음 좌표 보드의 값이 1일 때만 뻗어나갈 수 있다.
                    board[nextX][nextY] = 0; //섬에서 뻗어나가는 지점을 0으로 만든다.
                    Q.add(new Point(nextX, nextY));
                }
            }
        }
    }

    public static void solution(int[][] board){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]==1){
                    answer++;
                    board[i][j] = 0;
                    BFS(i, j, board);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution(board);
        System.out.println(answer);
    }
}
