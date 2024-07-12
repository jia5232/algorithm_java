package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] tree = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        int[] parents = new int[n+1];
        boolean[] visited = new boolean[n+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()){
            int current = queue.poll();

            for(int next : tree[current]){
                if(!visited[next]){
                    visited[next] = true;
                    parents[next] = current;
                    queue.add(next);
                }
            }
        }

        for(int i=2; i<=n; i++){
            System.out.println(parents[i]);
        }
    }
}
