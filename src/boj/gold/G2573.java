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
        boolean separated = false;
        while (true){
            if(separated) break;

            int meltingCount = findMelting();
            if(meltingCount==0) break;
            else time++;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(melting[i][j]>0){
                        board[i][j] = Math.max(0, board[i][j]-melting[i][j]);
                    }
                }
            }

            int loafCount = findLoaf();
            if(loafCount>1){
                separated = true;
                break;
            }
        }
        if(separated) System.out.println(time);
        else System.out.println(0);
    }

    public static int findMelting(){
        melting = new int[n][m];
        int meltingCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] > 0){
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if(nr>=0 && nr<n && nc>=0 && nc<m && board[nr][nc]==0){
                            count++;
                        }
                    }
                    melting[i][j] = count;
                    if(count>0) meltingCount++;
                }
            }
        }
        return meltingCount;
    }

    public static int findLoaf(){
        int loafCount = 0;
        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j]>0 && visited[i][j]==0){
                    loafCount++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = 1;
                    while (!queue.isEmpty()){
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int[] now = queue.poll();
                            for (int l = 0; l < 4; l++) {
                                int nr = now[0] + dr[l];
                                int nc = now[1] + dc[l];
                                if(nr>=0 && nr<n && nc>=0 && nc<m && visited[nr][nc]==0 && board[nr][nc]>0){
                                    visited[nr][nc] = 1;
                                    queue.add(new int[]{nr, nc});
                                }
                            }
                        }
                    }
                }
            }
        }
        return loafCount;
    }
}
