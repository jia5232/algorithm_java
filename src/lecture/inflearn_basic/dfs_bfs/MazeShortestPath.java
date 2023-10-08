package lecture.inflearn_basic.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MazeShortestPath {
    static int[] dx = {-1, 0, 1, 0}; //행
    static int[] dy = {0, 1, 0, -1}; //열
    static int[][] board, dis;

    public static void BFS(int x, int y){
        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(x, y));
        board[x][y]=1; //출발점 표시
        while(!Q.isEmpty()){
            Point tmp = Q.poll();
            if(tmp.x == 7 && tmp.y == 7) break;
            //이미 종점을 찍었으면 더이상 돌지 않는다!

            for (int i = 0; i < 4; i++) { //4개의 방향으로 조사
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx>=1 && nx<=7 && ny>=1 && ny<=7 && board[nx][ny]==0){
                    //board[nx][ny]=1 로 체크를 하고 체크된 곳은 다시 가지 않기 때문에 덮어써지는 경우는 없다.
                    board[nx][ny] = 1;
                    Q.add(new Point(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y]+1;
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];
        dis = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        BFS(1, 1); //출발점 (1, 1)
        if(dis[7][7]==0) System.out.println(-1);
        else System.out.println(dis[7][7]);
    }
}
