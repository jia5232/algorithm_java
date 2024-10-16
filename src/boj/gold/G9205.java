package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class G9205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            int storeNum = Integer.parseInt(br.readLine());
            String[] inputArr = br.readLine().split(" ");
            int[] start = new int[2];
            int[] end = new int[2];
            ArrayList<int[]> stores = new ArrayList<>();
            start[0] = Integer.parseInt(inputArr[0]);
            start[1] = Integer.parseInt(inputArr[1]);
            for (int i = 0; i < storeNum; i++) {
                inputArr = br.readLine().split(" ");
                int a = Integer.parseInt(inputArr[0]);
                int b = Integer.parseInt(inputArr[1]);
                stores.add(new int[]{a, b});
            }
            inputArr = br.readLine().split(" ");
            end[0] = Integer.parseInt(inputArr[0]);
            end[1] = Integer.parseInt(inputArr[1]);

            boolean[] visited = new boolean[storeNum + 2];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(start);
            boolean isFound = false;
            while (!queue.isEmpty()){
                if(isFound) break;
                int[] now = queue.poll();
                if(Math.abs(now[0]-end[0]) + Math.abs(now[1]-end[1]) <= 1000){
                    isFound = true;
                    break;
                }
                for (int i = 0; i < storeNum; i++) {
                    if(!visited[i+1]){
                        int[] next = stores.get(i);
                        if(Math.abs(now[0]-next[0]) + Math.abs(now[1]-next[1]) <= 1000){
                            queue.add(next);
                            visited[i+1] = true;
                        }
                    }
                }
            }
            if(isFound) System.out.println("happy");
            else System.out.println("sad");
        }
    }
}
