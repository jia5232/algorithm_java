package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class S18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int m = Integer.parseInt(inputArr[1]);
        int k = Integer.parseInt(inputArr[2]);
        int x = Integer.parseInt(inputArr[3]);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            inputArr = br.readLine().split(" ");
            int a = Integer.parseInt(inputArr[0]);
            int b = Integer.parseInt(inputArr[1]);
            graph.get(a).add(b);
        }
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        int[] ch = new int[n+1];
        ch[x] = 1;
        boolean isFound = false;
        int level = 0;
        while (!queue.isEmpty()){
            if(isFound) break;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                if(level==k){
                    isFound = true;
                    answer.add(now);
                }
                for(int next : graph.get(now)){
                    if(ch[next]==0){
                        ch[next] = 1;
                        queue.add(next);
                    }
                }
            }
            level++;
        }
        Collections.sort(answer);
        if(isFound){
            StringBuilder sb = new StringBuilder();
            for(int i : answer) sb.append(i).append("\n");
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }
}