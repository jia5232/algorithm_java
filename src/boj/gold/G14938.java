package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G14938 {
    static int n, m, r, tmpItemSum;
    static int[] items;
    static int[][] costs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]); //지역 개수
        m = Integer.parseInt(inputArr[1]); //수색 범위
        r = Integer.parseInt(inputArr[2]); //길의 개수
        items = new int[n + 1];
        inputArr = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(inputArr[i - 1]);
        }
        costs = new int[n+1][n+1];
        for(int[] row : costs){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for (int i = 0; i < r; i++) {
            inputArr = br.readLine().split(" ");
            int a = Integer.parseInt(inputArr[0]);
            int b = Integer.parseInt(inputArr[1]);
            int dis = Integer.parseInt(inputArr[2]);
            costs[a][b] = dis;
            costs[b][a] = dis;
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dijkstra(i));
        }

        System.out.println(answer);
    }

    static int dijkstra(int start){
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.dist));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()){
            Node current = pq.poll();
            int u = current.number;
            int d = current.dist;

            if(d>dist[u]) continue;

            for (int v = 1; v <= n; v++) {
                if(costs[u][v] != Integer.MAX_VALUE){
                    int len = costs[u][v];
                    if(dist[u]+len < dist[v]){
                        dist[v] = dist[u]+len;
                        pq.add(new Node(v, dist[v]));
                    }
                }
            }
        }

        int tmpItemSum = 0;
        for (int i = 1; i <= n; i++) {
            if(dist[i] <= m){
                tmpItemSum += items[i];
            }
        }

        return tmpItemSum;
    }
}

class Node{
    int number;
    int dist;

    public Node(int number, int dist) {
        this.number = number;
        this.dist = dist;
    }
}