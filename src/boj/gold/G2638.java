package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G2638 {
    static int n, m;
    static int[][] board, melting, externalAir;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(inputArr[j]);
            }
        }

        int time = 0;
        while(true){
            int meltingCount = BFS();
            if(meltingCount<=0) break;

            time++;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(melting[i][j]==1){
                        board[i][j] = 0;
                    }
                }
            }
        }
        System.out.println(time);
    }

    public static int BFS(){
        markExternalAir();
        melting = new int[n][m];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j]==1){
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if(nr>=0 && nr<n && nc>=0 && nc<m && board[nr][nc]==0 && externalAir[nr][nc]==1){
                            cnt++;
                        }
                    }
                    if(cnt>=2){
                        melting[i][j] = 1;
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    public static void markExternalAir(){
        externalAir = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        int[][] ch = new int[n][m];
        boolean isFound = false;
        for (int i = 0; i < n; i++) {
            if(isFound) break;
            for (int j = 0; j < m; j++) {
                if(board[i][j]==0){
                    queue.add(new int[]{i, j});
                    ch[i][j] = 1;
                    isFound = true;
                    break;
                }
            }
        }
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            externalAir[now[0]][now[1]] = 1;
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && ch[nr][nc]==0 && board[nr][nc]==0){
                    ch[nr][nc] = 1;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }
}
