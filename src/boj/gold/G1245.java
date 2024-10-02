package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G1245 {
    static int n, m;
    static int[][] board, ch;
    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
        board = new int[n][m];
        ch = new int[n][m];
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(inputArr[j]);
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(ch[i][j]==0){
                    boolean canGo = true;

                    for (int k = 0; k < 8; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if(nr>=0 && nr<n && nc>=0 && nc<m && board[nr][nc]>board[i][j]){
                            canGo = false;
                            break;
                        }
                    }
                    if(canGo){
                        boolean isPeak = BFS(i, j);
                        if(isPeak) answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static boolean BFS(int r, int c){
        boolean answer = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        ch[r][c] = 1;

        while (!queue.isEmpty()){
            int[] now = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    if(board[nr][nc] > board[now[0]][now[1]]){
                        answer = false;
                    }

                    if(ch[nr][nc]==0 && board[nr][nc]==board[now[0]][now[1]]){
                        ch[nr][nc] = 1;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
        return answer;
    }
}
