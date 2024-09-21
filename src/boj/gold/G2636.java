package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G2636 {
    static int n, m;
    static int[][] board, ch, melting;
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
        int lastMeltingCheese = 0;
        while (true){
            int meltingCheese = bfs();
            if(meltingCheese==0) break;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(melting[i][j]==1){
                        board[i][j] = 0;
                    }
                }
            }
            lastMeltingCheese = meltingCheese;
            time++;
        }
        System.out.println(time);
        System.out.println(lastMeltingCheese);
    }

    public static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        ch = new int[n][m];
        melting = new int[n][m];
        ch[0][0] = 1;

        int cheeseCount = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nr = now[0] + dr[j];
                    int nc = now[1] + dc[j];
                    if(nr>=0 && nr<n && nc>=0 && nc<m && ch[nr][nc]==0){
                        ch[nr][nc] = 1;
                        if(board[nr][nc]==1){
                            cheeseCount++;
                            melting[nr][nc] = 1;
                        } else{
                            queue.add(new int[]{nr, nc});
                        }
                    }
                }
            }
        }
        return cheeseCount;
    }
}
