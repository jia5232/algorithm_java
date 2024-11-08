package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G10026 {
    static int n;
    static char[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        String[] inputArr;
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                board[i][j] = inputArr[j].charAt(0);
            }
        }
        System.out.print(notRGBlindness()+" "+RGBlindness());
    }

    public static int RGBlindness(){
        int[][] ch = new int[n][n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(ch[i][j]==0){
                    answer++;
                    BFSForRGBlindness(i, j, ch, board[i][j]);
                }
            }
        }

        return answer;
    }
    public static void BFSForRGBlindness(int r, int c, int[][] ch, char nowChar){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        ch[r][c] = 1;
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<n && ch[nr][nc]==0 && isConfused(nowChar, board[nr][nc])){
                    ch[nr][nc] = 1;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }

    public static boolean isConfused(char c1, char c2){
        if(c1=='B' && c2=='B') return true;
        if((c1=='G' || c1=='R') && ((c2=='G' || c2=='R'))) return true;
        return false;
    }

    public static int notRGBlindness(){
        int[][] ch = new int[n][n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(ch[i][j]==0){
                    answer++;
                    BFSForNotRGBlindness(i, j, ch, board[i][j]);
                }
            }
        }

        return answer;
    }

    public static void BFSForNotRGBlindness(int r, int c, int[][] ch, char nowChar){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        ch[r][c] = 1;
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<n && board[nr][nc]==nowChar && ch[nr][nc]==0){
                    ch[nr][nc] = 1;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }
}