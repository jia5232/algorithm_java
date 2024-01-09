package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1260 {
    static ArrayList<ArrayList<Integer>> arrayList;
    static int[] ch;
    static Queue<Integer> queue;

    public static void DFS(int v){
        if(ch[v]==0) {
            ch[v] = 1;
            System.out.print(v+" "); //스택에 제일 최근에 넣은 놈이 제일 먼저 빠져나옴.
            for(int i : arrayList.get(v)){
                if(ch[i]==0){
                    DFS(i);
                }
            }
        }
    }

    public static void BFS(){
        while (!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now+" "); //큐에 제일 먼저 넣었던 놈이 먼저 빠져나옴!
            for(int i : arrayList.get(now)){
                if(ch[i]==0){
                    ch[i] = 1;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
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
        for (int i = 0; i <= n; i++) {
            Collections.sort(arrayList.get(i));
        }
        ch = new int[n+1];
        DFS(v);

        System.out.println();

        ch = new int[n+1];
        queue = new LinkedList<>();
        queue.add(v);
        ch[v] = 1;
        BFS();
    }
}
