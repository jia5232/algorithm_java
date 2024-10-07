package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S14562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            String[] inputArr = br.readLine().split(" ");
            int s = Integer.parseInt(inputArr[0]);
            int e = Integer.parseInt(inputArr[1]);
            if(s==e){
                System.out.println(0);
                continue;
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{s, e});
            int level = 0;
            boolean isFound = false;
            while (!queue.isEmpty()){
                if(isFound) break;

                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] now = queue.poll();
                    int nowS = now[0];
                    int nowE = now[1];

                    if(nowS==nowE){
                        isFound = true;
                        break;
                    }

                    if(nowS>nowE){
                        continue;
                    }

                    queue.add(new int[]{nowS+1, nowE});
                    queue.add(new int[]{nowS*2, nowE+3});
                }
                if(!isFound) level++;
            }
            System.out.println(level);
        }
    }
}
