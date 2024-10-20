package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S16948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputArr = br.readLine().split(" ");
        int r1 = Integer.parseInt(inputArr[0]);
        int c1 = Integer.parseInt(inputArr[1]);
        int r2 = Integer.parseInt(inputArr[2]);
        int c2 = Integer.parseInt(inputArr[3]);
        Queue<int[]> queue = new LinkedList<>();
        int[][] ch = new int[n][n];
        int[] dr = {-2, -2, 0, 0, 2, 2};
        int[] dc = {-1, 1, -2, 2, -1, 1};
        queue.add(new int[]{r1, c1});
        ch[r1][c1] = 1;
        int answer = 0;
        boolean isFound = false;
        while (!queue.isEmpty()){
            if(isFound) break;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                if(now[0]==r2 && now[1]==c2){
                    isFound = true;
                    break;
                }
                for (int j = 0; j < 6; j++) {
                    int nr = now[0] + dr[j];
                    int nc = now[1] + dc[j];
                    if(nr>=0 && nr<n && nc>=0 && nc<n && ch[nr][nc]==0){
                        ch[nr][nc] = 1;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
            if(!isFound) answer++;
        }
        if(isFound) System.out.println(answer);
        else System.out.println(-1);
    }
}
