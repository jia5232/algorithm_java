package lecture.inflearn_basic.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class WonderLandPriorityQueue {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        int[] ch = new int[num+1];
        for (int i = 0; i <= num; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }
        int answer = 0;
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(1, 0));
        while (!pQ.isEmpty()){
            Edge tmp = pQ.poll();
            int v = tmp.vex;
            if(ch[v]==0){
                ch[v] = 1;
                answer+=tmp.cost;
                for (Edge ob : graph.get(v)) {
                    if(ch[ob.vex]==0) pQ.offer(new Edge(ob.vex, ob.cost));
                }
            }
        }
        System.out.println(answer);
    }
}
