package lecture.school.final_exercise;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class MSTPrim { //다시!
//    static class Edge implements Comparable<Edge>{
//        int vex;
//        int cost;
//
//        public Edge(int vex, int cost) {
//            this.vex = vex;
//            this.cost = cost;
//        }
//
//
//        @Override
//        public int compareTo(Edge o) {
//            return this.cost - o.cost;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int t = Integer.parseInt(br.readLine());
//        for (int i = 0; i < t; i++) {
//            int nodeNum = Integer.parseInt(br.readLine());
//            ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
//            for (int j = 0; j <= nodeNum; j++) {
//                graph.add(new ArrayList<>());
//            }
//            int[] ch = new int[nodeNum+1];
//            for (int j = 0; j < nodeNum; j++) {
//                st = new StringTokenizer(br.readLine());
//                int a = Integer.parseInt(st.nextToken());
//                int n = Integer.parseInt(st.nextToken());
//                for (int k = 0; k < n; k++) {
//                    int b = Integer.parseInt(st.nextToken());
//                    int c = Integer.parseInt(st.nextToken());
//                    graph.get(a).add(new Edge(b, c));
//                    graph.get(b).add(new Edge(a, c));
//                }
//            }
//            int answer = 0;
//            PriorityQueue<Edge> pQ = new PriorityQueue<>();
//            pQ.add(new Edge(1, 0));
//            while (!pQ.isEmpty()){
//                Edge tmp = pQ.poll();
//                int vex = tmp.vex;
//                if(ch[vex]==0){
//                    ch[vex] = 1;
//                    answer += tmp.cost;
//                    for (Edge ob : graph.get(vex)) {
//                        if(ch[ob.vex]==0) pQ.add(new Edge(ob.vex, ob.cost));
//                    }
//                }
//            }
//            System.out.println(answer);
//        }
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MSTPrim {
    static class Edge implements Comparable<Edge>{
        int vex, cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int[] ch;
    static ArrayList<ArrayList<Edge>> graph;

    public static int solution(int v){
        int answer = 0;
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.add(new Edge(v, 0));
        while (!pQ.isEmpty()){
            Edge tmp = pQ.poll();
            if(ch[tmp.vex]==0){
                ch[tmp.vex] = 1;
                answer += tmp.cost;
                for (Edge edge : graph.get(tmp.vex)) {
                    if(ch[edge.vex]==0) pQ.add(new Edge(edge.vex, edge.cost));
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            int n = Integer.parseInt(br.readLine());
            ch = new int[n+1];
            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                for (int j = 0; j < num; j++) {
                    int b = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());
                    graph.get(a).add(new Edge(b, c));
                    graph.get(b).add(new Edge(a, c));
                }
            }

            System.out.println(solution(1));
        }
    }
}