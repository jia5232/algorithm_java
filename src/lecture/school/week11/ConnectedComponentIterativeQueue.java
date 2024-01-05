package lecture.school.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ConnectedComponentIterativeQueue {
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

            Deque<Node> queue = new ArrayDeque<>();
            for(int j = 0; j < n; j++){
                if(nodes[j].visited){
                    continue;
                }

                queue.push(nodes[j]);
                nodes[j].visited = true;
                int num = 0;
                while (queue.size() > 0){
                    Node node = queue.poll();
                    num++;
                    for (Node adj : node.adjs) {
                        if(!adj.visited){
                            queue.push(adj);
                            adj.visited = true;
                        }
                    }
                }
                answer.add(num);
            }

            answer.sort((o1, o2) -> o1 - o2);
            System.out.print(answer.size());
            for (Integer num : answer) {
                System.out.print(" " + num);
            }
            System.out.println();
        }
    }

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
}
