package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class S1260 {
    static int n, m, v;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
        v = Integer.parseInt(inputArr[2]);
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
        for (int i = 0; i <= n; i++) {
            Collections.sort(graph.get(i));
        }
        ch = new int[n+1];
        DFS(v);
        System.out.println();
        ch = new int[n+1];
        BFS(v);
    }

    public static void DFS(int n){
        ch[n] = 1;
        System.out.print(n+" ");
        for (int i : graph.get(n)) {
            if(ch[i]==0) DFS(i);
        }
    }

    public static void BFS(int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        ch[n] = 1;
        while (!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now+" ");
            for(int i : graph.get(now)){
                if(ch[i]==0){
                    ch[i] = 1;
                    queue.add(i);
                }
            }
        }
    }
}