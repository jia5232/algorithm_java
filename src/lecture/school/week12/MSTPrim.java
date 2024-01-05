package lecture.school.week12;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class MSTPrim {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int tc = Integer.parseInt(br.readLine());
//        for (int t = 0; t < tc; t++) {
//            int n = Integer.parseInt(br.readLine());
//
//            int[] p = new int[n + 1];
//            for(int i = 0 ; i <= n; i++){
//                p[i] = i;
//            }
//
//            List[] adjLists = new ArrayList[n + 1];
//            for(int i = 0; i <= n; i++){
//                adjLists[i] = new ArrayList<int[]>();
//            }
//            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
//            for(int i = 0; i < n; i++){
//                st = new StringTokenizer(br.readLine());
//                int v = Integer.parseInt(st.nextToken()); //start node
//                int k = Integer.parseInt(st.nextToken());
//                for(int j = 0; j < k; j++){
//                    int vn = Integer.parseInt(st.nextToken()); // end node
//                    int wn = Integer.parseInt(st.nextToken()); // weight
//                    adjLists[v].add(new int[]{v ,vn, wn});
//                }
//            }
//
//            boolean[] visited = new boolean[n + 1];
//            pq.addAll(adjLists[1]);
//            visited[1] = true;
//            List<int[]> tree = new ArrayList<>();
//            while (!pq.isEmpty()){
//                int[] curr = pq.poll();
//                int currEnd = curr[1];
//                if(visited[currEnd]) continue;
//                visited[currEnd] = true;
//                tree.add(curr);
//                if(tree.size() == n - 1) break;
//                pq.addAll(adjLists[currEnd]);
//            }
//            int sum = 0;
//            for (int[] e : tree) {
//                sum += e[2];
//            }
//            System.out.println(sum);
//        }
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MSTPrim {
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
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int answer = 0;
            int num = Integer.parseInt(br.readLine());
            ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
            for (int i = 0; i <= num; i++) {
                graph.add(new ArrayList<>());
            }
            int[] ch = new int[num+1];
            for (int i = 0; i < num; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                for (int j = 0; j < n; j++) {
                    int b = Integer.parseInt(st.nextToken());
                    int cost = Integer.parseInt(st.nextToken());
                    graph.get(a).add(new Edge(b, cost));
                    graph.get(b).add(new Edge(a, cost));
                }
            }
            PriorityQueue<Edge> pQ = new PriorityQueue<>();
            pQ.offer(new Edge(1, 0));
            while (!pQ.isEmpty()){
                Edge tmp = pQ.poll();
                int v = tmp.vex;
                if(ch[v]==0){
                    ch[v] = 1;
                    answer += tmp.cost;
                    for (Edge ob : graph.get(v)) {
                        if(ch[ob.vex]==0) pQ.offer(new Edge(ob.vex, ob.cost));
                    }
                }
            }
            System.out.println(answer);
        }
    }
}