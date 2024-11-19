package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class S24479 {
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
            Collections.sort(graph.get(i));
        }

        ch = new int[n+1];
        answer = new int[n+1];
        ch[r] = 1;
        DFS(r);
        for (int i = 1; i <= n; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void DFS(int n){
        answer[n] = cnt++;

        for(int next : graph.get(n)){
            if(ch[next]==0){
                ch[next] = 1;
                DFS(next);
            }
        }
    }
}
