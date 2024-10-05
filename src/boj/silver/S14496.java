package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class S14496 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int a = Integer.parseInt(inputArr[0]);
        int b = Integer.parseInt(inputArr[1]);
        inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int m = Integer.parseInt(inputArr[1]);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            inputArr = br.readLine().split(" ");
            int s = Integer.parseInt(inputArr[0]);
            int e = Integer.parseInt(inputArr[1]);
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        int answer = 0;
        boolean isFound = false;
        Queue<Integer> queue = new LinkedList<>();
        int[] ch = new int[n+1];
        queue.add(a);
        ch[a] = 1;
        while (!queue.isEmpty()){
            if(isFound) break;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                if(now==b){
                    isFound = true;
                    break;
                }
                for(int j : graph.get(now)){
                    if(ch[j]==0){
                        ch[j] = 1;
                        queue.add(j);
                    }
                }
            }
            if(!isFound) answer++;
        }
        if(isFound) System.out.println(answer);
        else System.out.println(-1);
    }
}
