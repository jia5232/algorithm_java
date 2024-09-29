package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S7562 {
    public static void main(String[] args) throws IOException {
        int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr;
        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            int l = Integer.parseInt(br.readLine());
            inputArr = br.readLine().split(" ");
            int[] start = new int[]{Integer.parseInt(inputArr[0]), Integer.parseInt(inputArr[1])};
            inputArr = br.readLine().split(" ");
            int[] end = new int[]{Integer.parseInt(inputArr[0]), Integer.parseInt(inputArr[1])};
            int[][] ch = new int[l][l];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(start);
            ch[start[0]][start[1]] = 1;
            int answer = 0;
            boolean isFound = false;
            while (!queue.isEmpty()){
                if(isFound) break;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] now = queue.poll();
                    if(now[0]==end[0] && now[1]==end[1]){
                        isFound = true;
                        break;
                    }
                    for (int j = 0; j < 8; j++) {
                        int nr = now[0] + dr[j];
                        int nc = now[1] + dc[j];
                        if(nr>=0 && nr<l && nc>=0 && nc<l && ch[nr][nc]==0){
                            ch[nr][nc] = 1;
                            queue.add(new int[]{nr, nc});
                        }
                    }
                }
                if(!isFound) answer++;
            }
            System.out.println(answer);
        }
    }
}
