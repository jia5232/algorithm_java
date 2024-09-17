package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G5558 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int h = Integer.parseInt(inputArr[0]);
        int w = Integer.parseInt(inputArr[1]);
        int n = Integer.parseInt(inputArr[2]);
        char[][] board = new char[h][w];
        int[] start = new int[2];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for(int i = 0; i < h; i++){
            inputArr = br.readLine().split("");
            for (int j = 0; j < w; j++) {
                board[i][j] = inputArr[j].charAt(0);
                if(board[i][j]=='S'){
                    start = new int[]{i, j};
                }
            }
        }
        int time = 0;
        for(int cheese = 1; cheese<=n; cheese++){
            Queue<int[]> queue = new LinkedList<>();
            int[][] ch = new int[h][w];
            queue.add(start);
            ch[start[0]][start[1]] = 1;
            boolean foundCheese = false;
            while (!queue.isEmpty() && !foundCheese){
                int size = queue.size();
                for(int i=0; i<size; i++){
                    int[] now = queue.poll();
                    for(int j=0; j<4; j++){
                        int nr = now[0] + dr[j];
                        int nc = now[1] + dc[j];
                        if(nr>=0 && nr<h && nc>=0 && nc<w && ch[nr][nc]==0 && board[nr][nc]!='X'){
                            ch[nr][nc] = 1;

                            if(Character.getNumericValue(board[nr][nc]) == cheese){
                                start = new int[]{nr, nc};
                                time++;
                                foundCheese = true;
                                break;
                            }

                            queue.add(new int[]{nr, nc});
                        }
                    }
                }
                if(!foundCheese) time++;
            }
        }
        System.out.println(time);
    }
}
