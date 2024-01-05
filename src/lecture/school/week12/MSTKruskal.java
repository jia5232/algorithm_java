package lecture.school.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class MSTKruskal {
    static int[] unf;

    static class Edge implements Comparable<Edge>{
        int v1;
        int v2;
        int cost;

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

    public static int Find(int v){
        if(unf[v]==v) return v;
        else return unf[v] = Find(unf[v]);
    }

    public static void Union(int a, int b){
        int f1 = Find(a);
        int f2 = Find(b);
        if(f1!=f2) unf[f1] = f2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int answer = 0;
            int num = Integer.parseInt(br.readLine());
            unf = new int[num+1];
            for (int j = 1; j <= num; j++) unf[j] = j;
            ArrayList<Edge> tree = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                for (int k = 0; k < n; k++) {
                    int v2 = Integer.parseInt(st.nextToken());
                    int cost = Integer.parseInt(st.nextToken());
                    tree.add(new Edge(v1, v2, cost));
                }
            }
            Collections.sort(tree);
            for (Edge edge : tree) {
                int f1 = Find(edge.v1);
                int f2 = Find(edge.v2);
                if(f1!=f2){
                    Union(f1, f2);
                    answer += edge.cost;
                }
            }
            System.out.println(answer);
        }
    }
}