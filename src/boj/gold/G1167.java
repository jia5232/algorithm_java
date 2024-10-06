package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class G1167 {
    static class Node{
        int vex;
        int cost;

        public Node(int vex, int cost){
            this.vex = vex;
            this.cost = cost;
        }
    }

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] ch, distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            String[] inputArr = br.readLine().split(" ");
            int idx = Integer.parseInt(inputArr[0]);
            for (int j = 1; j < inputArr.length; j+=2) {
                if(Integer.parseInt(inputArr[j])==-1) break;
                else{
                    int v = Integer.parseInt(inputArr[j]);
                    int c = Integer.parseInt(inputArr[j+1]);
                    graph.get(idx).add(new Node(v, c));
                }
            }
        }
        int max = 0;
        ch = new int[n+1];
        distance = new int[n+1];
        BFS(1);
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, distance[i]);
        }
        ch = new int[n+1];
        distance = new int[n+1];
        BFS(n);
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, distance[i]);
        }
        System.out.println(max);
    }

    public static void BFS(int n){
        ch[n] = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 0));
        while (!queue.isEmpty()){
            Node now = queue.poll();
            for(Node next : graph.get(now.vex)){
                if(ch[next.vex]==0){
                    ch[next.vex] = 1;
                    queue.add(new Node(next.vex, next.cost));
                    distance[next.vex] = distance[now.vex]+next.cost;
                }
            }
        }
    }
}