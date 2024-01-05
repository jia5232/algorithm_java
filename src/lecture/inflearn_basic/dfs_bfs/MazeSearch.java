package lecture.inflearn_basic.dfs_bfs;

//import java.util.Scanner;
//
//public class MazeSearch {
//    static int[] dx = {-1, 0, 1, 0}; //행
//    static int[] dy = {0, 1, 0, -1}; //열
//    static int[][] board;
//    static int answer = 0;
//
//    public static void DFS(int x, int y){
//        if (x==7 && y==7) answer++;
//        else{
//            for (int i = 0; i < 4; i++) { //4개의 방향에 대해서 조사.
//                int nx = x+dx[i];
//                int ny = y+dy[i];
//                if(nx>=1 && nx<=7 && ny>=1 && ny<=7 && board[nx][ny]==0){
//                    //nx, ny가 범위 안에 있고, 다음에 갈 위치가 0이어서 갈 수 있을 때.
//                    board[nx][ny] = 1;
//                    DFS(nx, ny);
//                    board[nx][ny] = 0;
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        board = new int[8][8];
//        for (int i = 1; i <= 7; i++) {
//            for (int j = 1; j <= 7; j++) {
//                board[i][j] = sc.nextInt();
//            }
//        }
//        board[1][1] = 1;
//        DFS(1, 1); //출발점 (1, 1)
//        System.out.println(answer);
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MazeSearch {
    static int[][] board;
    static int answer = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void DFS(int x, int y){
        if(x==7 && y==7){
            answer++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX>=1 && nextX<=7 && nextY>=1 && nextY<=7 && board[nextX][nextY]==0){
                board[nextX][nextY] = 1;
                DFS(nextX, nextY);
                board[nextX][nextY] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        board = new int[8][8];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 1; i <= 7; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 7; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        board[1][1] = 1;
        DFS(1, 1);
        System.out.println(answer);
    }
}