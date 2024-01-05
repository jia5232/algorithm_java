package lecture.inflearn_basic.dfs_bfs;

//import java.util.Scanner;
//
//public class IslandDFS {
//    static int n;
//    static int answer = 0;
//    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
//    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
//
//    public static void DFS(int x, int y, int[][] board){
//        for (int i = 0; i < 8; i++) {
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//            if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]==1){
//                //보드 범위안에 들어오고, 디음 좌표 보드의 값이 1일 때만 뻗어나갈 수 있다.
//                board[nx][ny] = 0; //섬에서 뻗어나가는 지점을 0으로 만든다.
//                DFS(nx, ny, board);
//            }
//        }
//    }
//
//    public static void solution(int[][] board){
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (board[i][j]==1){ //섬을 발견
//                    answer++;
//                    board[i][j] = 0; //섬의 출발점을 0으로 만든다.
//                    DFS(i, j, board);
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        int[][] arr = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                arr[i][j] = sc.nextInt();
//            }
//        }
//        solution(arr);
//        System.out.println(answer);
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IslandDFS {
    static int n;
    static int answer = 0;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void DFS(int x, int y, int[][] board){
        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            //보드 범위안에 들어오고, 디음 좌표 보드의 값이 1일 때만 뻗어나갈 수 있다.
            if(nextX>=0 && nextX<n && nextY>=0 && nextY<n && board[nextX][nextY]==1){
                board[nextX][nextY] = 0; //섬에서 뻗어나가는 지점을 0으로 만든다.
                DFS(nextX, nextY, board);
            }
        }
    }

    public static void solution(int[][] board){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]==1){ //섬을 발견
                    answer++;
                    board[i][j] = 0; //섬의 출발점을 0으로 만든다.
                    DFS(i, j, board);
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