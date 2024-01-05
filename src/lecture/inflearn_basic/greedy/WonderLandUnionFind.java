package lecture.inflearn_basic.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WonderLandUnionFind {
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
        int answer = 0;
        int num = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        ArrayList<Edge> tree = new ArrayList<>();
        unf = new int[num+1];
        for (int i = 1; i <= num; i++) unf[i] = i;
        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree.add(new Edge(a, b, c));
        }
        Collections.sort(tree);
        for (Edge ob : tree) {
            int fv1 = Find(ob.v1);
            int fv2 = Find(ob.v2);
            if(fv1!=fv2){
                Union(fv1, fv2);
                answer += ob.cost;
            }
        }
        System.out.println(answer);
    }
}