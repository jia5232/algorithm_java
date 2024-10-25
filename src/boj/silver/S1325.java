package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class S1325 {
    static int n, m, max;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] ch;

    public static void DFS(int start){
        ch[start] = 1;
        max++;
        for(int i : graph.get(start)){
            if(ch[i]==0){
                DFS(i);
            }
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList());
        }
        for (int i = 0; i < m; i++) {
            inputArr = br.readLine().split(" ");
            int a = Integer.parseInt(inputArr[0]);
            int b = Integer.parseInt(inputArr[1]);
            graph.get(b).add(a); //b를 해킹하면 a도 해킹할 수 있다.
        }
        int[] answer = new int[n+1];
        int maxCount = 0;
        for (int i = 1; i <= n; i++) {
            ch = new int[n+1];
            max = 0;
            DFS(i);
            answer[i] = max;
            maxCount = Math.max(maxCount, max);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if(maxCount==answer[i]) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}