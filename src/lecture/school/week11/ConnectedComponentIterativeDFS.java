package lecture.school.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ConnectedComponentIterativeDFS {
    private static List<Integer> answer;
    private static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            answer = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            nodes = new Node[n];
            for(int j = 0; j < n; j++){
                nodes[j] = new Node(j + 1, new ArrayList<>(), false);
            }

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int k = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                for (int l = 0; l < m; l++) {
                    int v = Integer.parseInt(st.nextToken());
                    nodes[k-1].adjs.add(nodes[v-1]);
                }
            }

            for(int j = 0; j < n; j++){
                int num = DFS(nodes[j]);
                if(num != 0){
                    answer.add(num);
                }
            }

            answer.sort((o1, o2) -> o1 - o2);
            System.out.print(answer.size());
            for (Integer num : answer) {
                System.out.print(" " + num);
            }
            System.out.println();
        }
    }

    public static int DFS(Node node){
        if(node.visited){
            return 0;
        }

        node.visited = true;
        int num = 1;
        for (Node n : node.adjs) {
            num += DFS(n);
        }
        return num;
    }

    static class Node{
        int id;
        List<Node> adjs;

        boolean visited;

        public Node(int id, ArrayList<Node> adjs, boolean visited) {
            this.id = id;
            this.adjs = adjs;
            this.visited = visited;
        }
    }
}