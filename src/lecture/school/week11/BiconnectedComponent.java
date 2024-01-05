package lecture.school.week11;

import java.util.*;
import java.io.*;

public class BiconnectedComponent {
    static int t, n, k, m, order;
    static int[] pk;
    static int[] nodeCnt;
    static ArrayList<Integer>[] con;
    static ArrayList<Edge> stack = new ArrayList<>();
    static int bccCnt;

    static int tarjan(int tNode, int prev) {
        int p = pk[tNode] = ++order;

        for(int nNode : con[tNode]) {
            if(nNode == prev) continue;

            if(pk[nNode] == 0) {
                stack.add(new Edge(tNode, nNode));
                int edgeP = tarjan(nNode, tNode);
                p = Math.min(p, edgeP);

                if(pk[tNode] <= edgeP) {
                    bccCnt++;
                    Edge endEdge = new Edge(tNode, nNode);
                    for(int i = stack.size()-1; i>=0; --i) {
                        Edge edge = stack.get(i);
                        stack.remove(i);

                        ++nodeCnt[edge.second];
                        if(edge.first == endEdge.first && edge.second == endEdge.second) {
                            ++nodeCnt[edge.first];
                            break;
                        }
                    }
                }
            } else p = Math.min(p, pk[nNode]);
        }

        return p;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            n = Integer.parseInt(br.readLine());
            pk = new int[n+1];
            nodeCnt = new int[n+1];
            con = new ArrayList[n+1];
            for(int i = 0; i < n; ++i) {
                st = new StringTokenizer(br.readLine());
                k = Integer.parseInt(st.nextToken());
                m = Integer.parseInt(st.nextToken());
                con[k] = new ArrayList<>();
                while(m-- > 0) {
                    int node = Integer.parseInt(st.nextToken());
                    con[k].add(node);
                }
            }

            order = 0;
            Arrays.fill(pk, 1, n+1, 0);
            Arrays.fill(nodeCnt, 1, n+1, 0);

            stack.clear();
            bccCnt = 0;
            tarjan(1, -1);

            System.out.println(bccCnt);

            ArrayList<Integer> ap = new ArrayList<>();
            for(int i = 1; i <= n; ++i)
                if(nodeCnt[i] >= 2) ap.add(i);

            System.out.print(ap.size() + " ");
            for(int node : ap) System.out.print(node + " ");
            System.out.println();
        }
        br.close();
    }

    static class Edge {
        int first, second;
        Edge(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}