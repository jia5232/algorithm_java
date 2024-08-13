package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Edge {
    int vex;
    int cost;

    public Edge(int vex, int cost){
        this.vex = vex;
        this.cost = cost;
    }
}

public class G1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int v = Integer.parseInt(inputArr[0]);
        int e = Integer.parseInt(inputArr[1]);
        int start = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Edge>> arrayList = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            arrayList.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            inputArr = br.readLine().split(" ");
            int a = Integer.parseInt(inputArr[0]);
            int b = Integer.parseInt(inputArr[1]);
            int cost = Integer.parseInt(inputArr[2]);
            arrayList.get(a).add(new Edge(b, cost));
        }

        int[] dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.cost));
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            if (current.cost > dist[current.vex]) continue;

            for (Edge edge : arrayList.get(current.vex)) {
                int newDist = dist[current.vex] + edge.cost;
                if (dist[edge.vex] > newDist) {
                    dist[edge.vex] = newDist;
                    pq.add(new Edge(edge.vex, newDist));
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if (dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
}