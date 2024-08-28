package lecture.inflearn_basic.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MazeSearch {
    static int[][] board, ch;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int answer;

    public static void DFS(int r, int c){
        if(r==6 && c==6){
            answer++;
        } else {
            for (int i = 0; i < 4; i++) {
                int nextR = r + dr[i];
                int nextC = c + dc[i];
                if(nextR>=0 && nextR<7 && nextC>=0 && nextC<7 && board[nextR][nextC]==0 && ch[nextR][nextC]==0){
                    ch[nextR][nextC] = 1;
                    DFS(nextR, nextC);
                    ch[nextR][nextC] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[7][7];
        ch = new int[7][7];
        answer = 0;
        StringTokenizer st;
        for (int i = 0; i < 7; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ch[0][0] = 1;
        DFS(0, 0);
        System.out.println(answer);
    }
}