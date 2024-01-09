package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G1167 {
    static class Node{
        int vex, cost;

        public Node(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
    }

    static int[] ch;
    static int[] distance;
    static ArrayList<ArrayList<Node>> arrayList;

    public static void BFS(int v){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(v, 0));
        ch[v] = 1;
        while (!queue.isEmpty()){
            Node now = queue.poll();
            for(Node next : arrayList.get(now.vex)){
                if(ch[next.vex]==0){
                    ch[next.vex] = 1;
                    queue.add(new Node(next.vex, next.cost));
                    distance[next.vex] = distance[now.vex]+next.cost;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arrayList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arrayList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()){
                int next = Integer.parseInt(st.nextToken());
                if(next == -1) break;
                else{
                    int v = next;
                    int c = Integer.parseInt(st.nextToken());
                    arrayList.get(num).add(new Node(v, c));
                }
            }
        }
        ch = new int[n+1];
        distance = new int[n+1];

        BFS(1);
        int maxIndex = 1;
        for (int i = 2; i <= n; i++) {
            if(distance[maxIndex] < distance[i]){
                maxIndex = i;
            }
        }
        ch = new int[n+1];
        distance = new int[n+1];
        BFS(maxIndex);
        System.out.println(Arrays.stream(distance).max().getAsInt());
    }
}
