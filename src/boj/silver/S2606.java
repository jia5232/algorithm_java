package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class S2606 {
    static int answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    public static void DFS(int n){
        answer++;

        for(int i : graph.get(n)){
            if(ch[i]==0){
                ch[i] = 1;
                DFS(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ch = new int[n+1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        String[] inputArr;
        for (int i = 0; i < m; i++) {
            inputArr = br.readLine().split(" ");
            int a = Integer.parseInt(inputArr[0]);
            int b = Integer.parseInt(inputArr[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        ch[1] = 1;
        DFS(1);
        System.out.println(answer-1);
    }
}
