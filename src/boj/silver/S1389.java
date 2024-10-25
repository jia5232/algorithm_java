package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class S1389 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static int BFS(int start, int end){
        Queue<Integer> queue = new LinkedList<>();
        int[] ch = new int[n+1];
        queue.add(start);
        ch[start] = 1;
        int level = 0;
        boolean isFound = false;
        while (!queue.isEmpty()){
            if(isFound) break;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                if(now==end){
                    isFound = true;
                    break;
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
        return level;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
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
        int[] answer = new int[n+1];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int kb = 0;
            for (int j = 1; j <= n; j++) {
                if(i==j) continue;
                kb += BFS(i, j);
            }
            answer[i] = kb;
            min = Math.min(min, kb);
        }
        for (int i = 1; i <= n; i++) {
            if(answer[i]==min){
                System.out.println(i);
                return;
            }
        }
    }
}
