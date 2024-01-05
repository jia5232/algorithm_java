package lecture.inflearn_basic.dfs_bfs;

//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class Tomato {
//    static class Point {
//        public int x, y;
//
//        public Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//    static int[] dx = {-1, 0, 1, 0}; //행
//    static int[] dy = {0, 1, 0, -1}; //열
//    static int[][] board, dis;
//    static int n, m; //n이 열, m이 행
//    static Queue<Point> Q = new LinkedList<>();
//
//    public static void BFS(){
//        while (!Q.isEmpty()){
//            Point tmp = Q.poll();
//            for (int i = 0; i < 4; i++) {
//                int nx = tmp.x + dx[i];
//                int ny = tmp.y + dy[i];
//                if(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny]==0){
//                    board[nx][ny] = 1;
//                    Q.add(new Point(nx, ny));
//                    dis[nx][ny] = dis[tmp.x][tmp.y]+1;
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        m = sc.nextInt();
//        n = sc.nextInt();
//        board = new int[n][m];
//        dis = new int[n][m];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                board[i][j] = sc.nextInt();
//                if(board[i][j]==1) Q.add(new Point(i, j));
//                //출발점이 여러개이면 BFS가 돌기 전에 출발점들을 큐에 미리 다 넣어둔다!
//            }
//        }
//        BFS();
//        boolean flag = true;
//        int answer = Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) { //board에 0이 있으면 모든 토마토를 익힐 수 없으므로 최대값 안찾아도 됨
//            for (int j = 0; j < m; j++) {
//                if(board[i][j]==0) flag=false;
//            }
//        }
//        if(flag){
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    answer = Math.max(answer, dis[i][j]);
//                }
//            }
//        }
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {
    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, dis;
    static int n, m;
    static Queue<Point> Q = new LinkedList<>();

    public static void BFS(){
        while (!Q.isEmpty()){
            Point tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = tmp.x + dx[i];
                int nextY = tmp.y + dy[i];
                if(nextX>=0 && nextX<n && nextY>=0 && nextY<m && board[nextX][nextY]==0){
                    board[nextX][nextY] = 1;
                    Q.add(new Point(nextX, nextY));
                    dis[nextX][nextY] = dis[tmp.x][tmp.y]+1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); //열
        n = Integer.parseInt(st.nextToken()); //행
        board = new int[n][m];
        dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==1) Q.add(new Point(i, j));
            }
        }

        BFS();
        boolean flag = true;
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j]==0) flag = false;
            }
        }

        if(flag){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(answer, dis[i][j]);
                }
            }
        }

        if(flag) System.out.println(answer);
        else System.out.println(-1);
    }
}