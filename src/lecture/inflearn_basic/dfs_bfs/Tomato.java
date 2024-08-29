package lecture.inflearn_basic.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato{
    static int m, n, tomatoes, ripe;
    static int[][] board;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        Queue<Spot> queue = new LinkedList<>();
        board = new int[n][m];
        boolean isFound = false;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int t = Integer.parseInt(st.nextToken());
                board[i][j] = t;
                if(t==0) tomatoes++;
                if(t==1){
                    tomatoes++;
                    ripe++;
                    queue.add(new Spot(i, j));
                }
            }
        }

        if(tomatoes==ripe){
            System.out.println(0);
            return;
        }

        int answer = 0;
        while (!queue.isEmpty()){
            if(isFound) break;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Spot now = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nextR = now.r + dr[j];
                    int nextC = now.c + dc[j];
                    if(nextR>=0 && nextR<n && nextC>=0 && nextC<m && board[nextR][nextC]==0){
                        queue.add(new Spot(nextR, nextC));
                        board[nextR][nextC] = 1;
                        ripe++;
                    }
                }
            }
            answer++;
            if(tomatoes==ripe) isFound = true;
        }

        if(isFound) System.out.println(answer);
        else System.out.println(-1);
    }
}

class Spot {
    int r, c;

    public Spot(int x, int y){
        this.r = x;
        this.c = y;
    }
}