package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class S18404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int m = Integer.parseInt(inputArr[1]);
        int[][] enemy = new int[m][2];
        inputArr = br.readLine().split(" ");
        int sr = Integer.parseInt(inputArr[0])-1;
        int sc = Integer.parseInt(inputArr[1])-1;
        for (int i = 0; i < m; i++) {
            inputArr = br.readLine().split(" ");
            int a = Integer.parseInt(inputArr[0])-1;
            int b = Integer.parseInt(inputArr[1])-1;
            enemy[i] = new int[]{a, b};
        }
        int[] answer = new int[m];
        int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dc = {-1, 1, -2, 2, -2, 2, -1, 1};
        int level = 0;
        int[][] ch = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        ch[sr][sc] = 1;
        while (!queue.isEmpty()){
            if(Arrays.stream(answer).min().getAsInt()!=0) break;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                for (int j = 0; j < m; j++) {
                    int[] e = enemy[j];
                    if(now[0]==e[0] && now[1]==e[1]){
                        answer[j] = level;
                    }
                }
                for (int j = 0; j < 8; j++) {
                    int nr = now[0] + dr[j];
                    int nc = now[1] + dc[j];
                    if(nr>=0 && nr<n && nc>=0 && nc<n && ch[nr][nc]==0){
                        ch[nr][nc] = 1;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
            level++;
        }
        for(int i : answer){
            System.out.print(i+" ");
        }
    }
}
