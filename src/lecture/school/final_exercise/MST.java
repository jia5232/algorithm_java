package lecture.school.final_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class MST {
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int answer = 0;
        unf = new int[v+1];
        for (int i = 1; i <= v; i++) unf[i] = i;

        ArrayList<Edge> tree = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree.add(new Edge(a, b, c));
        }
        Collections.sort(tree);
        for (Edge edge : tree) {
            int fa = Find(edge.v1);
            int fb = Find(edge.v2);
            if(fa!=fb){
                Union(fa, fb);
                answer += edge.cost;
            }
        }
        System.out.println(answer);
    }
}