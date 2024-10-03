package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class S18232 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int m = Integer.parseInt(inputArr[1]);
        inputArr = br.readLine().split(" ");
        int s = Integer.parseInt(inputArr[0]);
        int e = Integer.parseInt(inputArr[1]);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            inputArr = br.readLine().split(" ");
            int a = Integer.parseInt(inputArr[0]);
            int b = Integer.parseInt(inputArr[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int[] ch = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        ch[s] = 1;
        int time = 0;
        boolean isFound = false;
        while (!queue.isEmpty()){
            if(isFound) break;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                if(now==e){
                    isFound = true;
                    break;
                }

                if(now+1<=n && ch[now+1]==0){
                    ch[now+1] = 1;
                    queue.add(now+1);
                }

                if(now-1>0 && ch[now-1]==0){
                    ch[now-1] = 1;
                    queue.add(now-1);
                }

                for(int next : graph.get(now)){
                    if(ch[next]==0){
                        ch[next] = 1;
                        queue.add(next);
                    }
                }
            }
            if(!isFound) time++;
        }
        System.out.println(time);
    }
}
