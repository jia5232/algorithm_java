package lecture.inflearn_basic.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//public class Dijkstra {
//    static int n, m;
//    static ArrayList<ArrayList<Edge>> graph;
//    static int[] dis;
//
//    public static void solution(int v){
//        PriorityQueue<Edge> pQ = new PriorityQueue<>();
//        //queue에서 꺼내주는 기준: cost가 가장 작은 것부터 꺼내줌!
//        pQ.offer(new Edge(v, 0));
//        dis[v] = 0;
//        while (!pQ.isEmpty()){
//            Edge tmp = pQ.poll();
//            int now = tmp.vex;
//            int nowCost = tmp.cost;
//            if(nowCost>dis[now]) continue;
//            for(Edge ob : graph.get(now)){
//                if(dis[ob.vex]>nowCost+ob.cost){
//                    dis[ob.vex]=nowCost+ob.cost;
//                    pQ.offer(new Edge(ob.vex, nowCost+ob.cost));
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        graph = new ArrayList<ArrayList<Edge>>();
//        for (int i = 0; i <= n; i++) {
//            graph.add(new ArrayList<Edge>());
//        }
//        dis = new int[n+1];
//        Arrays.fill(dis, Integer.MAX_VALUE);
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            int c = Integer.parseInt(st.nextToken());
//            graph.get(a).add(new Edge(b, c));
//        }
//        solution(1);
//        for (int i = 2; i <= n; i++) {
//            if(dis[i]!=Integer.MAX_VALUE) System.out.println(i+" : "+dis[i]);
//            else System.out.println(i+" : impossible");
//        }
//    }
//}
//
//class Edge implements Comparable<Edge>{
//    public int vex; //정점
//    public int cost; //비용
//
//    public Edge(int vex, int cost) {
//        this.vex = vex;
//        this.cost = cost;
//    }
//
//    @Override
//    public int compareTo(Edge ob) {
//        return this.cost - ob.cost;
//    }
//}

public class Dijkstra {
    static int n, m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;

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
                if(dis[ob.vex] > nowCost+ob.cost){
                    dis[ob.vex] = nowCost+ob.cost;
                    pQ.offer(new Edge(ob.vex, nowCost+ob.cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
        }
        solution(1);
        for (int i = 2; i <= n; i++) {
            if(dis[i]!=Integer.MAX_VALUE) System.out.println(i+" : "+dis[i]);
            else System.out.println(i+" : impossible");
        }
    }

    static class Edge implements Comparable<Edge>{
        public int vex;
        public int cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}