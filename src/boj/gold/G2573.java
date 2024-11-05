package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G2573 {
    static int n, m;
    static int[][] board, melting;
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
        boolean isFound = false;
        while (true){
            time++;
            int num = meltingIce();
            if(num==0) break;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int next = board[i][j] - melting[i][j];
                    if(next<0) board[i][j] = 0;
                    else board[i][j] = next;
                }
            }

            int loafs = getLoaf();
            if(loafs>=2){
                isFound = true;
                break;
            }
        }
        if(isFound) System.out.println(time);
        else System.out.println(0);
    }

    public static int meltingIce(){
        int answer = 0;
        melting = new int[n][m];
        for(int i=0; i<n; i++){
            for (int j = 0; j < m; j++) {
                if(board[i][j]>0){
                    int sideIce = 0;
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if(nr>=0 && nr<n && nc>=0 && nc<m && board[nr][nc]==0){
                            sideIce++;
                        }
                    }
                    if(sideIce>0){
                        answer++;
                        melting[i][j] = sideIce;
                    }
                }
            }
        }
        return answer;
    }

    public static int getLoaf(){
        int answer = 0;
        int[][] ch = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j]>0 && ch[i][j]==0){
                    ch[i][j] = 1;
                    answer++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()){
                        int[] now = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nr = now[0] + dr[k];
                            int nc = now[1] + dc[k];
                            if(nr>=0 && nr<n && nc>=0 && nc<m && ch[nr][nc]==0 && board[nr][nc]>0){
                                ch[nr][nc] = 1;
                                queue.add(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}