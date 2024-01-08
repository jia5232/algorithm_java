package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S11724 {
    static int[] ch;
    static int answer;

    static ArrayList<ArrayList<Integer>> arrayList;

    public static void DFS(int v){
        if(ch[v]==0){
            ch[v] = 1;
            for (Integer i : arrayList.get(v)) {
                if(ch[i]==0){
                    DFS(i);
                }
            }
        } else return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arrayList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arrayList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrayList.get(a).add(b);
            arrayList.get(b).add(a);
        }
        ch = new int[n+1];
        answer = 0;
        for (int i = 1; i <= n; i++) {
            if(ch[i]==0){
                answer++;
                DFS(i);
            }
        }
        System.out.println(answer);
    }
}
