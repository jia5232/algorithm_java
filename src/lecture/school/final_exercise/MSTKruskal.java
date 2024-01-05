package lecture.school.final_exercise;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.StringTokenizer;
//
//public class MSTKruskal {
//    static int answer;
//    static ArrayList<Edge> tree;
//    static int[] unf;
//    static class Edge implements Comparable<Edge>{
//        int v1;
//        int v2;
//        int cost;
//
//        public Edge(int v1, int v2, int cost) {
//            this.v1 = v1;
//            this.v2 = v2;
//            this.cost = cost;
//        }
//
//
//        @Override
//        public int compareTo(Edge o) {
//            return this.cost-o.cost;
//        }
//    }
//
//    public static int Find(int v){
//        if(unf[v]==v) return v;
//        else return unf[v] = Find(unf[v]);
//    }
//
//    public static void Union(int a, int b){
//        int fa = Find(a);
//        int fb = Find(b);
//        if(fa!=fb) unf[fa] = fb;
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int t = Integer.parseInt(br.readLine());
//        for (int i = 0; i < t; i++) {
//            int n = Integer.parseInt(br.readLine());
//            tree = new ArrayList<>();
//            unf = new int[n+1];
//            for (int j = 1; j <= n; j++) unf[j] = j;
//            for (int j = 0; j < n; j++) {
//                st = new StringTokenizer(br.readLine());
//                int a = Integer.parseInt(st.nextToken());
//                int num = Integer.parseInt(st.nextToken());
//                for (int k = 0; k < num; k++) {
//                    int b = Integer.parseInt(st.nextToken());
//                    int c = Integer.parseInt(st.nextToken());
//                    tree.add(new Edge(a, b, c));
//                }
//            }
//            Collections.sort(tree);
//            answer = 0;
//            for (Edge edge : tree) {
//                int f1 = Find(edge.v1);
//                int f2 = Find(edge.v2);
//                if(f1!=f2){
//                    Union(f1, f2);
//                    answer += edge.cost;
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
import java.util.Collections;
import java.util.StringTokenizer;

public class MSTKruskal {
    static class Edge implements Comparable<Edge>{
        int v1, v2, cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }


        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int[] unf;

    public static int Find(int v){
        if(unf[v]==v) return v;
        else return unf[v] = Find(unf[v]);
    }

    public static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) unf[fa] = fb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            int n = Integer.parseInt(br.readLine());
            unf = new int[n+1];
            for (int i = 1; i <= n; i++) unf[i] = i;
            ArrayList<Edge> tree = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int edgeNum = Integer.parseInt(st.nextToken());
                for (int j = 0; j < edgeNum; j++) {
                    int b = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());
                    tree.add(new Edge(a, b, c));
                }
            }
            Collections.sort(tree);

            int answer = 0;
            for (Edge edge : tree) {
                int fa = Find(edge.v1);
                int fb = Find(edge.v2);
                if(fa!=fb){
                    answer += edge.cost;
                    Union(fa, fb);
                }
            }
            System.out.println(answer);
        }
    }
}