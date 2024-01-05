package lecture.school.final_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra {
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;
    static class Edge implements Comparable<Edge>{
        int vex;
        int cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void solution(int v){
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v, 0));
        dis[v] = 0;
        while (!pQ.isEmpty()){
            Edge tmp = pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if(nowCost>dis[now]) continue;
            for (Edge ob : graph.get(now)) {
                if(dis[ob.vex]>nowCost+ob.cost){
                    dis[ob.vex] = nowCost+ob.cost;
                    pQ.offer(new Edge(ob.vex, nowCost+ob.cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            dis = new int[n+1];
            Arrays.fill(dis, Integer.MAX_VALUE);

            graph = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }


            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                for (int k = 0; k < num; k++) {
                    int b = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());
                    graph.get(a).add(new Edge(b, c));
                }
            }
            solution(1);
        }
    }
}
