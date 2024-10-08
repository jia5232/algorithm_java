package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S17198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[10][10];
        int[][] ch = new int[10][10];
        String[] inputArr;
        for (int i = 0; i < 10; i++) {
            inputArr = br.readLine().split("");
            for (int j = 0; j < 10; j++) {
                board[i][j] = inputArr[j].charAt(0);
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        int[] start = new int[2];
        int[] end = new int[2];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(board[i][j]=='B'){
                    start[0] = i;
                    start[1] = j;
                }
                if(board[i][j]=='L'){
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        queue.add(start);
        int level = 0;
        while (!queue.isEmpty()){

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                if(now[0]==end[0] && now[1]==end[1]){
                    System.out.println(level-1);
                    return;
                }
                for (int j = 0; j < 4; j++) {
                    int nr = now[0] + dr[j];
                    int nc = now[1] + dc[j];
                    if(nr>=0 && nr<10 && nc>=0 && nc<10 && board[nr][nc]!='R' && ch[nr][nc]==0){
                        ch[nr][nc] = 1;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
            level++;
        }
    }
}
