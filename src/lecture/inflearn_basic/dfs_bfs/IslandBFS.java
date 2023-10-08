package lecture.inflearn_basic.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IslandBFS {
    static int n;
    static int answer = 0;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static Queue<Point> Q = new LinkedList<>();
    public static void BFS(int x, int y, int[][] board){
        Q.add(new Point(x, y));
        while (!Q.isEmpty()){
            Point pos = Q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]==1){
                    //보드 범위안에 들어오고, 디음 좌표 보드의 값이 1일 때만 뻗어나갈 수 있다.
                    board[nx][ny] = 0; //섬에서 뻗어나가는 지점을 0으로 만든다.
                    Q.add(new Point(nx, ny));
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        solution(arr);
        System.out.println(answer);
    }
}
