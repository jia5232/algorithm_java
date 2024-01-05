package lecture.school.final_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ConnectedComponentDFS {
    static List<Integer> answer;
    static Node[] nodes;
    static class Node{
        int id;
        List<Node> adjs;
        boolean visited;

        public Node(int id, List<Node> adjs, boolean visited) {
            this.id = id;
            this.adjs = adjs;
            this.visited = visited;
        }
    }

    public static int DFS(Node node){
        if(node.visited) return 0;

        node.visited = true;
        int num = 1;
        for (Node n : node.adjs) {
            num += DFS(n);
        }
        return num;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            answer = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            nodes = new Node[n+1];
            for (int i = 0; i <= n; i++) nodes[i] = new Node(i+1, new ArrayList<>(), false);
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int k = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                for (int j = 0; j < m; j++) {
                    int v = Integer.parseInt(st.nextToken());
                    nodes[k].adjs.add(nodes[v]);
                }
            }

            for (int i = 1; i <= n; i++) {
                int num = DFS(nodes[i]);
                if(num!=0){
                    answer.add(num);
                }
            }

            Collections.sort(answer);
            System.out.print(answer.size());
            for (Integer integer : answer) {
                System.out.print(" "+integer);
            }
            System.out.println();
        }
    }
}
