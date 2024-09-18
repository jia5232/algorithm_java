package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G1916 {
    static class Edge implements Comparable<Edge>{
        int vex;
        int cost;

        public Edge(int vex, int cost){
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] costs = new int[n+1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        ArrayList<ArrayList<Edge>> arrayList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arrayList.add(new ArrayList<>());
        }
        String[] inputArr;
        for (int i = 0; i < m; i++) {
            inputArr = br.readLine().split(" ");
            int a = Integer.parseInt(inputArr[0]);
            int b = Integer.parseInt(inputArr[1]);
            int cost = Integer.parseInt(inputArr[2]);
            arrayList.get(a).add(new Edge(b, cost));
        }
        inputArr = br.readLine().split(" ");
        int start = Integer.parseInt(inputArr[0]);
        int end = Integer.parseInt(inputArr[1]);
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        costs[start] = 0;
        queue.add(new Edge(start, 0));
        while (!queue.isEmpty()){
            Edge now = queue.poll();
            if(now.cost > costs[now.vex]) continue;
            for(Edge next : arrayList.get(now.vex)){
                if(costs[next.vex]>costs[now.vex]+next.cost){
                    costs[next.vex] = costs[now.vex] + next.cost;
                    queue.add(new Edge(next.vex, costs[next.vex]));
                }
            }
        }
        System.out.println(costs[end]);
    }
}
