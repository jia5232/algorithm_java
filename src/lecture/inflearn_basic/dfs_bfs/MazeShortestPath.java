package lecture.inflearn_basic.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MazeShortestPath {
    static int[][] board, dis;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void BFS(){
        Queue<Spot> queue = new LinkedList<>();
        queue.offer(new Spot(0, 0));
        board[0][0] = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Spot now = queue.poll();
                if(now.r==6 && now.c==6) break;

                for (int j = 0; j < 4; j++) {
                    int nextR = now.r + dr[j];
                    int nextC = now.c + dc[j];
                    if(nextR>=0 && nextR<7 && nextC>=0 && nextC<7 && board[nextR][nextC]==0){
                        board[nextR][nextC] = 1;
                        queue.add(new Spot(nextR, nextC));
                        dis[nextR][nextC] = dis[now.r][now.c] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[7][7];
        dis = new int[7][7];
        StringTokenizer st;
        for (int i = 0; i < 7; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        BFS();
        if(dis[6][6]==0) System.out.println(-1);
        else System.out.println(dis[6][6]);
    }
}

class Point{
    int r;
    int c;

    public Point(int r, int c){
        this.r = r;
        this.c = c;
    }
}