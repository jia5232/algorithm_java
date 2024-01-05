package lecture.school.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Dijkstra {
    static ArrayList<ArrayList<Edge>> graph;
    static List<List<Integer>> paths;
    static int[] dis;

    static class Edge2{
        int start;
        int end;
        int cost;

        Edge2(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge2 edge2 = (Edge2) o;
            return start == edge2.start && end == edge2.end && cost == edge2.cost;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end, cost);
        }
    }
    static class Edge implements Comparable<Edge>{
        int vex;
        int cost;

        List<Integer> currPath;

        Edge(int vex, int cost, List<Integer> currPath) {
            this.vex = vex;
            this.cost = cost;
            this.currPath = currPath;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static List<Integer> copyPath(List<Integer> path){
        List<Integer> copyPath = new ArrayList<>();
        copyPath.addAll(path);
        return copyPath;
    }

    public static void solution(int v){
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        List<Integer> startPath = new ArrayList<>();
        startPath.add(1);
        pQ.add(new Edge(v, 0, startPath));
        dis[v] = 0;

        while (!pQ.isEmpty()){
            Edge tmp = pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            List<Integer> nowPath = tmp.currPath;
            if(dis[now] < nowCost) continue;
            for (Edge ob : graph.get(now)) {
                if(dis[ob.vex] > nowCost+ob.cost){
                    dis[ob.vex] = nowCost+ob.cost;
                    List<Integer> copiedPath = copyPath(nowPath);
                    copiedPath.add(ob.vex);
                    paths.set(ob.vex, copiedPath); //ob.vex인덱스의 리스트를 갱신..
                    pQ.offer(new Edge(ob.vex, nowCost+ob.cost, copiedPath));
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
            graph = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }
            paths = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                paths.add(new ArrayList<>());
            }

            dis = new int[n+1];
            Arrays.fill(dis, Integer.MAX_VALUE);
            dis[0] = 0;

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int edgeNum = Integer.parseInt(st.nextToken());
                for (int k = 0; k < edgeNum; k++) {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    graph.get(v).add(new Edge(a, b, new ArrayList<>()));
                }
            }

            solution(1);
            Set<Edge2> set = new HashSet<>();
            for (List<Integer> path : paths) {
                for(int j = 0; j < path.size() - 1; j++){
                    int start = path.get(j);
                    int end = path.get(j + 1);
                    int cost = graph.get(start)
                            .stream()
                            .filter(o -> o.vex == end)
                            .findFirst()
                            .get().cost;
                    set.add(new Edge2(start,end,cost));
                }
            }

            int sum = 0;
            for (Edge2 edge2 : set) {
                sum += edge2.cost;
            }
            System.out.println(sum);
        }
    }
}