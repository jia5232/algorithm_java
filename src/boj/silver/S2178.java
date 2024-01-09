package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2178 {
    static class Point{
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //행
        int m = Integer.parseInt(st.nextToken()); //열
        int[][] board = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                board[i][j] = Character.getNumericValue(arr[j-1]);
            }
        }

        //방문여부 체크
        int[][] ch = new int[n+1][m+1];

        //깊이 기록(현재까지 거리가 몇인지)
        int[][] result = new int[n+1][m+1];

        Point[] dis = {new Point(0, -1), new Point(-1, 0), new Point(0, 1), new Point(1, 0)};
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(1, 1));
        ch[1][1] = 1;
        result[1][1] = 1;

        while (!queue.isEmpty()){
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextR = now.r + dis[i].r; //행
                int nextC = now.c + dis[i].c; //열
                if(nextR>=1 && nextR<=n && nextC>=1 && nextC<=m && ch[nextR][nextC]==0 && board[nextR][nextC]==1){
                    ch[nextR][nextC] = 1;
                    result[nextR][nextC] = result[now.r][now.c]+1;
                    queue.add(new Point(nextR, nextC));
                }
            }
        }

        System.out.println(result[n][m]);
    }
}
