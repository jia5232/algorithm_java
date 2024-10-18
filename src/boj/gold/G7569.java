package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G7569 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int m = Integer.parseInt(inputArr[0]);
        int n = Integer.parseInt(inputArr[1]);
        int h = Integer.parseInt(inputArr[2]);
        int[][][] board = new int[h][n][m];
        int[][][] check = new int[h][n][m];
        int tomatoes = 0, ripeTomatoes = 0;
        Queue<int[]> ripes = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                inputArr = br.readLine().split(" ");
                for (int k = 0; k < m; k++) {
                    int now = Integer.parseInt(inputArr[k]);
                    if(now==1){
                        ripeTomatoes++;
                        tomatoes++;
                        ripes.add(new int[]{i, j, k});
                        check[i][j][k] = 1;
                    }else if(now==0){
                        tomatoes++;
                    }
                    board[i][j][k] = now;
                }
            }
        }
        if(tomatoes==ripeTomatoes){
            System.out.println(0);
            return;
        } else {
            int time = 0;
            boolean isFound = false;
            int[] dr = {-1, 1, 0, 0, 0, 0};
            int[] dc = {0, 0, -1, 1, 0, 0};
            int[] dh = {0, 0, 0, 0, -1, 1};
            while (!ripes.isEmpty()){
                if(isFound) break;

                int size = ripes.size();
                for (int i = 0; i < size; i++) {
                    int[] now = ripes.poll();
                    int ch = now[0];
                    int cr = now[1];
                    int cc = now[2];
                    for (int j = 0; j < 6; j++) {
                        int nh = ch + dh[j];
                        int nr = cr + dr[j];
                        int nc = cc + dc[j];
                        if(nh>=0 && nh<h && nr>=0 && nr<n && nc>=0 && nc<m && check[nh][nr][nc]==0 && board[nh][nr][nc]==0){
                            check[nh][nr][nc] = 1;
                            ripeTomatoes++;
                            ripes.add(new int[]{nh, nr, nc});
                            if(tomatoes==ripeTomatoes){
                                isFound = true;
                                break;
                            }
                        }
                    }
                }
                if(!isFound) time++;
            }
            if(isFound) System.out.println(time+1);
            else System.out.println(-1);
        }
    }
}
