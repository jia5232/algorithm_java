package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G6593 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String[] inputArr = br.readLine().split(" ");
            int h = Integer.parseInt(inputArr[0]);
            int r = Integer.parseInt(inputArr[1]);
            int c = Integer.parseInt(inputArr[2]);
            if(h==0 && r==0 && c==0) break;

            char[][][] board = new char[h][r][c];
            int[][][] ch = new int[h][r][c];
            int[] start = new int[3];
            int[] end = new int[3];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < r; j++) {
                    inputArr = br.readLine().split("");
                    for (int k = 0; k < c; k++) {
                        char tmp = inputArr[k].charAt(0);
                        board[i][j][k] = tmp;
                        if(tmp=='S'){
                            start[0] = i;
                            start[1] = j;
                            start[2] = k;
                        } else if(tmp=='E'){
                            end[0] = i;
                            end[1] = j;
                            end[2] = k;
                        }
                    }
                }
                inputArr = br.readLine().split("");
            }
            int[] dr = {-1, 1, 0, 0, 0, 0};
            int[] dc = {0, 0, -1, 1, 0, 0};
            int[] dh = {0, 0, 0, 0, -1, 1};
            Queue<int[]> queue = new LinkedList<>();
            queue.add(start);
            ch[start[0]][start[1]][start[2]] = 1;
            boolean isFound = false;
            int level = 0;
            while (!queue.isEmpty()){
                if(isFound) break;

                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] now = queue.poll();
                    if(now[0]==end[0] && now[1]==end[1] && now[2]==end[2]){
                        isFound = true;
                        break;
                    }
                    for (int j = 0; j < 6; j++) {
                        int nh = now[0] + dh[j];
                        int nr = now[1] + dr[j];
                        int nc = now[2] + dc[j];
                        if(nh>=0 && nh<h && nr>=0 && nr<r && nc>=0 && nc<c && ch[nh][nr][nc]==0 && board[nh][nr][nc]!='#'){
                            ch[nh][nr][nc] = 1;
                            queue.add(new int[]{nh, nr, nc});
                        }
                    }
                }
                if(!isFound) level++;
            }
            if(isFound) System.out.println("Escaped in "+level+" minute(s).");
            else System.out.println("Trapped!");
        }
    }
}
