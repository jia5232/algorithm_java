package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class G13023 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean isFound = false;
    static int[] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
        ch = new int[n];
        graph = new ArrayList<>();
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
        for (int i = 0; i < n; i++) {
            DFS(1, i);
        }
        if(isFound) System.out.println(1);
        else System.out.println(0);
    }

    public static void DFS(int L, int now){
        if(isFound) return;

        if(L==5){
            isFound = true;
            return;
        }else{
            ch[now] = 1;
            for(int i : graph.get(now)){
                if(ch[i]==0){
                    DFS(L+1, i);
                }
            }
            ch[now] = 0;
        }
    }
}