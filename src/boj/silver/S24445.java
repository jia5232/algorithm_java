package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class S24445 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int n, m, r;
    static int[] ch, answer;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
        r = Integer.parseInt(inputArr[2]);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            inputArr = br.readLine().split(" ");
            int u = Integer.parseInt(inputArr[0]);
            int v = Integer.parseInt(inputArr[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 0; i <= n; i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        ch = new int[n+1];
        answer = new int[n+1];
        ch[r] = 1;
        BFS(r);
        for (int i = 1; i <= n; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void BFS(int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        ch[n] = 1;
        while (!queue.isEmpty()){
            int now = queue.poll();
            answer[now] = cnt++;
            for(int next : graph.get(now)){
                if(ch[next]==0){
                    ch[next] = 1;
                    queue.add(next);
                }
            }
        }
    }
}
