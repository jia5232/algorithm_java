package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class S11724 {
    static int n, m;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            inputArr = br.readLine().split(" ");
            int a = Integer.parseInt(inputArr[0]);
            int b = Integer.parseInt(inputArr[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        ch = new int[n+1];
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if(ch[i]==0){
                answer++;
                DFS(i);
            }
        }
        System.out.println(answer);
    }

    public static void DFS(int n){
        if(ch[n]==1){
            return;
        }else{
            ch[n] = 1;
            for(int i : graph.get(n)){
                DFS(i);
            }
        }
    }
}
