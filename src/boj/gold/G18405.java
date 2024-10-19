package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G18405 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int k = Integer.parseInt(inputArr[1]);
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            inputArr = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(inputArr[j]);
            }
        }
        inputArr = br.readLine().split(" ");
        int s = Integer.parseInt(inputArr[0]);
        int x = Integer.parseInt(inputArr[1])-1;
        int y = Integer.parseInt(inputArr[2])-1;
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (o1, o2) -> o1[0]==o2[0] ? board[o1[1]][o1[2]]-board[o2[1]][o2[2]] : o1[0]-o2[0]
        );
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]!=0){
                    queue.add(new int[]{0, i, j});
                }
            }
        }
        int time = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (!queue.isEmpty()){
            if(time==s){
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nr = now[1] + dr[j];
                    int nc = now[2] + dc[j];
                    if(nr>=0 && nr<n && nc>=0 && nc<n && board[nr][nc]==0){
                        board[nr][nc] = board[now[1]][now[2]];
                        queue.add(new int[]{time+1, nr, nc});
                    }
                }
            }
            time++;
        }
        System.out.println(board[x][y]);
    }
}
